package com.github.codingcaptain.samplemanager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.codingcaptain.samplemanager.api.ISampleStorage;
import com.github.codingcaptain.samplemanager.impl.DatabaseStorage;
import com.github.codingcaptain.samplemanager.impl.FileStorage;
import com.github.codingcaptain.samplemanager.impl.InMemoryStorage;

public class SampleStorageTest {

	List<ISampleStorage> storages;
	
	@BeforeEach
	private void setupEach() {
		storages = new ArrayList<>();
		storages.add(new DatabaseStorage("jdbc://h2:localhost/mydatabase", "jim", "kirk", "samples"));
		storages.add(new InMemoryStorage());
		storages.add(new FileStorage("/home/tmp/storage.txt"));
	}

	@Test
	public void testSaveAndGetAll() {
		for (final ISampleStorage storage : storages) {
			testSaveAndGetAll(storage);
		}
	}
	
	private void testSaveAndGetAll(ISampleStorage storage) {
		Sample sample = new Sample();
		sample.setId(1);
		sample.setValues(Arrays.asList(5d));
		storage.save(sample);

		assertEquals(1, storage.getAll().size());
		assertEquals(Arrays.asList(1), storage.getAll().get(0).getId());
		assertEquals(Arrays.asList(5d), storage.getAll().get(0).getValue(0));
	}

}
