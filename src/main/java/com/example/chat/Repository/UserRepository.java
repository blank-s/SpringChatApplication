package com.example.chat.Repository;

import com.example.chat.Payloads.UserLoginInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserLoginInfo,String> {
    UserLoginInfo findByUserName(String userName);
}
