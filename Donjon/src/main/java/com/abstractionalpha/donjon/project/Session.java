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
		end = null;
		
		notes = new ArrayList<String>();
		notesTimestamps = new ArrayList<LocalDateTime>();
	}
	
	public void addNote( String note ) throws IllegalStateException {
		
		if ( end == null ) {
			
			notes.add( note );
			notesTimestamps.add( LocalDateTime.now() );
			
		} else {
			
			throw new IllegalStateException( "Session is finished." );
			
		}
		
	}
	
	public void finish() throws IllegalStateException {
		
		if ( end == null ) {
			
			end = LocalDateTime.now();
			
		} else {
		
			throw new IllegalStateException( "Session is already finished." );
		
		}
		
	}
	
	public long elapsed() throws IllegalStateException {
		
		if ( end == null ) {
			
			throw new IllegalStateException( "Session has not yet finished." );
			
		} else {
			
			return Duration.between( start, end ).toMinutes();
			
		}
		
	}
	
	// TODO implement later
	// public Object toXml() { return null; }
	
}
