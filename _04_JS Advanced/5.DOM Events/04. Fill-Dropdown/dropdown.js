function addItem() {
    let itemText = document.querySelector('#newItemText');
    let itemValue = document.querySelector('#newItemValue');

    let option = document.createElement('option');
    option.textContent = itemText.value;
    option.value = itemValue.value;

    let menu = document.querySelector('#menu');
    menu.appendChild(option);

    itemText.value = "";
    itemValue.value = "";
}