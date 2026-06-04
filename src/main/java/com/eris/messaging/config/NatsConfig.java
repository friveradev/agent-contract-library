package com.eris.messaging.config;

public record NatsConfig(
        String url,
        String applicationName
) {}