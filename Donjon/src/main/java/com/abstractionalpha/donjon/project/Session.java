package com.abstractionalpha.donjon.project;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Session implements Cloneable {

	private LocalDateTime start;
	private LocalDateTime end;
	
	private ArrayList<String> notes;
	
	private Project project;
	
	public Session( Project project ) {}
	
	public void addNote( String note ) {}
	
	public void finish() {}
	
	public int elapsed() { return -1; }
	
	public Object clone() { return null; }
	
	// TODO implement later
	// public Object toXml() { return null; }
	
}
