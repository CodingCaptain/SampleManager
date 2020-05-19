package com.pw.testproject;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SampleManager {

	private final static Scanner SCANNER = new Scanner(System.in);
	private int sampleCounter = 0;
	private boolean sampleCounterFlag = true;
	private List<Sample> sampleList = new ArrayList<>();
	private StorageInterface sm = new StorageMemory();

	SampleManager() {
		int type = -1;
		while(type != 0 && type != 1) {
			System.out.println("Would you like to read in a file? \n1: yes \n0: no\n");
			type = SCANNER.nextInt();
		}

		switch (type) {
		case 0:
			sm = new StorageMemory();
			break;
		case 1:
			sm = new StorageFile();
			break;
		}
		
		sampleList = sm.readInSamples();
	}

	/**
	 * print samples and format data before printing
	 */
	public void printSample(Sample sample) {
		System.out.print("Sample " + sample.getId() + " on " + sample.parsedDate());
		// print values and results
		System.out.print(" and has value: " + Math.round(sample.getValue() * 100.0) / 100.0);
		System.out.print(" and result: ");
		System.out.print(sample.getResult() + ".\n");
	}

	/**
	 * next user task
	 * 
	 * @param sampleList is the list of samples
	 * @throws ParseException thrown if parsing exception
	 * @throws IOException    thrown if input exception or output exception
	 */
	public void nextTask() throws ParseException, IOException {

		// getting sampleList for not producing new samples with old ids
		if (sampleCounterFlag) {
			sampleCounter = sampleList.size();
			sampleCounterFlag = false;
		}

		// description for user input
		System.out.println("\nPlease choose the next task.");
		System.out.println("0: show/save all samples");
		System.out.println("1: show/save all samples ordered by id");
		System.out.println("2: show/save all samples ordered by date");
		System.out.println("3: show/save all samples ordered by result");
		System.out.println("4: insert new sample with value");
		System.out.println("5: insert new value in sample value list");
		System.out.println("6: remove list item of id");
		System.out.println("7: exit application\n");
		int task = SCANNER.nextInt();
		int id = 0;

		// switch for tasks the program does
		switch (task) {

		// showing all entries of sampleList
		case 0:
			sampleList = sm.getAllSamples();
			// print list with function printSample()
			for (Sample s : sampleList) {
				printSample(s);
			}
			break;

		// showing all entries of sampleList ordered by id
		case 1:
			sampleList = sm.getAllSamplesById();
			// print list with function printSample()
			for (Sample s : sampleList) {
				printSample(s);
			}
			break;

		// showing all entries of sampleList ordered by date
		case 2:
			sampleList = sm.getAllSamplesByDate();
			// print list with function printSample()
			for (Sample s : sampleList) {
				printSample(s);
			}
			break;

		// showing all entries of sampleList ordered by result
		case 3:
			sampleList = sm.getAllSamplesByResult();
			// print list with function printSample()
			for (Sample s : sampleList) {
				printSample(s);
			}
			break;

		// saving value for sample
		case 4:
			System.out.println("Please type in a double value, (with comma as separator for german system language)\n");
			double value = SCANNER.nextDouble();
			sampleList.add(sm.newSample(value, sampleCounter++));
			break;

		// saving next value in sample's valueList
		case 5:
			System.out.println("Which sample's value would you like to set?\n");
			id = SCANNER.nextInt();
			System.out.println("Please type in a double value, (with comma as separator for german system language)\n");
			double val = SCANNER.nextDouble();
			sampleList.set(id, sm.addSampleValue(id, val));
			break;

		// remove sample from sampleList
		case 6:
			System.out.println("Which sample should be removed?\n");
			id = SCANNER.nextInt();
			sm.deleteSample(id);
			break;

		// terminating program
		case 7:
			System.out.println("\nGoodbye!");
			System.exit(0);
			break;
		}

		// asking for next task
		nextTask();
	}

}
