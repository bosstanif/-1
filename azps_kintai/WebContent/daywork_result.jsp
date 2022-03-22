<!-- 最終更新日時0322 -->
<!-- 作成者井川-->
<!-- 勤怠記録画面(日間集計) -->

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

<!-- レスポンシブデザインテーブル.cssの読み込み -->
<link rel="stylesheet" href="css/responsiveTables.css">

<!-- モーダルウィンドウ.cssの読み込み -->
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

<h1>例)名無しさんの勤怠記録表（日毎集計）</h1>


<!-- ここからレスポンシブテーブル処理 -->


<table class="dataTable">
    <thead>
        <tr>
            <th>日付</th>
            <th>出勤</th>
            <th>退勤</th>
            <th>休憩 入</th>
            <th>休憩 戻</th>
            <th>労働時間</th>
            <th>残業時間</th>
            <th>申請</th>
            <th>コメント</th>
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
                <button class="action register_button">打刻修正申請</button>
            </td>

            <td>
                <button class="comment_button action">例)修正依頼却下</button>
            </td>
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
                <button class="action register_button">打刻修正申請</button>
            </td>
            <td>
                <button class="comment_button action">例)修正依頼承認</button>
            </td>
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
                <button class="action register_button">打刻修正申請</button>
            </td>
            <td>
                <button class="comment_button action"></button>
            </td>
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
                <button class="action register_button">打刻修正申請</button>
            </td>
            <td>
                <button class="comment_button action">例)ここには管理者から</button>
            </td>
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
                <button class="action register_button">打刻修正申請</button>
            </td>
            <td>
                <button class="comment_button action">修正依頼の返信が入ります</button>
            </td>
        </tr>


    </tbody>
</table>

<!-- ここまでレスポンシブテーブル処理 -->

<!-- ToDO
あとでModel読み込んで日付など値を入れる
日付切り替え機能
メイン画面へ遷移・月間集計へ遷移はheader側で対応

画面遷移図の▽マークのところは、先月の日間集計など月ごとに切り替えるためのボタン。

-->

<!-- フッターラッパー-の閉じdiv -->
</div>
<!-- フッターインクルードの読み込み -->
<!-- 静的または動的インクルードの選択 -->
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
<%--<%@ include file="/WEB-INF/jsp/footer.jsp" %> --%>

<!-- スクリプト読み込み -->
<!-- 打刻修正申請押下後モーダルウィンドウ用jsを読み込み -->
<script type="text/javascript" src="js/modalWindow.js"></script>

<!-- レスポンシブテーブルjsを読み込み -->
<script type="text/javascript" src="js/responsiveTables.js"></script>


</body>

</html>