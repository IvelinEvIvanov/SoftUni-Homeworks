function solve(objArr, sorting) {

    class Ticket {
        constructor(destination, price, status) {
            this.destination = destination;
            this.price = price;
            this.status = status;
        }
    }


    let arr = Array.from(objArr);
    let result = [];


    let destination;
    let price;
    let status;

    for (let index = 0; index < arr.length; index++) {
        let tokens = arr[index].split('|');

        destination = tokens[0];
        price = Number(tokens[1]);
        status = tokens[2];

        result[index] = new Ticket(destination, price, status);
    }



    if (sorting == 'destination') {
        return result.sort(function (item1, item2) {
            if (item1.destination > item2.destination) {
                return 1;
            }

            if (item1.destination < item2.destination) {
                return -1;
            }

            if (item1.destination == item2.destination) {
                return 0;
            }
        });
    } else if (sorting == 'price') {
        return result.sort(function (item1, item2) {
            return item1.price - item2.price;
        });
    } else if (sorting == 'status') {
        return result.sort(function (item1, item2) {
            if (item1.status > item2.status) {
                return 1;
            }

            if (item1.status < item2.status) {
                return -1;
            }

            if (item1.status == item2.status) {
                return 0;
            }
        });
    }
}



console.log(solve(['Philadelphia|94.20|available',
    'New York City|95.99|available',
    'New York City|95.99|sold',
    'Boston|126.20|departed'],
    'status'));