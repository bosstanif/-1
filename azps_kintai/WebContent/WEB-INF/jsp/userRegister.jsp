<!-- 最終更新日時0324 -->
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

<!-- 登録フォーム.cssの読み込み。家帰ってから追加 -->


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


<h2>新規ユーザー登録</h2>

<!-- モーダルのフォームタグを全体を包むように置いてみるテスト１ -->
<!-- UserRegisterServletへ飛ばすテスト送信フォーム -->
<form action="/azps_kintai/UserRegisterServlet" method="post">
<!-- <input type=submit name="test送信" value="test"> -->

<!-- ここからテーブル作成開始 -->

<!-- ここにmodalのアンカータグやボタンを置く -->


<!-- モーダル用データテーブルクラス読み込み -->
<table class="dataTable">

<tr>
<th>必須：社員ID</th>

<td>
<input class="form-text" type="text" name="empID" list="data"
pattern="^[0-9a-zA-Z]{6-10}$" size="52"
maxlength="10" placeholder="emp001(半角英数6～10文字で入力)" required>

</td>

</tr>


<tr>
<th>必須：パスワード</th>

<td>
<input type="password" name="pass" size="52"
pattern="^[0-9a-zA-Z]{6-20}$" placeholder="半角英数6～20文字で入力" required>

</td>

</tr>

<tr>
<th>必須：従業員名</th>

<td>
<input type="text" name="userName" size="52"
placeholder="堀江 貴文(苗字との間に半角スペースを入れてください)" required>

</td>

</tr>


</table>


<!-- テスト：送信した後モーダルウィンドウを開く感じで -->
<!-- 新規登録確認ボタン -->

<!-- hiddenでインプット、クッキーに保存が必要かも -->
<!-- 参考URL https://teratail.com/questions/53352　-->
<button onclick="pushed_Attendance()" name="確認画面へ"
class="js-modal-open register_button"  data-target="register_modal01">確認画面へ</button>

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

			<table class="dataTable">

		    <tr>
		    <th>
		        <b>打刻修正</b>
			</th>
			<td>
				<p></p>
			</td>
			</tr>


			<tr>
		    <th>
		        <b>打刻年月日</b>
			</th>

			<td>
				<input class="form-text" id="until-today" type="date" name="attendanceDay"
				placeholder="2022年3月23日" required>
			</td>
			</tr>


			<tr>
		    <th>
		        <b>出退勤時間</b>
			</th>

			<td>
				<input class="res_timepicker"  type="text" name="inTimeStart" placeholder="09:00"  required/>　～　
				<input class="res_timepicker"  type="text"   name="outTimeEnd" placeholder="17:00"  required/>
			</td>

		    <th>
		        <b>残業時間</b>
			</th>
			<td>
				<input class="form-text" type="text" name="overTimeHours" maxlength="2"
				pattern="[0-9]{1,2}" placeholder="0(数字のみ2桁まで)" required>
			</td>

			</tr>


			<tr>
		    <th>
		        <b>休憩時間</b>
			</th>

			<td>
				<input class="res_timepicker"  type="text" name="breakInStart" placeholder="09:00"  required/>　～　
				<input class="res_timepicker"  type="text"   name="breakOutEnd" placeholder="17:00"  required/>
			</td>

			</tr>

    	<tr>
		<th>
		　　<label class="text_center">コメント</label>
        </th>
        <td class="contact-body">
		<b>
		<textarea class="form-text" name="fixComment" placeholder="修正時のコメントを入力して下さい。(必須：100文字まで)" cols="100" rows="7" title="修正時のコメントを入力" required></textarea>
		<br></b>
        </td>
        </tr>

		</table>
<!-- 		submit属性でデータ送信ボタン作ってみる -->
<button onclick="pushed_Attendance()" name="この内容でユーザー登録する" type="submit"
class="js-modal-open register_button"  data-target="register_modal02">この内容でユーザー登録する</button>



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

	</form>


<!-- フッターラッパー-の閉じdiv -->
</div>
<!-- フッターインクルードの読み込み -->
<!-- 静的または動的インクルードの選択 -->
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
<%--<%@ include file="/WEB-INF/jsp/footer.jsp" %> --%>

<!-- スクリプト読み込み -->

<!-- ユーザー新規登録確認押下後モーダルウィンドウ用jsを読み込み -->
<script type="text/javascript" src="js/modalWindow.js"></script>

<!-- レスポンシブテーブルjsを読み込み -->
<script type="text/javascript" src="js/responsiveTables.js"></script>


</body>

</html>