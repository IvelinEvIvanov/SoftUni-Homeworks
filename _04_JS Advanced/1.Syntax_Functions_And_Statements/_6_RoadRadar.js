function printSpeedLimit(pSpeed, pArea) {

    const motorway = 130;
    const interstate = 90;
    const city = 50;
    const residential = 20;

    let difference = '';

    switch (pArea) {
        case 'motorway':
            if (pSpeed <= motorway) {
                printWithinTheLimits(pSpeed, motorway);
            } else {
                difference = pSpeed - motorway;
                printOverTheLimits(difference, motorway, getStatus(difference));
            }
            break;

        case 'interstate':
            if (pSpeed <= interstate) {
                printWithinTheLimits(pSpeed, interstate);
            } else {
                difference = pSpeed - interstate;
                printOverTheLimits(difference, interstate, getStatus(difference));
            }
            break;

        case 'city':
            if (pSpeed <= city) {
                printWithinTheLimits(pSpeed, city);
            } else {
                difference = pSpeed - city;
                printOverTheLimits(difference, city, getStatus(difference));
            }
            break;

        case 'residential':
            if (pSpeed <= residential) {
                printWithinTheLimits(pSpeed, residential);
            } else {
                difference = pSpeed - residential;
                printOverTheLimits(difference, residential, getStatus(difference));
            }
            break;

    }

    function printWithinTheLimits(pSpeed, pSpeedLimit) {
        console.log(`Driving ${pSpeed} km/h in a ${pSpeedLimit} zone`);

    }

    function getStatus(pSpeed) {
        if (pSpeed <= 20) {
            return 'speeding';
        }

        if (pSpeed <= 40) {
            return 'excessive speeding';
        }

        return 'reckless driving';
    }

    function printOverTheLimits(pDifference, pSpeed, pStatus) {
        console.log(`The speed is ${pDifference} km/h faster than the allowed speed of ${pSpeed} - ${pStatus}`);
    }
}

