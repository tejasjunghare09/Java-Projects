package com.cdac.tester;
import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.daos.TeamDao;
import com.cdac.daos.TeamDaoImpl;
public class UpdateAgeByTeam {

	public static void main(String[] args) {

		try(SessionFactory sf = getSessionFactory();
				Scanner sc = new Scanner(System.in);)
		{
			TeamDao teamDao = new TeamDaoImpl();
			System.out.println("Enter Team Name and Max Age to Update ");
			System.out.println(teamDao.updateAge(sc.next(),sc.nextInt()));
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
