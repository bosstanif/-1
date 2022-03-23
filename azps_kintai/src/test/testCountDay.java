package test;

import dao.CountDayDAO;
import model.AccountBeans;

public class testCountDay {

	public static void main(String[] args) {
		/* Q:日付の縛りをどこから持って来るか？
		1：新規登録 仮データ
		2：登録情報追加（3日）仮データ→SQL直実行
		3：保持情報修正（UPDATE）
		4：全データ閲覧（個人）
		5：集計結果閲覧
		*/

		test1();//OK確認03/23



	}

	public static void test1() {
		/* int dayNum, String dayTime, String inTime, String outTime, String breakIn, String breakOut*/
		                                              //2は確認のため仮
		AccountBeans accountBeans = new AccountBeans(2,"2022-03-23 09:00:00.000000","2022-03-23 09:00:00.000000","2022-03-23 12:00:00.000000","2022-03-23 13:00:00.000000","2022-03-23 18:00:00.000000");
		accountBeans.setAccount_Num(2);
		CountDayDAO dao = new CountDayDAO();
		dao.Insert(accountBeans);
	}

	public static void test3() {}
}
