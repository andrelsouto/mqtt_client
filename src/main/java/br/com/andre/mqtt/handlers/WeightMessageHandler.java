package br.com.andre.mqtt.handlers;

import br.com.andre.mqtt.models.Weight;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
@Slf4j
public class WeightMessageHandler implements MessageHandler {
    @Override
    public void handleMessage(Message<?> message) throws MessagingException {

        Weight weight = Weight.builder().weight(new BigDecimal(message.getPayload().toString())).date(LocalDate.now()).build();
        log.debug("Message: " + weight.getWeight());
    }
}
