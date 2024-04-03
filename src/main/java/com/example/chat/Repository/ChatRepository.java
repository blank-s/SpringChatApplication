package com.example.chat.Repository;

import com.example.chat.Payloads.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends MongoRepository<ChatMessage,String> {


}
