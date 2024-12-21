class ChristmasDinner {
    constructor(budget) {
        this.setBudget = budget;
        this._dishes = [];
        this._products = [];
        this._guests = {};
    }

    set setBudget(value) {
        if (value < 0) {
            throw new Error("The budget cannot be a negative number");
        }

        this._budget = value;
    }

    /**
     * 
     * @param {Array} product 
     */
    shopping(product) {

        if (this._budget < product[1]) {
            throw new Error("Not enough money to buy this product");
        }

        this._budget -= product[1];
        this._products.push(product[0]);

        return `You have successfully bought ${product[0]}`;
    }

    /**
     * 
     * @param {Object} recipe 
     */
    recipes(recipe) {
        if (!recipe.productsList.every(el => this._products.includes(el))) {
            throw new Error("We do not have this product");
        }

        this._dishes.push(recipe);

        return `${recipe.recipeName} has been successfully cooked!`;

    }

    inviteGuests(name, dish) {


        if (!this._dishes.some(el => el.recipeName === dish)) {
            throw new Error("We do not have this dish");
        }

        for (name in this._guests) {
            throw new Error("This guest has already been invited");
        }

        this._guests[name] = dish;

        return `"You have successfully invited ${name}!"`;
    }

    showAttendance() {

        let output = [];

        for (const keyName in this._guests) {

            const theDish = this._dishes.find(el => el.recipeName === this._guests[keyName]);

            output.push(`${keyName} will eat ${theDish.recipeName}, which consists of ${theDish.productsList.join(', ')}`);


        }

        return output.join('\n').trim();
    }
}

let dinner = new ChristmasDinner(300);

dinner.shopping(['Salt', 1]);
dinner.shopping(['Beans', 3]);
dinner.shopping(['Cabbage', 4]);
dinner.shopping(['Rice', 2]);
dinner.shopping(['Savory', 1]);
dinner.shopping(['Peppers', 1]);
dinner.shopping(['Fruits', 40]);
dinner.shopping(['Honey', 10]);

dinner.recipes({
    recipeName: 'Oshav',
    productsList: ['Fruits', 'Honey']
});
dinner.recipes({
    recipeName: 'Folded cabbage leaves filled with rice',
    productsList: ['Cabbage', 'Rice', 'Salt', 'Savory']
});
dinner.recipes({
    recipeName: 'Peppers filled with beans',
    productsList: ['Beans', 'Peppers', 'Salt']
});

dinner.inviteGuests('Ivan', 'Oshav');
dinner.inviteGuests('Petar', 'Folded cabbage leaves filled with rice');
dinner.inviteGuests('Georgi', 'Peppers filled with beans');

console.log(dinner.showAttendance());