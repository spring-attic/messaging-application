package com.pillopl.messaging.card.application;

import com.pillopl.messaging.card.model.CreditCard;
import com.pillopl.messaging.card.model.CreditCardRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

import static java.lang.Integer.valueOf;
import static java.util.Optional.of;

/**
 * @author Jakub Pilimon
 */
@Service
public class ApplyForCardService {

    private final CreditCardRepository creditCardRepository;

    public ApplyForCardService(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    @Transactional
    public Optional<CreditCard> apply(String pesel) {
        if (bornBeforeSeventies(pesel)) {
            return Optional.empty();
        }
        CreditCard card = CreditCard.withDefaultLimit(pesel);
        creditCardRepository.save(card);
        return of(card);
    }

    private boolean bornBeforeSeventies(String pesel) {
        return valueOf(pesel.substring(0, 2)) < 70;
    }

}
