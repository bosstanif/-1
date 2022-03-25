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


	//もしパラメータに"done"が代入されていたら
	if("done".equals(action)) {
		//こちらの画面でDAOメソッドに難あり
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
	}

/////////////////////////////////////////////////////////////////////////////////////////


	//POSTメソッド
	//ユーザー情報入力フォームタグからPOSTで送られてきた情報を処理する
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//リクエスト情報をUTF-8で読むと宣言
		request.setCharacterEncoding("UTF-8");

		// リクエストパラメータの取得
		//オートインクリメントのnum系は基本的に入れない。
		String emp_Id = request.getParameter("emp_Id");
		String name = request.getParameter("pass");
		String pass = request.getParameter("userName");

		//アカウントビーンズをnewAccount変数に代入してインスタンス化
		AccountBeans newAccount =new AccountBeans();
		newAccount.setEmp_Id(emp_Id);
		newAccount.setName(name);
		newAccount.setPass(pass);

		//2重チェック（HTML側書き換え対策）
		String errorMsg = "";
		//もし入力内容が書き換えられていたりタグにリクワイヤードつけ忘れていた場合は、変数エラーメッセージに以下の文章を代入する
		if (emp_Id == null || name == null || pass == null) {
			errorMsg = "入力項目にエラーがあります。社員IDまたは名前またはパスワードの値が見つかりません。";
		}
		// エラーメッセージをリクエストスコープに保存
		request.setAttribute("errorMsg", errorMsg);

		// セッションスコープに登録ユーザーを保存
		HttpSession session = request.getSession();
		//セッションスコープのsetAttributeの引数にはString型registerAccountと、↑で作成したアカウントビーンズインスタンスを入れる。
		session.setAttribute("registerAccount", newAccount);

		/*
		 * AccountDAO Adao = new AccountDAO(); Adao.Insert(newAccount);
		 */
		//フォワード
		//完了した処理結果をスコープに保存している状態でレジスターチェックJSPに返す。
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userRegisterCheck.jsp");
		dispatcher.forward(request, response);

	}

}
