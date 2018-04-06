package com.pillopl.messaging.card.infrastructure;

import org.junit.runner.RunWith;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Marcin Grzejszczak
 */
@RunWith(SpringRunner.class)
//@SpringBootTest(classes = ApplicationBaseClass.Config.class)
@AutoConfigureMessageVerifier
public class ApplicationBaseClass {
//	private static final String VALID_PERSONAL_ID = "86010197600";
//	private static final String INVALID_PERSONAL_ID = "86010156812";
//
//	@Autowired EventPublisher publisher;
//
//	public void sendAccepted() {
//		publisher.publish(new CardGranted(UUID.randomUUID(), BigDecimal.ONE, VALID_PERSONAL_ID));
//	}
//
//	public void sendRejected() {
//		publisher.publish(new CardApplicationRejected(INVALID_PERSONAL_ID));
//	}
//
//	@Configuration
//	@ImportAutoConfiguration({ TestSupportBinderAutoConfiguration.class,
//			MessageCollectorAutoConfiguration.class, JacksonAutoConfiguration.class })
//	@EnableBinding(Source.class)
//	static class Config {
//		@Bean
//		EventPublisher publisher(Source source) {
//			return new EventPublisher(source);
//		}source
//	}
}