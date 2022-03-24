<!-- 最終更新日時0316 -->
<!-- 作成者井川-->

<!--jspテンプレ-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--各種modelの読み込み欄 複数指定時,カンマ忘れないように。-->


<!DOCTYPE html>
<html lang="ja">

<!-- ここから下はヘッド。表示されない情報の部分のみ書く -->
<head>
<meta charset="UTF-8">
<title>従業員ログイン画面</title>

<!-- CSS読み込み-->
<!--リセットcssの読み込み。！一部表示が崩れる場合を除き必須！ -->
<link rel="stylesheet" href="css/ress.css">

<!--google fontsの指定-->
<link href="https:fonts.googleapis.com/css?family=Philosopher" rel="stylesheet">

<!--ファビコンの読み込み。これをjsp毎のtitleタグの下に置く。-->
<link rel="icon" type="image/png" href="images/favicon-16x16.png">


<!-- 全ページで共通デザイン部分のstyle.cssの読み込み -->
<link rel="stylesheet" href="css/style.css">

<!-- ログインcss読み込み -->
<link rel="stylesheet" href="css/login.css">

<!--フォームcss読み込み -->
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

<!-- フォーム全体の画面の固定 -->
<div class="contact">

<h5 class="h1_login">勤怠管理システム<br>従業員ログイン画面</h5>

<form action="/azps_kintai/LoginServlet" method="post">

<table class="contact-table">
<tbody>
<tr>
<th class="contact-item">
<label>社員ID</label>
</th>
<td class="contact-body">
<input class="form-text" type="text" name="emp_Id" list="data" size="52"
pattern="^[0-9a-zA-Z]{6-20}$"
maxlength="10" placeholder="emp001(半角英数6～10文字で入力)" required>
</td>
</tr>

<tr>
<th class="contact-item">
<label>パスワード</label></th>
<td class="contact-body">
<input class="form-text" type="password" name="pass" size="52"
pattern="^[0-9a-zA-Z]{6,20}$" placeholder="半角英数6～20文字で入力" required>
</td>
</tr>

</tbody>
</table>

<input class="contact-submit"  type="submit" value="ログイン" />




<!-- ユーザー新規登録 -->
<%-- <a href="<%= request.getContextPath() %>/LogoutServlet"> --%>
<!-- ユーザーレジスターサーブレットにgetで飛ばす -->
<a href="/azps_kintai/UserRegister.java">
</a>
</form>





</div>
<!-- フッターラッパー-の閉じdiv -->
</div>
<!-- フッターインクルードの読み込み -->
<!-- 静的または動的インクルードの選択 -->
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
<%--<%@ include file="/WEB-INF/jsp/footer.jsp" %> --%>

<!-- ToDo
管理者側オミットしたので、新規ユーザー登録機能の画面をつくる

 -->

</body>

</html>