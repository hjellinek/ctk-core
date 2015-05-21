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

package org.ga4gh.service;

import org.apache.avro.AvroRemoteException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.slf4j.LoggerFactory.*;

/**
 * {@code SimpleOrderService} is a simple example implementation of an Avro service generated from the
 * order-service.avpr protocol definition.
 */
public class SimpleOrderService implements OrderProcessingService {

	private org.slf4j.Logger log = getLogger(SimpleOrderService.class);
    public static int ECT_DELAY = 5 * 1000; // delay 5 seconds
  @Override
  public Confirmation submitOrder(Order order) throws AvroRemoteException, OrderFailure {
    log.info("Received order for '{}' items from customer with id '{}'",
      new Object[] {order.getOrderItems().size(), order.getCustomerId()});

    long estimatedCompletion = System.currentTimeMillis() + ECT_DELAY;
    return Confirmation.newBuilder().setCustomerId(order.getCustomerId()).setEstimatedCompletion(estimatedCompletion)
      .setOrderId(order.getOrderId()).build();
  }
}
