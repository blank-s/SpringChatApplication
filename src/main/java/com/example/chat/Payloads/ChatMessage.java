package com.example.chat.Payloads;

import com.example.chat.Enums.MessageType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Document(collection = "userMessages")
public class ChatMessage {

    @Id
    private String idUserName;

    private String content;
    private String sender;
    private MessageType type;
}
