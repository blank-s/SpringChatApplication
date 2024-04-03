    package com.example.chat.Payloads;

    import lombok.*;
    import org.springframework.data.annotation.Id;
    import org.springframework.data.mongodb.core.mapping.Document;

    import java.util.Collection;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Document(collection = "userLoginInfo")
    public class UserLoginInfo {


        private String userName;
        private String name;
        private String password;
    }
