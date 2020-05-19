package com.pw.testproject;

import java.text.ParseException;
import java.util.List;

public interface StorageInterface {
	
	/**
	 * read in samples by implementing methods like reading in from file or memory
	 * @return sampleList
	 */
	List<Sample> readInSamples();
	
	/**
	 * get all samples without filtering
	 * @return sampleList
	 */
	List<Sample> getAllSamples();

	/**
	 * order all samples by id, then get them as list
	 * @return sampleList
	 */
	List<Sample> getAllSamplesById();

	/**
	 * order all samples by date, then get them as list
	 * @return sampleList
	 */
	List<Sample> getAllSamplesByDate();

	/**
	 * order all samples by result string, then get them as list
	 * @return
	 */
	List<Sample> getAllSamplesByResult();

	/**
	 * creating new sample entry by providing a new value. The rest will be generated
	 * @param value is the value of the sample represented by a double
	 * @param sampleCounter sampleCounter for preventing overridden sample ids
	 * @return sample
	 * @throws ParseException for using parser for date formatting
	 */
	Sample newSample(double value, int sampleCounter) throws ParseException;

	/**
	 * set value for existing sample
	 * @param id for searching in sampleList
	 * @param value the value that will be updated
	 * @return sample
	 */
	Sample addSampleValue(int id, double value);

	/**
	 * delete sample with id
	 * @param id for searching in sampleList
	 */
	void deleteSample(int id);
}
