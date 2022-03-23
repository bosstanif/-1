/*最終更新03/23　更新者/井川*/

package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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

		//セッションスコープの破棄
		HttpSession session = request.getSession();
		session.invalidate();

		//ログイン状態がなかったときはlogin.jspからのアクセス

		//ログアウト画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");/* */
		dispatcher.forward(request, response);

	}

}
