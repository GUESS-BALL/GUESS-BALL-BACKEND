package com.cricket.Dao;

import com.cricket.entities.MatchHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchHistoryDao extends JpaRepository<MatchHistory,Integer> {

    public List<MatchHistory> findAllByMatchname(String match);
    public List<MatchHistory> findAllByEmail(String email);
    public MatchHistory findByEmailAndMatchname(String email,String match);
    public long countByEmail(String email);
}
