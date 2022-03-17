package model;

import java.io.Serializable;

public class AccountBeans implements Serializable {

	private int account_Num;
	private int muster_Flag;
	private String emp_Id;
	private String name;
	private String pass;
	private int status;
	private String comment;

	@Override//確認作業用
	public String toString() {
		return "AccountBeans [account_Num=" + account_Num + ", muster_Flag=" + muster_Flag + ", emp_Id=" + emp_Id
				+ ", name=" + name + ", pass=" + pass + ", status=" + status + ", comment=" + comment + "]";
	}

	public AccountBeans() {

	}

    //DAOやり取り用
	public AccountBeans(int account_Num, int muster_Flag, String emp_Id, String name, String pass, int status,
			String comment) {

		this.account_Num = account_Num;
		this.muster_Flag = muster_Flag;
		this.emp_Id = emp_Id;
		this.name = name;
		this.pass = pass;
		this.status = status;
		this.comment = comment;
	}

	//getter
	public int getAccount_Num() {
		return account_Num;
	}

	public void setAccount_Num(int account_Num) {
		this.account_Num = account_Num;
	}

	public int getMuster_Flag() {
		return muster_Flag;
	}

	//setter
	public void setMuster_Flag(int muster_Flag) {
		this.muster_Flag = muster_Flag;
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

}
