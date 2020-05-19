package com.pw.testproject;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.text.ParseException;

import org.junit.jupiter.api.Test;

class StorageMemoryTest {

	@Test
	void testNewSample() throws ParseException {
		StorageInterface sm = new StorageMemory();
		sm.newSample(0.4, -1);
	}

	@Test
	void testAddSampleValue() {
		StorageInterface sm = new StorageMemory();
		assertThrows(NullPointerException.class, () -> sm.addSampleValue(-1, 499d));
	}

	@Test
	void testDeleteSample() {
		StorageInterface sm = new StorageMemory();
		assertThrows(NullPointerException.class, () -> sm.deleteSample(20));
	}

}
