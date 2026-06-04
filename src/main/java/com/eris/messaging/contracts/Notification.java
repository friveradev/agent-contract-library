package com.eris.messaging.contracts;

import com.eris.messaging.contracts.enums.Importance;

import java.util.Map;

public record Notification(

        String channel,

        String recipient,

        String title,

        String message,

        Importance importance,

        Map<String, Object> metadata

) {
}