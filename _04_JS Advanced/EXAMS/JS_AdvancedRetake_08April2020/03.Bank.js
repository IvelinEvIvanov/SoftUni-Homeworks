class Bank {
    
    constructor(bankName) {
        this._bankName = bankName;
        this.allCustomers = [];    
    }

    newCustomer(customer) {
        let isId = this.allCustomers.find(el => el.personalId === customer.personalId);
        if (isId !== undefined) {
            throw new Error(`${customer.firstName} ${customer.lastName} is already our customer!`);
        }

        this.allCustomers.push(customer);

        return customer;

    }

    depositMoney(personalId, amount) {

        /**@type {Bank} */
        let customer = this.allCustomers.find(el => el.personalId === personalId);
        if (customer === undefined) {
            throw new Error(`We have no customer with this ID!`);
        }

        customer.totalMoney = (customer.totalMoney || 0) + Number(amount);
        customer.transactions = customer.transactions || [];

        customer.transactions.push({
            number: customer.transactions.length + 1,
            names: `${customer.firstName} ${customer.lastName}`,
            type: 'deposit',
            amount: amount
        });

        return `${customer.totalMoney}$`;

    }

    withdrawMoney(personalId, amount) {

        let customer = this.allCustomers.find(el => el.personalId === personalId);
        if (customer === undefined) {
            throw new Error(`We have no customer with this ID!`);
        }

        customer.totalMoney = customer.totalMoney || 0;
        if (customer.totalMoney < amount) {
            throw new Error(`${customer.firstName} ${customer.lastName} does not have enough money to withdraw that amount!`);
        }


        customer.totalMoney -= amount;
        customer.transactions = customer.transactions || [];
        customer.transactions.push({
            number: customer.transactions.length + 1,
            names: `${customer.firstName} ${customer.lastName}`,
            type: 'withdrew',
            amount: amount
        });

        return `${customer.totalMoney}$`;
    }

    customerInfo(personalId) {
        let customer = this.allCustomers.find(el => el.personalId === personalId);
        if (customer === undefined) {
            throw new Error(`We have no customer with this ID!`);
        }



        let result = `Bank name: ${this._bankName}\n`;
        result += `Customer name: ${customer.firstName} ${customer.lastName}\n`;
        result += `Customer ID: ${customer.personalId}\n`;
        result += `Total Money: ${customer.totalMoney}$\n`;

        result += `Transactions:\n`;
        let reversed = customer.transactions.reverse();
        reversed.forEach(el => {
            result += '' + el.number + '. ';
            if (el.type === 'deposit') {
                result += `${el.names} made ${el.type} of ${el.amount}$!\n`;
            } else {
                result += `${el.names} ${el.type} of ${el.amount}$!\n`;
            }

        });

        result = result.replace(/\n*$/, "");

        return result;

    }
}

let bank = new Bank('SoftUni Bank');

console.log(bank.newCustomer({firstName: 'Svetlin', lastName: 'Nakov', personalId: 6233267}));
console.log(bank.newCustomer({firstName: 'Mihaela', lastName: 'Mileva', personalId: 4151596}));

bank.depositMoney(6233267, 250);
console.log(bank.depositMoney(6233267, 250));
bank.depositMoney(4151596,555);

console.log(bank.withdrawMoney(6233267, 125));

console.log(bank.customerInfo(6233267));

