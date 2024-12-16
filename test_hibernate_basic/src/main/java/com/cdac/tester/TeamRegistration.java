package com.cdac.tester;

import java.util.Scanner;

import javax.swing.event.TableColumnModelEvent;

import static com.cdac.utils.HibernateUtils.getSessionFactory;
import org.hibernate.SessionFactory;

import com.cdac.daos.TeamDao;
import com.cdac.daos.TeamDaoImpl;
import com.cdac.entities.Team;

public class TeamRegistration {
	public static void main(String[] args) {

		try (SessionFactory sf= getSessionFactory();
				Scanner sc = new Scanner(System.in)){
			TeamDao teamDao = new TeamDaoImpl();
			System.out.println("Enter Team details = name,abbreviation,owner,maxPlayerAge,battingAvg,wicketsTaken ");
			Team newTeam = new Team(sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextInt(),sc.nextDouble(),sc.nextInt());
			System.out.println(teamDao.addTeam(newTeam));
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
}
