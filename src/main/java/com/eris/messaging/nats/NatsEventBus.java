package com.eris.messaging.nats;

import com.eris.messaging.contracts.Event;
import com.eris.messaging.api.EventBus;
import com.eris.messaging.api.EventHandler;
import com.eris.messaging.config.NatsConfig;
import com.eris.messaging.serialization.MessagingObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.nats.client.Connection;
import io.nats.client.Dispatcher;
import io.nats.client.Nats;

import java.nio.charset.StandardCharsets;

public class NatsEventBus implements EventBus {

    private final Connection connection;
    private final ObjectMapper mapper;

    public NatsEventBus(NatsConfig config) {

        try {
            this.connection = Nats.connect(config.url());
            this.mapper = MessagingObjectMapper.create();

        } catch (Exception e) {
            throw new RuntimeException("Error connecting to NATS", e);
        }
    }

    @Override
    public void publish(String subject, Event event) {

        try {
            String json = mapper.writeValueAsString(event);

            connection.publish(
                    subject,
                    json.getBytes(StandardCharsets.UTF_8)
            );

            connection.flush(java.time.Duration.ofSeconds(5));

        } catch (Exception e) {
            throw new RuntimeException("Error publishing event", e);
        }
    }

    @Override
    public void subscribe(String subject, EventHandler handler) {

        Dispatcher dispatcher =
                connection.createDispatcher(message -> {

                    try {
                        String json =
                                new String(message.getData(), StandardCharsets.UTF_8);

                        Event event =
                                mapper.readValue(json, Event.class);

                        handler.handle(event);

                    } catch (Exception e) {
                        throw new RuntimeException("Error processing event", e);
                    }
                });

        dispatcher.subscribe(subject);
    }

    @Override
    public void close() {

        try {
            connection.flush(java.time.Duration.ofSeconds(5));
            connection.close();
        } catch (Exception ignored) {
        }
    }
}