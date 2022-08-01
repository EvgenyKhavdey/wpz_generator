package ru.wpz.wpz_generator.kafka.core;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Component;
import ru.wpz.wpz_generator.kafka.KafkaTopic;


@Component
@Slf4j
@Setter
@AllArgsConstructor
public class KafkaHelper {

    private KafkaProducer<String, String> producer;

    public void sendTo(KafkaTopic topic, String msg){
        send(producer, topic, msg);
    }

    @SneakyThrows
    private void send(KafkaProducer<String, String> producer, KafkaTopic topic, String json) {
        String topicName = topic.getTopicName();
        log.info("В топик {} отправляется сообщение {}", topic, json);
        producer.send(new ProducerRecord<>(topicName, json));
        producer.flush();
    }

}
