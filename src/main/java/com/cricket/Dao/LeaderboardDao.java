package com.cricket.Dao;

import com.cricket.entities.Leaderboard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaderboardDao extends JpaRepository<Leaderboard,Integer> {

    public boolean existsByUsername(String username);
    public List<Leaderboard> findTop8ByOrderByScoreDesc();
    public Leaderboard findByUsername(String username);
}
