package ru.wpz.wpz_generator.domain;

import lombok.Data;

@Data
public class Message {

    private int devId;
    private int status;

    @Override
    public String toString() {
        return "{" +
                "devId=" + devId +
                ", status=" + status +
                '}';
    }
}
