/**
 *
 */
const accSingle = document.querySelector('.js-acc-single');
const items     = accSingle.querySelectorAll('.js-acc-item');
const accSingleTriggers = accSingle.querySelectorAll('.js-acc-single-trigger');

// 最初の要素を開いておく
const firstChild = accSingle.firstElementChild;
firstChild.classList.add('is-open');

accSingleTriggers.forEach(trigger => trigger.addEventListener('click', toggleAccordion));

function toggleAccordion() {
  const thisItem = this.parentNode;

  items.forEach(item => {
    if (thisItem == item) {
      thisItem.classList.toggle('is-open');
      return;
    }
    item.classList.remove('is-open');
  });
}