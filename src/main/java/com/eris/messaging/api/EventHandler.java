package com.eris.messaging.api;

import com.eris.messaging.contracts.Event;

@FunctionalInterface
public interface EventHandler {

    void handle(Event event);
}