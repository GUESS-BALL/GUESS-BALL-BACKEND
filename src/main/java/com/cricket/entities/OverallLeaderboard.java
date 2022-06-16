package com.cricket.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OverallLeaderboard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String firstname;
    String lastname;
    String dob;
    String email;
    int coinbalance;
    int accuracy;
    int gamesplayed;
    int questionsattempted;
    int correctanswers;

    public OverallLeaderboard(String firstname, String lastname, String dob, String email, int coinbalance, int accuracy, int gamesplayed, int questionsattempted, int correctanswers) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.email = email;
        this.coinbalance = coinbalance;
        this.accuracy = accuracy;
        this.gamesplayed = gamesplayed;
        this.questionsattempted = questionsattempted;
        this.correctanswers = correctanswers;
    }
}
