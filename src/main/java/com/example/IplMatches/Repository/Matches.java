package com.example.IplMatches.Repository;

import com.example.IplMatches.Model.MatchPlayed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Matches extends JpaRepository<MatchPlayed,Integer> {

}
