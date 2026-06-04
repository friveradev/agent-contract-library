package com.eris.messaging.contracts;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

public record Event(

        UUID eventId,

        UUID correlationId,

        String eventType,

        String source,

        Instant timestamp,

        Map<String, Object> payload

) {
}