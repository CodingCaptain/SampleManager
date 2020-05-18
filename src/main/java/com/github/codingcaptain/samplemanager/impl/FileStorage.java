package com.github.codingcaptain.samplemanager.impl;

import java.util.List;

import com.github.codingcaptain.samplemanager.ESampleResult;
import com.github.codingcaptain.samplemanager.Sample;
import com.github.codingcaptain.samplemanager.api.ISampleStorage;

public class FileStorage implements ISampleStorage {

	public FileStorage(String fileName) {
	}

	@Override
	public List<Sample> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sample> getAllOrderedByDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sample> getByResult(ESampleResult result) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sample save(Sample sample) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sample updateValue(int id, double value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

}
