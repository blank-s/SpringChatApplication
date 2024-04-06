    package com.example.chat.Payloads;

    import lombok.*;
    import org.springframework.data.mongodb.core.mapping.Document;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Document(collection = "userRegistrationInfo")
    public class UserRegistrationInfo {


        private String userName;
        private String name;
        private String password;
    }
