package com.pillopl.messaging.card.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(name = "card-application-rejected", value = CardApplicationRejected.class),
        @JsonSubTypes.Type(name = "card-granted", value = CardGranted.class)
})
public interface DomainEvent {
}
