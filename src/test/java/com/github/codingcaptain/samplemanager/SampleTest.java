package com.github.codingcaptain.samplemanager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.text.ParseException;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class SampleTest {

	@Test
	public void testId() {
		Sample s = new Sample();
		assertEquals(0, s.getId());
		s.setId(4);
		assertEquals(4, s.getId());
	}

	@Test
	public void testDate() throws ParseException {
		Sample s = new Sample();
		assertNull(s.getDate());

		s.setDate("31-01-1990 01:01:00");
		assertEquals(new Date(90, 0, 31, 1, 1, 0), s.getDate());
		
		assertThrows(NullPointerException.class, () -> s.setDate(null));
		assertThrows(ParseException.class, () -> s.setDate(""));
		assertThrows(ParseException.class, () -> s.setDate("foo"));
	}
}