/*譛�邨よ峩譁ｰ03/23縲�譖ｴ譁ｰ閠�/莠募ｷ�*/

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


@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		//セッションスコープに保存された情報を sessionに代入
		HttpSession session = request.getSession();
		//invalidateメソッドを使い、セッションスコープを破棄する。
		session.invalidate();
		//アプリケーションスコープに保存された情報を applicationに代入
		ServletContext application = this.getServletContext();
		//removeAttributeメソッドを使い、引数に変数"login"を指定しアプリケーションスコープから破棄する。
		application.removeAttribute("login");

		//繝ｭ繧ｰ繧､繝ｳ迥ｶ諷九′縺ｪ縺九▲縺溘→縺阪�ｯlogin.jsp縺九ｉ縺ｮ繧｢繧ｯ繧ｻ繧ｹ

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");/* */
		dispatcher.forward(request, response);

	}

}
