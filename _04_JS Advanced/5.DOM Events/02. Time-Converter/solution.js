function attachEventsListeners() {

    let myDays = document.querySelector('#days');
    let myHours = document.querySelector('#hours');
    let myMinutes = document.querySelector('#minutes');
    let mySeconds = document.querySelector('#seconds');

    let d;
    let h;
    let m;
    let s;

    document.querySelector('#daysBtn').addEventListener('click', daysHandler);
    document.querySelector('#hoursBtn').addEventListener('click', hoursHandler);
    document.querySelector('#minutesBtn').addEventListener('click', minutesHandler);
    document.querySelector('#secondsBtn').addEventListener('click', secondsHandler);


    //Functions
    function daysHandler(event) {

        let d = Number(myDays.value);

        if (d > 1) {
            myHours.value = 24 * d;
            myMinutes.value = 1440 * d;
            mySeconds.value = 86440 * d;
        } else if (d === 1) {
            myHours.value = 24;
            myMinutes.value = 1440;
            mySeconds.value = 86440;
        }
    }

    function hoursHandler(event) {
        let h = Number(myHours.value);

        if (h > 24) {
            myDays.value = h / 24;
            myMinutes.value = Number(myDays.value) * 1440;
            mySeconds.value = Number(myDays.value) * 86400;
        } else if (h === 24) {
            myDays.value = 1;
            myMinutes.value = 1440;
            mySeconds.value = 86400;
        }
    }

    function minutesHandler(event) {
        let m = Number(myMinutes.value);

        if (m > 1440) {
            myHours.value = m / 60;
            myDays.value = Number(myHours.value) / 24;
            mySeconds.value = Number(myDays.value) * 86400;
        } else if (m === 1440) {
            myDays.value = 1;
            myHours.value = 24;
            mySeconds.value = 86400;
        }
    }

    function secondsHandler(event) {
        let s = Number(mySeconds.value);

        if (s > 86400) {
            myMinutes.value = s / 60;
            myHours.value = Number(myMinutes.value) / 60;
            myDays.value = Number(myHours.value) / 24;
        } else if (s === 86400) {
            myDays.value = 1;
            myHours.value = 24;
            myMinutes.value = 1440;
        }
    }
}

/**
 * function attachEventsListeners() {
    let daysInput = document.getElementById('days');
    let hoursInput = document.getElementById('hours');
    let minutesInput = document.getElementById('minutes');
    let secondsInput = document.getElementById('seconds');
 
    let daysBtn = document.getElementById('daysBtn');
    let hoursBtn = document.getElementById('hoursBtn');
    let minutesBtn = document.getElementById('minutesBtn');
    let secondsBtn = document.getElementById('secondsBtn');
 
    daysBtn.addEventListener('click', function() {
        let days = daysInput.value;
        hoursInput.value = days * 24;
        minutesInput.value = days * 1440;
        secondsInput.value = days * 86400;
    });
 
    hoursBtn.addEventListener('click', function() {
        let hours = hoursInput.value;
        daysInput.value = hours / 24;
        minutesInput.value = hours * 60;
        secondsInput.value = hours * 60 * 60;
    });
 
    minutesBtn.addEventListener('click', function() {
        let minutes = minutesInput.value;
        hoursInput.value = minutes / 60;
        daysInput.value = minutes / 60 / 24;
        secondsInput.value = minutes * 60;
    });
 
    secondsBtn.addEventListener('click', function() {
        let seconds = secondsInput.value;
        hoursInput.value = seconds / 60 / 60;
        minutesInput.value = seconds / 60;
        daysInput.value = seconds / 60 / 60 / 24;
    });
}
 */