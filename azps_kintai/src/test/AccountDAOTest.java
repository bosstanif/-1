//OK確認03/23
package test;

import dao.AccountDAO;
import model.AccountBeans;
import model.Login;

public class AccountDAOTest {

	public static void main(String[] args) {

		testSelect_All1(); // ユーザーが見つかる場合のテスト
		testSelect_All2(); // ユーザーが見つからない場合のテスト
	}

	public static void testSelect_All1() {//Emp_Id,Pass
		Login login = new Login("01", "testpass01");
		AccountDAO dao = new AccountDAO();
		AccountBeans result = dao.Select_All(login);
		if (result != null &&
				result.getEmp_Id().equals("01") &&
				result.getName().equals("testname") &&
				result.getPass().equals("testpass01") &&
				result.getStatus() == 0 ) {
			System.out.println("findByLogin1:成功しました");
		} else {
			System.out.println("findByLogin1:失敗しました");
		}
	}

	public static void testSelect_All2() {//パス違い
		Login login = new Login("01", "pass01");
		AccountDAO dao = new AccountDAO();
		AccountBeans result = dao.Select_All(login);
		if (result == null) {
			System.out.println("findByLogin2:成功しました");
		} else {
			System.out.println("findByLogin2:失敗しました");
		}
	}
}