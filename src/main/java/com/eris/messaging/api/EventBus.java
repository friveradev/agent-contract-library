package com.eris.messaging.api;

import com.eris.messaging.contracts.Event;

public interface EventBus extends AutoCloseable {

    void publish(String subject, Event event);

    void subscribe(String subject, EventHandler handler);

    @Override
    void close();
}