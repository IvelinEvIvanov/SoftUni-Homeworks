class Vacationer {
    constructor(arrFullname, arrCreditCard) {
        this.fullName = arrFullname;
        this.idNumber = this.generateIDNumber();
        this.creditCard = this.addCreditCardInfo(arrCreditCard);
        this.wishList = [];
    }

    get fullName() {
        return this._fullName;
    }

    /**
     * @param {Array} fullname
     */
    set fullName(fullname) {
        if (fullname.length < 3) {
            throw new Error('Name must include first name, middle name and last name');
        }

        let regexTemplate = /^[A-Z][a-z]+$/;

        for (const name of fullname) {
            if (!regexTemplate.test(name)) {
                throw new Error('Invalid full name');
            }
        }

        return this._fullName = {
            firstName: fullname[0],
            middleName: fullname[1],
            lastName: fullname[2]
        }

    }

    generateIDNumber() {
        let firstLetterASCIICode = this.fullName.firstName.charCodeAt(0);
        let middleNameLength = this.fullName.middleName.length;
        let lastLetter = this.fullName.lastName.charAt(this.fullName.lastName.length - 1);

        let idCode = (231 * firstLetterASCIICode) + (139 * middleNameLength);

        if (lastLetter === 'a' || lastLetter === 'e' || lastLetter === 'o' ||
            lastLetter === 'i' || lastLetter === 'u') {

            return '' + idCode + '8';
        } else {
            return '' + idCode + '8';
        }
    }

    /**
     * 
     * @param {Array} input 
     * 
     */
    addCreditCardInfo(input) {

        if (input != undefined && input.length < 3) {
            throw new Error('Missing credit card information');
        }

        const obj = {
            cardNumber: 0,
            expirationDate: "",
            securityNumber: 0
        };

        if (input === undefined) {
            obj.cardNumber = 1111;
            obj.securityNumber = 111;

            return obj;
        }

        if (typeof input[0] !== 'number' || typeof input[2] !== 'number') {
            throw new Error('Invalid credit card details');
        }

        obj.cardNumber = input[0];
        obj.expirationDate = input[1];
        obj.securityNumber = input[2];

        return obj;


    }

    /**
     * 
     * @param {string} destination 
     */
    addDestinationToWishList(destination) {

        if (this.wishList.length === 0) {
            this.wishList.push(destination);
        } else {
            if (this.wishList.includes(destination)) {
                throw new Error('Destination already exists in wishlist');
            }

            this.wishList.push(destination);
            this.wishList.sort((a, b) => a.length - b.length);
        }
    }

    getVacationerInfo() {
        const result = [];
        result.push(`Name: ${this.fullName.firstName} ${this.fullName.middleName} ${this.fullName.lastName}`);
        result.push(`ID number: ${this.idNumber}`);
        result.push('Wishlist:');

        if (this.wishList.length == 0) {
            result.push('empty');
        } else {
            result.push(this.wishList.join(', '));
        }

        result.push('Credit Card:');
        result.push(`Card Number: ${this.creditCard.cardNumber}`);
        result.push(`Expiration Date: ${this.creditCard.expirationDate}`);
        result.push(`Security Number: ${this.creditCard.securityNumber}`);

        return result.join('\n').trim();
    }
}

/*********************************************
                INPUT
*********************************************/
// Initialize vacationers with 2 and 3 parameters
let vacationer1 = new Vacationer(["Vania", "Ivanova", "Zhivkova"]);
let vacationer2 = new Vacationer(["Tania", "Ivanova", "Zhivkova"],
    [123456789, "10/01/2018", 777]);

// Should throw an error (Invalid full name)
try {
    let vacationer3 = new Vacationer(["Vania", "Ivanova", "ZhiVkova"]);
} catch (err) {
    console.log("Error: " + err.message);
}

// Should throw an error (Missing credit card information)
try {
    let vacationer3 = new Vacationer(["Zdravko", "Georgiev", "Petrov"]);
    vacationer3.addCreditCardInfo([123456789, "20/10/2018"]);
} catch (err) {
    console.log("Error: " + err.message);
}

vacationer1.addDestinationToWishList('Spain');
vacationer1.addDestinationToWishList('Germany');
vacationer1.addDestinationToWishList('Bali');

// Return information about the vacationers
console.log(vacationer1.getVacationerInfo());
console.log(vacationer2.getVacationerInfo());

// Corresponding output
// Error: Invalid full name

// Error: Missing credit card information

// Name: Vania Ivanova Zhivkova
// ID Number: 208398
// Wishlist:
// Bali, Spain, Germany
// Credit Card:
// Card Number: 1111
// Expiration Date:
// Security Number: 111

// Name: Tania Ivanova Zhivkova
// ID Number: 203778
// Wishlist:
// empty
// Credit Card:
// Card Number: 123456789
// Expiration Date: 10/01/2018
// Security Number: 777


