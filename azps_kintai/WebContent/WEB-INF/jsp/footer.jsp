<!-- 最終更新日時0316 -->

<!-- contentType="charset=UTF-8" は重複セットになるので読み込まない。ヘッダと元のjsp側とでバッティングしエラー　-->
<%@ page language="java"  pageEncoding="UTF-8"%>

<!-- 変数の機能定義などに必要なモデルの読み込み。jspに変数設定していてなおかつこの指定が抜けてると変数関連エラーになります。 -->
<%@ page import="model.AccountBeans"%>
<%-- <%@ page import="model.Account,model.Restaurant,java.util.List"%> --%>

<!-- セッションスコープからユーザー情報を取得 -->
<%-- <% Account loginAccount = (Account) session.getAttribute("loginAccount"); %> --%>

<!-- footer.cssを指定-->
<link rel="stylesheet" href="css/footer.css">

<!-- コピーライト部分 -->
<!-- footerタグで囲うべき箇所なので、footerタグ内にclass記載 -->
<footer class="footer page_footer_flex footer_wrapper footer_border_underline footer_bg_color">
<!-- ログイン変数が作られた後はこちらのコメントを削除 -->
<%--<% if(loginAccount == null){
<!-- アンカータグ。ログイン前なので飛ばす先はlogin.jsp。「/login.jsp」でも動作 -->
<a href="/azps_kintai/Logout">
<!--左上部画像の読み込み。ロゴ部分 -->
<img class=footer_img_logo src="images/headlogo.png" alt="従業員 ログイン画面へ" >
</a>

	<% }else{%><!-- もしログイン後なら -->
	<!-- アンカータグ。ログイン後なので飛ばす先はlogin.jsp。「/login.jsp」でも動作 -->
	<a href="/kuidaoreLog/Logout">
	<!--画像の読み込み-->
	<img class="footer_img_logo" src="images/headlogo.png" alt="従業員 メイン画面へ" >
	</a>
	<%} %><!-- if文終わり -->--%>



<nav class="footer_main_nav">
<small>&copy; 2022 azps_java_team</small>
</nav>

</footer>



