package com.example.IplMatches.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class TeamDetails {
    @Id
    Integer id;
    String name;
    boolean inGame;

}
