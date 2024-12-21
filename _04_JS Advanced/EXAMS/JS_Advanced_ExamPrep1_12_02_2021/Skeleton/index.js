function solve() {
    let btnAdd = document.querySelectorAll('.form-control')[3];
    btnAdd = btnAdd.querySelector('button');
    btnAdd.addEventListener('click', btnAddHandler);

    let sectionTrainings_Div = document.querySelector('.user-view.section-view');
    sectionTrainings_Div = sectionTrainings_Div.querySelector('div');

    let isBasics = false;
    let isFundamentals = false;
    let isAdvanced = false;
    let isDB = false;
    let isWeb = false;

    //dynamic divs for clicked btnAdd
    let divBasics = {}
    let divFundamentals = {};
    let divAdvanced = {};
    let divDB = {};
    let divWeb = {};

    //Handlers
    /**
     * 
     * @param {Event} ev 
     */
    function btnAddHandler(ev) {
        ev.preventDefault();

        //get input
        let intxtNameLecture = document.querySelector('input[name="lecture-name"]')
        let intxtNameLectureValue = intxtNameLecture.value;

        let inDatetimeLecture = document.querySelector('input[name="lecture-date"]');
        let inDatetimeLectureValue = inDatetimeLecture.value;
        let datetimeTokens = inDatetimeLectureValue.split('T');
        let foramtedDate = datetimeTokens[0].replaceAll('-', '/');
        let formatedTime = datetimeTokens[1];

        let inDropDownLectureModule = document.querySelector('select[name="lecture-module"]');
        let inDropDownLectureModuleValue = inDropDownLectureModule.value;

        //validate input
        if (intxtNameLectureValue !== '' && inDatetimeLectureValue !== ''
            && inDropDownLectureModuleValue !== 'Select module') {

            //main dynamic div
            let dynamicDiv = document.createElement('div');
            dynamicDiv.classList.add('module');

            //create tags
            let ul = document.createElement('ul');
            let h3 = document.createElement('h3');
            let li = document.createElement('li');
            let h4 = document.createElement('h4');
            let button = document.createElement('button');

            //set tags
            li.classList.add('flex');
            button.classList.add('red');
            button.textContent = 'Del';

            //append to tags
            li.appendChild(h4);
            li.appendChild(button);
            ul.appendChild(li);

            //append to main div - dynamic parent
            dynamicDiv.appendChild(h3);
            dynamicDiv.appendChild(ul);

            let moduleName = inDropDownLectureModule.querySelector('option:checked').value;

            //Init Dynamic DIVs
            if (moduleName === 'Basics') {
                if (!isBasics) {
                    divBasics = dynamicDiv.cloneNode(true);
                    isBasics = true;

                    let h3 = divBasics.querySelector('h3');
                    h3.textContent = `${moduleName.toUpperCase()}-MODULE`;

                    let h4 = divBasics.querySelector('ul > li > h4');
                    h4.textContent = `${intxtNameLectureValue} - ${foramtedDate} - ${formatedTime}`;

                    sectionTrainings_Div.appendChild(divBasics);
                } else {
                    h4.textContent = `${intxtNameLectureValue} - ${foramtedDate} - ${formatedTime}`;
                    let arrLi = Array.from(divBasics.querySelector('ul').children);
                    arrLi.push(li);

                    sortByDate(arrLi);

                    let ulSorted = divBasics.querySelector('ul');
                    arrLi.forEach(el => {
                        ulSorted.appendChild(el);
                    });
                }
            } else if (moduleName === 'Fundamentals') {
                if (!isFundamentals) {
                    divFundamentals = dynamicDiv.cloneNode(true);
                    isFundamentals = true;

                    let h3 = divFundamentals.querySelector('h3');
                    h3.textContent = `${moduleName.toUpperCase()}-MODULE`;

                    let h4 = divFundamentals.querySelector('ul > li > h4');
                    h4.textContent = `${intxtNameLectureValue} - ${foramtedDate} - ${formatedTime}`;

                    sectionTrainings_Div.appendChild(divFundamentals);
                } else {
                    h4.textContent = `${intxtNameLectureValue} - ${foramtedDate} - ${formatedTime}`;
                    let arrLi = Array.from(divFundamentals.querySelector('ul').children);
                    arrLi.push(li);

                    sortByDate(arrLi);

                    let ulSorted = divFundamentals.querySelector('ul');
                    arrLi.forEach(el => {
                        ulSorted.appendChild(el);
                    });
                }
            } else if (moduleName === 'Advanced') {
                if (!isAdvanced) {
                    divAdvanced = dynamicDiv.cloneNode(true);
                    isAdvanced = true;

                    let h3 = divAdvanced.querySelector('h3');
                    h3.textContent = `${moduleName.toUpperCase()}-MODULE`;

                    let h4 = divAdvanced.querySelector('ul > li > h4');
                    h4.textContent = `${intxtNameLectureValue} - ${foramtedDate} - ${formatedTime}`;

                    sectionTrainings_Div.appendChild(divAdvanced);
                } else {
                    h4.textContent = `${intxtNameLectureValue} - ${foramtedDate} - ${formatedTime}`;
                    let arrLi = Array.from(divAdvanced.querySelector('ul').children);
                    arrLi.push(li);

                    sortByDate(arrLi);

                    let ulSorted = divAdvanced.querySelector('ul');
                    arrLi.forEach(el => {
                        ulSorted.appendChild(el);
                    });
                }
            } else if (moduleName === 'DB') {
                if (!isDB) {
                    divDB = dynamicDiv.cloneNode(true);
                    isDB = true;

                    let h3 = divDB.querySelector('h3');
                    h3.textContent = `${moduleName.toUpperCase()}-MODULE`;

                    let h4 = divDB.querySelector('ul > li > h4');
                    h4.textContent = `${intxtNameLectureValue} - ${foramtedDate} - ${formatedTime}`;

                    sectionTrainings_Div.appendChild(divDB);
                } else {
                    h4.textContent = `${intxtNameLectureValue} - ${foramtedDate} - ${formatedTime}`;
                    let arrLi = Array.from(divDB.querySelector('ul').children);
                    arrLi.push(li);

                    sortByDate(arrLi);

                    let ulSorted = divDB.querySelector('ul');
                    arrLi.forEach(el => {
                        ulSorted.appendChild(el);
                    });
                }
            } else if (moduleName === 'Web') {
                if (!isWeb) {
                    divWeb = dynamicDiv.cloneNode(true);
                    isWeb = true;

                    let h3 = divWeb.querySelector('h3');
                    h3.textContent = `${moduleName.toUpperCase()}-MODULE`;

                    let h4 = divWeb.querySelector('ul > li > h4');
                    h4.textContent = `${intxtNameLectureValue} - ${foramtedDate} - ${formatedTime}`;

                    sectionTrainings_Div.appendChild(divWeb);
                } else {
                    h4.textContent = `${intxtNameLectureValue} - ${foramtedDate} - ${formatedTime}`;
                    let arrLi = Array.from(divWeb.querySelector('ul').children);
                    arrLi.push(li);

                    sortByDate(arrLi);

                    let ulSorted = divWeb.querySelector('ul');
                    arrLi.forEach(el => {
                        ulSorted.appendChild(el);
                    });
                }
            }
        }
    }

    /**
     * 
     * @param {Array} arr 
     */
    function sortByDate(arr) {
        arr.sort((li1, li2) => {

            let date1 = li1.querySelector('h4').textContent;
            let date2 = li2.querySelector('h4').textContent;

            date1 = date1.split(' - ');
            date1 = date1[1] + date1[2];

            date2 = date2.split(' - ');
            date2 = date2[1] + date2[2];

            return date1.localeCompare(date2);
        });
    }
};