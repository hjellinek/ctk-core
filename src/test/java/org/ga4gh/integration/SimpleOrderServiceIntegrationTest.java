/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ga4gh.integration;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.ga4gh.models.SoftAssertions;
import org.ga4gh.service.*;
import org.ga4gh.transport.SimpleOrderServiceClient;
import org.ga4gh.transport.SimpleOrderServiceEndpoint;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

import static junit.framework.Assert.assertTrue;
import static org.ga4gh.service.ConfirmationAssert.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * <code>SimpleOrderServiceIntegrationTest</code> runs as part of the Integration phase of the build and is
 * meant for end to end service testing.
 */
@RunWith(JUnitParamsRunner.class)
public class SimpleOrderServiceIntegrationTest {

	private static SimpleOrderServiceEndpoint service;
	private static SimpleOrderServiceClient client;

	@Test
	public void simpleRoundTripTest() throws Exception {
		Order simpleOrder = createOrder();
		long orderTime = System.currentTimeMillis();
		Confirmation c = client.submitOrder(simpleOrder);

        assertEquals(c.getOrderId(), simpleOrder.getOrderId());
        assertEquals(c.getCustomerId(), simpleOrder.getCustomerId());
        assertTrue(c.getEstimatedCompletion() > orderTime
                && c.getEstimatedCompletion() <= (orderTime + 2 * SimpleOrderService.ECT_DELAY));
	}

	@Test
	public void simpleRoundTripTestFail() throws Exception {
		Order simpleOrder = createOrder();
		long orderTime = System.currentTimeMillis();
		Confirmation c = client.submitOrder(simpleOrder);

		// make errors in all three fields, but only see the first error
		simpleOrder.setCustomerId(-1L);
		simpleOrder.setOrderId(-3L);
		c.setEstimatedCompletion(0L);

        assertEquals(c.getOrderId(), simpleOrder.getOrderId());
        assertEquals(c.getCustomerId(), simpleOrder.getCustomerId());
        assertTrue(c.getEstimatedCompletion() > orderTime
                && c.getEstimatedCompletion() <= (orderTime + 2 * SimpleOrderService.ECT_DELAY));
	}

	// use assertJ for better left-to-right readability
	@Test
	public void assertjRoundTripTest() throws Exception {
		Order simpleOrder = createOrder();
		long orderTime = System.currentTimeMillis();
		Confirmation c = client.submitOrder(simpleOrder);

		assertThat(c).hasCustomerId(simpleOrder.getCustomerId());
		assertThat(c).hasOrderId(simpleOrder.getOrderId());
		org.assertj.core.api.Assertions.assertThat(c.estimatedCompletion)
                .isBetween(orderTime, orderTime + 2 * SimpleOrderService.ECT_DELAY);

        // had to qualify this assertThat to use the core version instead of the Confirmation one
	}

	// use SoftAssertions to expose all errors at once, at a cost of 3 lines
    // and, can't use the core assertThat().isBetween() on a ConfirmationAssert
    // so I switch to using Java8 feature - and that means I need to
    // add a clarifying error message, ese AssertJ just says "the given Predicate" :(
    // TODO make estimatedCompletion validation same as above
	@Test
	public void assertjSoftRoundTripTest() throws Exception {
		Order simpleOrder = createOrder();
		long orderTime = System.currentTimeMillis();
		Confirmation c = client.submitOrder(simpleOrder);

		SoftAssertions softly = new SoftAssertions();
		softly.assertThat(c)
            .hasCustomerId(simpleOrder.getCustomerId())
			.hasOrderId(simpleOrder.getOrderId())
            .matches(conf -> conf.getEstimatedCompletion() > orderTime,
                    "estimated time is after order time");
		softly.assertAll();
    }

	@Test
	public void assertjRoundTripTestFail() throws Exception {
		Order simpleOrder = createOrder();
		long orderTime = System.currentTimeMillis();
		Confirmation c = client.submitOrder(simpleOrder);

		// set failing values in the three fields
		simpleOrder.setCustomerId(-1L);
		simpleOrder.setOrderId(-3L);
		c.setEstimatedCompletion(0L);

		SoftAssertions softly = new SoftAssertions();
        softly.assertThat(c)
                .hasCustomerId(simpleOrder.getCustomerId())
                .hasOrderId(simpleOrder.getOrderId())
                .matches(conf -> conf.getEstimatedCompletion() > orderTime,
                        "estimated time is after order time");
        softly.assertAll();
	}


