package com.pillopl.messaging.card.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class CardGranted implements DomainEvent {

    UUID cardNo;
    BigDecimal cardLimit;
    String clientPesel;
    Instant timestamp;
    String type;

    public CardGranted(UUID cardNo, BigDecimal cardLimit, String clientPesel) {
        this.cardNo = cardNo;
        this.cardLimit = cardLimit;
        this.clientPesel = clientPesel;
        this.timestamp = Instant.now();
        this.type = "card-granted";
    }

    public CardGranted() {
    }

    public UUID getCardNo() {
        return cardNo;
    }

    public BigDecimal getCardLimit() {
        return cardLimit;
    }

    public String getClientPesel() {
        return clientPesel;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    @Override public String getType() {
        return type;
    }
}
