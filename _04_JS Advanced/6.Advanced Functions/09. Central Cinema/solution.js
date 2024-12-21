function solve() {

    let txtbName = document.querySelector('input[placeholder="Name"]');
    let txtbHall = document.querySelector('input[placeholder="Hall"]');
    let txtbTicket = document.querySelector('input[placeholder="Ticket Price"]');

    let ulMovies = document.querySelector('#movies > ul');
    let ulArchive = document.querySelector('#archive > ul');

    let btnClear = document.querySelector('#archive > button');

    document.querySelector("#container > button").addEventListener('click', function (e) {
        e.preventDefault();

        if (txtbName.value != '' && txtbHall.value != '' && txtbTicket.value != '') {
            let ticketPrice = Number(txtbTicket.value);
            let movieName = txtbName.value;
            if (ticketPrice) {
                let li = document.createElement('li');

                let span = document.createElement('span');
                let strong = document.createElement('strong');

                let div = document.createElement('div');


                span.textContent = txtbName.value;
                strong.textContent = `Hall: ${txtbHall.value}`;

                let divStrong = document.createElement('strong');
                let inputTicketSold = document.createElement('input');
                inputTicketSold.setAttribute('type', 'text');
                inputTicketSold.setAttribute('placeholder', 'Tickets Sold');
                let buttonArchive = document.createElement('button');
                buttonArchive.textContent = 'Archive';

                divStrong.textContent = Number(txtbTicket.value).toFixed(2);
                div.appendChild(divStrong);
                div.appendChild(inputTicketSold);
                div.appendChild(buttonArchive);

                li.appendChild(span);
                li.appendChild(strong);
                li.appendChild(div);
                ulMovies.appendChild(li);

                txtbName.value = '';
                txtbHall.value = '';
                txtbTicket.value = '';

                //Button Archive Handler
                buttonArchive.addEventListener('click', function (e) {
                    e.preventDefault();

                    let ticketsCount = Number(inputTicketSold.value);
                    if (ticketsCount) {
                        let totalPrice = Number(ticketsCount * Number(ticketPrice)).toFixed(2);


                        let liArchive = document.createElement('li');
                        let spanAchive = document.createElement('span');
                        spanAchive.textContent = movieName;

                        liArchive.appendChild(spanAchive);

                        let strongAchive = document.createElement('strong');
                        strongAchive.textContent = `Total amount: ${totalPrice}`;

                        liArchive.appendChild(strongAchive);

                        let btnArchive = document.createElement('button');
                        btnArchive.textContent = 'Delete';

                        liArchive.appendChild(btnArchive);

                        ulArchive.appendChild(liArchive);

                        e.target.parentElement.parentElement.remove();

                        //Delete Item Handler
                        btnArchive.addEventListener('click', function (e) {
                            e.preventDefault();

                            e.target.parentElement.remove();
                        });

                        //Clear Handler                        
                        btnClear.addEventListener('click', function (e) {
                            e.preventDefault();

                            let li = (e.target.parentElement.children[1].children);

                            for (const item of li) {
                                item.remove();
                            }
                        });

                    }//if
                });//buttonArchive handler
            }//if
        }//if
    });//#container > button handler


}