	// let's data-drive the test, passing in good and bad and and expected-result flag
	@Test
	@Parameters
	public void parAssertjParamsRoundTripTest(Order simpleOrder, long orderTime, boolean isValid) throws Exception {
		Confirmation c = client.submitOrder(simpleOrder);

		SoftAssertions softly = new SoftAssertions();
		softly.assertThat(c)
				.hasOrderId(simpleOrder.getOrderId())
                .matches(conf -> customerIdPreserved.test(conf,simpleOrder));
        softly.assertAll();

        org.assertj.core.api.Assertions.assertThat(c.estimatedCompletion)
                .isBetween(orderTime, orderTime + 2 * SimpleOrderService.ECT_DELAY);
	}

	// we can push parameters from a provider that has hard-coded data
	// of fetch it from a DB or a file, whatever ... we just have to build the Object[]
	private Object[] parametersForParAssertjParamsRoundTripTest() {
        boolean VALID_ECT = true;
		return new Object[]{ // {Order, orderTime, isValid}
				new Object[] {createOrder(), System.currentTimeMillis(), VALID_ECT},
                // pass in an invalid ECT time
                new Object[] {createOrder(), System.currentTimeMillis() + 2 * SimpleOrderService.ECT_DELAY + 1, !VALID_ECT},
                new Object[] {createOrder(), System.currentTimeMillis() + SimpleOrderService.ECT_DELAY - 1, !VALID_ECT},
                // this last one should fail since the EXT really *is* valid but we're saying it's not
				new Object[] {createOrder(), System.currentTimeMillis() + SimpleOrderService.ECT_DELAY + 1, !VALID_ECT}
		};
	}

	// using a java8 BiPredicate
	// these would come from the DomainAssertions package
	BiPredicate<Confirmation,Order> customerIdPreserved =
			(Confirmation C, Order O) -> C.getCustomerId() == O.getCustomerId();

    BiPredicate<Confirmation,Order> orderIdPreserved =
            (Confirmation C, Order O) -> C.getOrderId() == O.getOrderId();

	// BiPredicate is cute, but not clearer in this lightweight case(IMO)
	@Test
	public void bipAssertjRoundTripTestFail() throws Exception {
		Order simpleOrder = createOrder();
		long orderTime = System.currentTimeMillis();
		Confirmation c = client.submitOrder(simpleOrder);

		// set failing values in the three fields
		simpleOrder.setCustomerId(-1L);
		simpleOrder.setOrderId(-3L);
		c.setEstimatedCompletion(0L);

		SoftAssertions softly = new SoftAssertions();
		softly.assertThat(c)
				.hasCustomerId(simpleOrder.getCustomerId())
				.hasOrderId(simpleOrder.getOrderId())
				.matches(conf -> customerIdPreserved.test(conf, simpleOrder),
						"customer ID preserved from Order to Confirmation");
        softly.assertAll();
	}

	@BeforeClass
	public static void setupTransport() throws Exception {
		InetSocketAddress endpointAddress = new InetSocketAddress("0.0.0.0", 12345);
		service = new SimpleOrderServiceEndpoint(endpointAddress);
		client = new SimpleOrderServiceClient(endpointAddress);

		service.start();
		client.start();
	}

	@AfterClass
	public static void shutdownTransport() throws Exception {
		client.stop();
		service.stop();
	}

	public Order createOrder() {
		return Order.newBuilder().setOrderId(1).setCustomerId(1).setOrderItems(createItems()).build();
	}

	public List<Item> createItems() {
		List<Item> items = new ArrayList<Item>();
		for (int x = 0; x < 5; x++)
			items.add(Item.newBuilder().setName("Item-" + x).setQuantity(x + 1).setSku(1230 + x).build());
		return items;
	}

}
