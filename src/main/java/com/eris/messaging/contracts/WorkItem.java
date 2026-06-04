package com.eris.messaging.contracts;

import com.eris.messaging.contracts.enums.Importance;
import com.eris.messaging.contracts.enums.Status;
import com.eris.messaging.contracts.enums.WorkItemType;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

public record WorkItem(

        UUID id,

        WorkItemType type,

        String title,

        String content,

        Importance importance,

        Status status,

        boolean requiresAction,

        String owner,

        Source source,

        Instant createdAt,

        Instant dueDate,

        Instant completedAt,

        Map<String, Object> metadata

) {
}