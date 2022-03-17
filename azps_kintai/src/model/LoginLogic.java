package model;

import dao.AccountDAO;

public class LoginLogic {

	public AccountBeans execute(Login login) {
		AccountDAO dao = new AccountDAO();
		AccountBeans account = dao.Select_All(login);
		return account;
	}
}
