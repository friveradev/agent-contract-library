package com.eris.messaging.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public final class MessagingObjectMapper {

    private MessagingObjectMapper() {}

    public static ObjectMapper create() {

        return new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .findAndRegisterModules();
    }
}