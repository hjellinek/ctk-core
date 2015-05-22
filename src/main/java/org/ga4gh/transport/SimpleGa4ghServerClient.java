package org.ga4gh.transport;

import org.apache.avro.ipc.NettyTransceiver;
import org.apache.avro.ipc.Transceiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by Wayne Stidolph on 5/21/2015.
 */
public class SimpleGa4ghServerClient {
    private static final Logger log = LoggerFactory.getLogger(SimpleOrderServiceEndpoint.class);

    private InetSocketAddress endpointAddress;

    private Transceiver transceiver;

    public SimpleGa4ghServerClient(InetSocketAddress endpointAddress) {
        this.endpointAddress = endpointAddress;
    }

    public synchronized void start() throws IOException {
        if (log.isInfoEnabled()) {
            log.info("Starting Simple GA4GH Netty client on '{}'", endpointAddress);
        }
        transceiver = new NettyTransceiver(endpointAddress);
       // service = SpecificRequestor.getClient(OrderProcessingService.class, transceiver);
    }

    public void stop() throws IOException {
        if (log.isInfoEnabled()) {
            log.info("Stopping Simple GA4GH Netty client on '{}'", endpointAddress);
        }
        if (transceiver != null && transceiver.isConnected()) {
            transceiver.close();
        }
    }
}
