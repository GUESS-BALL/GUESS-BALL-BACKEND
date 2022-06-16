package com.cricket.controller;

import com.cricket.Services.MatchHistoryService;
import com.cricket.Services.OverallLeaderboardService;
import com.cricket.entities.OverallLeaderboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin("*")
public class OverallController {

    @Autowired
    private OverallLeaderboardService overallLeaderboardService;

    @Autowired
    private MatchHistoryService matchHistoryService;

    @GetMapping("/getLeaderboard")
    public List<OverallLeaderboard> getAll(){
        return overallLeaderboardService.getAll();
    }

    @GetMapping("/getLeaderboard/{email}")
    public OverallLeaderboard getOne(@PathVariable(value = "email") String email){
        OverallLeaderboard overallLeaderboard = overallLeaderboardService.getOne(email);
        overallLeaderboard.setGamesplayed((int)(matchHistoryService.matchesPlayed(email)));
        return overallLeaderboard;
    }
}
