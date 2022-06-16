package com.cricket.controller;

import com.cricket.Services.MatchHistoryService;
import com.cricket.entities.MatchHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class MatchHistoryController {

    @Autowired
    private MatchHistoryService matchHistoryService;

    @GetMapping("/findByEmail/{email}")
    public List<MatchHistory> findAllByEmail(@PathVariable(value = "email") String email){
        return matchHistoryService.findByEmail(email);
    }

    @GetMapping("/findByMatch/{match}")
    public List<MatchHistory> findAllByMatch(@PathVariable(value = "match") String match){
        return matchHistoryService.findByMatch(match);
    }

    @GetMapping("/getAllMatches")
    public List<String> getAllMatches(){
        ArrayList<String> matches = new ArrayList<>();
        List<MatchHistory> matchHistoryList = findAllByEmail("masterkiller@gmail.com");
        for(MatchHistory matchHistory:matchHistoryList){
            matches.add(matchHistory.getMatchname());
        }
        return  matches;
    }
}
