/*jquery使用、複数modal版*/

$(function(){
    $('.js-modal-open').each(function(){
        $(this).on('click',function(){
            var target = $(this).data('target');
            var modal = document.getElementById(target);
            $(modal).fadeIn(200);/*0.2秒かけてフェードイン */
            return false;
        });
    });

    $('.js-modal-submit-open').each(function(){
        $(this).on('submit',function(){
            var target = $(this).data('target');
            var modal = document.getElementById(target);
            $(modal).fadeIn(200);/*0.2秒かけてフェードイン */
            return false;
        });
    });

    $('.js-modal-close').on('click',function(){
        $('.js-modal').fadeOut(50);/*0.05秒でフェードアウト */
        return false;
    });
});


/*こちらは指定の条件の時にポップアップされるほうの広告型モーダル*/
window.onload = function() {
  var popup = document.getElementById('js-popup');
  if(!popup) return;
  popup.classList.add('is-show');

  var blackBg = document.getElementById('js-black-bg');
  var closeBtn = document.getElementById('js-close-btn');

  closePopUp(blackBg);
  closePopUp(closeBtn);

  function closePopUp(elem) {
    if(!elem) return;
    elem.addEventListener('click', function() {
      popup.classList.remove('is-show');
    })
  }
}


/*ここまで */

/*この下はjquery無し版 */

/* Id1つ目（出勤ボタン用）*/

const buttonOpen = document.getElementById('modalOpen');
const modal = document.getElementById('easyModal');
const buttonClose = document.getElementsByClassName('modalClose')[0];

//ボタンがクリックされた時
buttonOpen.addEventListener('click', modalOpen);
function modalOpen() {
	modal.style.display = 'block';
};

//バツ印がクリックされた時
buttonClose.addEventListener('click', modalClose);
function modalClose() {
	modal.style.display = 'none';
};

//モーダルコンテンツ以外がクリックされた時
addEventListener('click', outsideClose);
function outsideClose(e) {
	if (e.target == modal) {
	modal.style.display = 'none';
	};
};

