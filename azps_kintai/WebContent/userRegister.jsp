<!-- 最終更新日時0325 -->
<!-- 作成者井川-->

<!--jspテンプレ-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--各種modelの読み込み欄 複数指定時,カンマ忘れないように。-->

<!-- 参考検索ワード -->
<!-- モーダル formタグ位置 -->


<!-- サーブレットのスコープ内にエラーメッセージ変数があればそのメッセージが表示される処理。 -->
<%
String errorMsg = (String) request.getAttribute("errorMsg");
%>

<!DOCTYPE html>
<html lang="ja">

<!-- ここから下はヘッド。表示されない情報の部分のみ書く -->
<head>
<meta charset="UTF-8">
<title>従業員情報新規登録画面</title>

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

<div class="contact">
	<h2 class="contact-ttl">新規ユーザー登録</h2>

<!-- モーダルのフォームタグを全体を包むように置いてみるテスト１ -->
<!-- UserRegisterServletへ飛ばすテスト送信フォーム -->
<form action="/azps_kintai/UserRegisterServlet" method="post">
<!-- <form action="/azps_kintai/UserRegisterServlet" method="post"> -->
<!-- <input type=submit name="test送信" value="test"> -->

<!-- ここからテーブル作成開始 -->

<!-- ここにmodalのアンカータグやボタンを置く -->


<!-- モーダル用データテーブルクラス読み込み -->
<table class="contact-table">

<tr>
<th class="contact-item"><span class="Form-Item-Label-Required text_right">*必須</span>
<label>社員ID</label>
</th>

<td class="contact-body">
<input class="form-text" type="text" name="emp_Id" list="data"
pattern="^[0-9a-zA-Z]{1,10}$" size="52" autocomplete="off" title="emp001(半角英数1～10文字で入力)"
maxlength="10" placeholder="emp001(半角英数1～10文字で入力)" required>

</td>

</tr>


<tr>
<th class="contact-item"><span class="Form-Item-Label-Required text_right">*必須</span>
<label>パスワード</label>
</th>

<td class="contact-body">
<input class="form-text" type="password" name="pass" size="52" title="半角英数6～20文字で入力"
pattern="^[0-9a-zA-Z]{6,20}$" placeholder="半角英数6～20文字で入力" required>

</td>

</tr>

<tr>
<th class="contact-item"><span class="Form-Item-Label-Required text_right">*必須</span>
<label>従業員名</label>
</th>

<td class="contact-body">
<input class="form-text" type="text" name="userName" size="52" autocomplete="off"
pattern="^[^0-9]{2,20}$" title="アズール プラス:2文字以上:数字以外(苗字との間に半角スペースを入れてください)"
placeholder="アズール プラス:2文字以上:数字以外(苗字との間に半角スペースを入れてください)" required>

</td>

</tr>


</table>
<!-- <a class="register_button margin_80px_right" type="submit" href="/azps_kintai/UserRegisterServlet?action=null" title="確認画面へ進む">確認画面へ</a> -->
<input class="register_button"  type="submit" title="確認画面へ進む" value="確認画面へ" />

<!-- <button onclick="pushed_Attendance()" name="この内容でユーザー登録する" type="submit"
class="js-modal-open register_button"  data-target="register_modal01">この内容でユーザー登録する</button> -->


</form>

<!-- テスト：送信した後モーダルウィンドウを開く感じで -->
<!-- 新規登録確認ボタン -->

<!-- hiddenでインプット、クッキーに保存が必要かも -->
<!-- 参考URL https://teratail.com/questions/53352　-->


<!-- <input class="contact-submit"  type="submit" value="新規登録" /> -->


<!-- ここから下で非表示にしてあるモーダル内の表示を実装 -->


    <div id="register_modal01" class="modal js-modal">
        <div class="modal__bg js-modal-close"></div>
        <div class="modal__content">
<!-- <p>regiser内1つ目モーダルウィンドウです。ここにモーダルウィンドウで表示したいコンテンツを入れます。モーダルウィンドウを閉じる場合は下の「閉じる」をクリックするか、背景の黒い部分をクリックしても閉じることができます。</p> -->
<!-- 5つ目のモーダル内にはユーザー新規登録確認画面が入ります -->

