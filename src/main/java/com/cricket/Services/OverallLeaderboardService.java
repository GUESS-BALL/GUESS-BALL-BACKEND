package com.cricket.Services;

import com.cricket.Dao.OverallLeaderboardDao;
import com.cricket.entities.OverallLeaderboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OverallLeaderboardService {

    @Autowired
    private OverallLeaderboardDao overallLeaderboardDao;

    public List<OverallLeaderboard> getAll(){
        return overallLeaderboardDao.findAllByOrderByCoinbalanceDesc();
    }

    public OverallLeaderboard getOne(String email){
        OverallLeaderboard overallLeaderboard =  overallLeaderboardDao.findByEmail(email);
        return overallLeaderboard;
    }

    public OverallLeaderboard insertOne(OverallLeaderboard overallLeaderboard){
        if(overallLeaderboard.getQuestionsattempted()>0){
            overallLeaderboard.setAccuracy((int)((overallLeaderboard.getCorrectanswers()/(overallLeaderboard.getQuestionsattempted()*1.0))*100));
        }
        return overallLeaderboardDao.save(overallLeaderboard);
    }

    public void increment(String email, boolean shouldIncrement){
        OverallLeaderboard overallLeaderboard = getOne(email);
        if(overallLeaderboard!=null){
            overallLeaderboard.setCoinbalance(overallLeaderboard.getCoinbalance()+(shouldIncrement ? 20 : -5));
            if(shouldIncrement){
                overallLeaderboard.setCorrectanswers(overallLeaderboard.getCorrectanswers()+1);
            }
            if(overallLeaderboard.getGamesplayed()==0){
                overallLeaderboard.setGamesplayed(1);
            }
            overallLeaderboard.setQuestionsattempted(overallLeaderboard.getQuestionsattempted()+1);
            insertOne(overallLeaderboard);
        }
    }
}
