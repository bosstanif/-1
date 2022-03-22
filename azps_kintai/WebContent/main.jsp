<!-- 最終更新日時0323 -->
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

<!-- timcard.cssの読み込み -->
<link rel="stylesheet" href="css/timecard.css">

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


<!-- 青背景で囲む -->
<div class="date-time">

<!-- デジタル時計表示部分 -->
<p class="nowdate" id="RealtimeDate1">Now Loading...</p>

<p class="nowtime" id="RealtimeClockArea3">Now Loading...</p>

</div>

<!-- ここにmodalのアンカータグやボタンを置く -->
    <div onload="pushed_Attendance()" class="content buttons">
	<ul>
		<li>
<form action="/azps_kintai/MainServlet" method="post">
<!-- 送信テスト用のフォームタグ -->
<!--   <form action="main.jsp" method="get"> -->


<!-- 				↓現在日時をvalueに入れてhidden属性でServlet側へ送る。動作未検証 -->
			<input id="attendanceIntimeValueInput" type="hidden" name="intimeValue" value="">
		<!-- クリックでモーダル1を表示 -->
        <button onclick="pushed_Attendance()"  type="submit" data-target="modal01">出勤</button><br>
<!--         <button onclick="pushed_Attendance()" class="js-modal-open" type="submit" data-target="modal01">出勤</button><br> -->
</form>
		</li>

		<li>
  <form action="/azps_kintai/MainServlet" method="post">
<!-- 送信テスト用のフォームタグ -->
<!-- <form action="main.jsp" method="get"> -->

<!-- 			<p id="RealtimeClockArea4">test Loading...</p> -->
<!--	↓現在日時をvalueに入れてhidden属性でServlet側へ送る。動作検証済み -->
			<input id="attendanceOuttimeValueInput" type="hidden" name="outtimeValue" value="">
		<!-- クリックでモーダル2を表示 -->
  		<button onclick="pushed_Attendance()"  type="submit"
        data-target="modal02">退勤test</button><br>

<!--         <button onsubmit="pushed_Attendance()" class="js-modal-submit-open" type="submit"
        data-target="modal02" value="test">退勤</button><br> -->
		</form>
		</li>

    </ul>
    </div>

    <!-- ここで2行目に切り替える -->

    <div onload="pushed_Attendance()" class="content buttons">
	<ul>
		<li>
 <form action="/azps_kintai/MainServlet" method="post">
<!-- 送信テスト用のフォームタグ -->
<!--   <form action="main.jsp" method="get"> -->
<!-- 				↓出勤Servlet用の時刻が送れているかテスト。あとでコメントアウトする -->
<!-- 				<p id="attendanceBreakinValueInputtest">test Loading...</p> -->
<!-- 				↓現在日時をvalueに入れてhidden属性でServlet側へ送る。動作未検証 -->
			<input id="attendanceBreakinValueInput" type="hidden" name="breakinValue" value="">

        <!-- クリックでモーダル3を表示 -->
        <button onclick="pushed_Attendance()" data-target="modal03">休憩 入</button><br>
<!--         <button onclick="pushed_Attendance()" class="js-modal-open"  data-target="modal03">休憩 入</button><br> -->


</form>
		</li>

		<li>
 <form action="/azps_kintai/MainServlet" method="post">
<!-- 送信テスト用のフォームタグ -->
<!--   <form action="main.jsp" method="get"> -->
<!-- 				↓出勤Servlet用の時刻が送れているかテスト。あとでコメントアウトする -->
<!-- 				<p id="attendanceBreakoutValueInputtest">test Loading...</p> -->
<!-- 				↓現在日時をvalueに入れてhidden属性でServlet側へ送る。動作未検証 -->
			<input id="attendanceBreakoutValueInput" type="hidden" name="breakoutValue" value="">
		<!-- クリックでモーダル4を表示 -->
        <button onclick="pushed_Attendance()" data-target="modal04">休憩 戻</button><br>
<!--         <button onclick="pushed_Attendance()" class="js-modal-open"  data-target="modal04">休憩 戻</button><br> -->
</form>

		</li>

    </ul>
    </div>


<!-- ここから下でモーダル内の表示を実装 -->
    <div id="modal01" class="modal js-modal">
        <div class="modal__bg js-modal-close"></div>
        <div class="modal__content">
<!--             <p>1つ目モーダルウィンドウです。ここにモーダルウィンドウで表示したいコンテンツを入れます。モーダルウィンドウを閉じる場合は下の「閉じる」をクリックするか、背景の黒い部分をクリックしても閉じることができます。</p> -->

 <!-- <form action="MainServlet" method="post"> -->
