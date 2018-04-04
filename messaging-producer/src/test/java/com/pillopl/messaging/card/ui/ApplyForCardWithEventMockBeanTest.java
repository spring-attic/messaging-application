package com.pillopl.messaging.card.ui;

import com.pillopl.messaging.card.DomainEventsPublisher;
import com.pillopl.messaging.card.model.CardApplicationRejected;
import com.pillopl.messaging.card.model.CardGranted;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplyForCardWithEventMockBeanTest {

    @MockBean DomainEventsPublisher domainEventsPublisher;

    @Autowired CreditCardApplicationController cardApplicationController;

    @Test
    public void shouldEmitCardGrantedEvent() {
        // when
        cardApplicationController.applyForCard(new CardApplication("70345678"));

        // then
        verify(domainEventsPublisher).publish(isA(CardGranted.class));
    }

    @Test
    public void shouldEmitCardApplicationRejectedEvent() {
        // when
        cardApplicationController.applyForCard(new CardApplication("60345678"));

        // then
        verify(domainEventsPublisher).publish(isA(CardApplicationRejected.class));
    }

}
