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
		// ���O�C�����Ă��邩�̊m�F
		// �Z�b�V�����X�R�[�v���烆�[�U�[�����擾
		HttpSession session = request.getSession();
		AccountBeans loginAccount = (AccountBeans) session.getAttribute("loginAccount");
		
		if(loginAccount == null) { // ���O�C�����Ă��Ȃ��ꍇ
			// ���_�C���N�g
			response.sendRedirect("/azps_kintai/");
		} else { // ���O�C���ς݂̏ꍇ
			// �t�H���[�h
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		}

	}

}