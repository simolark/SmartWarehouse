package com.example.subswh.config;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaConsumerService {

    private List<String> messages = new ArrayList<>();

//    @KafkaListener(topics = "test")
//    public void consume(String message) {
//        System.out.println("Consumed message: " + message);
//        messages.add(message);
//    }

    public List<String> getMessages() {
        List<String> result = new ArrayList<>(messages);
        messages.clear();
        return result;
    }


}
