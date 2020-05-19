package com.pw.testproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class StorageFile implements StorageInterface {

	private List<Sample> sampleList;
	
	/**
	 * read in sampleList from text file
	 */
	@Override
	public List<Sample> readInSamples() {

		sampleList = new ArrayList<>();		

		try {
			Scanner scanner = new Scanner(new File("output.txt"));
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				Sample s = new Sample();
				// read in values and save them to new sample
				String[] sampleEntries = line.split(";");

				s.setId(Integer.parseInt(sampleEntries[0]));
				try {
					s.setDate(sampleEntries[1]);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				s.setValue(Double.parseDouble(sampleEntries[2]));
				s.setResult(sampleEntries[3]);

				// add sample to sampleList
				sampleList.add(s);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return sampleList;
	}

	
	/**
	 * return sampleList without filtering
	 */
	@Override
	public List<Sample> getAllSamples() {
		return sampleList;
	}


	/**
	 * return sampleList after ordering by id
	 */
	@Override
	public List<Sample> getAllSamplesById() {
		Collections.sort(sampleList, new Comparator<Sample>() {
			public int compare(Sample s1, Sample s2) {
				return s1.getId() - s2.getId();
			}
		});
		return sampleList;
	}


	/**
	 * return sampleList after ordering by date
	 */
	@Override
	public List<Sample> getAllSamplesByDate() {
		List<Sample> sl = sampleList;
		Collections.sort(sl, new Comparator<Sample>() {
			public int compare(Sample s1, Sample s2) {
				return s1.getDate().compareTo(s2.getDate());
			}
		});
		return sl;
	}
	
	/**
	 * return sampleList after ordering by result string
	 */
	@Override
	public List<Sample> getAllSamplesByResult() {
		List<Sample> sl = sampleList;
		Collections.sort(sl, new Comparator<Sample>() {
			public int compare(Sample s1, Sample s2) {
				return s1.getResult().compareTo(s2.getResult());
			}
		});
		return sl;
	}
	
	/**
	 * create new sample by providing value
	 * and update output file
	 */
	@Override
	public Sample newSample(double value, int sampleCounter) throws ParseException {
		Sample sample = new Sample();
		sample.setId(sampleCounter);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
		sample.setDate(sdf.format(date));
		sample.setValue(value);
		sampleList.add(sample);

		FileWriter fw;
		try {
			fw = new FileWriter("output.txt");
			String output = "";
			for (Sample s : sampleList) {
				output = s.getId() + ";" + s.parsedDate() + ";";
				output += Math.round(s.getValue() * 100.0) / 100.0 + ";";
				output += s.getResult();
				fw.write(output + "\n");
			}
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sample;
	}
	
	/**
	 * update value for existing sample in sampleList
	 * and update output file 
	 */
	@Override
	public Sample addSampleValue(int id, double value) {
		sampleList.get(id).setValue(value);

		FileWriter fw;
		try {
			fw = new FileWriter("output.txt");
			String output = "";
			for (Sample s : sampleList) {
				output = s.getId() + ";" + s.parsedDate() + ";";
				output += Math.round(s.getValue() * 100.0) / 100.0 + ";";
				output += s.getResult();
				fw.write(output + "\n");
			}
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sampleList.get(id);
	}
	
	/**
	 * check id in sampleList, delete corresponding sample
	 * and update output file
	 */
	@Override
	public void deleteSample(int id) {

		int counter = 0;
		Sample testSample = new Sample();
		for (Sample s : sampleList) {
			if (s.getId() == id) {
				testSample = s;
			} else {
				counter++;
			}
		}

		if (!(counter == sampleList.size())) {
			if (sampleList.remove(testSample)) {
				System.out.println("successfully removed sample " + id);
			} else {
				System.out.println("could not remove sample " + id);
			}
		} else {
			System.out.println("could not remove sample " + id);
		}

		FileWriter fw;
		try {
			fw = new FileWriter("output.txt");
			String output = "";
			for (Sample s : sampleList) {
				output = s.getId() + ";" + s.parsedDate() + ";";
				output += Math.round(s.getValue() * 100.0) / 100.0 + ";";
				output += s.getResult();
				fw.write(output + "\n");
			}
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
