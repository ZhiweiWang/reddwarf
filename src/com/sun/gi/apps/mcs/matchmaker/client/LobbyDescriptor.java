package com.sun.gi.apps.mcs.matchmaker.client;

import com.sun.gi.utils.SGSUUID;

/**
 * 
 * <p>Title: LobbyDescriptor</p>
 * 
 * <p>Description: A simple, immutable, value object that represents the contents of a Lobby
 * in the match making application.</p>
 * 
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Sun Microsystems, TMI</p>
 * 
 * @author	Sten Anderson
 * @version 1.0
 */
public class LobbyDescriptor {

	private SGSUUID lobbyID;
	private String name;
	private String description;
	private int numUsers;
	private int maxUsers;
	private boolean passwordProtected;
	
	public LobbyDescriptor(SGSUUID id, String name, String desc, int numUsers, int maxUsers, boolean passwordProtected) {
		this.lobbyID = id;
		this.name = name;
		this.description = desc;
		this.numUsers = numUsers;
		this.maxUsers = maxUsers;
		this.passwordProtected = passwordProtected;
	}
	
	public SGSUUID getLobbyID() {
		return lobbyID;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getNumUsers() {
		return numUsers;
	}
	
	public int getMaxUsers() {
		return maxUsers;
	}
	
	public boolean isPasswordProtected() {
		return passwordProtected;
	}
	
}
