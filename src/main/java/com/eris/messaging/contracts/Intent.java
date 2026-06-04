package com.eris.messaging.contracts;

import java.util.Map;

public record Intent(

        String action,

        double confidence,

        Map<String, Object> payload

) {
}