package com.abstractionalpha.donjon.project;

import java.util.ArrayList;

public class Project {
	
	private String name;
	
	private ArrayList<Session> sessions;
	
	public Project( String name ) {
		
		this.name = name;
		sessions = new ArrayList<Session>();
		
	}
	
	public String getName() { return name; }
	
	public void addSession( Session session ) {
		
		sessions.add( session );
		
	}
	
	protected void finish( Session session ) { session.finish(); }
	
	protected ArrayList<Session> getSessions() { return sessions; }
	
	// TODO implement later
	// public Object toXml() { return null; }

}
