
package test;

import dao.AccountDAO;
import model.AccountBeans;
import model.Login;

public class AccountDAOTest {

	public static void main(String[] args) {

		testSelect_All1(); // ユーザーが見つかる場合のテスト
		testSelect_All2(); // ユーザーが見つからない場合のテスト
	}

	public static void testSelect_All1() {
		Login login = new Login("*******", "*******");
		AccountDAO dao = new AccountDAO();
		AccountBeans result = dao.Select_All(login);
		if (result != null &&
				result.getAccount_Num() == 0 &&         //*******
				result.getMaster_Flag() == 0 &&         //*******
				result.getEmp_Id().equals("*******") &&
				result.getName().equals("*******") &&
				result.getPass().equals("*******") &&
				result.getStatus() == 0 &&              //*******
				result.getComment().equals("*******")) {
			System.out.println("findByLogin1:成功しました");
		} else {
			System.out.println("findByLogin1:失敗しました");
		}
	}

	public static void testSelect_All2() {
		Login login = new Login("*******", "*******");
		AccountDAO dao = new AccountDAO();
		AccountBeans result = dao.Select_All(login);
		if (result == null) {
			System.out.println("findByLogin2:成功しました");
		} else {
			System.out.println("findByLogin2:失敗しました");
		}
	}
}