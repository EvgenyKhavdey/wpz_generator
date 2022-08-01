package ru.wpz.wpz_generator.kafka;

public enum KafkaTopic {
    TEST("test");

    private String topicName;

    KafkaTopic(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicName() {
        return topicName;
    }
}
