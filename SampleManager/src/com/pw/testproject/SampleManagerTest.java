package com.pw.testproject;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;

import org.junit.jupiter.api.Test;

import java.io.IOException;


class SampleManagerTest {

	@Test
	void test() throws ParseException, IOException {

		SampleManager sm = new SampleManager();
		
		assertThrows(NullPointerException.class, () -> sm.printSample(null));
				
	}

}
