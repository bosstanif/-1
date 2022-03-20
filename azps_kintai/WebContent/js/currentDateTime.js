function set2fig(num) {
    // 桁数が1桁だったら先頭に0を加えて2桁に調整する
    var ret = num;
    if( num < 10 ) { ret = "0" + num; }
    return ret;
}

function showClock3() {
	var nowdate = new Date(); //変数nowdateインスタンスを生成
	var year = nowdate.getFullYear();     // 年(4桁の西暦)
	var mon  = nowdate.getMonth() + 1;    // 月(1～12)
	var date = nowdate.getDate();         // 日(1～31)

	var week = nowdate.getDay();          // 曜日(※0～6)
	var weekchars = new Array( "日", "月", "火", "水", "木", "金", "土" );
	var todayweek = weekchars[ week ];   // 曜日を文字列で得る

	var nowTime = new Date(); //変数nowTimeインスタンスを生成
	var nowHour = nowTime.getHours(); //時(0～59)
	var nowMin  = nowTime.getMinutes(); //分(0～59)
	var nowSec  = nowTime.getSeconds(); //秒(0～59)
//	var nowmsec = nowdate.getMilliseconds(); // ミリ秒(0～999) //今回は格納や表示の必要性がないのでミリ秒はオミット

	var msg = set2fig(nowHour) + ":" + set2fig(nowMin) + ":" + set2fig(nowSec);
	document.getElementById("RealtimeClockArea3").innerHTML = msg;/*HTML側で"RealtimeClockArea3"指定した時に代入できるよ */


	var msgDate = year + "年" + mon + "月" + date + "日" + "(" + todayweek + ")" ;
	document.getElementById("RealtimeDate1").innerHTML = msgDate;

}

setInterval('showClock3()',1000);//1000ミリ秒（1秒）ごとに値を取得