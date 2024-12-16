package com.cdac.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="players")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true ,exclude = "teamPlayer")

public class Player extends BaseEntity{
	
//	players(id bigint primary key auto_increment,
//	first_name varchar(20),last_name varchar(20)
//	,dob date,batting_avg double
//	,wickets_taken int,team_id int ,
//	constraint fk_teams foreign key (team_id) references teams(team_id)

	@Column(length = 20 ,name = "first_name")
	private String firstName;
	@Column(length = 20 ,name = "last_name")
	private String lastName;
	@Column(name = "dob")
	private LocalDate date;
	@Column(name = "batting_avg")
	private double battingAvg;
	@Column( name = "wickets_taken")
	private int wicketsTaken;
	
	@ManyToOne
	@JoinColumn(name = "teams_id",nullable = false)
	private Team teamPlayer;
	
	
	public Player(String firstName, String lastName, LocalDate date, double battingAvg, int wicketsTaken) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.date = date;
		this.battingAvg = battingAvg;
		this.wicketsTaken = wicketsTaken;
		
	}
	
	
	
	
	
	
	
}
