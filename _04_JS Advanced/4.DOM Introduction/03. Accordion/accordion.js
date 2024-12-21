function toggle() {
    let mybutton = document.getElementsByClassName('button')[0];
    let extraId = document.getElementById('extra');

    if (mybutton.textContent === 'More') {
        extraId.style.display = 'block';
        mybutton.textContent = 'Less';
    } else if (mybutton.textContent === 'Less') {
        extraId.style.display = 'none';
        mybutton.textContent = 'More';
    }

}