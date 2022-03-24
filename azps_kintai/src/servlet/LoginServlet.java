package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AccountBeans;
import model.Login;
import model.LoginLogic;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//postメソッド
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// UTF-8形式でリクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");

		//jsp側からPost送信されてきた値のうち、取得したい情報を設定。
		//ログイン時なので社員番号とパスワードを取得し、
		String emp_Id = request.getParameter("emp_Id");
		String pass = request.getParameter("pass");

		//LoginBeansからインスタンスを生成し、logic変数に代入、
		Login login = new Login(emp_Id, pass);
		//その後logic変数をLoginLogic内から呼び出したLoginLogicメソッドにて照らし合わせる処理を行う。
		LoginLogic bo = new LoginLogic();
		//結果：要素文字列の完全一致でtrue判定ならば
		AccountBeans loginAccount = bo.execute(login);
		
		// ログイン処理の成否によって処理を分岐
	if (loginAccount != null) {// ログイン成功時、BeansModelからアカウント関連の変数をパスワードを除きすべて取得。	
		HttpSession session = request.getSession();
			session.setAttribute("loginAccount", loginAccount);
		ServletContext application = this.getServletContext();
			application.setAttribute("login", login);
//POST時のフォワード先
/*	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");*/
RequestDispatcher dispatcher = request.getRequestDispatcher("/main.jsp");
			dispatcher.forward(request, response);
		} else {//ログイン失敗時
			response.sendRedirect("/azps_kintai/");
		}
	}
}
