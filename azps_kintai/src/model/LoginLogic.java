package model;

import dao.AccountDAO;

public class LoginLogic {

	public AccountBeans execute(Login login) {
//	public boolean execute(Login login) {
		//AccoutDAOのインスタンスを生成
		AccountDAO dao = new AccountDAO();
		//LoginServletから引き出してきた値とDBにある値が、
		//AccoutDAOのセレクトオールメソッド、
		//25～32行目にて完全一致か判定
		AccountBeans account = dao.Select_All(login);
		//呼び出したLoginServlet45行目に返す
		return account;//判定処理完了した結果を呼び出し先に変数account内に入れて戻す
//		return account != null;//判定処理完了した結果を呼び出し先に変数account内に入れて戻す
	}
}
