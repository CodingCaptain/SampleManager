package com.pw.testproject;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;

import org.junit.jupiter.api.Test;

class SampleTest {

	@Test
	void testSetId() {
		Sample s = new Sample();
		assertTrue(s.getId()==0);
		s.setId(4);
		assertTrue(s.getId()==4);
	}

	@Test
	void testSetDate() {
		Sample s = new Sample();
		assertNull(s.getDate());

		assertThrows(NullPointerException.class, () -> s.setDate(null));
		assertThrows(ParseException.class, () -> s.setDate(""));
		assertThrows(ParseException.class, () -> s.setDate("foo"));
	}

	@Test
	void testSetValue() {
		Sample s = new Sample();
		assertTrue(s.getValue() == 0d);
		s.setValue(0.5);
		assertTrue(s.getValue() < 1d);
	}
	
	@Test
	void testGetResult() {
		Sample s = new Sample();
		assertTrue(s.getResult()=="negative");
		s.setValue(0.4d);
		assertTrue(s.getResult()=="questionable");
		s.setValue(0.9d);
		assertTrue(s.getResult()=="positive");
	}
}
