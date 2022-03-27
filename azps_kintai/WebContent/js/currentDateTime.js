function set2fig(num) {
    // 桁数が1桁だったら先頭に0を加えて2桁に調整する
    let ret = num;
    if( num < 10 ) { ret = "0" + num; }
    return ret;
}

/*本来サーバー時間を取ってくるべきだが今回はローカルPCの時間で実装 */
function showClock3() {
	let nowdate = new Date(); //変数nowdateインスタンスを生成
	let year = nowdate.getFullYear();     // 年(4桁の西暦)
	let mon  = nowdate.getMonth() + 1;    // 月(1～12)
	let date = nowdate.getDate();         // 日(1～31)

	let week = nowdate.getDay();          // 曜日(※0～6)
	let weekchars = new Array( "日", "月", "火", "水", "木", "金", "土" );
	let todayweek = weekchars[ week ];   // 曜日を文字列で得る

	let nowTime = new Date(); //変数nowTimeインスタンスを生成
	let nowHour = nowTime.getHours(); //時(0～59)
	let nowMin  = nowTime.getMinutes(); //分(0～59)
	let nowSec  = nowTime.getSeconds(); //秒(0～59)
//	let nowmsec = nowdate.getMilliseconds(); // ミリ秒(0～999) //今回は格納や表示の必要性がないのでミリ秒はオミット

//こちらが日付
	let msgDate = year + "年" + mon + "月" + date + "日" + "(" + todayweek + ")" ;
	document.getElementById("RealtimeDate1").innerHTML = msgDate;

//こちらが時間
	let msg = set2fig(nowHour) + ":" + set2fig(nowMin) + ":" + set2fig(nowSec);
	document.getElementById("RealtimeClockArea3").innerHTML = msg;/*HTML側で"RealtimeClockArea3"指定した時に代入できるよ */

//テスト用↓
//	document.getElementById("RealtimeClockArea4").innerHTML = msg;/*HTML側で"RealtimeClockArea3"指定した時に代入できるよ */

}
setTimeout('showClock3()',0);//0ミリ秒（0秒）目の値を1度だけ取得これによりLoadingが一瞬しか表示されなくなる。
setInterval('showClock3()',1000);//1000ミリ秒（1秒）ごとに値を取得

/*出勤ボタンを押した */
function pushed_Attendance() {
	let pushed_now = new Date(); //変数pushed_dateインスタンスを生成
	let pushed_year = pushed_now.getFullYear();     // 年(4桁の西暦)
	let pushed_mon  = pushed_now.getMonth() + 1;    // 月(1～12)
	let pushed_day = pushed_now.getDate();         // 日(1～31)

	let pushed_week = pushed_now.getDay();          // 曜日(※0～6)
	let pushed_weekchars = new Array( "日", "月", "火", "水", "木", "金", "土" );
	let pushed_todayweek = pushed_weekchars[ pushed_week ];   // 曜日を文字列で得る

	let pushed_nowTime = new Date(); //変数pushed_Timeインスタンスを生成
	let pushed_Hour = pushed_nowTime.getHours(); //時(0～59)
	let pushed_Min  = pushed_nowTime.getMinutes(); //分(0～59)
	let pushed_Sec  = pushed_nowTime.getSeconds(); //秒(0～59)
	let pushed_msec = pushed_nowTime.getMilliseconds(); // ミリ秒(0～999) //今回は格納や表示の必要性がないのでミリ秒はオミット。



/*出勤ボタンを押したときのメッセージ処理 */
	let msgDatePushed = pushed_year + "年" + pushed_mon + "月" + pushed_day + "日" + "(" + pushed_todayweek + ")" ;
	document.getElementById("intimeDate1").innerHTML = msgDatePushed;
	let msgTimePushed = set2fig(pushed_Hour) + ":" + set2fig(pushed_Min) + ":" + set2fig(pushed_Sec);
	document.getElementById("intimeDate2").textContent = msgTimePushed;

/*退勤ボタンを押したときのメッセージ処理 */
	document.getElementById("outtimeDate1").innerHTML = msgDatePushed;
	document.getElementById("outtimeDate2").textContent = msgTimePushed;

/*休憩入ボタンを押したときのメッセージ処理 */
	document.getElementById("brealinDate1").innerHTML = msgDatePushed;
	document.getElementById("breakinDate2").textContent = msgTimePushed;

/*休憩戻ボタンを押したときのメッセージ処理 */
	document.getElementById("breakoutDate1").innerHTML = msgDatePushed;
	document.getElementById("breakoutDate2").textContent = msgTimePushed;

/*	'1000-01-01 00:00:00.000000',*/

/*	Servlet側にdatetime型で渡す値を設定。曜日情報は今回はDBに定義していないので持たせない*/
/*出勤時のデータServletへ */
/*現状、getメソッドでテスト送信した際に、" "が"+"、":"が"%3A"と16進数にデコードされてURLバーに表記されてしまうので
その値がサーブレット側でUTF-8形式にエンコード変換されてきちんともとの形式で表示されるかがわからない
 うまくいかないようなら、2022-03-23-04-07-41.604のように-で処理するか、サーブレット側で変換が必要。
 */
	let msgAttendancePushed = pushed_year + "-" + set2fig(pushed_mon) + "-" + set2fig(pushed_day) + " " +  set2fig(pushed_Hour) + ":" + set2fig(pushed_Min) + ":" + set2fig(pushed_Sec) + "." + pushed_msec;
	document.getElementById("attendanceIntimeValueInput").value = msgAttendancePushed;
	/*テスト用 */
	document.getElementById("attendanceIntimeValueInputtest").textContent = msgAttendancePushed;

/*退勤時のデータServletへ */
	document.getElementById("attendanceOuttimeValueInput").value = msgAttendancePushed;
	/*テスト用 */
	document.getElementById("attendanceOuttimeValueInputtest").textContent = msgAttendancePushed;

/*休憩入り時のデータServletへ */
	document.getElementById("attendanceBreakinValueInput").value = msgAttendancePushed;
	/*テスト用 */
	document.getElementById("attendanceBreakinValueInputtest").textContent = msgAttendancePushed;

/*休憩戻り時のデータServletへ */
	document.getElementById("attendanceBreakoutValueInput").value = msgAttendancePushed;
	/*テスト用 */
	document.getElementById("attendanceBreakoutValueInputtest").textContent = msgAttendancePushed;

}

setTimeout('showClock4()',0);//0ミリ秒（0秒）目の値を1度だけ取得

