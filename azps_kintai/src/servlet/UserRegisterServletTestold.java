package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserRegisterServletTest
 */
@WebServlet("/UserRegisterServletTest")
public class UserRegisterServletTestold extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		//サーブレットクラスの動作を決定する「action」の値を
		//リクエストパラメータから取得した値を文字列変数actionに代入
		String action = request.getParameter("action");//
		System.out.println("action");

		String forwardPath = null;//np

		//もしパラメータに"done"が代入されていたら
		if("done".equals(action)) {
			// セッションスコープに保存された登録アカウントを取得


			forwardPath = "/WEB-INF/jsp/userRegisterCheck.jsp";//△。遷移先error 63ぬるぽ構文ミスかも
		  } else {
			  forwardPath = "/WEB-INF/jsp/userRegister.jsp";//np
		  }

		// 引数にforwardPathを指定し、↑までで設定されたフォワード先にフォワード

//		forwardPath = "/WEB-INF/jsp/userRegister.jsp";//np

//		//forwardPath = "/userRegister.jsp";//np

//		forwardPath = "/WEB-INF/jsp/userRegisterResult.jsp";//np


//		forwardPath = "/WEB-INF/jsp/userRegisterCheck.jsp";//△。遷移先error 63ぬるぽ構文ミスかも
		//ユーザー情報新規登録からちゃんとsubmitして進むと大丈夫だった

		// 引数にforwardPathを指定し、↑までで設定されたフォワード先にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);//np
		dispatcher.forward(request, response);//np
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
