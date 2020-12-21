package com.codeahoy.userprofile;

import io.unlaunch.UnlaunchClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Value("${unlaunch.server.key}")
    private String sdkKey;

    private static final Logger logger = LoggerFactory.getLogger(Configuration.class);

    @Bean
    public UnlaunchClient unlaunchClient()  {
        UnlaunchClient client = UnlaunchClient.builder().
                sdkKey(sdkKey).
                pollingInterval(30, TimeUnit.SECONDS).
                eventsFlushInterval(30, TimeUnit.SECONDS).
                eventsQueueSize(500).
                metricsFlushInterval(30, TimeUnit.SECONDS).
                metricsQueueSize(100).
                build();

        try {
            client.awaitUntilReady(2, TimeUnit.SECONDS);
            logger.info("unlaunch client is ready");
        } catch (InterruptedException | TimeoutException e) {
            logger.warn("client wasn't ready " + e.getMessage());
        }
        return client;
    }
}
