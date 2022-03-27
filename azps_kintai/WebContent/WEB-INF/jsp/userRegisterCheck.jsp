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
<title>ユーザー登録確認画面</title>

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

<!-- if判定でエラーメッセージがあればそれを表示。 -->

<!-- このif文はWEB-INF内にある同ファイルに対してしか正常に機能しない。 -->
<%
if (errorMsg.length() != 0) {
%>
<h1 class="h1_u_reg_ng text_center">入力エラー</h1>

<div class="div_u_reg_ng text_center">
	<b >--<%=errorMsg%>--<br>再度情報を入力してください。
	</b><br>
	<br>
	<!-- ユーザーレジスターサーブレットを介し新規登録画面へ戻る処理 -->
	<a class="register_button" href="/azps_kintai/UserRegisterServlet" title="新規ユーザー登録へ戻る">戻る</a>
</div>

<%
}
%>

<!-- もしエラーメッセージが何もなければ以下の処理を実行 -->
<%
if (errorMsg == null || errorMsg.length() == 0) {
%>


<!-- ここから下は登録情報の確認が促される画面。 -->

<!-- フォーム全体の画面の固定 -->
<div class="contact">

<table class="contact-table">

<tr>
<th class="contact-item"><span class="Form-Item-Label-Required text_right">*必須</span>
<label>社員ID</label>
</th>

<td class="contact-body">
<b><%=registerAccount.getEmp_Id()%></b>

</td>

</tr>


<tr>
<th class="contact-item"><span class="Form-Item-Label-Required text_right">*必須</span>
<label>パスワード</label>
</th>

<td class="contact-body">
<b><%=registerAccount.getPass()%></b>

</td>

</tr>

<tr>
<th class="contact-item"><span class="Form-Item-Label-Required text_right">*必須</span>
<label>従業員名</label>
</th>

<td class="contact-body">
<b><%=registerAccount.getName()%></b>

</td>

</tr>


</table>
</div>

<!-- if文の終わり -->
	<%
	}
	%>

	<div class="text_center">
	<h3>この内容でユーザー登録します。よろしいですか？</h3>
	<br><br>


	<!-- いいえの場合 -->
 	<a class="register_button"  href="/azps_kintai/UserRegisterServlet" title="新規ユーザー登録へ戻る">いいえ</a>
　

	<!-- はいの場合、モーダルポップアップで入力完了処理、しようかと思ったがaction=done飛ばす必要があるため断念。結果ページへ進む -->
<!--     <button onclick="pushed_Attendance()" class="js-modal-open register_button"  data-target="userRegisterChecke_modal01">はい</button> -->
 	<a class="register_button margin_80px_right"  href="/azps_kintai/UserRegisterServlet?action=done" title="新規ユーザー登録する">はい</a>


	</div>
<!-- UserRegisterServletへ飛ばすテスト送信フォーム -->
<!-- <form action="/azps_kintai/UserRegisterServlet" method="post"> -->
<!-- <input type=submit name="test送信" value="test"> -->
<!-- </form> -->

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