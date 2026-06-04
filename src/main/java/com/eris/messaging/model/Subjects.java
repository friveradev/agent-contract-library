package com.eris.messaging.model;

public final class Subjects {

    private Subjects() {}

    public static final String WORKITEM_CREATE =
            "commands.workitem.create";

    public static final String WORKITEM_CREATED =
            "events.workitem.created";

    public static final String TELEGRAM_AUDIO_RECEIVED =
            "events.telegram.audio.received";

    public static final String VOICE_TRANSCRIBED =
            "events.voice.transcribed";

    public static final String INTENT_DETECTED =
            "events.intent.detected";

    public static final String NOTIFICATION_SEND =
            "commands.notification.send";
}