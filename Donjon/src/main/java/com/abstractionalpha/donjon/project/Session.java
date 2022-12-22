package com.abstractionalpha.donjon.project;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Session {

	private LocalDateTime start;
	private LocalDateTime end;
	
	private ArrayList<String> notes;
	private ArrayList<LocalDateTime> notesTimestamps;
	
	public Session() {
		
		start = LocalDateTime.now();
		
		notes = new ArrayList<String>();
		notesTimestamps = new ArrayList<LocalDateTime>();
	}
	
	public void addNote( String note ) {
		
		notes.add( note );
		notesTimestamps.add( LocalDateTime.now() );
		
	}
	
	public void finish() {
		
		end = LocalDateTime.now();
		
	}
	
	public long elapsed() { return Duration.between(start, end).toMinutes(); }
	
	// TODO implement later
	// public Object toXml() { return null; }
	
}
