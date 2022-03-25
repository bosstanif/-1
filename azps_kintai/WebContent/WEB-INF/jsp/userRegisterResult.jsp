<!-- 最終更新日時0325 -->
<!-- 作成者井川-->

<!--jspテンプレ-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--各種modelの読み込み欄 複数指定時,カンマ忘れないように。-->
<!-- アカウントの重複があればエラーメッセージを返す処理のための情報持っているモデルとその変数をインポート -->
<%@ page import="model.AccountBeans"%>
<%
AccountBeans registerAccount = (AccountBeans) session.getAttribute("registerAccount");
String errorMsg = (String) request.getAttribute("errorMsg");
%>

<!DOCTYPE html>
<html lang="ja">

<!-- ここから下はヘッド。表示されない情報の部分のみ書く -->
<head>
<meta charset="UTF-8">
<title>ユーザー登録完了画面</title>

<!-- CSS読み込み-->
<!--リセットcssの読み込み。！一部表示が崩れる場合を除き必須！ -->
<link rel="stylesheet" href="css/ress.css">

<!--google fontsの指定-->
<link href="https:fonts.googleapis.com/css?family=Philosopher" rel="stylesheet">

<!--ファビコンの読み込み。これをjsp毎のtitleタグの下に置く。-->
<link rel="icon" type="image/png" href="images/favicon-16x16.png">

<!-- 全ページで共通デザイン部分のstyle.cssの読み込み -->
<link rel="stylesheet" href="css/style.css">

<!-- レスポンシブデザインテーブル.cssの読み込み -->
<link rel="stylesheet" href="css/responsiveTables.css">

<!-- モーダルウィンドウ.cssの読み込み -->
<link rel="stylesheet" href="css/timecard.css">

<!-- 登録フォーム.cssの読み込み-->
<link rel="stylesheet" href="css/form.css">


</head>

<body class="text_center" >
<!-- 全体を中央ぞろえにしたくない場合は↑のclass="text_center"を消してください-->
<!-- ここから下はボディ。そのページ独自の内容のみ書く。 -->

<!-- 上部ヘッダー部分。ヘッドとは違うので注意 -->

<!-- 静的または動的インクルードの選択 -->
<%-- <jsp:include page="/WEB-INF/jsp/header.jsp" /> --%>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<!-- フッター用のラッパーを追加-->
<div id="footer_wrapper">
<!-- ここの下から実際にページ内容を書き始める。 -->


<h2 class="h1_u_reg_result text_center">ユーザー登録完了</h2>

<div class="div_u_reg_result text_center">
	<h4 >
		 　ユーザー登録を完了しました。
	</h4>
	<br>
	<br>
<!-- 	ログインサーブレット経由でログイン画面へ飛ぶ -->
	<a class="register_button" href="/azps_kintai/LoginServlet" title="ユーザーログインへ" >ログイン画面へ</a>
</div>

<!-- フッターラッパー-の閉じdiv -->
</div>
<!-- フッターインクルードの読み込み -->
<!-- 静的または動的インクルードの選択 -->
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
<%--<%@ include file="/WEB-INF/jsp/footer.jsp" %> --%>

<!-- スクリプト読み込み -->,

<!-- ユーザー新規登録確認押下後モーダルウィンドウ用jsを読み込み -->
<script type="text/javascript" src="js/modalWindow.js"></script>

<!-- レスポンシブテーブルjsを読み込み -->
<script type="text/javascript" src="js/responsiveTables.js"></script>

<!-- グローバル変数jsを読み込み -->
<script type="text/javascript" src="js/globalConst.js"></script>

</body>

</html>