package com.cdac.tester;
import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.daos.PlayerDao;
import com.cdac.daos.PlayerDaoImpl;
import com.cdac.daos.TeamDao;
import com.cdac.daos.TeamDaoImpl;
import com.cdac.entities.Team;
public class DisplayTeamAndPlayerDetails {
	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory();
				Scanner sc = new Scanner(System.in)) {
			
			TeamDao teamDao = new TeamDaoImpl();			
			System.out.println("Enter id to search - ");			
			Team team=teamDao.getPlayerDetailsById(sc.nextLong());
			System.out.println(team);
			System.out.println("All players - ");
			team.getPlayerList().
			forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
