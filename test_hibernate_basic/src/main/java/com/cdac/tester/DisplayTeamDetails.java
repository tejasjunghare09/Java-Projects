package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

import org.hibernate.SessionFactory;

import com.cdac.daos.TeamDao;
import com.cdac.daos.TeamDaoImpl;
public class DisplayTeamDetails {
	public static void main(String[] args) {
		try(SessionFactory sf = getSessionFactory()){
			TeamDao teamDao = new TeamDaoImpl();
			teamDao.getAllTeams().forEach(System.out::println);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
