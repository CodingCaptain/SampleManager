package com.pw.testproject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class StorageMemory implements StorageInterface {

	private List<Sample> sampleList;
	
	/**
	 * generating new sampleList
	 */
	@Override
	public List<Sample> readInSamples() {

		sampleList = new ArrayList<>();

		// generating data for sampleList
		for (int i = 0; i < 10; i++) {
			int randomNum = ThreadLocalRandom.current().nextInt(1950, 2000 + 1);
			Sample sample = new Sample();
			sample.setId(i);
			sample.setValue(0.1 * i);
			try {
				sample.setDate("26.10." + randomNum + " 01:21:00");
			} catch (ParseException e) {
				e.printStackTrace();
			}
			sampleList.add(sample);
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
	 * get reduced sampleList of results with positive, questionable or negative only
	 */
	@Override
	public List<Sample> getOnlySamplesOfResult(String result) {
		List<Sample> sl = sampleList;
		List<Sample> slo = new ArrayList<>();
		for(Sample s : sl) {
			if(s.getResult().contains(result)) {
				slo.add(s);
			}
		}
		return slo;		
	}

	/**
	 * create new sample by providing value
	 */
	@Override
	public Sample newSample(double value, int sampleCounter) throws ParseException {
		Sample sample = new Sample();
		sample.setId(sampleCounter);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
		sample.setDate(sdf.format(date));
		sample.setValue(value);
		return sample;
	}

	/**
	 * update value for existing sample in sampleList
	 */
	@Override
	public Sample addSampleValue(int id, double value) {
		sampleList.get(id).setValue(value);
		return sampleList.get(id);
	}

	/**
	 * check id in sampleList and delete corresponding sample
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
	}
}
