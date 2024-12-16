package com.cdac.daos;

import com.cdac.entities.Team;
import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.io.Serializable;
import java.util.List;

import org.hibernate.*;


public class TeamDaoImpl implements TeamDao{

	@Override
	public String addTeam(Team team) {
		String mesg = "Team Registration Failed!!!!!";
		
		Session session = getSessionFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		try {
			Serializable teamId = session.save(team);
			tx.commit();
			mesg = " Team Added Successfully ! " + teamId;
			
		}catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		
		return mesg;
	}

	@Override
	public List<Team> getAllTeams() {
		String jpql = "select t from Team t";
		List<Team> teams = null;
		Session session = getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			teams =session.createQuery(jpql, Team.class).getResultList();
			tx.commit();
			
		} catch (Exception e) {
			if (tx !=null) 
				tx.rollback();
				
			throw e;
			
		}
		
		return teams;
	}

	@Override
	public List<Team> getSelectedTeams(int maxPlayerAge, double battingAvg) {
		List<Team> teams = null;
		String jpql = "select t from Team t where t.maxPlayerAge < :maxage and t.battingAvg > :battingavg ";
		
		Session session = getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			teams = session.createQuery(jpql, Team.class).setParameter("maxage", maxPlayerAge).setParameter("battingavg", battingAvg)
					.getResultList();
			
			tx.commit();
		} catch (RuntimeException e) {
			
			if (tx != null)
				tx.rollback();
			
			throw e;
		}

		return teams;
	}

	@Override
	public List<Team> getOwnerAndTeam(int maxPlayerAge, double battingAvg) {
		List<Team> teams = null;
String jpql = "select new com.cdac.entities.Team(owner,abbreviation) from Team t where t.maxPlayerAge < :maxage and t.battingAvg > :battingavg ";
		
		Session session = getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			teams = session.createQuery(jpql, Team.class).setParameter("maxage", maxPlayerAge).setParameter("battingavg", battingAvg)
					.getResultList();
			
			tx.commit();
		} catch (RuntimeException e) {
			
			if (tx != null)
				tx.rollback();
			
			throw e;
		}

		return teams;
	}

	@Override
	public String updateAge(String name,int newAge) {
		Team team = null;
		String mesg = "Max Age updation failed !!!";
		String jpql = "select t from Team t where t.name=:name";
		Session session = getSessionFactory().getCurrentSession();
	
		Transaction tx = session.beginTransaction();
		try {
			team =session.createQuery(jpql,Team.class)
					.setParameter("name", name)
					.getSingleResult();
			
			team.setMaxPlayerAge(newAge);
			
			tx.commit();
			mesg="Max Age Updated!!!";
			
		}catch (Exception e) {
			if (tx != null)
				tx.rollback();
			
			throw e;
		}
		
		
		return mesg;
	}

	@Override
	public String deleteById(long teamId) {
		String msg = "Deletion Failed!!!";
		Team team = null;
		
		Session session = getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			team = session.get(Team .class, teamId );
			if(team!=null) {
				session.delete(team);
				
			}
			tx.commit();
			msg= "Team Deleted !!!";
			
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			throw e;
		}
		
		return msg;
	}

	@Override
	public Team getPlayerDetailsById(Long teamId) {
		Team team =null;
		String jpql = "select t from Team t left join fetch t.PlayerList where t.id=:id";
		Session session= getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
		
			team =session.createQuery(jpql,Team.class)
					.setParameter("id",teamId ).getSingleResult();
			
			tx.commit();
		}catch (Exception e) {
			if (tx != null)
				tx.rollback();
			
			throw e;
		}
		
		
		return team;
	}
	
	
	
	

}
