package com.cricket.controller;

import com.cricket.Services.LeaderboardService;
import com.cricket.Services.MatchHistoryService;
import com.cricket.Services.OverallLeaderboardService;
import com.cricket.entities.Leaderboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class LeaderboardController {

    @Autowired
    private LeaderboardService leaderboardService;

    @Autowired
    private OverallLeaderboardService overallLeaderboardService;

    @Autowired
    private MatchHistoryService matchHistoryService;

    @GetMapping("/Leaderboard")
    public List<Leaderboard> getAll(){
        return leaderboardService.getLeaderboard();
    }

    @PostMapping("/increment/{username}")
    public Leaderboard increment(@PathVariable(value = "username") String username){
        overallLeaderboardService.increment(username,true);
        matchHistoryService.process(username,true);
        return leaderboardService.increaseScore(username);
    }

    @PostMapping("/decrement/{username}")
    public Leaderboard decrement(@PathVariable(value = "username") String username){
        overallLeaderboardService.increment(username,false);
        matchHistoryService.process(username,false);
        return leaderboardService.decreaseScore(username);
    }

    @DeleteMapping("/Leaderboard")
    public void deleteAll(){
        leaderboardService.removeAll();
    }

    @DeleteMapping("/Leaderboard/{id}")
    public void deleteById(@PathVariable(value = "id") int id){
        leaderboardService.removeById(id);
    }

}
