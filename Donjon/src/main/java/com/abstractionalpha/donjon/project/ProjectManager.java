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
	
	public void addProject( String name ) {}
	
	public void addSession( String projectName ) {}
	
	public void addNote( Session session ) {}
	
	public void finish( Session session ) {}
	
	// TODO implement later
	// public Object toXml() { return null; }
	
	public static ProjectManager getInstance() {
		
		return singleton;
		
	}
	
}
