package com.eris.messaging.api;

import com.eris.messaging.contracts.Event;

public interface EventEnvelopeFactory {

    Event create(
            String eventType,
            String source,
            Object payload
    );
}