<!-- 送信テスト用のフォームタグ -->

		        <h1 >出勤しました</h1>
				<p>おはようございます。今日も一日頑張りましょう！</p>
 				<p id="intimeDate1">Now Loading...</p>
				<p id="intimeDate2">Now Loading...</p>

            <button class="js-modal-close" >閉じる</button>
        </div><!--modal__inner-->
    </div><!--modal-->

    <div id="modal02" class="modal js-modal">
        <div class="modal__bg js-modal-close"></div>
        <div class="modal__content">
<!--             <p>2つ目モーダルウィンドウです。ここにモーダルウィンドウで表示したいコンテンツを入れます。モーダルウィンドウを閉じる場合は下の「閉じる」をクリックするか、背景の黒い部分をクリックしても閉じることができます。</p> -->

		        <h1 >退勤しました</h1>
				<p>本日もお疲れ様でした。帰り道もお気をつけて。</p>
 				<p id="outtimeDate1">Now Loading...</p>
				<p id="outtimeDate2">Now Loading...</p>

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

            <button class="js-modal-close" >閉じる</button>
        </div><!--modal__inner-->+
    </div><!--modal-->

<!-- <div onload="pushed_Attendance()" class="buttons">
<ul> -->

 			<%!
	int intime = 0;
			%>

<!-- <li> -->
<!-- もし出勤状態が1以外なら -->
<% if(intime != 1){ %>


<!-- 出勤ボタンとその後の処理 -->


<!-- postで送る今回は時間が足りないためaction=""内のセキュリティ対策なしで実装する -->

<!-- ↓input内容を指定Servlet側に送る処理 -->
<!-- <form action="MainServlet" method="post"> -->

<!-- 	<button onclick="pushed_Attendance()" class="js-modal-open buttons" data-target="modal03" value="出勤"> 出勤</button>
	<div id="modal01" class="modal js-modal">
		<div class="js-modal-close">
			<div class="modal-header">
 --><!-- ここから下はjava記述 -->
<!-- 出勤状態変数を1に指定 -->
			<%
	intime = 1;
			%>

<!-- 				<h1 >出勤しました</h1>
				<a class="js-modal-close" href="">閉じる</a>
				<span class="js-modal-close">×</span>
			</div>
			<div class="modal-body">
				<p>おはようございます。今日も一日頑張りましょう！</p>
 				<p id="RealtimeDate2">Now Loading...</p>
				<p id="RealtimeDate3">Now Loading...</p>
				↓出勤Servlet用の時刻が送れているかテスト。あとでコメントアウトする
				<p id="attendanceValueInputtest">test Loading...</p>
				↓現在日時をvalueに入れてhidden属性でServlet側へ送る。動作未検証
			<input id="attendanceValueInput" type="hidden" name="pushedIntime" value=""> -->
<!-- 			</div>
		</div>
	</div> -->
<!-- </form> -->

<!-- </li> -->

<% }%>


<!-- もし出勤状態が1なら 出勤以外のボタンも押せる状態に。-->
<% if(intime == 1){ %>
<% }%>


<!-- ここから下は出勤==falseの時の押せない状態の半透明ボタン。 -->


<!-- </ul>
</div> -->


<!-- todolist
取得した時間をhiddenで送信する。　OK
出勤や退勤結果表示はダイアログで済ます　OK
ボタンを押した後、色を変えたい。（薄い色から濃い色、またはその逆）


出勤後は出勤を押せなくしようかと思ったが、前のアプリでは出勤連続して押せたのでなしでいいか。また、休憩入りと休憩戻りは押せるようになる。
休憩入り後は休憩後を～とかもなし。
退勤後は出勤を押せるようにする。
どちらかというと
退勤、休憩入り、休憩戻りは出勤を押してからしか押せないでいいかも。。



-->

<!-- 日間勤怠集計読み込み部分 -->
<!-- 静的または動的インクルードの選択 -->
<%-- <jsp:include page="/WEB-INF/jsp/daywork_result.jsp" /> --%>
<%@ include file="/WEB-INF/jsp/daywork_result.jsp" %>


<!-- 月間勤怠集計読み込み部分 -->
<!-- 静的または動的インクルードの選択 -->
<jsp:include page="/WEB-INF/jsp/monthwork_result.jsp" />
<%-- <%@ include file="/WEB-INF/jsp/monthwork_result.jsp" %> --%>



<!-- フッターラッパー-の閉じdiv -->
</div>
<!-- フッターインクルードの読み込み -->
<!-- 静的または動的インクルードの選択 -->
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
<%--<%@ include file="/WEB-INF/jsp/footer.jsp" %> --%>


<!-- スクリプト読み込み -->

<!-- 時刻表示用jsを読み込み -->
 <script type="text/javascript" src="js/currentDateTime.js"></script>

<!-- タイムカード押下後ダイアログ処理用jsを読み込み -->
 <script type="text/javascript" src="js/modalWindow.js"></script>


</body>

</html>