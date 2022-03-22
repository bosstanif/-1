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
	private int dayTime;
	private int inTime;
	private int outTime;
	private int breakIn;
	private int breakOut;

	@Override//確認作業用
	public String toString() {
		return "AccountBeans [account_Num=" + account_Num + ", muster_Flag=" + master_Flag + ", emp_Id=" + emp_Id
				+ ", name=" + name + ", pass=" + pass + ", status=" + status + ", comment=" + comment + "]";
	}

	public AccountBeans() {

	}

    //AccountDAOやり取り用
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
    //CountDayDAOやり取り用
	public AccountBeans( int dayNum, int dayTime, int inTime, int outTime, int breakIn, int breakOut) {


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

	public int getDayTime() {
		return dayTime;
	}

	public void setDayTime(int dayTime) {
		this.dayTime = dayTime;
	}

	public int getInTime() {
		return inTime;
	}

	public void setInTime(int inTime) {
		this.inTime = inTime;
	}

	public int getOutTime() {
		return outTime;
	}

	public void setOutTime(int outTime) {
		this.outTime = outTime;
	}

	public int getBreakIn() {
		return breakIn;
	}

	public void setBreakIn(int breakIn) {
		this.breakIn = breakIn;
	}

	public int getBreakOut() {
		return breakOut;
	}

	public void setBreakOut(int breakOut) {
		this.breakOut = breakOut;
	}

}
