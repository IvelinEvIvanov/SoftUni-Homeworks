function validate() {
    const userFieldset = document.querySelector('#userInfo');
    const companyCheckbox = userFieldset.querySelector('#company');
    const companyFieldset = document.querySelector('#companyInfo');
    const companyNumberInput = companyFieldset.querySelector('#companyNumber')

    let isCompanyValid = false;
    let isCompanyChecked = false;

    companyCheckbox.addEventListener('click', function (e) {
        if (e.target.checked == true) {
            companyFieldset.style.display = 'inline';

            isCompanyChecked = true;

        } else if (e.target.checked == false) {
            companyFieldset.style.display = 'none';
            isCompanyChecked = false;
        }
    });

    document.querySelector('#submit').addEventListener('click', function (e) {
        e.preventDefault();

        //Regex Pattern
        const patternUsername = /^[A-Za-z0-9]{3,20}$/g;
        const patternEmail = /@.*\./g;
        const patternPassword = /^\w{5,15}$/;
        const patternConfirmPassword = /^\w{5,15}$/;

        //Inputs
        const usernameInput = document.querySelector('#username');
        const emailInput = document.querySelector('#email');
        const passwordInput = document.querySelector('#password');
        const passwordConfirmInput = document.querySelector('#confirm-password');

        let validDiv = document.querySelector('#valid');

        //Valid Tests
        let isUserNameValid = patternUsername.test(usernameInput.value);
        let isEmailValid = patternEmail.test(emailInput.value);
        let isPsswordValid = patternPassword.test(passwordInput.value);
        let isConfirmPassowrdValid = patternConfirmPassword.test(passwordConfirmInput.value);

        if (isPsswordValid && isConfirmPassowrdValid) {
            if (passwordInput.value !== passwordConfirmInput.value) {
                isPsswordValid = false;
                isConfirmPassowrdValid = false;
            }
        }


        if (!isUserNameValid) {
            usernameInput.style.borderColor = 'red';
            validDiv.style.display = 'none';
        } else {
            usernameInput.style.border = 'none';
        }

        if (!isEmailValid) {
            emailInput.style.borderColor = 'red';
            validDiv.style.display = 'none';
        } else {
            emailInput.style.border = 'none';
        }

        if (!isPsswordValid) {
            passwordInput.style.borderColor = 'red';
            validDiv.style.display = 'none';
        } else {
            passwordInput.style.border = 'none';
        }

        if (!isConfirmPassowrdValid) {
            passwordConfirmInput.style.borderColor = 'red';
            validDiv.style.display = 'none';
        } else {
            passwordConfirmInput.style.border = 'none';
        }

        if (isCompanyChecked) {
            let companyNumber = companyNumberInput.value;
            if (companyNumber < 1000 || companyNumber > 9999) {
                isCompanyValid = false;
                companyNumberInput.style.borderColor = 'red';
                validDiv.style.display = 'none';
            } else {
                isCompanyValid = true;
                companyNumberInput.style.border = 'none';
            }
        } else {
            companyNumberInput.style.border = 'none';
        }

        if (isUserNameValid && isEmailValid && isPsswordValid && isConfirmPassowrdValid) {
            if (isCompanyChecked && isCompanyValid) {
                validDiv.style.display = 'block';
            } else if (isCompanyChecked && !isCompanyValid) {
                validDiv.style.display = 'none';
            } else {
                validDiv.style.display = 'block';
            }

        }

    });

}

/**
 * function validate() {
  document.querySelector("#submit").type = "button";
  document.querySelector("#company").addEventListener("change", (e) => {
    console.log(e.target);
    if (document.querySelector("#company").checked) {
      document.querySelector("#companyInfo").style.display = "block";
    } else {
      document.querySelector("#companyInfo").style.display = "none";
    }
  });
 
  document.querySelector("#submit").addEventListener("click", (e) => {
    let validOut = [];
    let userName = document.querySelector("#username");
    let email = document.querySelector("#email");
    let passWord = document.querySelector("#password");
    let confirmPass = document.querySelector("#confirm-password");
    let checkBox = document.querySelector("#company");
    let userTest = /^[A-Za-z0-9]{3,20}$/;
    let emailTest = /^[^@.]+@[^@]*\.[^@]*$/;
    let passTest = /^[\w]{5,15}$/;
 
    //console.log(checkBox.checked);
 
    if (userTest.exec(userName.value) === null) {
      userName.style.borderColor = "red";
      validOut.push(false);
    } else {
      userName.style.borderColor = "";
      validOut.push(true);
    }
 
    if (emailTest.exec(email.value) === null) {
      email.style.borderColor = "red";
      validOut.push(false);
    } else {
      email.style.borderColor = "";
      validOut.push(true);
    }
 
    if (
      passWord.value === confirmPass.value &&
      passTest.exec(confirmPass.value) != null &&
      passTest.exec(passWord.value) != null
    ) {
      confirmPass.style.borderColor = "";
      passWord.style.borderColor = "";
      validOut.push(true);
    } else {
      confirmPass.style.borderColor = "red";
      passWord.style.borderColor = "red";
      validOut.push(false);
    }
 
    if (checkBox.checked) {
      let company = document.querySelector("#companyNumber");
      if (company.value < 1000 || company.value > 9999) {
        company.style.borderColor = "red";
        validOut.push(false);
      } else {
        company.style.borderColor = "";
        validOut.push(true);
      }
    }
 
    if (!validOut.includes(false)) {
      document.querySelector("#valid").style.display = "block";
    } else {
      document.querySelector("#valid").style.display = "none";
    }
  });
}
 */
