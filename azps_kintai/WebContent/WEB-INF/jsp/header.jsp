<!-- 最終更新日時0316 -->

<%@ page language="java" pageEncoding="UTF-8"%>

<!-- 変数の機能定義などに必要なモデルの読み込み。ここが抜けてると変数関連エラーになる-->
<%-- <%@ page import="model.*"%> --%>
<%@ page import="model.AccountBeans"%>
<%--<%@ page import="model.AccountBeans,model.Restaurant,java.util.List"%>--%>


<!-- セッションスコープからユーザー情報を取得 -->

<%
AccountBeans loginAccount = (AccountBeans) session.getAttribute("loginAccount");
%>


<!-- ヘッダーCSSを読み込み -->
<link rel="stylesheet" href="css/header.css">

<!-- ブラウザの戻るボタンを禁止するjavascript-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function(){
    history.pushState(null, null, null);
    $(window).on("popstate", function(){
        history.pushState(null, null, null);
    });
});
</script>

<!--ラッパークラスを追加-->
<header class="page_header_flex header_wrapper header_border_underline header_bg_color" >

<!-- 変数未定義なので一度コメント -->

<% if(loginAccount == null){%>
<!-- 製作者側でプロジェクト名が異なる可能性があるので、コンテキストパスで飛ばす -->
<%-- <a href="<%= request.getContextPath() %>/LogoutServlet"> --%>
<!-- 動作テストのためログインサーブレットへ飛ばしてみる -->
<a href="<%= request.getContextPath() %>/LoginServlet">
<!-- アンカータグ。ログイン前なので飛ばす先はlogin.jsp。「/login.jsp」でも動く -->
<!--左上部画像の読み込み。ヘッダ上部くいだおれログのロゴ -->
<img class=header_img_logo src="images/timecardAppLogo300_300.png" alt="従業員 ログイン画面へ" >
</a>


<% }else{%><!-- ログイン後なら -->
<!-- アンカータグ。ログイン後なので飛ばす先はlogin.jsp。
「/login.jsp」でも動く -->
<a href="/azps_kintai/LogoutServlet">
<!--画像の読み込み-->
<img class="header_img_logo" src="images/timecardAppLogo300_300.png" alt="従業員 メイン画面へ" >
</a>
<%} %><!-- if文終わり -->

<nav>
<!-- ヘッダー右上部のメインナビゲーションバー -->
<ul class="header_main_nav">

<!-- 変数未定義なので一度コメント -->

<!-- アンカータグで飛ぶ先を指定するよ -->
<!-- その前に、スクリプト式でログイン済みかどうかを判定する -->
<!-- ログイン前なら -->
<!-- keyとなる"loginAccount"は持っていないので -->
<% if(loginAccount == null){%>
<!-- 本来Stringで受け取っているなら下の式(ｺﾒ内の赤下線は無視)だが、@pageで指定していて、 -->
<!-- スクリプトレット内なので変数直接読み込めるから↑の書き方で正解。 -->
<%--<% if(loginAccount.equals("")){%> --%>

<!-- ここから下がtrue時のhtml側の実行メソッド -->

<li><a href="/azps_kintai/Login">
<span class="header_span_item1">ユーザーログイン</span></a></li>

<!-- 変数未定義なので一度コメント -->

<% }else{%>

<!-- ここから下がfalse時（ログインされてると判定)のhtml側の実行メソッド -->
<li><a href="/azps_kintai/MainServlet">勤怠記録　</a></li>
<li><a href="/azps_kintai/MyPageServlet">
</a>
<p>
ようこそ
<!-- 変数未定義なので一度コメント -->
<%-- <%=loginAccount.getUserNickname()%> --%>

さん　
</p>
</li>

<li><a href="/azps_kintai/LogoutServlet">ログアウト　</a></li>

<!-- 変数未定義なので一度コメント -->
<%} %><!-- if文終わり -->

</ul>
</nav>
</header>
