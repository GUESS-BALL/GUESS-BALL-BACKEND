package com.cricket.controller;

import com.cricket.Services.LeaderboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin("*")
public class cricketball {

    @Autowired
    private LeaderboardService leaderboardService;

    public String status = "buttonstyle";
    public Date newUpdateTime = new Date();
    public int lastBallScore = -1;
    public String lastSection = "";

    public static String match = "INDIA VS NEWZEALAND";

    @GetMapping("/getStatus")
    public String getStatus(){
        return this.status;
    }

    @PostMapping("/changeStatus/{s}")
    public String postStatus(@PathVariable(value = "s") String s){
        this.status = s;
        return this.status;
    }

    @GetMapping("/isBallUpdated/{time}")
    public int isBallUpdated(@PathVariable(value = "time") String time){
//        System.out.println(time);
//        System.out.println(newUpdateTime.toString());
//        System.out.println("--------");
        if(!(newUpdateTime.toString().equals(time))){return lastBallScore;}
        else{ return -1;}
    }

    @GetMapping("/getLastBallTime")
    public String getTime(){
        return newUpdateTime.toString();
    }

    @PostMapping("/updateBall/{score}")
    public int updateBall(@PathVariable(value = "score") int score){
        System.out.println(score);
        newUpdateTime = new Date();
        lastBallScore = score;
        return lastBallScore;
    }

    @PostMapping("/updateSection/{section}")
    public void updateSection(@PathVariable(value = "section") String section){
        lastSection = section;
    }

    @GetMapping("/isSectionUpdated/{time}")
    public String getGroundSection(@PathVariable(value = "time") String time){
        if(!(newUpdateTime.toString().equals(time))){return lastSection;}
        else{ return "";}
    }

    @PostMapping("/match/{name}")
    public String changeMatch(@PathVariable(name = "name") String name){
        leaderboardService.removeAll();
        match = name;
        return name;
    }

}
