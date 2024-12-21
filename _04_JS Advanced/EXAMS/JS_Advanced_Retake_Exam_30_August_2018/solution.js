function addDestination() {

    let data = Array.from(document.querySelectorAll('.inputData'));
    let city = data[0].value;
    let country = data[1].value;

    if (city != '' && country != '') {
        const season = document.querySelector('#seasons').value;
        const table = document.querySelector('#destinationsList');

        const tr = document.createElement('tr');

        const tdDestination = document.createElement('td');
        const tdSeasson = document.createElement('td');

        tdDestination.textContent = `${city}, ${country}`;

        tr.appendChild(tdDestination);

        if (season === 'summer') {
            let summer = document.querySelector('#summer');
            tdSeasson.textContent = 'Summer';
            tr.appendChild(tdSeasson);
            ++summer.value;
        } else if (season === 'autumn') {
            let autumn = document.querySelector('#autumn');
            tdSeasson.textContent = 'Autumn';
            tr.appendChild(tdSeasson);
            ++autumn.value;
        } else if (season === 'winter') {
            let winter = document.querySelector('#winter');
            tdSeasson.textContent = 'Winter';
            tr.appendChild(tdSeasson);
            ++winter.value;
        } else if (season === 'spring') {
            let spring = document.querySelector('#spring');
            tdSeasson.textContent = 'Spring';
            tr.appendChild(tdSeasson);
            ++spring.value;
        }

        data[0].value = '';
        data[1].value = ''

        table.appendChild(tr);
    }



}



