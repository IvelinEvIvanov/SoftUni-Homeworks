function solve(inputArr) {

    const mapCars = new Map();

    for (let index = 0; index < inputArr.length; index++) {

        let [carBrand, carModel, producedCars] = inputArr[index].split(' | ');

        let obj = {};
        if (!mapCars.has(carBrand)) {
            obj[carModel] = Number(producedCars);
            let arr = new Array();
            arr.push(obj);

            mapCars.set(carBrand, arr);
        } else {
            let isUpdated = false;
            obj[carModel] = Number(producedCars);

            let carArr = mapCars.get(carBrand);

            for (const itrObj of carArr) {
                let key = Object.keys(itrObj)[0];
                if (key === carModel) {
                    itrObj[key] += obj[key];
                    isUpdated = true;
                    break;
                }
            }

            if (!isUpdated) {
                let brandArr = mapCars.get(carBrand);
                brandArr.push(obj);
                mapCars.set(carBrand, brandArr);
            }


        }
    }

    for (const [key, val] of mapCars.entries()) {
        console.log(key);

        for (const itrObj of val) {
            let k = Object.keys(itrObj)[0];
            console.log(`###${k} -> ${itrObj[k]}`);
        }
    }

}

solve(['Audi | Q7 | 1000',
    'Audi | Q6 | 100',
    'BMW | X5 | 1000',
    'BMW | X6 | 100',
    'Citroen | C4 | 123',
    'Volga | GAZ-24 | 1000000',
    'Lada | Niva | 1000000',
    'Lada | Jigula | 1000000',
    'Citroen | C4 | 22',
    'Citroen | C5 | 10']);