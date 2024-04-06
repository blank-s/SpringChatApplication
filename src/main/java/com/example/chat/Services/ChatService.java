package com.example.chat.Services;

import com.example.chat.Payloads.ChatMessage;
import com.example.chat.Repository.ChatRepository;
import com.example.chat.kafkaProducer.ChatMessagesProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private ChatMessagesProducer chatMessagesProducer;

    public void saveMessage(ChatMessage chatMessage) throws JsonProcessingException {

        chatMessage.setIdUserName(chatMessage.getSender());
        Optional<ChatMessage> optionalChatMessage = chatRepository.findById(chatMessage.getIdUserName());
        if(optionalChatMessage.isPresent()) {
            ChatMessage existingChatMessage = optionalChatMessage.get();
            String newMessage = existingChatMessage.getContent() + "\n" + chatMessage.getContent() ;
            existingChatMessage.setContent(newMessage);
            //chatRepository.save(existingChatMessage);
            chatMessagesProducer.sendMessage(existingChatMessage);

            System.out.println(newMessage);
        }
        else
            chatMessagesProducer.sendMessage(chatMessage);


    }
}
