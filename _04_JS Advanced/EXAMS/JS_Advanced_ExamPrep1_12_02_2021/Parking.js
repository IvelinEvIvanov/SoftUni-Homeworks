class Parking {
    /**
     * 
     * @param {Number} capacity 
     * @param {Array} vehicles
     * @param {Boolean} payed
     */
    constructor(capacity) {
        this.capacity = capacity;
        this.vehicles = [];
    }

    /**
     * 
     * @param {String} carModel 
     * @param {String} carNumber 
     */
    addCar(carModel, carNumber) {
        if (this.capacity <= 0) {
            throw new Error('Not enough parking space.');
        }

        this.vehicles.push({ carModel, carNumber, payed: false });
        this.capacity--;

        return `The ${carModel}, with a registration number ${carNumber}, parked.`;
    }

    removeCar(carNumber) {

        let carNumberResult = this.vehicles.find(car => car['carNumber'] === carNumber);
        if (carNumberResult === undefined) {
            throw new ErrorEvent("The car, you're looking for, is not found.");
        } else if (carNumberResult['payed'] === false) {
            throw new Error(`${carNumber} needs to pay before leaving the parking lot.`);
        }

        let index = this.vehicles.findIndex(car => car['carNumber'] === carNumber);
        this.vehicles.splice(index, 1,);

        this.capacity++;

        return `${carNumber} left the parking lot.`;
    }

    pay(carNumber) {
        let carNumberResult = this.vehicles.find(car => car['carNumber'] === carNumber);
        if (carNumberResult === undefined) {
            throw new Error`${carNumber} is not in the parking lot.`;
        } else if (carNumberResult['payed'] === true) {
            throw new Error(`${carNumber}'s driver has already payed his ticket.`)
        }

        carNumberResult['payed'] = true;

        return `${carNumber}'s driver successfully payed for his stay.`;
    }

    getStatistics(carNumber) {
        let result = '';
        result += `The Parking Lot has ${this.capacity} empty spots left.\n`;

        if (carNumber === undefined) {

            if (this.vehicles.length >= 2) {

                this.vehicles.sort((a, b) => a['carModel'].localeCompare(b['carModel']))
                    .forEach(car => {
                        result += `${car['carModel']} == ${car['carNumber']} - `;

                        if (car['payed'] == false) {
                            result += `Not payed`;
                        } else {
                            result += `Has payed`;
                        }

                        return result;
                    });
            }

            if (carNumber !== undefined) {
                let carNumberResult = this.vehicles.find(car => car['carNumber'] === carNumber);
                if (carNumberResult !== undefined) {
                    return result += `${car['carModel']} == ${car['carNumber']} - ` + car['payed'] ? `Has payed` : `Not payed`;
                }
            } else {
                const carModel = this.vehicles[0]['carModel'];
                const carNumber = this.vehicles[0]['carNumber'];
                result += `${carModel} == ${carNumber} - `;
                result += this.vehicles[0]['payed'] ? `Has payed` : `Not payed`;;
                return result;
            }


        }
    }
}

const parking = new Parking(12);

console.log(parking.addCar("Volvo t600", "TX3691CA"));
console.log(parking.addCar("Aolvo t600", "TX3691CA"));
console.log(parking.getStatistics());
console.log(parking.pay("TX3691CA"));
console.log(parking.removeCar("TX3691CA"));

// Corresponding output
// The Volvo t600, with a registration number TX3691CA, parked.
// The Parking Lot has 11 empty spots left.
// Volvo t600 == TX3691CA - Not payed
// TX3691CA's driver successfully payed for his stay.
// TX3691CA left the parking lot.

