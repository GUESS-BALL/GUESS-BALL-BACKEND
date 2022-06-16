package com.cricket.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String matchname;
    String email;
    int questionsattempted;
    int correctanswers;
    int accuracy;
    int pointsgained;

    public MatchHistory(String match, String email, int questionsattempted, int correctanswers, int accuracy, int pointsgained) {
        this.matchname = match;
        this.email = email;
        this.questionsattempted = questionsattempted;
        this.correctanswers = correctanswers;
        this.accuracy = accuracy;
        this.pointsgained = pointsgained;
    }
}
