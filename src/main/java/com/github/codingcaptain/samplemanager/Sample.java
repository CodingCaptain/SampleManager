package com.github.codingcaptain.samplemanager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sample {

	private int id; // unique number of sample
	private Date date; // date and time of sample
	private List<Double> values = new ArrayList<>(); // value of sample
	private ESampleResult result;

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
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		this.date = sdf.parse(dateString);
	}

	public List<Double> getValues() {
		return values;
	}

	public void setValues(List<Double> values) {
		this.values = values;
	}

	public double getValue(int id) {
		return values.get(id);
	}

	public void setValue(int id, double value) {
		if (values.size() == 0) { // add value with id, if size of valuesList is above 0s
			this.values.add(value);
		} else {
			this.values.set(id, value);
		}
	}

	public ESampleResult getResult(int id) {
		double val = getValue(id); // set result texts
		if (val <= 0.3) {
			setResult(ESampleResult.NEGATIVE);
		} else if (val > 0.3 && val <= 0.6) {
			setResult(ESampleResult.QUESTIONABLE);
		} else {
			setResult(ESampleResult.POSITIVE);
		}
		return result;
	}

	public void setResult(ESampleResult result) {
		this.result = result;
	}

}
