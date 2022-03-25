<!-- 最終更新日時0324 -->
<!-- 作成者井川-->
<!-- 勤怠記録画面(日間集計) -->
<!-- 動的インクルードで読み込むことで画面遷移情報削減化 -->

<!-- URLメモ -->
<!-- https://atmarkit.itmedia.co.jp/ait/articles/0109/19/news002.html -->

<!--jspテンプレ-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--各種modelの読み込み欄 複数指定時,カンマ忘れないように。-->
<!-- ここではヘッダー側で読み込んでいるのでモデルの指定は必要なし（）重複ローカル変数で500エラーになる -->
<%-- <%@ page import="model.AccountBeans,model.CountdayBeans,java.util.List"%> --%>
<%-- <%@ page import="model.AccountBeans"%> --%>

<!-- セッションスコープから現在ログインしているユーザー情報を取得 -->
<!-- ここでは既に同じ内容のものをヘッダー側で読み込んでいるのでこの変数定義の指定は必要なし（）重複ローカル変数で500エラーになる -->
<%-- <%
AccountBeans loginAccount = (AccountBeans) session.getAttribute("loginAccount");
%> --%>


<!DOCTYPE html>
<html lang="ja">

<!-- ここから下はヘッド。表示されない情報の部分のみ書く -->
<head>
<meta charset="UTF-8">
<title>日間勤怠記録表</title>

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

<!-- タイムピッカー.cssの読み込み-->
<!-- CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/jquery-datetimepicker@2.5.20/jquery.datetimepicker.css">
<!-- <link rel="stylesheet" href="datetimepicker-master/build/jquery.datetimepicker.css"> -->

</head>

<body class="text_center" >
<!-- 全体を中央ぞろえにしたくない場合は↑のclass="text_center"を消してください-->
<!-- ここから下はボディ。そのページ独自の内容のみ書く。 -->

<!-- ここの下から実際にページ内容を書き始める。 -->


<h1>例)名無しさんの勤怠記録表：日毎集計</h1>


<!-- ここからレスポンシブテーブル処理 -->

<table onload="pushed_Attendance()" class="dataTable">
    <thead>
        <tr>
            <th>日付</th>
            <th>出勤</th>
            <th>退勤</th>
            <th>休憩 入</th>
            <th>休憩 戻</th>
            <th>労働時間</th>
            <th>残業時間</th>
            <!-- 管理者側オミットしたので、打刻修正申請から打刻修正変更 -->
            <th>打刻修正</th>
<!--             <th>コメント</th> -->
        </tr>
    </thead>
    <tbody>


        <tr>
            <td>例)03/01(火)</td>
            <td>例)9:03</td>
            <td>例)18:00</td>
            <td>例)12:00</td>
            <td>例)13:00</td>
            <td>例)8h</td>
            <td>例)0h</td>
            <td>
                <button onclick="pushed_Attendance()" class="js-modal-open register_button"  data-target="daywork_modal01">打刻修正</button>
            </td>

<!--             <td>
                <button class="comment_button action">例)修正依頼却下</button>
            </td> -->
        </tr>


        <tr>
            <td>例)03/02(水)</td>
            <td>例)9:00</td>
            <td>例)18:00</td>
            <td>例)12:00</td>
            <td>例)13:00</td>
            <td>例)8h</td>
            <td>例)0h</td>
            <td>
                <button onclick="pushed_Attendance()" class="js-modal-open register_button"  data-target="daywork_modal01">打刻修正</button>
            </td>
<!--             <td>
                <button class="comment_button action">例)修正依頼承認</button>
            </td> -->
        </tr>


        <tr>
            <td>例)03/03(木)</td>
            <td>例)9:00</td>
            <td>例)18:00</td>
            <td>例)12:00</td>
            <td>例)13:00</td>
            <td>例)8h</td>
            <td>例)0h</td>
            <td>
                <button onclick="pushed_Attendance()" class="js-modal-open register_button"  data-target="daywork_modal01">打刻修正</button>
            </td>
<!--             <td>
                <button class="comment_button action"></button>
            </td> -->
        </tr>


        <tr>
            <td>例)03/04(金)</td>
            <td>例)9:00</td>
            <td>例)19:00</td>
            <td>例)12:00</td>
            <td>例)13:00</td>
            <td>例)8h</td>
            <td>例)1h</td>
            <td>
                <button onclick="pushed_Attendance()" class="js-modal-open register_button"  data-target="daywork_modal01">打刻修正</button>
            </td>
