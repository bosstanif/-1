package model;

import java.io.Serializable;

public class Login implements Serializable {

	private String emp_Id;
	private String pass;

	@Override
	public String toString() {
		return "Login [emp_Id=" + emp_Id + ", pass=" + pass + "]";
	}

	public Login() {

	}

	public Login(String emp_Id, String pass) {
		super();
		this.emp_Id = emp_Id;
		this.pass = pass;
	}

	public String getEmp_Id() {
		return emp_Id;
	}

	public void setEmp_Id(String emp_Id) {
		this.emp_Id = emp_Id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
