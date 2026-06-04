package com.eris.messaging.contracts;

public record Source(

        String channel,

        String externalId,

        String author

) {
}