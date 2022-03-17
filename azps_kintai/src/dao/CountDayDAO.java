package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.AccountBeans;
import model.Login;

public class CountDayDAO {

	private final String JDBC_URL = "jdbc:mysql://localhost:3306/"
			+ "AZPS?characterEncoding=UTF-8&serverTimezone=Asia/Tokyo";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";

	public void Insert(AccountBeans accountBeans) {//毎日一回
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// INSERT文を準備
			String sql = "INSERT INTO COUNTDAY (DAY_NUM,DAYTIME,INTIME,OUTTIME,BREAKIN,BREAKOUT)"
					+ " VALUES (DAYTIME = ?,INTIME = ?,OUTTIME = ?,BREAKIN =?,BREAKOUT = ?)" + " WHERE ACCOUNT_NUM = ?";

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

	public AccountBeans Select_All(AccountBeans accountBeans) {// × 主要コンストラクタを二つにしたら片方がnewされて消えていく？

		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// SELECT文を準備
			String sql = "SELECT DAY_NUM,DAYTIME,INTIME,OUTTIME,BREAKIN,BREAKOUT"
					+ " FROM COUNTDAY WHERE EMP_ID = ? AND PASS = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, accountBeans.getEmp_Id());// 社員ID
			pStmt.setString(2, accountBeans.getPass());// パスワード

			// SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			// 結果表からデータを取得
			while (rs.next()) {
				int account_Num = rs.getInt("ACCOUNT_NUM");
				int muster_Flag = rs.getInt("MUSTER_FLAG");
				String emp_Id = rs.getString("EMP_ID");
				String name = rs.getString("NAME");
				String pass = rs.getString("PASS");
				int status = rs.getInt("STATUS");
				String comment = rs.getString("COMMENT");

				accountBeans = new AccountBeans(account_Num, muster_Flag, emp_Id, name, pass, status, comment);
			}
			return accountBeans;
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return null;

	}
}
