package com.example.chat.Repository;

import com.example.chat.Payloads.UserRegistrationInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserRegistrationInfo,String> {
    UserRegistrationInfo findByUserName(String userName);
}
