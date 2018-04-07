package com.pillopl.messaging.card.ui;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Jakub Pilimon
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplyForCardWithEventMockBeanTest {

    @Autowired
    CreditCardApplicationController creditCardApplicationController;


    @Test
    public void shouldEmitCardGrantedEvent() {

    }

    @Test
    public void shouldEmitCardApplicationRejectedEvent() {

    }

}
