package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String userMail = request.getParameter("userMail");
		String pass = request.getParameter("pass");
		String userNickname = request.getParameter("userNickname");
		// ログイン処理の実行
		Account loginAccount = new Account(userMail, pass,userNickname);
		LoginLogic bo = new LoginLogic();
		Account account = bo.execute(loginAccount);/* （右辺が実行）、（左辺に代入） */

		// ログイン処理の成否によって処理を分岐
		if (account != null) {// ログイン成功時、
			Account acc = new Account(account.getUserId(), account.getUserMail(), account.getPass(),account.getUserNickname());
			// セッションスコープに保存されたユーザーメールを保存
			HttpSession session = request.getSession();

			session.setAttribute("loginAccount", acc);

			GetRestaurantLogic getRestaurantLogic = new GetRestaurantLogic();
			List<Restaurant> resList = getRestaurantLogic.findByAll();
			session.setAttribute("resList", resList);

			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");/* */
			dispatcher.forward(request, response);
		} else {// ログイン失敗時

			// リダイレクト
			response.sendRedirect("/azps_kintai/LoginServlet");
		}


	}

}
