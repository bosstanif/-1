package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.AccountBeans;
import model.Login;

public class AccountDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/"
			+ "AZPS?characterEncoding=UTF-8&serverTimezone=Asia/Tokyo";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";

	public AccountBeans Select_All(Login login) {

		AccountBeans accountBeans = null;

		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// SELECT文を準備
			String sql = "SELECT ACCOUNT_NUM,MUSTER_FLAG,EMP_ID,NAME,PASS,STATUS,COMMENT"
					+ " FROM ACCOUNT WHERE EMP_ID = ? AND PASS = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, login.getEmp_Id());//社員ID
			pStmt.setString(2, login.getPass());//パスワード

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

			return null;//AccountBeansにnull格納
		}

	}
}