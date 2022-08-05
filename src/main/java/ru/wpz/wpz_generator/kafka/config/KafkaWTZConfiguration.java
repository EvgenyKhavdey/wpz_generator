package ru.wpz.wpz_generator.kafka.config;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

import java.util.Properties;

@EnableKafka
@Configuration
@ComponentScan(basePackages = "ru.wpz.wpz_generator.kafka.core")
public class KafkaWTZConfiguration {

    @Bean
    public KafkaProducer kafkaProducer(){
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:29092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("security.protocol", "Plaintext");
        return new KafkaProducer(properties);
    }

}
