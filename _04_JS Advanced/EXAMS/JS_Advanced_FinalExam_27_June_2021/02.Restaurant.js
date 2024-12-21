class Restaurant {
    constructor(budget) {
        /**@type {Number} */
        this.budgetMoney = Number(budget);

        /**@type {Object} */
        this.menu = {};

        /**@type {Object} */
        this.stockProducts = {};

        /**@type {Array} */
        this.history = [];
    }

    /**
     * 
     * @param {Array} input 
     */
    loadProducts(input) {
        if (!this.stockProducts.hasOwnProperty('products')) {
            this.stockProducts.products = [];
        }


        for (let index = 0; index < input.length; index++) {

            let [productName, productQuantity, productTotalPrice] = input[index].split(' ');


            let obj = {
                productName: productName,
                productQuantity: Number(productQuantity),
                productTotalPrice: Number(productTotalPrice)
            }

            if (obj.productTotalPrice <= this.budgetMoney) {
                let existedProduct = this.stockProducts.products.find(el => el.productName === productName);
                if (existedProduct) {
                    existedProduct.productQuantity += productQuantity;
                    this.budgetMoney -= obj.productTotalPrice;
                    this.history.push(`Successfully loaded ${productQuantity} ${productName}`);
                } else {
                    this.stockProducts.products.push(obj);
                    this.budgetMoney -= obj.productTotalPrice;

                    this.history.push(`Successfully loaded ${productQuantity} ${productName}`);
                }
            } else {
                this.history.push(`There was not enough money to load ${productQuantity} ${productName}`);
            }

        }

        return this.history.join('\n');
    }

    /**
     * 
     * @param {string} meal 
     * @param {Array} products 
     * @param {Number} price 
     */
    addToMenu(meal, products, price) {
        if (!this.menu.hasOwnProperty('meals')) {
            this.menu.meals = [];
        }


        let obj = {};
        obj['meal'] = meal;
        obj['products'] = [];
        for (let index = 0; index < products.length; index++) {

            let existedMeal = Object.values(this.menu).includes(meal);
            if (existedMeal) {
                return `The ${meal} is already in the our menu, try something different.`;
            }


            let [productName, productQuantity] = products[index].split(' ');

            let obj1 = {};
            obj1['productName'] = productName;
            obj1['productQuantity'] = Number(productQuantity);

            obj.products.push(obj1);

        }

        obj['price'] = Number(price);

        this.menu.meals.push(obj);

        let mealsCount = this.menu.meals.length;
        if (mealsCount === 1) {
            return `Great idea! Now with the ${meal} we have 1 meal in the menu, other ideas?`;
        }

        return `Great idea! Now with the ${meal} we have ${mealsCount} meals in the menu, other ideas?`;
    }

    showTheMenu() {
        let menuCounter = 0;
        if (this.menu.hasOwnProperty('meals')) {
            menuCounter = this.menu.meals.length;

            let menuResult = [];
            for (let index = 0; index < this.menu.meals.length; index++) {
                menuResult.push(`${this.menu.meals[index].meal} - $ ${this.menu.meals[index].price}`);
            }

            return menuResult.join('\n');
        }

        if (!this.menu.hasOwnProperty('meals') || menuCounter === 0) {
            return `Our menu is not ready yet, please come later...`;
        }
    }

    makeTheOrder(meal) {
        let existedMeal = '';
        if (this.menu.hasOwnProperty('meals')) {
            let mealsArr = this.menu.meals;
            for (let index = 0; index < mealsArr.length; index++) {
                if (mealsArr[index].meal === meal) {
                    existedMeal = mealsArr[index];
                    break;
                }
            }
        }

        if (existedMeal === '') {
            return `There is not ${meal} yet in our menu, do you want to order something else?`;
        }

        let loadedProducts = this.stockProducts.products;
        let orderProducts = existedMeal.products;


        for (let index = 0; index < orderProducts.length; index++) {
            if (!loadedProducts.some(el => orderProducts[index].productName === el.productName)) {
                return `For the time being, we cannot complete your order (${meal}), we are very sorry...`;
            }
        }

        this.budgetMoney += existedMeal.price;

        for (let index = 0; index < loadedProducts.length; index++) {
            for (let index1 = 0; index1 < orderProducts.length; index1++) {
                if (loadedProducts[index].productName === orderProducts[index1].productName) {
                    loadedProducts[index].productQuantity -= orderProducts[index1].productQuantity;
                    continue;
                }
            }
        }

        return `Your order (${meal}) will be completed in the next 30 minutes and will cost you ${existedMeal.price}.`;
    }
}

let kitchen = new Restaurant(1000);
kitchen.loadProducts(['Yogurt 30 3', 'Honey 50 4', 'Strawberries 20 10', 'Banana 5 1']);
kitchen.addToMenu('frozenYogurt', ['Yogurt 1', 'Honey 1', 'Banana 1', 'Strawberries 10'], 9.99);
console.log(kitchen.makeTheOrder('frozenYogurt'));

//let kitchen = new Restaurant(1000);
//console.log(kitchen.loadProducts(['Banana 10 5', 'Banana 20 10', 'Strawberries 50 30', 'Yogurt 10 10', 'Yogurt 500 1500', 'Honey 5 50']));

// Successfully loaded 10 Banana
// Successfully loaded 20 Banana
// Successfully loaded 50 Strawberries
// Successfully loaded 10 Yogurt
// There was not enough money to load 500 Yogurt
// Successfully loaded 5 Honey

// let kitchen = new Restaurant(1000);
// console.log(kitchen.addToMenu('frozenYogurt', ['Yogurt 1', 'Honey 1', 'Banana 1', 'Strawberries 10'], 9.99));
// console.log(kitchen.addToMenu('Pizza', ['Flour 0.5', 'Oil 0.2', 'Yeast 0.5', 'Salt 0.1', 'Sugar 0.1', 'Tomato sauce 0.5', 'Pepperoni 1', 'Cheese 1.5'], 15.55));
// console.log(kitchen.showTheMenu());
//Great idea! Now with the frozenYogurt we have 1 meal in the menu, other ideas?
//Great idea! Now with the Pizza we have 2 meals in the menu, other ideas?