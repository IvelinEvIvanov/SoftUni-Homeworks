window.addEventListener('load', solve);

function solve() {
    let inputModel = document.querySelector('#model');
    let inputYear = document.querySelector('#year');
    let inputDescription = document.querySelector('#description');
    let inputPrice = document.querySelector('#price');

    let outputTbody = document.querySelector('#furniture-list');

    let buttonAdd = document.querySelector('#add');
    buttonAdd.addEventListener('click', btnAddHandler);

    function btnAddHandler(e) {
        e.preventDefault();

        let model = inputModel.value;
        let year = Number(inputYear.value);
        let description = inputDescription.value;
        let price = Number(inputPrice.value);

        if (model !== '' && year > 0 && description !== '' && price > 0) {


            let trInfo = document.createElement('tr');
            trInfo.classList.add('info');

            let tdModel = document.createElement('td');
            tdModel.textContent = model;
            trInfo.appendChild(tdModel);

            let tdPrice = document.createElement('td');
            tdPrice.textContent = price.toFixed(2);
            trInfo.appendChild(tdPrice);

            let tdButtons = document.createElement('td');
            let buttonInfo = document.createElement('button');
            buttonInfo.textContent = 'More Info';
            buttonInfo.classList.add('moreBtn');
            buttonInfo.addEventListener('click', btnMoreHandler);
            tdButtons.appendChild(buttonInfo);

            let buttonBuy = document.createElement('button');
            buttonBuy.textContent = 'Buy it';
            buttonBuy.classList.add('buyBtn');
            buttonBuy.addEventListener('click', btnBuyHandler);
            tdButtons.appendChild(buttonBuy);

            trInfo.appendChild(tdButtons);

            let trHide = document.createElement('tr');
            trHide.classList.add('hide');

            let tdYear = document.createElement('td');
            tdYear.textContent = 'Year: ' + year;
            trHide.appendChild(tdYear);

            let tdDesription = document.createElement('td');
            tdDesription.setAttribute('colspan', '3');
            tdDesription.textContent = 'Description: ' + description;
            trHide.appendChild(tdDesription);

            outputTbody.appendChild(trInfo);
            outputTbody.appendChild(trHide);

            inputModel.value = '';
            inputYear.value = ''
            inputDescription.value = '';
            inputPrice.value = '';
        }

    }

    function btnMoreHandler(e) {
        let trHide = document.querySelector('.hide');

        if (e.target.textContent === 'More Info') {
            e.target.textContent = 'Less Info';
            trHide.style.setProperty('display', 'contents');
        } else {
            e.target.textContent = 'More Info';
            trHide.style.setProperty('display', 'none');
        }

    }

    function btnBuyHandler(e) {
        let buy = e.target;
        let parent = buy.parentElement.parentElement;
        let price = Number(parent.children[1].textContent);
        let next=parent.nextSibling;
        next.remove();
        parent.remove();

        let td = document.querySelector('.total-price');
        let total = Number(td.textContent);
        total = total + price;
        td.textContent = total.toFixed(2);

    }

}
