package test;

import dao.AccountDAO;
import model.AccountBeans;

public class testAccount {

	public static void main(String[] args) {

		/*
		1：新規登録 仮データ
		2：ログイン→ログインロジックテスト
		3：勤怠状態変化（UPDATE）
		4：コメント変化（UPDATE）→再3後：初期化確認
		5：保持情報修正（UPDATE）
		6：全データ閲覧（個人）
		*/

		test1();//OK確認03/23

		//test3();//OK確認03/23
		//test4();//OK確認03/23
		//test5();//OK確認03/23
		//test6();//OK確認03/23

	}

	public static void test1() {
		/*int account_Num, int master_Flag, String emp_Id, String name, String pass, int status,
		String comment*/ //2は確認のため仮
		AccountBeans accountBeans = new AccountBeans(2, 0, "02", "testname2", "testpass02", 0, "test_comment02");
		AccountDAO dao = new AccountDAO();
		dao.Insert(accountBeans);
	}

	public static void test3() {
		AccountBeans accountBeans = new AccountBeans(2, 0, "02", "testname2", "testpass02", 0, "test_comment02");
		AccountDAO dao = new AccountDAO();
		dao.Update_Status1(accountBeans);
		//dao.Update_Status2(accountBeans);
		//dao.Update_Status3(accountBeans);
		//dao.Update_Status0(accountBeans);

	}

	public static void test4() {
		AccountBeans accountBeans = new AccountBeans(2, 0, "02", "testname2", "testpass02", 0, "test_comment02");
		accountBeans.setComment("更新テスト02");
		AccountDAO dao = new AccountDAO();
		dao.Update_Comment(accountBeans);

	}

	public static void test5() {
		/*int account_Num, int master_Flag, String emp_Id, String name, String pass, int status,
		String comment*/ //2は確認のため仮
		AccountBeans accountBeans = new AccountBeans(2, 0, "02", "testname2", "testpass02", 0, "test_comment02");
		accountBeans.setName("testname3");
		accountBeans.setStatus(3);
		accountBeans.setComment("更新テスト03");
		AccountDAO dao = new AccountDAO();
		dao.Update_ALL(accountBeans);
	}

	public static void test6() {
		AccountBeans accountBeans = new AccountBeans(2, 0, "02", "testname2", "testpass02", 0, "test_comment02");
		AccountDAO dao = new AccountDAO();
		dao.Select_All(accountBeans);
		System.out.println(accountBeans.toString());
	}
}
