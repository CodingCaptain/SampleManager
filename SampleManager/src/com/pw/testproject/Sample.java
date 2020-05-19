package com.pw.testproject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Sample class for representing a real sample
public class Sample {

	private int id;				// unique number of sample
	private Date date;			// date and time of sample
	private double value;		// value of sample
	private String result;		// result of sample: can be positive, questionable, negative
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	
	public String parsedDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
		return sdf.format(getDate());
	}
	
	public void setDate(String dateString) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
		this.date = sdf.parse(dateString);
	}
		
	public double getValue() {		
		return value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
	public String getResult() {
		double val = getValue();		
		// set imaginary result texts
		if(val<=0.3) {
			setResult("negative");
		}else if(val>0.3 && val<=0.6){
			setResult("questionable");
		}else {
			setResult("positive");			
		}
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
}
