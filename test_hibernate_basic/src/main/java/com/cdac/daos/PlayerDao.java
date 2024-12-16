package com.cdac.daos;

import com.cdac.entities.Player;

public interface PlayerDao {

	String addNewPlayer(Player player,Long teamId);

	String removePlayer(long teamId, long playerId);

	
}
