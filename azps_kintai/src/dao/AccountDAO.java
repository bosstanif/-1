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

	public AccountBeans Select_All(Login login) {//ログイン本人確認

		AccountBeans accountBeans = null;

		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// SELECT文を準備
			String sql = "SELECT ACCOUNT_NUM,MASTER_FLAG,EMP_ID,NAME,PASS,STATUS,COMMENT"
					+ " FROM ACCOUNT WHERE EMP_ID = ? AND PASS = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, login.getEmp_Id());//社員ID
			pStmt.setString(2, login.getPass());//パスワード

			// SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			// 結果表からデータを取得
			while (rs.next()) {
				int account_Num = rs.getInt("ACCOUNT_NUM");
				int muster_Flag = rs.getInt("MASTER_FLAG");
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

	public AccountBeans Select_All(AccountBeans accountBeans) {//自身のデータ閲覧

		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// SELECT文を準備
			String sql = "SELECT ACCOUNT_NUM,MASTER_FLAG,EMP_ID,NAME,PASS,STATUS,COMMENT"
					+ " FROM ACCOUNT WHERE EMP_ID = ? AND PASS = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, accountBeans.getEmp_Id());//社員ID
			pStmt.setString(2, accountBeans.getPass());//パスワード

			// SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			// 結果表からデータを取得
			while (rs.next()) {
				int account_Num = rs.getInt("ACCOUNT_NUM");
				int muster_Flag = rs.getInt("MASTER_FLAG");
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

			return accountBeans;
		}

	}

	public void Update_Status0(AccountBeans accountBeans) {

		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// SELECT文を準備
			String sql = "UPDATE ACCOUNT SET STATUS = 0, COMMENT =NUll WHERE EMP_ID = ? AND PASS = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, accountBeans.getEmp_Id());//社員ID
			pStmt.setString(2, accountBeans.getPass());//パスワード

			// SELECT文を実行し、結果表を取得
			pStmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void Update_Status1(AccountBeans accountBeans) {

		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// SELECT文を準備
			String sql = "UPDATE ACCOUNT SET STATUS = 1, COMMENT =NUll WHERE EMP_ID = ? AND PASS = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, accountBeans.getEmp_Id());//社員ID
			pStmt.setString(2, accountBeans.getPass());//パスワード

			// SELECT文を実行し、結果表を取得
			pStmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void Update_Status2(AccountBeans accountBeans) {

		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// SELECT文を準備
			String sql = "UPDATE ACCOUNT SET STATUS = 2, COMMENT =NUll WHERE EMP_ID = ? AND PASS = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, accountBeans.getEmp_Id());//社員ID
			pStmt.setString(2, accountBeans.getPass());//パスワード

			// SELECT文を実行し、結果表を取得
			pStmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void Update_Status3(AccountBeans accountBeans) {

		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// SELECT文を準備
			String sql = "UPDATE ACCOUNT SET STATUS = 3, COMMENT =NUll WHERE EMP_ID = ? AND PASS = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, accountBeans.getEmp_Id());//社員ID
			pStmt.setString(2, accountBeans.getPass());//パスワード

			// SELECT文を実行し、結果表を取得
			pStmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void Update_Comment(AccountBeans accountBeans) {//コメント更新ステータスが更新されると初期化

		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// SELECT文を準備
			String sql = "UPDATE ACCOUNT SET COMMENT = ? WHERE EMP_ID = ? AND PASS = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, accountBeans.getEmp_Id());//社員ID
			pStmt.setString(2, accountBeans.getPass());//パスワード
			pStmt.setString(3, accountBeans.getComment());//コメント

			// SELECT文を実行し、結果表を取得
			pStmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void Update_ALL(AccountBeans accountBeans) {

		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// SELECT文を準備
			String sql = "UPDATE ACCOUNT SET NAME = ?,PASS = ?,STATUS =? COMMENT =? WHERE EMP_ID = ? AND PASS = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, accountBeans.getEmp_Id());//社員ID
			pStmt.setString(2, accountBeans.getPass());//パスワード

			// SELECT文を実行し、結果表を取得
			pStmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void Insert(AccountBeans accountBeans) {
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// INSERT文を準備
			String sql = "INSERT INTO ACCOUNT (MASTER_FLAG,EMP_ID,NAME,PASS,STATUS)"
					+ " VALUES(?,?,?,?,?)";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, accountBeans.getMaster_Flag());//管理権限デフォルトあり
			pStmt.setString(2, accountBeans.getEmp_Id());//社員番号
			pStmt.setString(3, accountBeans.getName());//名前
			pStmt.setString(4, accountBeans.getPass());//パスワード
			pStmt.setInt(5, accountBeans.getStatus());//勤務状況デフォルトあり


			// INSERT文を実行し、結果表を取得
			pStmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}
}