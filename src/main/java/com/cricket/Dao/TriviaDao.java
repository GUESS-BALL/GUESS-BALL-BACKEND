package com.cricket.Dao;

import com.cricket.entities.Trivia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TriviaDao extends JpaRepository<Trivia,Integer> {
}
