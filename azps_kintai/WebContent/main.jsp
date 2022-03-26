<!-- 最終更新日時0325 -->
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


<!-- 機能ごとにjspを作りインクルードで読み込むほうがデバッグが簡単 -->>
<!-- 時計、及び出退勤ボタンの読み込み部分 -->
<!-- 動的または静的インクルードの選択
	 動的：サーブレット読み込み可、モデル読み込み不可。ｲﾝｸﾙ先の<実行結果>を取り込む
	 静的：モデルとその変数名の読み込み可、サーブレット読み込み不可。ｲﾝｸﾙ先の内容を<実行して読み出す>。 -->
<%-- <jsp:include page="/WEB-INF/jsp/attendance.jsp" /> --%>
<%@ include file="/WEB-INF/jsp/attendance.jsp" %>


<!-- 日間勤怠集計読み込み部分 -->
<!-- 動的または静的インクルードの選択
	 動的：サーブレット読み込み可、モデル読み込み不可。ｲﾝｸﾙ先の<実行結果>を取り込む
	 静的：モデルとその変数名の読み込み可、サーブレット読み込み不可。ｲﾝｸﾙ先の内容を<実行して読み出す>。 -->
<%-- <jsp:include page="/WEB-INF/jsp/daywork_result.jsp" /> --%>
<%@ include file="/WEB-INF/jsp/daywork_result.jsp" %>


<!-- 月間勤怠集計読み込み部分 -->
<!-- 動的または静的インクルードの選択
	 動的：サーブレット読み込み可、モデル読み込み不可。ｲﾝｸﾙ先の<実行結果>を取り込む
	 静的：モデルとその変数名の読み込み可、サーブレット読み込み不可。ｲﾝｸﾙ先の内容を<実行して読み出す>。 -->
<%-- <jsp:include page="/WEB-INF/jsp/monthwork_result.jsp" /> --%>
 <%@ include file="/WEB-INF/jsp/monthwork_result.jsp" %>



<!-- フッターラッパー-の閉じdiv -->
</div>
<!-- フッターインクルードの読み込み -->
<!-- 動的または静的インクルードの選択
	 動的：サーブレット読み込み可、モデル読み込み不可。ｲﾝｸﾙ先の<実行結果>を取り込む
	 静的：モデルとその変数名の読み込み可、サーブレット読み込み不可。ｲﾝｸﾙ先の内容を<実行して読み出す>。 -->
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
<%--<%@ include file="/WEB-INF/jsp/footer.jsp" %> --%>


<!-- スクリプト読み込み -->

<!-- 時刻表示用jsを読み込み -->
 <script type="text/javascript" src="js/currentDateTime.js"></script>

<!-- タイムカード押下後ダイアログ処理用jsを読み込み -->
 <script type="text/javascript" src="js/modalWindow.js"></script>


</body>

</html>