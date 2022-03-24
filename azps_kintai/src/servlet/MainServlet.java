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
import dao.CountDayDAO;
import model.AccountBeans;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		AccountBeans loginAccount = (AccountBeans) session.getAttribute("logiAccount");
		// UTF-8�`���Ń��N�G�X�g�p�����[�^�̎擾
		request.setCharacterEncoding("UTF-8");

		String inTime = request.getParameter("inTimeValue");
		String outTime = request.getParameter("outTimeValue");
		String breakIn = request.getParameter("breakinTimeValue");
		String breakOut = request.getParameter("breakoutTimeValue");
		String dayTime = request.getParameter("inTimeValue");

		AccountDAO Adao = new AccountDAO();
		CountDayDAO Cdao = new CountDayDAO();

		if (inTime != null && outTime == null && breakIn == null && breakOut == null) {
			Adao.Insert(loginAccount);
			Adao.Update_Status1(loginAccount);

			loginAccount = new AccountBeans(dayTime, inTime, outTime, breakIn, breakOut);

		} else if (inTime != null && outTime == null && breakIn != null && breakOut == null) {// 休憩入り
			Adao.Update_Status3(loginAccount);

		} else if (inTime != null && outTime == null && breakIn != null && breakOut != null) {
			Adao.Update_Status1(loginAccount);

		} else {// 退勤
			Adao.Update_Status0(loginAccount);

		}

		loginAccount.toString();
		Cdao.Update_ALL(loginAccount);
		session.removeAttribute("loginAccount");
		session.setAttribute("loginAccount", loginAccount);

		String action = request.getParameter("打刻修正を行う");

		if (action != null) {

			AccountBeans fixAccount = new AccountBeans();

			request.setCharacterEncoding("UTF-8");

			dayTime = request.getParameter("attendanceDay");
			fixAccount.setDayTime(dayTime);
			inTime = request.getParameter("inTimeStart");
			fixAccount.setInTime(inTime);
			outTime = request.getParameter("outTimeEnd");
			fixAccount.setOutTime(outTime);
			breakIn = request.getParameter("breakInStart");
			fixAccount.setBreakIn(breakIn);
			breakOut = request.getParameter("breakOutEnd");
			fixAccount.setBreakOut(breakOut);
			String comment = request.getParameter("fixComment");
			fixAccount.setComment(comment);
			String fixDate = request.getParameter("");// daywork.jsp-285.
			fixAccount.setFixDate(fixDate);

			Cdao.Update_ALL(loginAccount);

		}

		// �t�H���[�h
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);

	}

}