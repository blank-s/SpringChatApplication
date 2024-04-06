package com.example.chat.kafkaProducer;

import com.example.chat.Payloads.ChatMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class ChatMessagesProducer {

    public ChatMessagesProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        //this.topic = topic;
    }

    private static final Logger logger = LoggerFactory.getLogger(ChatMessagesProducer.class);

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(ChatMessage chatMessage) throws JsonProcessingException {
        String topic = "chat-messages";
        logger.info("sending Message: {} to topic: {}  ",chatMessage.toString(),topic);
        ObjectMapper objectMapper = new ObjectMapper();
        String serializedMessage = objectMapper.writeValueAsString(chatMessage);
        logger.info("serialized Message: {} to topic: {}  ",serializedMessage,topic);

        kafkaTemplate.send(topic,serializedMessage);
    }
}
