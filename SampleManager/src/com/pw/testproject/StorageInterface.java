package com.pw.testproject;

import java.text.ParseException;
import java.util.List;

public interface StorageInterface {
	
	List<Sample> getSampleList();
	
	List<Sample> readInSamples();
	
	List<Sample> getAllSamples();

	List<Sample> getAllSamplesById();

	List<Sample> getAllSamplesByDate();

	List<Sample> getAllSamplesByResult();

	Sample newSample(double value, int sampleCounter) throws ParseException;

	Sample addSampleValue(int id, double value);

	void deleteSample(int id);
}
