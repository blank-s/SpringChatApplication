package com.example.chat.kafkaConsumer;

import com.example.chat.Payloads.ChatMessage;
import com.example.chat.Repository.ChatRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ChatMessageConsumer {

    private static final Logger logger  = LoggerFactory.getLogger(ChatMessageConsumer.class);

    private final ObjectMapper objectMapper;

    @Autowired
    private ChatRepository chatRepository;

    public ChatMessageConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    @KafkaListener(topics = "chat-messages", groupId = "myGroup")
    public void consume(String chatMessage) throws JsonProcessingException {

        ChatMessage messageObject = objectMapper.readValue(chatMessage, ChatMessage.class);
        chatRepository.save(messageObject);
    }

}
