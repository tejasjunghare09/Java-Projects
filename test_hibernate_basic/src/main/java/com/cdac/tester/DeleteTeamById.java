package com.cdac.tester;
import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.daos.TeamDao;
import com.cdac.daos.TeamDaoImpl;
public class DeleteTeamById {

	public static void main(String[] args) {

		try(SessionFactory sf = getSessionFactory();
				Scanner sc = new Scanner(System.in);)
		{
			TeamDao teamDao = new TeamDaoImpl();
			System.out.println("Enter Team id to Delete : ");
			System.out.println(teamDao.deleteById(sc.nextLong()));
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
