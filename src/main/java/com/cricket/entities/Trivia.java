package com.cricket.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Trivia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String question;
    String options;
    String answer;
    String answerdescription;

    public Trivia(String question, String options, String answer, String answerdescription) {
        this.question = question;
        this.options = options;
        this.answer = answer;
        this.answerdescription = answerdescription;
    }
}
