package com.cdac.tester;
import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.daos.PlayerDao;
import com.cdac.daos.PlayerDaoImpl;
import com.cdac.entities.Player;
public class AddPlayer {

	public static void main(String[] args) {
		try(SessionFactory sf = getSessionFactory();
				Scanner sc = new Scanner(System.in)) {
			PlayerDao playerDao = new PlayerDaoImpl();
			System.out.println("Enter Player First Name,Last Name,Dob,Batting Average,wickets taken : ");
			Player player = new Player(sc.next(),sc.next(),LocalDate.parse(sc.next()),sc.nextDouble(),sc.nextInt());
			System.out.println("Success!!!");
			System.out.println("Enter Team id : ");
			System.out.println(playerDao.addNewPlayer(player,sc.nextLong()));
		} catch (Exception e) {
			e.printStackTrace();		}
	}
	
}
