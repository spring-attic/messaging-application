package com.pillopl.messaging.card.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class CardGranted implements DomainEvent {

    final UUID cardNo;
    final BigDecimal cardLimit;
    final String clientPesel;
    final Instant timestamp = Instant.now();

    public CardGranted(UUID cardNo, BigDecimal cardLimit, String clientPesel) {
        this.cardNo = cardNo;
        this.cardLimit = cardLimit;
        this.clientPesel = clientPesel;
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
        return "card-granted";
    }
}
