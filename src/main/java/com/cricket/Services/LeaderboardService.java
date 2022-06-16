package com.cricket.Services;

import com.cricket.Dao.LeaderboardDao;
import com.cricket.entities.Leaderboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaderboardService {

    @Autowired
    private LeaderboardDao leaderboardDao;

    public List<Leaderboard> getLeaderboard(){
        return leaderboardDao.findTop8ByOrderByScoreDesc();
    }

    public boolean isPresent(String username){
        return leaderboardDao.existsByUsername(username);
    }

    public Leaderboard increaseScore(String username){
        if(isPresent(username)){
            Leaderboard leaderboard = leaderboardDao.findByUsername(username);
            leaderboard.setScore(leaderboard.getScore()+20);
            return leaderboardDao.save(leaderboard);
        }
        else{
            return leaderboardDao.save(new Leaderboard(username,20));
        }
    }

    public Leaderboard decreaseScore(String username){
        if(isPresent(username)){
            Leaderboard leaderboard = leaderboardDao.findByUsername(username);
            leaderboard.setScore(leaderboard.getScore()-5);
            return leaderboardDao.save(leaderboard);
        }
        else{
            return leaderboardDao.save(new Leaderboard(username,-5));
        }
    }

    public void removeAll(){
        leaderboardDao.deleteAll();
    }

    public void removeById(int id){
        leaderboardDao.deleteById(id);
    }
}
