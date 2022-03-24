package model;

import java.io.Serializable;


public class AccountBeans implements Serializable {

	private int account_Num;
	private int master_Flag;
	private String emp_Id;
	private String name;
	private String pass;
	private int status;
	private String comment;

	private int dayNum;
	private String dayTime;
	private String inTime;
	private String outTime;
	private String breakIn;
	private String breakOut;
	private String fixDate;

	public void setFixDate(String fixDate) {
		this.fixDate = fixDate;
	}

	@Override
	public String toString() {
		return "AccountBeans [account_Num=" + account_Num + ", master_Flag=" + master_Flag + ", emp_Id=" + emp_Id
				+ ", name=" + name + ", pass=" + pass + ", status=" + status + ", comment=" + comment + ", dayNum="
				+ dayNum + ", dayTime=" + dayTime + ", inTime=" + inTime + ", outTime=" + outTime + ", breakIn="
				+ breakIn + ", breakOut=" + breakOut + "]";
	}

	public AccountBeans() {

	}

    //AccountDAO繧�繧雁叙繧顔畑
	public AccountBeans(int account_Num, int master_Flag, String emp_Id, String name, String pass, int status,
			String comment) {

		this.account_Num = account_Num;
		this.master_Flag = master_Flag;
		this.emp_Id = emp_Id;
		this.name = name;
		this.pass = pass;
		this.status = status;
		this.comment = comment;
	}
	
    public AccountBeans(String dayTime, String inTime, String outTime, String breakIn, String breakOut) {
		
		this.dayTime = dayTime;
		this.inTime = inTime;
		this.outTime = outTime;
		this.breakIn = breakIn;
		this.breakOut = breakOut;
	}

	//CountDayDAO繧�繧雁叙繧顔畑
	public AccountBeans( int dayNum, String dayTime, String inTime, String outTime, String breakIn, String breakOut) {


		this.dayNum = dayNum;
		this.dayTime = dayTime;
		this.inTime = inTime;
		this.outTime = outTime;
		this.breakIn = breakIn;
		this.breakOut = breakOut;
	}

	public int getAccount_Num() {
		return account_Num;
	}

	public void setAccount_Num(int account_Num) {
		this.account_Num = account_Num;
	}

	public int getMaster_Flag() {
		return master_Flag;
	}

	public void setMaster_Flag(int master_Flag) {
		this.master_Flag = master_Flag;
	}

	public String getEmp_Id() {
		return emp_Id;
	}

	public void setEmp_Id(String emp_Id) {
		this.emp_Id = emp_Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


	public int getDayNum() {
		return dayNum;
	}

	public void setDayNum(int dayNum) {
		this.dayNum = dayNum;
	}

	public String getDayTime() {
		return dayTime;
	}

	public void setDayTime(String dayTime) {
		this.dayTime = dayTime;
	}

	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public String getBreakIn() {
		return breakIn;
	}

	public void setBreakIn(String breakIn) {
		this.breakIn = breakIn;
	}

	public String getBreakOut() {
		return breakOut;
	}

	public void setBreakOut(String breakOut) {
		this.breakOut = breakOut;
	}

}
