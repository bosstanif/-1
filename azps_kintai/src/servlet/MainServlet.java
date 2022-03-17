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


@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ログインしているかの確認
		// セッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();
		AccountBeans loginAccount = (AccountBeans) session.getAttribute("loginAccount");
		
		if(loginAccount == null) { // ログインしていない場合
			// リダイレクト
			response.sendRedirect("/azps_kintai/");
		} else { // ログイン済みの場合
			// フォワード
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		}

	}

}