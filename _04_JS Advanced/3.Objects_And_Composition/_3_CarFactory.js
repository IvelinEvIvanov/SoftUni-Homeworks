function solve(inputObj) {


    function getEngine(power) {
        const engines = [
            
                {power: 90, volume: 1800},
                {power: 120, volume: 2400},
                {power: 200, volume: 3500}
            
        ];

        let result;
        for (let index = 0; index < engines.length; index++) {
            if (engines[index].power >= power) {
                result = engines[index];
                break;
            }

        }

        return result;
    }

    function getCarriage(carriage, color) {
        return {
            type: carriage,
            color
        }

    }

    function getWeels(wheelsize) {
        if (wheelsize % 2 === 0) {
            let w = wheelsize - 1;
            return [w, w, w, w];
        } else {
            return [wheelsize, wheelsize, wheelsize, wheelsize];
        }
    }

    return {
        model: inputObj.model,
        engine: getEngine(inputObj.power),
        carriage: getCarriage(inputObj.carriage, inputObj.color),
        wheels: getWeels(inputObj.wheelsize)
    }

}

console.log(solve({
    model: 'VW Golf II',
    power: 90,
    color: 'blue',
    carriage: 'hatchback',
    wheelsize: 14
}));