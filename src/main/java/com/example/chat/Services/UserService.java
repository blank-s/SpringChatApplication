package com.example.chat.Services;

import com.example.chat.Payloads.ChatMessage;
import com.example.chat.Payloads.UserLoginInfo;
import com.example.chat.Repository.ChatRepository;
import com.example.chat.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Slf4j
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public void registerUser(UserLoginInfo userLoginInfo) throws Exception {
        log.info("username: "+userLoginInfo.getUserName());
        UserLoginInfo checkUserExists = userRepository.findByUserName(userLoginInfo.getUserName());
        if(checkUserExists == null){
            userRepository.save(userLoginInfo);
        }
        else {
            log.info("UserName Already Exists");
            throw new Exception("UserName Already Exists" + userLoginInfo.getUserName()  );
        }
    }

    public void checkUser(ChatMessage chatMessage) {
        UserLoginInfo checkUserExists = userRepository.findByUserName(chatMessage.getSender());

    }
}
