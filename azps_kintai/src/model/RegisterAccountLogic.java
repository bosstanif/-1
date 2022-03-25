package model;

import dao.AccountDAO;

public class RegisterAccountLogic {
	public boolean execute (AccountBeans registerAccount) {/*㉒*/
		AccountDAO dao = new AccountDAO(); //DAO呼び出し /*㉓*/
		//登録済みアカウントかのチェックをするdao.findByCheckメソッドを実行する。
		boolean registed = dao.findByCheck(registerAccount); ///*㉕（右辺が実行）㉗（左辺に代入）*/ 入力されたアカウントが既にあるかを確認
		if (!registed) {
			//AccountDao.java内にある Insertメソッドを使い、入力された登録情報スコープ内の情報をDBにインサートする。
			dao.Insert(registerAccount); //アカウントが登録されていないので、INSERTする
			return true;
			} else {
			return false; //アカウント登録済み
			}
		}
	}
