package com.cricket.controller;

import com.cricket.Services.OverallLeaderboardService;
import com.cricket.Services.UserCredentialsService;
import com.cricket.entities.OverallLeaderboard;
import com.cricket.entities.UserCredentials;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@RestController
@CrossOrigin("*")
public class UserCredentialsController {

    @Autowired
    UserCredentialsService userCredentialsService;

    @Autowired
    OverallLeaderboardService overallLeaderboardService;

    @PostMapping("/getValidation")
    public String validateCredentials(@RequestBody UserCredentials userCredentials){
        if(userCredentialsService.validate(userCredentials)){
            return getUser(userCredentials.getEmail()).getRole();
        }
        return "Wrong Credentials";
    }

    @GetMapping("/userCredentials/{username}")
    public UserCredentials getUser(@PathVariable(value = "username") String username){
        return userCredentialsService.getUserByUsername(username);
    }

    @PostMapping("/UserCredentials")
    public UserCredentials insertUser(@RequestBody UserCredentials userCredentials){
        if(userCredentials.getRole()==null){
            userCredentials.setRole("USER");
        }
        overallLeaderboardService.insertOne(new OverallLeaderboard(userCredentials.getFirstname() , userCredentials.getLastname(), userCredentials.getDob(), userCredentials.getEmail(),300,0,0,0,0));
        return userCredentialsService.insertUser(userCredentials);
    }

    @DeleteMapping("/UserCredentials/{username}")
    public void deleteUser(@PathVariable(value = "username") String username){
        userCredentialsService.deleteUser(username);
    }

    @DeleteMapping("/UserCredentials")
    public void deleteUsers(){
        userCredentialsService.deleteAll();
    }
}
