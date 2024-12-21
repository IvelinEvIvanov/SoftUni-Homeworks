function solve(arr) {
    let mapTempJuice = new Map();
    let mapResult = new Map();

    for (let index = 0; index < arr.length; index++) {

        let [juice, quantity] = arr[index].split(' => ');
        quantity = Number(quantity);

        if (quantity < 1000) {

            if (!mapTempJuice.has(juice)) {
                mapTempJuice.set(juice, quantity);
            } else {
                quantity += mapTempJuice.get(juice);
                mapTempJuice.set(juice, quantity);
            }

        }

        if (quantity >= 1000) {
            let numberJuices = Math.floor(quantity / 1000);
            let quantityleft = quantity % 1000;

            if (!mapResult.has(juice)) {
                mapResult.set(juice, numberJuices);
            } else {
                mapResult.set(juice, mapResult.get(juice) + numberJuices);
            }

            if (!mapTempJuice.has(juice)) {
                mapTempJuice.set(juice, quantityleft);
            } else {
                mapTempJuice.set(juice, quantityleft);
            }
        }

    }

    for (const [key, val] of mapResult.entries()) {
        console.log(key + ' => ' + val);
    }
}

solve(['Kiwi => 234',
    'Pear => 2345',
    'Watermelon => 3456',
    'Kiwi => 4567',
    'Pear => 5678',
    'Watermelon => 6789']);