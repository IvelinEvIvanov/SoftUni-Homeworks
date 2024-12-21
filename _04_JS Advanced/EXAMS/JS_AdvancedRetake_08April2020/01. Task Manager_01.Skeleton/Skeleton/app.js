function solve() {

    document.querySelector('#add').addEventListener('click', handlerBtn_Add);


    /**
     * 
     * @param {Event} e 
     */
    function handlerBtn_Add(e) {
        e.preventDefault();

        let txtTask = document.querySelector('#task');
        let txtareaDescription = document.querySelector('#description');
        let txtDate = document.querySelector('#date');

        let txtTaskValue = txtTask.value;
        let txtDateValue = txtDate.value;
        let txtareaLines = txtareaDescription.value;
        txtareaLines = txtareaLines.trim().split('\n');

        if (txtTaskValue !== '' && txtDateValue !== '' && txtareaLines !== '') {
            //create html tags
            let article = document.createElement('article');
            let h3 = document.createElement('h3');
            let pDescription = document.createElement('p');
            let pDate = document.createElement('p');
            let div = document.createElement('div');
            let buttonStart = document.createElement('button');
            let buttonDelete = document.createElement('button');

            //set props
            article.addEventListener('click', handlerArticle_Btn);
            div.classList.add('flex');
            buttonStart.classList.add('green');
            buttonDelete.classList.add('red');

            //append to inner tags
            h3.textContent = txtTaskValue;
            pDescription.textContent = 'Description: ' + txtareaLines;
            pDate.textContent = 'Due Date: ' + txtDateValue;
            buttonStart.textContent = 'Start';
            buttonDelete.textContent = 'Delete';

            div.appendChild(buttonStart);
            div.appendChild(buttonDelete);

            //apend to outer parent
            article.appendChild(h3);
            article.appendChild(pDescription);
            article.appendChild(pDate);
            article.appendChild(div);

            //apend to root parent
            let open = document.querySelector('.orange');
            open = open.parentElement.nextElementSibling;
            open.appendChild(article);

        }
    }

    function handlerArticle_Btn(ev) {

        /** @type {HTMLElement} */
        let currentTarget = ev.currentTarget;
        /** @type {HTMLElement} */
        let target = ev.target;

        if (target.tagName === 'BUTTON' && target.textContent === 'Start') {

            let copyOfArticle = currentTarget.cloneNode(true);
            let nextSection = document.querySelector('#in-progress');

            let buttonDelete = copyOfArticle.querySelector('.green');
            buttonDelete.textContent = 'Delete';
            buttonDelete.classList.remove('green');


            let buttonFinish = copyOfArticle.querySelector('.red');
            buttonFinish.textContent = 'Finish';
            buttonFinish.classList.remove('red');

            buttonDelete.classList.add('red');
            buttonFinish.classList.add('orange');

            currentTarget.remove();

            copyOfArticle.addEventListener('click', handlerArticle_Btn);
            nextSection.appendChild(copyOfArticle);
        } else if (target.tagName === 'BUTTON' && target.textContent === 'Finish') {

            let copyOfArticle = currentTarget.cloneNode(true);

            let nextSection = document.querySelector('.wrapper');
            nextSection = nextSection.children[3];
            nextSection = nextSection.children[1];

            let flex = copyOfArticle.querySelector('.flex');
            flex.remove();

            currentTarget.remove();

            nextSection.appendChild(copyOfArticle);
        } else if (target.tagName === 'BUTTON' && target.textContent === 'Delete') {
            currentTarget.remove();
        }
    }
}