<!--             <td>
                <button class="comment_button action">例)ここには管理者から</button>
            </td> -->
        </tr>


        <tr>
            <td>例)03/05(土)</td>
            <td>例)9:00</td>
            <td>例)17:00</td>
            <td>例)12:00</td>
            <td>例)13:00</td>
            <td>例)7h</td>
            <td>例)0h</td>
            <td>
                <button onclick="pushed_Attendance()" class="js-modal-open register_button"  data-target="daywork_modal01">打刻修正</button>
            </td>
<!--             <td>
                <button class="comment_button action">修正依頼の返信が入ります</button>
            </td> -->
        </tr>


    </tbody>
</table>




<!-- ここから下で非表示にしてあるモーダル内の表示を実装 -->

    <div id="daywork_modal01" class="modal js-modal">
        <div class="modal__bg js-modal-close"></div>
        <div class="modal__content">
<!-- <p>daywork内1つ目モーダルウィンドウです。ここにモーダルウィンドウで表示したいコンテンツを入れます。モーダルウィンドウを閉じる場合は下の「閉じる」をクリックするか、背景の黒い部分をクリックしても閉じることができます。</p> -->
<!-- 1つ目のモーダル内には打刻修正の画面が入ります -->

<!-- 修正時間をFixServletに送るためのform -->
<!-- <form action="/azps_kintai/MainServlet" method="post"> -->
<!-- テスト用form -->
  <form action="main.jsp" method="get">
<!-- テスト結果は以下の通りなので、きちんとform情報が送れている -->
<!-- http://localhost:8080/azps_kintai/main.jsp?
birthday=2022-03-23&inTimeStart=1000&outTimeEnd=1000&overTimeHours=00&breakInStart=1000&breakOutEnd=1000&fixComment=000&fixValue= -->



				<h2><b>＜ 打刻修正 ＞</b></h2>
			<table class="contact-table">


			<tr>
			<th class="contact-item">
			<label>出勤日時</label>
			</th>

			<td class="contact-body">
				<input class="res_timepicker form-text"  type="text" name="inTimeStart" autocomplete="off" placeholder="2022/01/01 09:00(過去一ヶ月から本日まで選択可能)"  >
			</td>
			</tr>


			<tr>
			<th class="contact-item">
			<label>退勤日時</label>
			</th>

			<td class="contact-body">
				<input class="res_timepicker form-text"  type="text"   name="outTimeEnd" autocomplete="off" placeholder="2022/01/01 17:00(過去一ヶ月から本日まで選択可能)"  >
			</td>
			</tr>



			<tr>
			<th class="contact-item">
			<label>残業時間</label>
			</th>

			<td class="contact-body">
				<input class="form-text hour_timepicker"  type="text" name="overTimeHours" maxlength="2" size="52" autocomplete="off"
				pattern="[0-9]{1,2}" placeholder="00:00(数字のみ、最大12時間まで選択可能)" autocomplete="off">
			</td>

			</tr>


			<tr>
			<th class="contact-item">
			<label>休憩入り日時</label>
			</th>

			<td class="contact-body">
				<input class="res_timepicker form-text"  type="text" name="breakInStart" autocomplete="off" placeholder="2022/01/01 12:00(過去一ヶ月から本日まで選択可能)" size="52" >
			</td>

			</tr>


			<tr>
			<th class="contact-item">
			<label>休憩戻り日時</label>
			</th>

			<td class="contact-body">
				<input class="res_timepicker form-text"  type="text"   name="breakOutEnd" autocomplete="off"  placeholder="2022/01/01 13:00(過去一ヶ月から本日まで選択可能)" size="52" >
			</td>

			</tr>


    	<tr>
			<th class="contact-item"><span class="Form-Item-Label-Required text_right">*必須</span>
			<label>コメント</label>
			</th>

			<td class="contact-body">
		<b>
		<textarea class="form-text"  name="fixComment" placeholder="修正時のコメントを入力して下さい。(必須：100文字まで)
		例)出勤を押し忘れたので、出勤時間のみ打刻修正しました。"
		cols="100" rows="7" title="修正時のコメントを入力" required></textarea>
		<br></b>
        </td>
        </tr>

		</table>

