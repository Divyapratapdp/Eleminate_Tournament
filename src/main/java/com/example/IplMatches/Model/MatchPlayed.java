package com.example.IplMatches.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MatchPlayed {
    @Id
    Integer serialNo;
    String teamA;
    String teamB;
    String Winner;
}
