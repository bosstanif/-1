package servlet;

import java.io.IOException;

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
	//UserRegisterResult.jspから「ログイン画面へ戻る」を押された時と、
	//header.jspから「ログイン画面」を押した時に起動
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {/*②*/
		//リクエストパラメータの取得
		/*ログインサーブレット宛にgetで送信されてきたら・・・*/


		//フォワード、またはセンドリダイレクトの選択。
		//フォワード：サーブレットまたはjspファイルが指定可能、転送元アプリケーションにのみ飛べる。
		//			  転送後URLはリクエスト時のまま、リクエストスコープ引き継ぎ可
		//			  ログイン処理などの場合、doPostでフォワード後に同じ画面リロードするとdoGetが実行される。何もメソッド無いとブランクページ。ので注意。
		//			  対策として、乱数キーも生成してセッション保管か、センドリダイレクト(ユーザーからURL指定可能になるデメリットはある)。PRGパターン。
		//センドリダイレクト：サーブレット、HTML、jspファイルなどブラウザがリクエストできるものすべて(WEB-INF内などを除く)指定可能、
		//					  すべてのアプリケーション、他サイトに転送可能。
		//					  転送後URLはリダイレクト先に変わるのでWebContent内でよくて、リロード二重投稿などを防ぎたい場合に利用
		//リクエストスコープ引き継ぎ不可、セッションとアプリケーションスコープは可

		//フォワード
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
//		dispatcher.forward(request, response); /* ③ */

		//センドリダイレクト　ここでセンドリダイレクト使うことでurlを明示的に変更。
		response.sendRedirect("/azps_kintai/login.jsp");
		}


//////////////////////////////////////////////////////////////////////////////////

	//postメソッド
	//「ログイン」実行時に起動
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		// UTF-8形式でリクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");

		//jsp側からPost送信されてきた値のうち、取得したい情報を設定。
		//ログイン時なので社員番号とパスワードを取得し、
		String emp_Id = request.getParameter("emp_Id");
		String pass = request.getParameter("pass");

		//エラーメッセージとフォワード先分岐用の変数を定義
		//今回はまだ使用しない
		String msg = "";
		String forwardPath = "";

		//ログイン確認処理の実行
		//
		//Login.javaモデルからを生成し、インスタンス変数loginに代入、
		Login login = new Login(emp_Id, pass);
		//logic変数をLoginLogic内から呼び出したLoginLogicメソッドにて照らし合わせる処理を行うため実体化。
		//LoginLogic.javaモデルからLoginLogic()を行う処理をインスタンス変数boに代入
		LoginLogic bo = new LoginLogic();


		//AccountBeans.javaモデルからexecuteメソッドを実行し
		//要素の完全一致でtrue判定する処理メソッドを呼び出す。
		//引数には↑↑で実行したLogin.javaインスタンスを代入した変数を指定して変数accountに代入。
		AccountBeans account = bo.execute(login);
//		boolean result = bo.execute(login);

		//↑で設定した変数accountでは一致しなければnullのままなので。
		// nullじゃないかどうかでログイン処理の成否によって処理を分岐
		if (account != null) {
//		if(result) {
		// ログイン成功時、DBに登録済みのDAOを通してAccontBeansModelから定義済みのアカウント関連の引数有りコンストラクタ変数をパスワードを除きすべて取得。
		//これは完全に一緒じゃなければならない。
//			//↓DAO側で生成するように処理変更したのでなし。
		AccountBeans accountBeansInstance = new AccountBeans(account.getAccount_Num(),account.getMaster_Flag(),account.getEmp_Id(), account.getName(), account.getPass(),account.getStatus(),account.getComment());
//		AccountBeans accountBeansInstance = new AccountBeans(account.getAccount_Num(),account.getMaster_Flag(),account.getEmp_Id(), account.getName(), account.getPass(),account.getStatus(),account.getComment());
		//セッションスコープに保存されたユニーク（一意であり重複しない）属性のものを変数sessionに代入。
		HttpSession session = request.getSession();

		//こちらはアプリケーションスコープ。複数ユーザーが使う複数の端末から使う可能性がある前提のアプリでは、一部テストなどの限定条件下を除き使わない。（一斉ログアウトなどされるため）
		//ServletContext application = this.getServletContext();
		//application.setAttribute("login", login);

		//セッションスコープに、loginAccount変数と,↑で設定したaccountBeansInstance変数をセット
		//結果としてDAOからの情報をログインアカウントに持たせる。
		session.setAttribute("loginAccount", accountBeansInstance);
//		session.setAttribute("emp_Id",emp_Id);

		//さらに、個々人ごとの勤務記録も本来はこのログイン認証OKのタイミングで行う。（あとで追加を行う）

		//ここまでのif==true処理を終えた後の、POST時のフォワード先を指定する。ここではログイン処理後はメイン画面に遷移したいので、メイン画面を指定。

		//フォワード、またはセンドリダイレクトの選択。
		//フォワード：サーブレットまたはjspファイルが指定可能、転送元アプリケーションにのみ飛べる。
		//			  転送後URLはリクエスト時のまま、リクエストスコープ引き継ぎ可
		//			  ログイン処理などの場合、doPostでフォワード後に同じ画面リロードするとdoGetが実行される。何もメソッド無いとブランクページ。ので注意。
		//			  対策として、乱数キーも生成してセッション保管か、センドリダイレクト(ユーザーからURL指定可能になるデメリットはある)。PRGパターン。
		//センドリダイレクト：サーブレット、HTML、jspファイルなどブラウザがリクエストできるものすべて(WEB-INF内などを除く)指定可能、
		//					  すべてのアプリケーション、他サイトに転送可能。
		//					  転送後URLはリダイレクト先に変わるのでWebContent内でよくて、リロード二重投稿などを防ぎたい場合に利用
		//リクエストスコープ引き継ぎ不可、セッションとアプリケーションスコープは可

		//フォワード
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
//		dispatcher.forward(request, response);

		//センドリダイレクト
		response.sendRedirect("/azps_kintai/main.jsp");
//		response.sendRedirect("./main.jsp");//この形だとおそらくうまくパスを読み取れないためEclipse再起動時404になることがある

		} else {
			//ログイン失敗時は遷移元のページへリダイレクト。ここでは、LogoutServletに飛ばし、セッションスコープの破棄と、login,jspへ戻る処理を同時に行う
			//リダイレクトした場合、URL欄に表示されるurlはここで指定したリダイレクト先ではなく、この場合、LoginServletになる。
			response.sendRedirect("/azps_kintai/LogoutServlet");
		}
	}
}
