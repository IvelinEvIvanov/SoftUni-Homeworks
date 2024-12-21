window.addEventListener('load', solution);

function solution() {
  document.querySelector('#submitBTN').addEventListener('click', btnSubmitHandler);
  document.querySelector('#editBTN').addEventListener('click', btnEditHandler);
  document.querySelector('#continueBTN').addEventListener('click', btnContinueHandler);

  let btnEdit = document.querySelector('#editBTN');
  let btnContinue = document.querySelector('#continueBTN');
  let btnSubmit = document.querySelector('#submitBTN');

  let ulInfoPreview = document.querySelector('#infoPreview');

  let fullName = '';
  let email = '';
  let phone = '';
  let address = '';
  let postalCode = '';

  /**
   * 
   * @param {Event} e 
   */
  function btnSubmitHandler(e) {
    e.preventDefault();

    fullName = document.querySelector('#fname');
    email = document.querySelector('#email');
    phone = document.querySelector('#phone');
    address = document.querySelector('#address');
    postalCode = document.querySelector('#code');

    if (fullName.value !== '' && email.value !== '') {
      let li = document.createElement('li');
      li.textContent = `Full Name: ${fullName.value}`;
      ulInfoPreview.appendChild(li);

      li = document.createElement('li');
      li.textContent = `Email: ${email.value}`
      ulInfoPreview.appendChild(li);

      li = document.createElement('li');
      li.textContent = `Phone Number: ${phone.value}`;
      ulInfoPreview.appendChild(li);

      li = document.createElement('li');
      li.textContent = `Address: ${address.value}`;
      ulInfoPreview.appendChild(li);

      li = document.createElement('li');
      li.textContent = `Postal Code: ${postalCode.value}`;
      ulInfoPreview.appendChild(li);
    }

    fullName.value = '';
    email.value = '';
    phone.value = '';
    address.value = '';
    postalCode.value = '';

    e.target.disabled = true;
    btnEdit.disabled = false;
    btnContinue.disabled = false;
  }

  function btnEditHandler(e) {
    let ulLis = ulInfoPreview.children;
    let arrLis = [];
    for (let index = 0; index < ulLis.length; index++) {
      arrLis.push(ulLis[index].textContent.split(': ')[1].trim());
    }

    while (ulInfoPreview.firstChild) {
      ulInfoPreview.removeChild(ulInfoPreview.firstChild);
    }

    fullName.value = arrLis[0];
    email.value = arrLis[1];
    phone.value = arrLis[2];
    address.value = arrLis[3];
    postalCode.value = arrLis[4];

    e.target.disabled = true;
    btnContinue.disabled = true;
    btnSubmit.disabled = false;

  }

  function btnContinueHandler(e) {
    let block = document.querySelector('#block');

    while (block.firstChild) {
      block.firstChild.remove();
    }

    let h3 = document.createElement('h3');
    h3.textContent = 'Thank you for your reservation!';
    block.appendChild(h3);

  }
}
