package com.cdac.daos;

import org.hibernate.Session;
import org.hibernate.Transaction;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

import com.cdac.entities.Player;
import com.cdac.entities.Team;

public class PlayerDaoImpl implements PlayerDao {

	@Override
	public String addNewPlayer(Player player,Long teamId) {
		String mesg= "Adding Player Failed";
		Session session = getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Team team = session.get(Team.class, teamId);
			if(team!= null) {
				team.addPlayer(player);
			}
			
			tx.commit();
			mesg = "added new Player with id=" + player.getId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			
			throw e;
		}
		return mesg;
	}

	@Override
	public String removePlayer(long teamId,long playerId) {
		String mesg = "Removing Player Failed !!!";
		Session session = getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Team team = session.get(Team.class,teamId );
			Player player = session.get(Player.class,playerId );
			if(team!=null && player!=null) {
				team.removePlayer(player);
				mesg = "Player Deleted Successfully !!!";
			}
			tx.commit();
		}catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			
			throw e;
		}
		
		return mesg;
	}

	

}
