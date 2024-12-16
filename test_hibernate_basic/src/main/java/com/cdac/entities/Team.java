package com.cdac.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name ="teams")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true ,exclude = "PlayerList")
public class Team extends BaseEntity {

	
	
	@Column(length =100, name = "name",unique = true)
	private String name;
	@Column(length = 10,name = "abbreviation",unique = true)
	private String abbreviation;
	@Column(length = 50,name = "owner" ,nullable = false)
	private String owner;
	@Column(length = 10,name = "max_player_age")
	private int maxPlayerAge;
	@Column(length =10,name = "batting_avg")
	private double battingAvg;
	@Column(length = 10,name = "wickets_taken")
	private int wicketsTaken;
	
	
	@OneToMany(mappedBy = "teamPlayer",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private List<Player> PlayerList = new ArrayList<>();
	
	
	
	public Team(String owner,String abbreviation ) {
		super();
		this.abbreviation = abbreviation;
		this.owner = owner;
	}

	public Team( String name, String abbreviation, String owner, int maxPlayerAge, double battingAvg,
			int wicketsTaken) {
		super();
		
		this.name = name;
		this.abbreviation = abbreviation;
		this.owner = owner;
		this.maxPlayerAge = maxPlayerAge;
		this.battingAvg = battingAvg;
		this.wicketsTaken = wicketsTaken;
	}

	//Helper Methods 
	public void addPlayer(Player player) {
		this.PlayerList.add(player);
		player.setTeamPlayer(this);

	}
	public void removePlayer(Player player) {
		this.PlayerList.remove(player);
		player.setTeamPlayer(null);
	}
	
	
	
	
}
