package com.cricket.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCredentials {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String email;
    String password;
    String role;
    String firstname;
    String lastname;
    String dob;
}