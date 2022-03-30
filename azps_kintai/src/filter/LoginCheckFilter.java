/*package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
*//**
	* Servlet Filter implementation class LoginCheckFilter
	*/
/*
フィルターをかける対象（主にサーブレット）を選ぶ
@WebFilter({"/LoginServlet","/UserRegisterServlet","/LogoutServlet","/MainServlet"})
public class LoginCheckFilter implements Filter {

 *//**
	* デフォルトコンストラクタ変数
	*/
/*
public LoginCheckFilter() {
 //こちらは多分あってもなくても。かな？
}

*//**
	* @see Filter#destroy()
	*/
/*
public void destroy() {
//終了時メソッド内を空欄で定義
}

*//**
	* @igawa 主なFilter実行メソッド
	*/
/*
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

//コンソール内で動作確認
System.out.println("Login Check...");

//ログインしているかを確認するためのユーザ情報を
//セッションスコープ変数から取得

if (loginAccount == null) {
	// コンソールで動作確認
	System.out.println("The not login.for reDirect...");
	// ログインしていない場合、リダイレクト
	((HttpServletResponse) response).sendRedirect("/docoTsubu/");
} else {
	// コンソールで動作確認
	System.out.println("nomal moving...");
	// ログイン済みの場合、通常の遷移
	chain.doFilter(request, response);
}
}

*//**
	* @see Filter#init(FilterConfig)
	*//*
		public void init(FilterConfig fConfig) throws ServletException {
		//開始メソッド内を空欄で定義
		}

		}
		*/