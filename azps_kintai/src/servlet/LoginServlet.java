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


	//getメソッド
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {/*②*/
		//リクエストパラメータの取得
		/*ログインサーブレット宛にgetで送信されてきたら・・・*/
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response); /* ③ */
		}

	//postメソッド
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		// UTF-8形式でリクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");

		//jsp側からPost送信されてきた値のうち、取得したい情報を設定。
		//ログイン時なので社員番号とパスワードを取得し、
		String emp_Id = request.getParameter("emp_Id");
		String pass = request.getParameter("pass");

		//ログイン処理の実行
		//
		//Login.javaモデルからインスタンスを生成し、logic変数に代入、
		Login login = new Login(emp_Id, pass);
		//その後logic変数をLoginLogic内から呼び出したLoginLogicメソッドにて照らし合わせる処理を行う。
		//LoginLogic.javaモデルからLoginLogic()を行う処理を変数boに代入
		LoginLogic bo = new LoginLogic();
		//結果：要素文字列の完全一致でtrue判定ならば
		//AccountBeans.javaモデルからexecuteメソッドを実行。引数には↑↑で実行したLogin.javaインスタンスを代入した変数を指定して変数accountに代入。
		AccountBeans account = bo.execute(login);

		//↑で設定した変数accountが生成されていればというif文。
		// ログイン処理の成否によって処理を分岐
	if (account != null) {
		// ログイン成功時、DBに登録済みのDAOを通してAccontBeansModelから定義済みのアカウント関連の引数有りコンストラクタ変数をパスワードを除きすべて取得。これは完全に一緒じゃなければならない。
		AccountBeans acc = new AccountBeans(account.getAccount_Num(),account.getMaster_Flag(),account.getEmp_Id(), account.getName(), account.getPass(),account.getStatus(),account.getComment());
		//セッションスコープに保存されたユニーク（一意であり重複しない）属性のものを変数sessionに代入。
		HttpSession session = request.getSession();

		//こちらはアプリケーションスコープ。複数ユーザーが使う複数の端末から使う可能性がある前提のアプリでは、一部テストなどの限定条件下を除き使わない。（一斉ログアウトなどされるため）
		//ServletContext application = this.getServletContext();
		//application.setAttribute("login", login);

		//セッションスコープに、loginAccount変数と,↑で設定したacc変数をセットことでDAOからの情報をログインアカウントに持たせる。
		session.setAttribute("loginAccount", acc);

		//さらに、個々人ごとの勤務記録も本来はこのログイン認証OKのタイミングで行う。（あとで追加を行う）

		//ここまでのif==true処理を終えた後の、POST時のフォワード先を指定する。ここではログイン処理後はメイン画面に遷移したいので、メイン画面を指定。
		/*	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");*/
		RequestDispatcher dispatcher = request.getRequestDispatcher("/main.jsp");
		dispatcher.forward(request, response);
		} else {
			//ログイン失敗時は遷移元のページへリダイレクト。ここでは、LogoutServletに飛ばし、セッションスコープの破棄と、login,jspへ戻る処理を同時に行う
			//リダイレクトした場合、URL欄に表示されるurlはここで指定したリダイレクト先ではなく、この場合、LoginServletになる。
			response.sendRedirect("/azps_kintai/LogoutServlet");
		}
	}
}
