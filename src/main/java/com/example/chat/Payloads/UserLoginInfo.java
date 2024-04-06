package com.example.chat.Payloads;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "userLoginInfo")
public class UserLoginInfo {


    private String userName;
    private String password;
}
