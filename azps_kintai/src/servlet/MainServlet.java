package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import model.AccountBeans;


@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			HttpSession session = request.getSession();
			AccountBeans loginAccount = (AccountBeans)session.getAttribute("logiAccount");
		// UTF-8形式でリクエストパラメータの取得
				request.setCharacterEncoding("UTF-8");
				
				
				String inTime = request.getParameter("inTimeValue");
				String outTime = request.getParameter("outTimeValue");
				String breakIn= request.getParameter("breakinTimeValue");
				String breakOut= request.getParameter("breakoutTimeValue");
				String dayTime= request.getParameter("inTimeValue");
				
				if(inTime!=null&&outTime==null&&breakIn==null&&breakOut==null) {
				AccountDAO dao = new AccountDAO();
				dao.Insert(loginAccount);
				dao.Update_Status1(loginAccount);
				
				loginAccount = new AccountBeans(dayTime, inTime, outTime, breakIn, breakOut);
				
				session.removeAttribute("loginAccount");
				session.setAttribute("loginAccount", loginAccount);
				
				}else if(inTime!=null&&outTime==null&&breakIn!=null&&breakOut==null) {
					
					
					
					
				}else if(inTime!=null&&outTime==null&&breakIn!=null&&breakOut!=null) {
 				}else {mmm
				
			
				
		// フォワード
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
		

	}

}