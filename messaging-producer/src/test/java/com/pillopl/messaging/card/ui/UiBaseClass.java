package com.pillopl.messaging.card.ui;

import com.pillopl.messaging.card.application.ApplyForCardService;
import com.pillopl.messaging.card.model.CreditCard;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

import java.util.Optional;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Marcin Grzejszczak
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UiBaseClass.Config.class)
@EnableWebMvc
public class UiBaseClass {

	private static final String VALID_PERSONAL_ID = "86010197600";
	private static final String INVALID_PERSONAL_ID = "86010156812";

	@Autowired WebApplicationContext context;

	@Before public void setup() {
		RestAssuredMockMvc.webAppContextSetup(this.context);
	}

	@Configuration
	static class Config {
		@Bean
		CreditCardApplicationController creditCardApplicationController() {
			ApplyForCardService service = Mockito.mock(ApplyForCardService.class);
			BDDMockito.given(service.apply(BDDMockito.anyString()))
					.willReturn(Optional.of(CreditCard.withDefaultLimit(VALID_PERSONAL_ID)));
			BDDMockito.given(service.apply(INVALID_PERSONAL_ID))
					.willReturn(Optional.empty());
			return new CreditCardApplicationController(service);
		}
	}
}