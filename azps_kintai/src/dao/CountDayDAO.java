package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.AccountBeans;

public class CountDayDAO {
	
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/"
			+ "AZPS?characterEncoding=UTF-8&serverTimezone=Asia/Tokyo";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";
	
	public void Insert(AccountBeans accountBeans) {
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// INSERT文を準備
			String sql = "INSERT INTO COUNTDAY (DAY_NUM,DAYTIME,INTIME,OUTTIME,BREAKIN,BREAKOUT)"
					+ " VALUES (DAY_NUM = ?,DAYTIME = ?,INTIME = ?,OUTTIME = ?,BREAKIN =?,BREAKOUT = ?)"
					+ " WHERE ACCOUNT_NUM = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, accountBeans.getMuster_Flag());//管理権限デフォルトあり
			pStmt.setString(2, accountBeans.getEmp_Id());//社員番号
			pStmt.setString(3, accountBeans.getName());//名前
			pStmt.setString(4, accountBeans.getPass());//パスワード
			pStmt.setInt(5, accountBeans.getStatus());//勤務状況デフォルトあり
			pStmt.setInt(6, accountBeans.getStatus());//勤務状況デフォルトあり
			
			pStmt.setInt(7, accountBeans.getStatus());//勤務状況デフォルトあり
			

			// INSERT文を実行し、結果表を取得
			pStmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
}
