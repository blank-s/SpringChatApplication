package com.example.chat.Services;

import com.example.chat.Payloads.UserLoginInfo;
import com.example.chat.Payloads.UserRegistrationInfo;
import com.example.chat.Repository.UserRepository;
import com.example.chat.config.EncryptionConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EncryptionConfig encryptionConfig;

    public void registerUser(UserRegistrationInfo userRegistrationInfo) throws Exception {
        log.info("username: "+ userRegistrationInfo.getUserName());
        UserRegistrationInfo checkUserExists = userRepository.findByUserName(userRegistrationInfo.getUserName());
        if(checkUserExists == null){
            userRegistrationInfo.setPassword(encryptionConfig.encrypt(userRegistrationInfo.getPassword()));
            userRepository.save(userRegistrationInfo);
        }
        else {
            log.info("UserName Already Exists");
            throw new Exception("UserName Already Exists" + userRegistrationInfo.getUserName()  );
        }
    }



    public void checkLoginCredentials(UserLoginInfo userLoginInfo) throws Exception {
        UserRegistrationInfo checkUserExists = userRepository.findByUserName(userLoginInfo.getUserName());
        if(checkUserExists == null){
            log.info("UserName Does Not Exists/Register first");
           throw  new RuntimeException("UserName does not");
        }
        else {
            String decryptedPassword = encryptionConfig.decrypt(checkUserExists.getPassword());
            if(!checkUserExists.getPassword().equals(decryptedPassword)) {
                log.info("Wrong Password /Enter Again");
                throw new RuntimeException("Wrong Password /Enter Again");
            }
        }

    }
}
