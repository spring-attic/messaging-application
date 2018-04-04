package com.pillopl.messaging;

import com.pillopl.messaging.card.model.CardApplicationRejected;
import com.pillopl.messaging.card.model.CardGranted;
import com.pillopl.messaging.card.model.DomainEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableBinding(Sink.class)
public class ConsumerMessagingApplication {

    public static void main(String[] args) {
		SpringApplication.run(ConsumerMessagingApplication.class, args);
	}

}

@Component
class Listener {
	private static final Logger log = LoggerFactory.getLogger(Listener.class);

//	Issue in Stream / Contract with payload deserialization
//
//	@StreamListener(target = Sink.INPUT, condition = "payload.type == 'card-granted'")
//	public void receiveGranted(@Payload CardGranted granted) {
//		log.info("\n\nGRANTED [" + granted.getClientPesel() + "] !!!! :) :) :)\n\n");
//	}
//
//	@StreamListener(target = Sink.INPUT, condition = "payload.type == 'card-application-rejected'")
//	public void receiveRejected(@Payload CardApplicationRejected rejected) {
//		log.error("\n\nREJECTED [" + rejected.getClientPesel() + "] !!!! :( :( :(\n\n");
//	}

	@StreamListener(target = Sink.INPUT)
	public void receiveRejected(DomainEvent domainEvent) {
		switch (domainEvent.getType()) {
		case "card-granted":
			log.info("\n\nGRANTED [" + ((CardGranted) domainEvent).getClientPesel()
					+ "] !!!! :) :) :)\n\n");
			break;
		case "card-application-rejected":
			log.error("\n\nREJECTED [" + ((CardApplicationRejected) domainEvent)
					.getClientPesel() + "] !!!! :( :( :(\n\n");
			break;
		default:
			throw new UnsupportedOperationException(
					"Unknown type [" + domainEvent.getType() + "]");
		}
	}
}

