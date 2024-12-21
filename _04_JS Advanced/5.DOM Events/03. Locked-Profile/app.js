
function lockedProfile() {
    //global variables
    let checkboxes;
    let arrOfHandlers = [];

    //Handlers
    function bntClickedUser1(e) {
        checkboxes = document.querySelectorAll("input[name='user1Locked']");

        solve(checkboxes, e.target,'#user1HiddenFields');

    }

    function bntClickedUser2(e) {
        checkboxes = document.querySelectorAll("input[name='user2Locked']");

        solve(checkboxes, e.target,'#user2HiddenFields');
    }

    function bntClickedUser3(e) {
        checkboxes = document.querySelectorAll("input[name='user3Locked']");

        solve(checkboxes, e.target,'#user3HiddenFields');
    }

    //Functions

    function solve(pCheckboxes, pBtn,user) {

        if (pCheckboxes[1].checked) {
            if (pBtn.textContent === 'Show more') {
                document.querySelector(user).style.display = 'block';     
                pBtn.textContent = 'Hide it';
            } else if (pBtn.textContent === 'Hide it') {
                document.querySelector(user).style.display = 'none';
                pBtn.textContent = 'Show more';
            }
        }
    }

    //Logic
    arrOfHandlers = [bntClickedUser1, bntClickedUser2, bntClickedUser3];

    let buttons = document.querySelectorAll('button');
    for (let i = 0; i < buttons.length; i++) {
        buttons[i].addEventListener('click', arrOfHandlers[i]);
    }

}

/**
 * function lockedProfile() {
    const btns = [...document.getElementsByTagName('button')];
    btns.forEach(btn => btn.addEventListener('click', showHide));
 
    function showHide(event) {
        const button = event.target;
        const profile = button.parentNode;
        const moreInformation = profile.getElementsByTagName('div')[0];
        const lockStatus = profile.querySelector('input[type="radio"]:checked').value;
 
        if (lockStatus === 'unlock') {
            if (button.textContent === 'Show more') {
                moreInformation.style.display = 'inline-block';
                button.textContent = 'Hide it';
            } else if (button.textContent === 'Hide it') {
                moreInformation.style.display = 'none';
                button.textContent = 'Show more';
            }
        }
    }
}
 */
