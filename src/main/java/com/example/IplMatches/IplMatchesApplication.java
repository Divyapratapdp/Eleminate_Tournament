package com.example.IplMatches;

import com.example.IplMatches.Model.TeamDetails;
import com.example.IplMatches.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@SpringBootApplication
@Component
public class IplMatchesApplication {
	 private static TeamRepository teamRepository;
	 @Autowired
	 public IplMatchesApplication(TeamRepository teamRepository){
		 this.teamRepository=teamRepository;
	 }
	static Scanner s=new Scanner(System.in);

	public static void saveTeam(Integer noOfTeams){
		for(int i=1;i<=noOfTeams;i++){
			TeamDetails teamDetails=new TeamDetails();
			System.out.println("Enter team Name");
			String name=s.next();
			teamDetails.setId(i);
			teamDetails.setName(name);
			teamDetails.setInGame(true);
			teamRepository.save(teamDetails);
		}

	}
	private static void tournament(Integer noOfMatches) {
		Integer matchNo=1;
		if(noOfMatches+1%2==1){
			System.out.println("Match number ="+matchNo);
			TeamDetails teamA=teamRepository.getById(1);
			TeamDetails teamB=teamRepository.getById(2);
			System.out.println(teamA.getName()+" Vs "+teamB.getName());
			System.out.println("Enter Eliminated team ID");
			Integer l=s.nextInt();
			matchNo++;
			if(l==teamB.getId()){
				teamB.setInGame(false);
				teamRepository.save(teamB);
			}else {
				teamA.setInGame(false);
				teamRepository.save(teamA);
			}
		}
			Integer a=1;
		System.out.println(a);
		while(matchNo<=noOfMatches){
			System.out.println("Match number ="+matchNo);
			TeamDetails teamA = new TeamDetails();
			TeamDetails teamB = new TeamDetails();
			for(int n=0;n<noOfMatches+1;n++){
				boolean gotB=false;
				teamA=teamRepository.getById(a);
				if(teamA.isInGame()){
					a=a+1;
					if(a>noOfMatches+1){a=1;}
					for(int i=n;i<noOfMatches+1;i++){
						teamB=teamRepository.getById(a);
						if(teamB.isInGame()==true){
							gotB=true;
							break;
						}
						a++;
						if(a>noOfMatches+1){
							a=1;
						}
					}
				}
				if(gotB){
					a++;
					if(a>noOfMatches+1){a=1;}
					break;
				}
			a++;
			if(a>noOfMatches+1){a=1;}
			}
			System.out.println(teamA.getId()+"-"+teamA.getName()+" Vs "+teamB.getId()+"-"+teamB.getName());
			System.out.println("Enter Eliminated team ID");
			Integer l=s.nextInt();
			if(matchNo==noOfMatches){
				if(l==teamB.getId()) {
					System.out.println("Winner is:"+teamA.getName());
				}
				else {
					System.out.println("Winner is:"+teamB.getName());
				}
			}
			matchNo++;
			if(l==teamB.getId()){
				teamB.setInGame(false);
				teamRepository.save(teamB);
			}else {
				teamA.setInGame(false);
				teamRepository.save(teamA);
			}
		}
	}


	public static void main(String[] args) {
		SpringApplication.run(IplMatchesApplication.class, args);
		System.out.println("Enter no of teams:");
		int noOfTeams=s.nextInt();
		saveTeam(noOfTeams);
		int noOfMatches=noOfTeams-1;
		System.out.println("Tournament Started");
		tournament(noOfMatches);
		System.out.println("Tournament Ended");
	}
}