<!-- 修正申請ボタン -->

<!--hidden属性でinput情報を name="fixValue"でサーブレット側に渡す -->
<input type="hidden" name="fixValue" value="" ><br><br>
<!-- モーダル関連を読み込むとsubmit属性(リクワイアードチェック)が機能しないので外しておく。 -->
<input class="register_button " type="submit" value="打刻修正を行う" ><br><br>
<!-- サブミット後自動実行してモーダルウィンドウ開いてほしい(願望) -->
<!-- <p onclick="pushed_Attendance()" class="js-modal-open register_button"  data-target="daywork_modal01">あああ</p> -->

	</form>

            <button class="js-modal-close" >閉じる</button>
        </div><!--modal__inner-->
    </div><!--modal-->

    <div id="daywork_modal02" class="modal js-modal">
        <div class="modal__bg js-modal-close"></div>
        <div class="modal__content">
<!-- <p>daywork内2つ目モーダルウィンドウです。ここにモーダルウィンドウで表示したいコンテンツを入れます。モーダルウィンドウを閉じる場合は下の「閉じる」をクリックするか、背景の黒い部分をクリックしても閉じることができます。</p> -->
<!-- 2つ目のモーダル内には打刻修正の画面が入ります -->

		        <h1>修正申請完了しました</h1>
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



<!-- ここまでレスポンシブテーブル処理 -->

<!-- ToDO
あとでModel読み込んで日付など値を入れる
日付切り替え機能
メイン画面へ遷移・月間集計へ遷移はheader側で対応

画面遷移図の▽マークのところは、先月の日間集計など月ごとに切り替えるためのボタン。

プレースホルダー側で労働時間や今日の日付などを関数指定できると良いな。
-->


<!-- スクリプト読み込み -->
<!-- 打刻修正申請押下後モーダルウィンドウ用jsを読み込み -->
<script type="text/javascript" src="js/modalWindow.js"></script>

<!-- レスポンシブテーブルjsを読み込み -->
<script type="text/javascript" src="js/responsiveTables.js"></script>

<!-- 時間選択.jsを読み込み 導入がやや複雑なためwebから。そのため少しカクつく -->
<!-- jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-datetimepicker@2.5.20/build/jquery.datetimepicker.full.min.js"></script>

<!-- ローカルに保存したデートタイムピッカー。パスが違うっぽい？ -->
<!-- <script type="text/javascript" src="datetimepicker-master/build/jquery.datetimepicker.full.min.js"></script> -->
<!-- <script type="text/javascript" src="datetimepicker-master/build/jquery.datetimepicker.full.js"></script> -->


<script>
/*日本語化*/
$.datetimepicker.setLocale('ja');

/*全部入り(ただし重い)時間修正用表示*/
$('.res_timepicker').datetimepicker({
	step:1,                /*1分単位で表示*/
	minDate:'-1970/01/31',  /*一ヶ月前まで日付入力可能*/
	maxDate:'+1970/01/01',  /*今日分まで日付入力可能*/
	defaultTime:'09:00',     /*デフォルトで選ばれている時間*/
//	theme:'dark' //ダークモード。
});

/*年月日のみ修正用表示*/
$('.day_timepicker').datetimepicker({
	timepicker:false ,       /*時間機能をオフ*/
	minDate:'-1970/01/31',  /*一ヶ月前まで日付入力可能*/
	maxDate:'+1970/01/01',  /*今日分まで日付入力可能*/
//	theme:'dark' //ダークモード。
});

/*時間のみ修正用表示*/
$('.time_timepicker').datetimepicker({
	datepicker:false ,       /*日付機能をオフ*/
	step:1,                /*1分単位で表示*/
	defaultTime:'09:00',     /*デフォルトで選ばれている時間*/
//	theme:'dark' //ダークモード。
});

/*残業時間用表示その2*/
$('.hour_timepicker').datetimepicker({
	step:5,                   /*残業時間は5分刻みで取得*/
	datepicker:false ,       /*日付機能をオフ*/
	format:'H:i',            /*出力フォーマットを時間：分のみに変更*/
//	format:'H',            /*出力フォーマットを時間のみに変更*/
	defaultTime:'00:00',     /*デフォルトで選ばれている時間*/
	maxTime:'12:01'          /*最大で選べる時間*/
});

</script>

</body>

</html>