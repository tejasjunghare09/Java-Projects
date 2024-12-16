package com.cdac.tester;
import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.daos.PlayerDao;
import com.cdac.daos.PlayerDaoImpl;
public class RemovePlayerFromTeam {

	public static void main(String[] args) {
		try(SessionFactory sf = getSessionFactory();
				Scanner sc = new Scanner(System.in)){
				PlayerDao playerDao = new PlayerDaoImpl();
				System.out.println("Enter Team id and Player id : ");
				System.out.println(playerDao.removePlayer(sc.nextLong(),sc.nextLong()));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
