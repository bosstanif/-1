package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AccountBeans;

public class CountDayDAO {

	private final String JDBC_URL = "jdbc:mysql://localhost:3306/"
			+ "AZPS?characterEncoding=UTF-8&serverTimezone=Asia/Tokyo";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";

	public void Insert(AccountBeans accountBeans) {//毎日一回ログイン成功したら
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// INSERT文を準備
			String sql = "INSERT INTO COUNTDAY (DAY_NUM,DAYTIME,INTIME,OUTTIME,BREAKIN,BREAKOUT)"
					+ " VALUES (DAYTIME = ?,INTIME = ?,OUTTIME = ?,BREAKIN =?,BREAKOUT = ?)"
					+ " WHERE ACCOUNT_NUM = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, accountBeans.getDayTime());// 管理権限デフォルトあり
			pStmt.setInt(2, accountBeans.getInTime());// 社員番号
			pStmt.setInt(3, accountBeans.getOutTime());// 名前
			pStmt.setInt(4, accountBeans.getBreakIn());// パスワード
			pStmt.setInt(5, accountBeans.getBreakOut());// 勤務状況デフォルトあり

			pStmt.setInt(6, accountBeans.getAccount_Num());// アカウント番号

			// INSERT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			// 結果表からデータを取得
			while (rs.next()) {
				int dayNum = rs.getInt("DAY_NUM");
				int dayTime = rs.getInt("DAYTIME");
				int inTime = rs.getInt("INTIME");
				int outTime = rs.getInt("OUTTIME");
				int breakIn = rs.getInt("BREAKIN");
				int breakOut = rs.getInt("BREAKOUT");

				accountBeans = new AccountBeans(dayNum, dayTime, inTime, outTime, breakIn, breakOut);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		}

	public List<AccountBeans> Select_AllTime(AccountBeans accountBeans/*,DAY_NUM = 値１ AND DAY_NUM =値２*/) {//労働情報のリスト化全件取得//日付の縛りがいる

		List<AccountBeans> workTime_List =new ArrayList<AccountBeans>();

		AccountBeans workTime = null;

		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// SELECT文を準備
			String sql = "SELECT DAY_NUM,DAYTIME,INTIME,OUTTIME,BREAKIN,BREAKOUT"
					+ " FROM COUNTDAY WHERE EMP_ID = ? AND PASS = ?"
					+ " AND DAY_NUM = 値１ AND DAY_NUM =値２";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, accountBeans.getEmp_Id());
			pStmt.setString(2, accountBeans.getPass());
			pStmt.setInt(3, DAY_NUM = 値１);
			pStmt.setInt(3, DAY_NUM =値２);

			// SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			// 結果表からデータを取得
			while (rs.next()) {
				int dayNum = rs.getInt("DAY_NUM");
				int dayTime = rs.getInt("DAYTIME");
				int inTime = rs.getInt("INTIME");
				int outTime = rs.getInt("OUTTIME");
				int breakIn = rs.getInt("BREAKIN");
				int breakOut = rs.getInt("BREAKOUT");

				workTime = new AccountBeans(dayNum, dayTime, inTime, outTime, breakIn, breakOut);

				// Listにインスタンスを順番に詰める
				workTime_List.add(workTime);
			}
			return workTime_List;
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return null;

	}

	public void Update_ALL(AccountBeans accountBeans/*,DAY_NUM = 値１ AND DAY_NUM =値２*/) {//修正したい日時データをAccountBeansに設定しないといけない

		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// SELECT文を準備
			String sql = "UPDATE ACCOUNT SET INTIME = ?,OUTTIME = ?,BREAKIN =?,BREAKOUT = ?,FIX_DATE =?"
					   + " WHERE EMP_ID = ? AND PASS = ? AND DAYTIME = ?"
					   + " AND DAY_NUM = 値１ AND DAY_NUM =値２";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, accountBeans.getInTime());
			pStmt.setInt(2, accountBeans.getOutTime());
			pStmt.setInt(3, accountBeans.getBreakIn());
			pStmt.setInt(4, accountBeans.getBreakOut());
			pStmt.setInt(5, accountBeans.getDayTime());//FIX_DATE
			pStmt.setString(6, accountBeans.getEmp_Id());
			pStmt.setString(7, accountBeans.getPass());
			pStmt.setInt(8, accountBeans.getDayTime());
			pStmt.setInt(9, DAY_NUM = 値１);
			pStmt.setInt(10, DAY_NUM =値２);


			// SELECT文を実行し、結果表を取得
			pStmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
