package model;

import java.time.LocalDate;
import java.time.Period;

public class Administrator {
	private int addtions;
	private LocalDate startDate;
	public int getAddtions() {
		return addtions;
	}
	public void setAddtions(int addtions) {
		this.addtions = addtions;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	public int getAntiguedad() {
		Period period = Period.between(startDate, LocalDate.now());
		return period.getYears();
		
	}
}
