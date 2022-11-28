package com.example.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;

import java.util.Objects;

/**
 * Make this a component to manually manage acknowledgements.
 *
 */
@Slf4j
public class LibraryEventsConsumerManualOffset implements AcknowledgingMessageListener<Integer, String> {

    @Override
    @KafkaListener(topics = "library-events")
    public void onMessage(ConsumerRecord<Integer, String> data, Acknowledgment acknowledgment) {
        log.info("ConsumerRecord : {}", data);
        if (Objects.nonNull(acknowledgment)) {
            acknowledgment.acknowledge();
            log.info("Message acknowledged");
        }
    }
}
