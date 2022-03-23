package model;

import dao.AccountDAO;

public class LoginLogic {

	public AccountBeans execute(Login login) {
		//AccoutDAOのインスタンスを生成
		AccountDAO dao = new AccountDAO();
		//LoginServletから引き出してきた値とDBにある値が、
		//AccoutDAOのセレクトオールメソッド、
		//25～32行目にて完全一致か判定
		AccountBeans account = dao.Select_All(login);
		//呼び出したLoginServlet45行目に返す
		return account;
	}
}
