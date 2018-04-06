package com.pillopl.messaging.card.ui;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jakub Pilimon
 */
class CardApplication {

    private final String pesel;

    @JsonCreator
    CardApplication(@JsonProperty("pesel") String pesel) {
        this.pesel = pesel;
    }

    String getPesel() {
        return pesel;
    }

}
