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
import model.RegisterAccountLogic;


@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Getメソッド
	//header.jspから新規ユーザー登録ボタンを押した時と、
	//userRegisterCheck.jspからこの情報で登録する→「はい」で起動
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	//リクエスト情報をUTF-8で読むと宣言
	request.setCharacterEncoding("UTF-8");

	String action = request.getParameter("action");
	System.out.println("action"+"test");
	//フォワード初期化
	String forwardPath = null;//np

	//サーブレットクラスの動作を決定する「action」の値を
	//リクエストパラメータから取得


	//もしパラメータに"done"が代入されてGETリクエストされてきていたら
	//userRegisterCheck.jspで、この情報で登録する「はい」を押したものとみなす。
	if("done".equals(action)) {
		// ユーザー登録確認画面から「登録実行」をリクエストされたときの処理
		// セッションスコープに保存された登録アカウントを取得
		HttpSession session = request.getSession();
		//アカウントBeansクラスにキャストしてgetAttributeで引数レジスターアカウントを変数registerAcountに代入。
		AccountBeans registerAccount = (AccountBeans) session.getAttribute("registerAccount");

		// 登録処理の呼び出し

		//AccountDAO.java から呼び出したdao.findByCheckメソッドで既に登録されている情報かチェック
		RegisterAccountLogic logic = new RegisterAccountLogic();
		//AccountDao.java から呼び出したdao.INSERTメソッドで
		boolean registration = logic.execute(registerAccount);

		//session.removeAttribute("registerAccont");

			// 新規登録できた場合（IDが登録済みではなかった）
			//if==true
			if (registration) {
				// 登録後のフォワード先を設定
				forwardPath = "/WEB-INF/jsp/userRegisterResult.jsp";//np

			}
			else {
				// それ以外、つまり登録済みだった場合
				// エラーメッセージをリクエストスコープに保存
				request.setAttribute("errorMsg", "登録済みの社員番号です");
				// フォワード
				forwardPath = "/WEB-INF/jsp/userRegisterCheck.jsp";//△。単純遷移だとerror 63ぬるぽ構文ミスかも

			}

		//ネスト2フォワード先へ遷移
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);

	} else {
		//actionに何も入ってなければユーザーレジスターjspに飛ぶ
		/*もしactionに値が入っていなければ、フォワード先を以下のものに書き変える*/
		forwardPath = "/WEB-INF/jsp/userRegister.jsp";//np


  }


	//ネスト1フォワード処理
	/*↑で取得したフォワードパスを変数dispatcherに代入する。*/
	RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
	dispatcher.forward(request, response);
	//センドリダイレクト ここでセンドリダイレクト使うと、ユーザー新規登録がSQLに反映されない（連番だけ進む）。
//	response.sendRedirect("/azps_kintai/userRegister.jsp");

	}

/////////////////////////////////////////////////////////////////////////////////////////


	//POSTメソッド
	//新規ユーザー登録の情報入力フォームタグからinputのPOSTで送られてきた情報を処理する
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//送られてきたリクエスト情報をUTF-8形式でで読むと宣言
		request.setCharacterEncoding("UTF-8");

		// 送られてきたリクエストパラメータの取得
		String emp_Id = request.getParameter("emp_Id");
		String name = request.getParameter("userName");
		String pass = request.getParameter("pass");

		//2重チェック（HTML側書き換え対策）
		String errorMsg = "";
		//もし入力内容が書き換えられていたりタグにリクワイヤードつけ忘れていた場合用に、変数エラーメッセージに以下の文章を代入する
		if (emp_Id == null || name == null || pass == null) {
			errorMsg = "入力項目にエラーがあります。社員ID、名前、パスワードのいずれかの値が見つかりません。";
		}
		// エラーメッセージをリクエストスコープに保存
		request.setAttribute("errorMsg", errorMsg);

		//登録するユーザーの情報を設定するために、
		//アカウントビーンズをnewAccount変数に代入してインスタンス化

		//引数有りコンストラクタ実験用：どちらでもいけるし不具合はなし。
		//AccountBeans newAccount =new AccountBeans(emp_Id, name, pass);
		AccountBeans newAccount =new AccountBeans();
		//ビーンズ内のコンストラクタと同じ情報を持った実体化変数にset。
		//これによりnewAccount変数内にemp_Idなどの情報も格納される。
		//ここでsetさせた必要性はまだ不明だけど以下コメントのAccountDAOのテストかもなのでとりあえず残す。
		//いやでもこれがないと確認画面でgetParameterできぬ。ってああ、引数なしコンストラクタで実体化してるからだわ。。
		//なんで、accountDAO側に手を加える。
		newAccount.setEmp_Id(emp_Id);
		newAccount.setName(name);
		newAccount.setPass(pass);

		// セッションスコープに登録ユーザーインスタンスを保存
		HttpSession session = request.getSession();
		//セッションスコープのsetAttributeの引数にはkeyとなるString型registerAccountと、↑で作成したnewAccountインスタンス変数を入れる。
		session.setAttribute("registerAccount", newAccount);

		//多分サーブレットからDAOテスト用
		/*
		 * AccountDAO Adao = new AccountDAO(); Adao.Insert(newAccount);
		 */

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
		//完了した処理結果をスコープに保存している状態でレジスターチェックJSPに飛ぶ。
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userRegisterCheck.jsp");
		dispatcher.forward(request, response);

		//センドリダイレクト
//		response.sendRedirect("./userRegisterCheck.jsp");

		//フォワード


	}
}