<!-- 修正時間をFixServletに送るためのform -->

<!-- テスト用form -->
<!--  <form action="main.jsp" method="get"> -->
<!-- テスト結果は以下の通りなので、きちんとform情報が送れている -->
<!-- http://localhost:8080/azps_kintai/main.jsp?
birthday=2022-03-23&inTimeStart=1000&outTimeEnd=1000&overTimeHours=00&breakInStart=1000&breakOutEnd=1000&fixComment=000&fixValue= -->

<!-- モーダル用データテーブルクラス読み込み -->
<form>
<table class="contact-table">

<tr>
<th class="contact-item"><span class="Form-Item-Label-Required text_right">*必須</span>
<label>社員ID</label>
</th>

<td class="contact-body">
<input class="form-text" type="text" name="emp_Id" list="data"
pattern="^[0-9a-zA-Z]{6,10}$" size="52" autocomplete="off" title="emp001(半角英数6～10文字で入力)"
maxlength="10" placeholder="emp001(半角英数6～10文字で入力)" required>

</td>

</tr>


<tr>
<th class="contact-item"><span class="Form-Item-Label-Required text_right">*必須</span>
<label>パスワード</label>
</th>

<td class="contact-body">
<input class="form-text" type="password" name="pass" size="52" title="半角英数6～20文字で入力"
pattern="^[0-9a-zA-Z]{6,20}$" placeholder="半角英数6～20文字で入力" required>

</td>

</tr>

<tr>
<th class="contact-item"><span class="Form-Item-Label-Required text_right">*必須</span>
<label>従業員名</label>
</th>

<td class="contact-body">
<input class="form-text" type="text" name="userName" size="52" autocomplete="off"
pattern="^[^0-9]{2,20}$" title="アズール プラス:2文字以上:数字以外(苗字との間に半角スペースを入れてください)"
placeholder="アズール プラス:2文字以上:数字以外(苗字との間に半角スペースを入れてください)" required>

</td>

</tr>


</table>

<!-- 		submit属性でデータ送信ボタン作ってみる -->
<!-- <input onclick="pushed_Attendance()" name="この内容でユーザー登録する" type="submit"
class="js-modal-open register_button"  data-target="register_modal02"> -->
<input onclick="pushed_Attendance()" name="この内容でユーザー登録する" type="submit"
class=" register_button"  data-target="register_modal02">

</form>

<!-- 送信完了しましたボタンの非表示モーダル -->
<div class="text_center">

    <div id="user_register02" class="modal js-modal">
        <div class="modal__bg js-modal-close"></div>
        <div class="modal__content">
<!-- <p>main内と通算して6つ目モーダルウィンドウです。ここにモーダルウィンドウで表示したいコンテンツを入れます。モーダルウィンドウを閉じる場合は下の「閉じる」をクリックするか、背景の黒い部分をクリックしても閉じることができます。</p> -->
<!-- 6つ目のモーダル内には打刻修正の画面が入ります -->

		        <h1>ユーザー新規登録完了しました</h1>
				<p></p>
 				<p id="outtimeDate1">Now Loading...</p>
				<p id="outtimeDate2">Now Loading...</p>
<!-- 				↓出勤Servlet用の時刻が送れているかテスト。あとでコメントアウトする -->
				<p id="attendanceOuttimeValueInputtest">test Loading...</p>
<!-- 				↓現在日時をvalueに入れてhidden属性でServlet側へ送る。動作未検証 -->
			<input id="attendanceOuttimeValueInput" type="hidden" name="outtimeValue" value="">

            <button class="js-modal-close" >閉じる</button>
        </div><!--modal__inner-->
    </div><!--modal-->

</div>



            <button class="js-modal-close" >閉じる</button>
        </div><!--modal__inner-->
    </div><!--modal-->


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

<!-- 自作のグローバル変数jsを読み込み -->
<script type="text/javascript" src="js/globalConst.js"> </script>

</body>

</html>