package com.example.config;

import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;

@EnableKafka
@Configuration
public class LibraryEventsConsumerConfig {

    /** This will be a bean to help you manage manual offset.
     *
     * @param configure
     * @param kafkaConsumerFactory
     * @return
     */
    public ConcurrentKafkaListenerContainerFactory<?, ?> kafkaListenerContainerFactory(
            ConcurrentKafkaListenerContainerFactoryConfigurer configure,
            ConsumerFactory<Object, Object> kafkaConsumerFactory) {

        var factory = new ConcurrentKafkaListenerContainerFactory<>();
        configure.configure(factory, kafkaConsumerFactory);

        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL);
        // configure multiple kafka listeners for the same application
        factory.setConcurrency(3);

        return factory;
    }
}
