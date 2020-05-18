package com.pw.testproject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class SampleManager {
	
	public static Scanner scan = new Scanner(System.in);
	public int sampleCounter = 0;
	public boolean sampleCounterFlag = true;
	
	//print samples and format data before printing
	public void printSample(Sample sample) {	
		System.out.print("Sample "+sample.getId()+ " on "+sample.parsedDate());
		// print values and results
		for(int i = 0; i<sample.getValues().size();i++) {
			System.out.print(" and has value: "); 
			System.out.print(Math.round(sample.getValue(i) * 100.0) / 100.0);
			System.out.print(" and result: ");
			System.out.print(sample.getResult(i));
		}
		System.out.print(".\n");
	}
	
	public void nextTask(ArrayList<Sample> sampleList) throws ParseException {
		
		// getting sampleList for not producing new samples with old ids
		if(sampleCounterFlag) {
			sampleCounter = sampleList.size(); 
			sampleCounterFlag = false;
		}
		
		// description for user input
		System.out.println("\nPlease choose the next task.");
		System.out.println("0: show all samples");		
		System.out.println("1: insert new sample with value");
		System.out.println("2: insert new value in sample value list");
		System.out.println("3: remove list item of id");
		System.out.println("4: exit application\n");
		int task = scan.nextInt();
		int id = 0;
		
		// switch for tasks the program do
		switch(task) {
		 
			// showing all entries sampleList ordered by id or date
			case 0:	System.out.println("0: order by id, 1: order by date\n");
					int subTask = scan.nextInt();
					
					if(subTask == 0) {
						// short form of sorting list of samples by id
						Collections.sort(sampleList, new Comparator<Sample>() {
							  public int compare(Sample s1, Sample s2) {
							      return s1.getId() - s2.getId();
							  }
						});
					}else {
						// short form of sorting list of samples by date
						Collections.sort(sampleList, new Comparator<Sample>() {
							  public int compare(Sample s1, Sample s2) {
							      return s1.getDate().compareTo(s2.getDate());
							  }
						});
					}
					
					// print list with function printSample()
					for(Sample s : sampleList) {
						printSample(s);
					}
				
					break;
			
			// saving value for sample		
			case 1: Sample sample = new Sample();
					sample.setId(sampleCounter++);
					Date date = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
					sample.setDate(sdf.format(date));
					System.out.println("Please type in value, separated by comma ,\n");
					double value = scan.nextDouble();
					sample.setValue(sample.getValues().size(),value);
					sampleList.add(sample);
					break;
				
			// saving next value in sample's valueList		
			case 2:
					System.out.println("Which sample's value list would you like to extend?\n");
					id = scan.nextInt();
					System.out.println("Please type in value, separated by comma ,\n");
					double val = scan.nextDouble();
					sampleList.get(id).getValues().add(val);
					break;
			
			// remove sample from sampleList		
			case 3: 
					System.out.println("Which sample should be removed?\n");
					id = scan.nextInt(); 
					int counter = 0;
					Sample testSample = new Sample();
					for(Sample s : sampleList) {
						if(s.getId() == id) {
							testSample = s;
						}else {
							counter++;
						}
					}
									
					if(!(counter == sampleList.size())) {
						if(sampleList.remove(testSample)){
							System.out.println("successfully removed sample "+id);}
						else {
							System.out.println("could not remove sample "+id);
						}	
					}else {
						System.out.println("could not remove sample "+id);
					}
					break;
			
			// terminating program
			case 4: 
					System.out.println("\nGoodbye!");
					System.exit(0);
					break;
				
		}
		
		nextTask(sampleList);		
	}
	
}
