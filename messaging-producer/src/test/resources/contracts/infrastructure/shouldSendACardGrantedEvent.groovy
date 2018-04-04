import org.springframework.cloud.contract.spec.Contract

Contract.make {
	label("card_granted")
	input {
		triggeredBy("sendAccepted()")
	}
	outputMessage {
		sentTo("channel")
		body(
			cardNo: anyUuid(),
			cardLimit: anyNumber(),
			clientPesel: "86010197600",
			timestamp: anyIso8601WithOffset(),
			type: "card-granted"
		)
		headers {
			messagingContentType(applicationJson())
		}
	}
}