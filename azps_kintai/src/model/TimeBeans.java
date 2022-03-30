package model;

import java.io.Serializable;

public class TimeBeans implements Serializable {

	private String emp_Id;
	private String day;
	private String intime;
	private String outtime;

	public TimeBeans(String emp_Id,String day, String intime, String outtime) {
		this.emp_Id = emp_Id;
		this.day = day;
		this.intime = intime;
		this.outtime = outtime;
	}



	public String getEmp_Id() {
		return emp_Id;
	}



	public void setEmp_Id(String emp_Id) {
		this.emp_Id = emp_Id;
	}



	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getIntime() {
		return intime;
	}

	public void setIntime(String intime) {
		this.intime = intime;
	}

	public String getOuttime() {
		return outtime;
	}

	public void setOuttime(String outtime) {
		this.outtime = outtime;
	}


}
