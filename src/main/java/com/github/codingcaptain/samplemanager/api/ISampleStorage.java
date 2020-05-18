package com.github.codingcaptain.samplemanager.api;

import java.util.List;

import com.github.codingcaptain.samplemanager.ESampleResult;
import com.github.codingcaptain.samplemanager.Sample;

public interface ISampleStorage {
	List<Sample> getAll();

	List<Sample> getAllOrderedByDate();

	List<Sample> getByResult(ESampleResult result);

	Sample save(Sample sample);

	Sample updateValue(int id, double value);

	void delete(int id);

	default void delete(Sample sample) {
		delete(sample.getId());
	}
}
