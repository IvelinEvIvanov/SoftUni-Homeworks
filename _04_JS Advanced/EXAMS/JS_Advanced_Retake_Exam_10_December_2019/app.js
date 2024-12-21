function solution() {
    document.querySelector('.card:nth-child(1) button').addEventListener('click', btnAddGiftHandler);


    /**
     * 
     * @param {Event} e 
     */
    function btnAddGiftHandler(e) {
        e.preventDefault();

        const txtAddGift = document.querySelector('.card:nth-child(1) input[type="text"]');
        const ul = document.querySelector('.card:nth-child(2) ul');
        const li = document.createElement('li');

        li.classList.add('gift');
        li.textContent = txtAddGift.value;

        txtAddGift.value = '';

        //buttons
        const btnSend = document.createElement('button');
        btnSend.textContent = 'Send';
        btnSend.setAttribute('id', 'sendButton');
        btnSend.addEventListener('click', btnSendGiftHandler);

        const btnDiscard = document.createElement('button');
        btnDiscard.textContent = 'Discard';
        btnDiscard.setAttribute('id', 'discardButton');
        btnDiscard.addEventListener('click', btnDiscardGiftHandler);


        //append buttons to li
        li.appendChild(btnSend);
        li.appendChild(btnDiscard);

        let arr = Array.from(ul.children);
        arr.push(li);
        arr.sort((a, b) => a.textContent.localeCompare(b.textContent));

        //append li to ul
        arr.forEach(el => {
            ul.appendChild(el);
        });

    }

    /**
     * 
     * @param {Event} e
     *  
     */
    function btnSendGiftHandler(e) {
        const ul = document.querySelector('.card:nth-child(3) ul');

        /** @type {Element}*/
        const li = e.currentTarget.parentElement;
        const liSended = document.createElement('li');
        liSended.classList.add('gift');
        liSended.textContent = li.childNodes[0].textContent;

        //apend li to ul
        ul.appendChild(liSended);

        li.remove();
    }

    /**
     * 
     * @param {Event} e 
     */
    function btnDiscardGiftHandler(e) {
        const ul = document.querySelector('.card:nth-child(4) ul');

        /** @type {Element}*/
        const li = e.currentTarget.parentElement;
        const liDiscarded = document.createElement('li');
        liDiscarded.classList.add('gift');
        liDiscarded.textContent = li.childNodes[0].textContent;

        //apend li to ul
        ul.appendChild(liDiscarded);
        
        li.remove();
    }
}