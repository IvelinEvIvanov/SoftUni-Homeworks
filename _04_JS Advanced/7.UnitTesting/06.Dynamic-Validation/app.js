function validate() {
    let tagEmail = document.querySelector('#email');
    tagEmail.addEventListener('change', validate);

    let patternEmail = /^[a-z]+@[a-z]+\.[a-z]+$/;

    function validate(e) {
        let email = this.value;
        if (patternEmail.test(email)) {
            e.target.classList.remove('error');
        } else {
            e.target.classList.add('error');
        }
    }
}