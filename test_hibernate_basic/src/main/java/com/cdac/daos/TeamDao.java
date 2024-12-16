package com.cdac.daos;

import java.util.List;

import com.cdac.entities.Team;

public interface TeamDao {
	
	String addTeam(Team team);

	List<Team> getAllTeams();

	List<Team> getSelectedTeams(int maxPlayerAge, double battingAvg);

	List<Team> getOwnerAndTeam(int maxPlayerAge, double battingAvg);

	String updateAge(String name,int newAge);

	String deleteById(long nextLong);
	
	Team getPlayerDetailsById(Long teamId);

}
