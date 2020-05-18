package com.github.codingcaptain.sampleviewer;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import com.github.codingcaptain.samplemanager.Sample;
import com.github.codingcaptain.samplemanager.SampleManager;

// class for viewing samples
public class SampleViewer {

	public static void main(String[] args) throws IOException {		
		
		System.out.println("Welcome to a simple sample program.\n");
		ArrayList<Sample> sampleList = new ArrayList<>();
		
		// generating data for sampleList 
		// works without generating data but you have to type in your values to see results
		for(int i = 0; i < 10 ; i++) {
			int randomNum = ThreadLocalRandom.current().nextInt(1950, 2000 + 1);
			Sample sample = new Sample();
			sample.setId(i);
			sample.setValue(0, 0.1*i);
			try {
				sample.setDate("26-10-"+randomNum+" 01:21:00");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sampleList.add(sample);
		}
		
		
		// start managing our sampleList
		SampleManager sm = new SampleManager();

		try {
			sm.nextTask(sampleList);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			

	}	
}
