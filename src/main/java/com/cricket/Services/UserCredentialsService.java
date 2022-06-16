package com.cricket.Services;

import com.cricket.Dao.UserCredentialsDao;
import com.cricket.entities.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialsService {

    @Autowired
    private UserCredentialsDao userCredentialsDao;

    public boolean doesUserExists(String username){
        return userCredentialsDao.existsByEmail(username);
    }

    public UserCredentials getUserByUsername(String username){
        if(!doesUserExists(username)){
            return null;
        }
        return userCredentialsDao.findByEmail(username);
    }

    public void deleteUser(String username){
        if(doesUserExists(username)){
            userCredentialsDao.deleteById(getUserByUsername(username).getId());
        }
    }

    public UserCredentials insertUser(UserCredentials userCredentials){
        return userCredentialsDao.save(userCredentials);
    }

    public boolean validate(UserCredentials userCredentials){
        if(!doesUserExists(userCredentials.getEmail())){
            return false;
        }
        return getUserByUsername(userCredentials.getEmail()).getPassword().equals(userCredentials.getPassword());
    }

    public void deleteAll(){
        userCredentialsDao.deleteAll();
    }
}
