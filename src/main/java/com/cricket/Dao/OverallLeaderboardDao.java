package com.cricket.Dao;

import com.cricket.entities.OverallLeaderboard;
import com.cricket.entities.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OverallLeaderboardDao extends JpaRepository<OverallLeaderboard,Integer> {

    public boolean existsByEmail(String email);
    public OverallLeaderboard findByEmail(String email);
    public List<OverallLeaderboard> findAllByOrderByCoinbalanceDesc();
}
