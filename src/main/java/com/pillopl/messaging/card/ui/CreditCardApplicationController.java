package com.pillopl.messaging.card.ui;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pillopl.messaging.card.application.ApplyForCardService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

@RestController("/applications")
class CreditCardApplicationController {

    private final ApplyForCardService applyForCardService;

    CreditCardApplicationController(ApplyForCardService applyForCardService) {
        this.applyForCardService = applyForCardService;
    }

    @PostMapping
    ResponseEntity applyForCard(@RequestBody CardApplication cardApplication) {
        return applyForCardService
                .apply(cardApplication.getPesel())
                .map(card -> ok().build())
                .orElse(status(FORBIDDEN).build());
    }
}

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