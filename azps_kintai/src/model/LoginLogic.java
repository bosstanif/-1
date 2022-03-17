package model;

import dao.AccountDAO;

public class LoginLogic {

	public boolean execute(Login login) {

		AccountDAO dao = new AccountDAO();
		AccountBeans account = dao.Select_All(login);
		return account != null;
	}
}
