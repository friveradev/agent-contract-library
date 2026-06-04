package com.eris.messaging.event;

import com.eris.messaging.contracts.Event;
import com.eris.messaging.api.EventEnvelopeFactory;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

public class DefaultEventEnvelopeFactory implements EventEnvelopeFactory {

    @Override
    public Event create(
            String eventType,
            String source,
            Object payload
    ) {

        Map<String, Object> normalizedPayload;

        if (payload instanceof Map<?, ?> map) {
            normalizedPayload = (Map<String, Object>) map;
        } else {
            normalizedPayload = Map.of("data", payload);
        }

        return new Event(
                UUID.randomUUID(),
                UUID.randomUUID(),
                eventType,
                source,
                Instant.now(),
                normalizedPayload
        );
    }
}