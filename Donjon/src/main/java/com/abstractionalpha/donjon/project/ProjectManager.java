package com.abstractionalpha.donjon.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ProjectManager {
	
	private HashMap<String, Project> projects;
	private HashSet<Session> active;
	
	private static ProjectManager singleton;
	
	private ProjectManager() {
		
		projects = new HashMap<String, Project>();
		active = new HashSet<Session>();
		
		singleton = this;
		
	}
	
	public void addProject( String name ) throws IllegalArgumentException {
		
		if ( getProject( name ) == null ) {
		
			projects.put( name, new Project( name ) );
			
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
		
		return projects.get( name );
		
	}
	
	public void addNote( Session session, String note ) throws IllegalArgumentException {
		
		validate( session );
		
		if ( active.contains( session ) ) {
			
			session.addNote(note);
			
		} else {
			
			throw new IllegalArgumentException( "Session isn't active." );
			
		}
		
		
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
