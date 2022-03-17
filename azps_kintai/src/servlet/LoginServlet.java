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

		String emp_Id = request.getParameter("emp_Id");
		String pass = request.getParameter("pass");

		Login login = new Login(emp_Id, pass);
		LoginLogic bo = new LoginLogic();
		AccountBeans loginAccount = bo.execute(login);

		if (loginAccount != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginAccount", loginAccount);
			RequestDispatcher dispatcher = request.getRequestDispatcher("");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("");
		}
	}
}
