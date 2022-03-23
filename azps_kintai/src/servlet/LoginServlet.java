package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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

//getメソッド
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータの取得
	/*RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");*/
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);
	}

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
		Login logic = new Login(emp_Id, pass);
		//その後logic変数をLoginLogic内から呼び出したLoginLogicメソッドにて照らし合わせる処理を行う。
		LoginLogic bo = new LoginLogic();
		//結果：要素文字列の完全一致でtrue判定ならば
		AccountBeans loginAccount = bo.execute(logic);

		// ログイン処理の成否によって処理を分岐
	if (loginAccount != null) {// ログイン成功時、BeansModelからアカウント関連の変数をパスワードを除きすべて取得。
		//getの後に続く変数名の1文字目は大文字にしなければならないことに注意
		//本来はセキュリティ的にpassを未定義のコンストラクタをBeansModelに作る必要があると思うが今回は無視。
		AccountBeans acc = new AccountBeans(loginAccount.getAccount_Num(),
				loginAccount.getMaster_Flag(),
				loginAccount.getEmp_Id(),
				loginAccount.getName(),
				loginAccount.getPass(),
				loginAccount.getStatus(),
				loginAccount.getComment());
		// セッションスコープに保存されたユーザーメールを保存
			HttpSession session = request.getSession();
			session.setAttribute("loginAccount", acc);

//POST時のフォワード先
/*	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");*/
RequestDispatcher dispatcher = request.getRequestDispatcher("/main.jsp");
			dispatcher.forward(request, response);
		} else {//ログイン失敗時
			response.sendRedirect("/azps_kintai/LoginServlet");
		}
	}
}
