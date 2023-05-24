package com.example.IplMatches.Repository;

import com.example.IplMatches.Model.TeamDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<TeamDetails,Integer> {

}
