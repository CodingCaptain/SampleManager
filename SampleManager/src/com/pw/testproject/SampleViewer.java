package com.pw.testproject;

import java.io.IOException;
import java.text.ParseException;

public class SampleViewer {
	public static void main(String[] args) throws IOException {		
		
		System.out.println("Welcome to a simple sample program.\n");
		
		SampleManager sm = new SampleManager();

		try {
			sm.nextTask();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}	
}
