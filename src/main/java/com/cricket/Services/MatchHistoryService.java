package com.cricket.Services;

import com.cricket.Dao.MatchHistoryDao;
import com.cricket.controller.cricketball;
import com.cricket.entities.MatchHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchHistoryService {

    @Autowired
    private MatchHistoryDao matchHistoryDao;

    public List<MatchHistory> findByMatch(String match){
        List<MatchHistory> matchHistoryList = matchHistoryDao.findAllByMatchname(match);
        matchHistoryList.sort(((o1,o2) -> o2.getPointsgained()-o1.getPointsgained()));
        return matchHistoryList;
    }

    public List<MatchHistory> findByEmail(String match){
        return matchHistoryDao.findAllByEmail(match);
    }

    public MatchHistory process(String email, boolean increment){
        MatchHistory matchHistory = matchHistoryDao.findByEmailAndMatchname(email, cricketball.match);
        if(matchHistory!=null){
            matchHistory.setQuestionsattempted(matchHistory.getQuestionsattempted()+1);
            if(increment){matchHistory.setCorrectanswers(matchHistory.getCorrectanswers()+1);}
            matchHistory.setPointsgained(increment ? matchHistory.getPointsgained()+20 : matchHistory.getPointsgained()-5);
            matchHistory.setAccuracy((int)((matchHistory.getCorrectanswers()*1.0/matchHistory.getQuestionsattempted())*100));
            return matchHistoryDao.save(matchHistory);
        }
        else{
            return matchHistoryDao.save(new MatchHistory(cricketball.match,email,1,increment ? 1 : 0,increment ? 100 : 0,increment ? 20 : -5));
        }
    }

    public long matchesPlayed(String email){
        return matchHistoryDao.countByEmail(email);
    }
}
