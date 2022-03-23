<!-- 最終更新日時0323 -->
<!-- 作成者井川-->
<!-- 勤怠記録画面(日間集計) -->
<!-- 動的インクルードで読み込むことで画面遷移情報削減化 -->

<!--jspテンプレ-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--各種modelの読み込み欄 複数指定時,カンマ忘れないように。-->


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
                <button onclick="pushed_Attendance()" class="js-modal-open register_button"  data-target="modal05">打刻修正</button>
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
                <button onclick="pushed_Attendance()" class="js-modal-open register_button"  data-target="modal05">打刻修正</button>
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
                <button onclick="pushed_Attendance()" class="js-modal-open register_button"  data-target="modal05">打刻修正</button>
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
                <button onclick="pushed_Attendance()" class="js-modal-open register_button"  data-target="modal05">打刻修正</button>
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
                <button onclick="pushed_Attendance()" class="js-modal-open register_button"  data-target="modal05">打刻修正</button>
            </td>
<!--             <td>
                <button class="comment_button action">修正依頼の返信が入ります</button>
            </td> -->
        </tr>


    </tbody>
</table>

<!-- ここにmodalのアンカータグやボタンを置く -->
    <div onload="pushed_Attendance()" class="content buttons">
	<ul>
		<li>
		<!-- クリックでモーダル1を表示 -->
        <button onclick="pushed_Attendance()" class="js-modal-open"  data-target="modal01">打刻修正</button><br>
		</li>

		<li>
		<!-- クリックでモーダル2を表示 -->
        <button onclick="pushed_Attendance()" class="js-modal-open"  data-target="modal02">退勤</button><br>
		</li>

    </ul>
    </div>

    <!-- ここで2行目に切り替える -->

    <div onload="pushed_Attendance()" class="content buttons">
	<ul>
		<li>
        <!-- クリックでモーダル3を表示 -->
        <button onclick="pushed_Attendance()" class="js-modal-open"  data-target="modal03">休憩 入</button><br>
		</li>

		<li>
		<!-- クリックでモーダル4を表示 -->
        <button onclick="pushed_Attendance()" class="js-modal-open"  data-target="modal04">休憩 戻</button><br>
		</li>

    </ul>
    </div>


<!-- ここから下で非表示にしてあるモーダル内の表示を実装 -->

    <div id="modal05" class="modal js-modal">
        <div class="modal__bg js-modal-close"></div>
        <div class="modal__content">
<!-- <p>main内と通算して5つ目モーダルウィンドウです。ここにモーダルウィンドウで表示したいコンテンツを入れます。モーダルウィンドウを閉じる場合は下の「閉じる」をクリックするか、背景の黒い部分をクリックしても閉じることができます。</p> -->
<!-- 5つ目のモーダル内には打刻修正の画面が入ります -->

<!-- 修正時間をFixServletに送るためのform -->
<form action="/azps_kintai/FixServlet" method="post">
<!-- テスト用form -->
<!-- 		  <form action="main.jsp" method="get"> -->
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

<!-- 修正申請ボタン -->
	<div class="text_center">

<button onclick="pushed_Attendance()" class="js-modal-open register_button"  data-target="modal06">打刻修正を行う</button>

<!--hidden属性でinput情報を name="fixValue"でサーブレット側に渡す -->
<input type="hidden" name="fixValue" value="" ><br><br>
<!-- モーダル関連を読み込むとsubmit属性(リクワイアードチェック)が機能しないので外しておく。 -->
<input class="register_button " type="submit" value="打刻修正を行う" ><br><br>
<!-- サブミット後自動実行してモーダルウィンドウ開いてほしい(願望) -->
<p onclick="pushed_Attendance()" class="js-modal-open register_button"  data-target="modal06"></p>
	</div>

	</form>

            <button class="js-modal-close" >閉じる</button>
        </div><!--modal__inner-->
    </div><!--modal-->

    <div id="modal06" class="modal js-modal">
        <div class="modal__bg js-modal-close"></div>
        <div class="modal__content">
<!-- <p>main内と通算して6つ目モーダルウィンドウです。ここにモーダルウィンドウで表示したいコンテンツを入れます。モーダルウィンドウを閉じる場合は下の「閉じる」をクリックするか、背景の黒い部分をクリックしても閉じることができます。</p> -->
<!-- 6つ目のモーダル内には打刻修正の画面が入ります -->

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

    <div id="modal03" class="modal js-modal">
        <div class="modal__bg js-modal-close"></div>
        <div class="modal__content">
<!--             <p>3つ目モーダルウィンドウです。ここにモーダルウィンドウで表示したいコンテンツを入れます。モーダルウィンドウを閉じる場合は下の「閉じる」をクリックするか、背景の黒い部分をクリックしても閉じることができます。</p> -->

		        <h1 >休憩に入りました</h1>
				<p>お疲れ様です。ゆっくり休息をとってください。</p>
 				<p id="brealinDate1">Now Loading...</p>
				<p id="breakinDate2">Now Loading...</p>
<!-- 				↓出勤Servlet用の時刻が送れているかテスト。あとでコメントアウトする -->
				<p id="attendanceBreakinValueInputtest">test Loading...</p>
<!-- 				↓現在日時をvalueに入れてhidden属性でServlet側へ送る。動作未検証 -->
			<input id="attendanceBreakinValueInput" type="hidden" name="outtimeValue" value="">

            <button class="js-modal-close" >閉じる</button>
        </div><!--modal__inner-->
    </div><!--modal-->

    <div id="modal04" class="modal js-modal">
        <div class="modal__bg js-modal-close"></div>
        <div class="modal__content">
<!--             <p>4つ目モーダルウィンドウです。ここにモーダルウィンドウで表示したいコンテンツを入れます。モーダルウィンドウを閉じる場合は下の「閉じる」をクリックするか、背景の黒い部分をクリックしても閉じることができます。</p> -->

		        <h1 >休憩から復帰しました</h1>
				<p>お疲れ様です。引き続き頑張りましょう！</p>
 				<p id="breakoutDate1">Now Loading...</p>
				<p id="breakoutDate2">Now Loading...</p>
<!-- 				↓出勤Servlet用の時刻が送れているかテスト。あとでコメントアウトする -->
				<p id="attendanceBreakoutValueInputtest">test Loading...</p>
<!-- 				↓現在日時をvalueに入れてhidden属性でServlet側へ送る。動作未検証 -->
			<input id="attendanceBreakoutValueInput" type="hidden" name="outtimeValue" value="">

            <button class="js-modal-close" >閉じる</button>
        </div><!--modal__inner-->+
    </div><!--modal-->
</form>


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


</body>

</html>