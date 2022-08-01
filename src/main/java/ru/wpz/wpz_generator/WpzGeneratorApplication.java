package ru.wpz.wpz_generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.wpz.wpz_generator.kafka.config.KafkaWTZConfiguration;
import ru.wpz.wpz_generator.kafka.core.KafkaHelper;

@SpringBootApplication
public class WpzGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(WpzGeneratorApplication.class, args);
        KafkaWTZConfiguration kafkaWTZConfiguration = new KafkaWTZConfiguration();
        KafkaHelper kafkaHelper = new KafkaHelper(kafkaWTZConfiguration.kafkaProducer());
        Generator generator = new Generator(kafkaHelper);
        generator.methodGenerator();
    }

}
