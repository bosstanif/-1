package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountDAO;
import model.AccountBeans;


@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");

		String emp_Id = request.getParameter(" ");
		String name = request.getParameter(" ");
		String pass = request.getParameter(" ");
	
		AccountBeans newAccount =new AccountBeans();
		newAccount.setEmp_Id(emp_Id);
		newAccount.setName(name);
		newAccount.setPass(pass);
		
		/*
		 * AccountDAO Adao = new AccountDAO(); Adao.Insert(newAccount);
		 */
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userRegisterCheck.jsp");
		dispatcher.forward(request, response);

		//doGet(request, response);
	}

}
