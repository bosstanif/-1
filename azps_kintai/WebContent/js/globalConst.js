/*
自作
 決まった定数：コンストラクターの変数
 */

/*グローバル変数。フィールドみたいなもの */

//const fix_submit = 'fix_false'; /*打刻修正時の変数フラグ。モーダル呼び出し用 */

//const fix_submit = 'fix_true'; /*打刻修正時の変数フラグ。モーダル呼び出し用 */
//console.log(fix_submit); /*動作チェック用。コンソールに変数名を表示 */


/*ローカル変数 メソッドみたいなもの*/

/*function js_modal_open(){

if(fix_submit == "fix_true"){

	}
}*/



/*テストメソッド */
const button = document.querySelector('button');

button.onclick = function() {
  let name = prompt('あなたの名前は何ですか？');
  alert('こんにちは、' + name + 'さん、初めまして！');
}
/*テスト2 */
/*これはちゃんと機能する*/
/*const textbox = document.getElementById("message");

const value = textbox.value
button.onclick = function() {
  let name = prompt('あなたの名前は何ですか？');
  alert('こんにちは、' + name + 'さん、初めまして！');
}*/


/*練習 */
var hoge = "a"; // グローバル変数

btn.onclick = () => {

  var hoge = "b"; // ローカル変数
  console.log(hoge); // b

}


var hoge = "a"; //グローバル変数

btn.onclick = function(){
	  var hoge = "cat"; // ローカル変数
  console.log(hoge); // a
 alert(hoge);

}
