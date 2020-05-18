package com.pw.testproject;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SampleManagerTest {

	@Test
	void test() {
		Sample sample = new Sample();
		
		
		SampleManager sm = new SampleManager();
		sm.printSample(sample);		
		assertEquals(5,10);
	}

}
