<!-- 最終更新日時0322 -->
<!-- 作成者井川-->
<!-- 勤怠記録画面(月間集計) -->

<!--jspテンプレ-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--各種modelの読み込み欄 複数指定時,カンマ忘れないように。-->


<!DOCTYPE html>
<html lang="ja">

<!-- ここから下はヘッド。表示されない情報の部分のみ書く -->
<head>
<meta charset="UTF-8">
<title>月間勤怠記録表</title>

<!-- CSS読み込み-->
<!--リセットcssの読み込み。！一部表示が崩れる場合を除き必須！ -->
<link rel="stylesheet" href="css/ress.css">

<!--google fontsの指定-->
<link href="https:fonts.googleapis.com/css?family=Philosopher" rel="stylesheet">

<!--ファビコンの読み込み。これをjsp毎のtitleタグの下に置く。-->
<link rel="icon" type="image/png" href="images/favicon-16x16.png">

<!-- 全ページで共通デザイン部分のstyle.cssの読み込み -->
<link rel="stylesheet" href="css/style.css">

<!-- モーダルウィンドウ.cssの読み込み -->
<link rel="stylesheet" href="css/timecard.css">

<!-- レスポンシブデザインテーブル.cssの読み込み -->
<link rel="stylesheet" href="css/responsiveTables.css">

</head>

<body class="text_center" >
<!-- 全体を中央ぞろえにしたくない場合は↑のclass="text_center"を消してください-->
<!-- ここから下はボディ。そのページ独自の内容のみ書く。 -->


<!-- ここの下から実際にページ内容を書き始める。 -->

<h1>例)名無しさんの勤怠記録表：月毎集計</h1>


<!-- ここからレスポンシブテーブル処理 -->


<table class="dataTable">
    <thead>
        <tr>
            <th>総労働時間</th>
            <th>総残業時間</th>
            <th>実労働日数</th>
        </tr>
    </thead>
    <tbody>


        <tr>
            <td>例)115:00</td>
            <td>例)0:00</td>
            <td>例)15日</td>
        </tr>

    </tbody>
</table>

<!-- ここまでレスポンシブテーブル処理 -->

<!-- ToDO
あとでModel読み込んで日付など値を入れる
日付切り替え機能
メイン画面へ遷移・月間集計へ遷移はheader側で対応

画面遷移図の▽マークのところは、先月の日間集計など月ごとに切り替えるためのボタン。
月間勤怠記録表からは打刻修正申請はできないようにする。（加茂さんに確認済み）
日毎集計への遷移ボタンが画面遷移図にないのでそこは新たにheader側で作る。

-->

<!-- スクリプト読み込み -->
<!-- 打刻修正申請押下後モーダルウィンドウ用jsを読み込み -->
<script type="text/javascript" src="js/modalWindow.js"></script>

<!-- レスポンシブテーブルjsを読み込み -->
<script type="text/javascript" src="js/responsiveTables.js"></script>


</body>

</html>