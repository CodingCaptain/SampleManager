package com.pw.testproject;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;

import org.junit.jupiter.api.Test;

class SampleTest {

	@Test
	void testSetDate() {
		Sample s = new Sample();
		assertNull(s.getDate());
		
		assertThrows(NullPointerException.class, () -> s.setDate(null));
		assertThrows(ParseException.class, () -> s.setDate(""));
		assertThrows(ParseException.class, () -> s.setDate("foo"));
	}

	//eingabefehler
	
}
