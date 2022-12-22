package com.abstractionalpha.donjon.project;

import java.util.ArrayList;

public class ProjectManager {
	
	private ArrayList<Project> projects;
	
	private ArrayList<Session> active;
	
	private static ProjectManager singleton;
	
	private ProjectManager() {
		
		projects = new ArrayList<Project>();
		active = new ArrayList<Session>();
		
		singleton = this;
		
	}
	
	public void addProject( String name ) throws IllegalArgumentException {
		
		if ( getProject( name ) == null ) {
		
			projects.add( new Project( name ) );
			
		} else {
			
			throw new IllegalArgumentException( String.format( "Project %s already exists.", name ) );
			
		}
		
	}
	
	public void addSession( String projectName ) throws IllegalArgumentException {
		
		Project project = getProject( projectName );
		if ( project != null ) {
			
			Session session = new Session();
			project.addSession( session );
			active.add( session );
			
		} else {
			
			throw new IllegalArgumentException( String.format( "Project %s does not exist.", projectName ) );
			
		}
		
	}
	
	private Project getProject( String name ) {
		
		for ( Project p : projects ) { if ( p.getName().equals( name ) )  return p; }
		
		return null;
		
	}
	
	public void addNote( Session session, String note ) throws IllegalArgumentException {
		
		validate( session );
		
		session.addNote( note );
		
	}
	
	public void finish( Session session ) {
		
		validate( session );
		
		if ( active.contains( session ) ) {
			
			active.remove( session );
			session.finish();
			
		} else {
			
			throw new IllegalArgumentException( "Session isn't active." );
			
		}
		
	}
	
	private void validate( Session session ) throws IllegalArgumentException {
		
		if ( session == null ) { throw new IllegalArgumentException( "Session is null." ); }
		
	}
	
	// TODO implement later
	// public Object toXml() { return null; }
	
	public static ProjectManager getInstance() {
		
		return singleton;
		
	}
	
}
