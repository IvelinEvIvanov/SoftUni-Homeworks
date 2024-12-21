
function solution() {

    const protein = { key: 'protein', val: 0 };
    const carbohydrate = { key: 'carbohydrate', val: 0 };
    const fat = { key: 'fat', val: 0 };
    const flavour = { key: 'flavour', val: 0 };


    const apple = [{ ...carbohydrate }, { ...flavour }];
    apple[0].val = 1;
    apple[1].val = 2;

    const lemonade = [{ ...carbohydrate }, { ...flavour }];
    lemonade[0].val = 10;
    lemonade[1].val = 20;

    const burger = [{ ...carbohydrate }, { ...fat }, { ...flavour }];
    burger[0].val = 5;
    burger[1].val = 7;
    burger[2].val = 3;

    const eggs = [{ ...protein }, { ...fat }, { ...flavour }];
    eggs[0].val = 5;
    eggs[1].val = 1;
    eggs[2].val = 1;

    const turkey = [{ ...protein }, { ...carbohydrate }, { ...fat }, { ...flavour }];
    turkey[0].val = 10;
    turkey[1].val = 10;
    turkey[2].val = 10;
    turkey[3].val = 10;

    const totalIngredients = [{ ...protein }, { ...carbohydrate }, { ...fat }, { ...flavour }];

    return function manager(input) {
        let tokens = new String(input).split(' ');

        if (tokens[0] === 'restock') {

            if (tokens[1] === 'protein') {
                totalIngredients[0].val += Number(tokens[2]);
                return 'Success';
            } else
                if (tokens[1] === 'carbohydrate') {
                    totalIngredients[1].val += Number(tokens[2]);
                    return 'Success';
                } else
                    if (tokens[1] === 'fat') {
                        totalIngredients[2].val += Number(tokens[2]);
                        return 'Success';
                    } else
                        if (tokens[1] === 'flavour') {
                            totalIngredients[3].val += Number(tokens[2]);
                            return 'Success';
                        }
        } else
            if (tokens[0] === 'prepare') {

                if (tokens[1] === 'apple') {

                    let countOfProduct = Number(tokens[2]);
                    if (((apple[0].val * countOfProduct) < totalIngredients[1].val) && ((apple[1].val * countOfProduct) < totalIngredients[3].val)) {

                        totalIngredients[1].val -= (apple[0].val * countOfProduct);
                        totalIngredients[3].val -= (apple[1].val * countOfProduct);

                        return 'Success';
                    } else {
                        let notEnoughIngredient = '';
                        if ((apple[0].val * countOfProduct) > totalIngredients[1].val) {
                            notEnoughIngredient = apple[0].key;
                        } else {
                            notEnoughIngredient = apple[1].key;
                        }

                        return `Error: not enough ${notEnoughIngredient} in stock`;
                    }
                } else
                    if (tokens[1] === 'lemonade') {

                        let countOfProduct = Number(tokens[2]);
                        if (((lemonade[0].val * countOfProduct) < totalIngredients[1].val) && ((lemonade[1].val * countOfProduct) < totalIngredients[3].val)) {

                            totalIngredients[1].val -= (lemonade[0].val * countOfProduct);
                            totalIngredients[3].val -= (lemonade[1].val * countOfProduct);

                            return 'Success';
                        } else {
                            let notEnoughIngredient = '';
                            if ((lemonade[0].val * countOfProduct) > totalIngredients[1].val) {
                                notEnoughIngredient = lemonade[0].key;
                            } else {
                                notEnoughIngredient = lemonade[1].key;
                            }

                            return `Error: not enough ${notEnoughIngredient} in stock`;
                        }
                    } else
                        if (tokens[1] === 'burger') {

                            let countOfProduct = Number(tokens[2]);
                            if (((burger[0].val * countOfProduct) < totalIngredients[1].val) &&
                                ((burger[1].val * countOfProduct) < totalIngredients[2].val) && ((burger[2].val * countOfProduct) < totalIngredients[3].val)) {

                                totalIngredients[1].val -= (burger[0].val * countOfProduct);
                                totalIngredients[2].val -= (burger[1].val * countOfProduct);
                                totalIngredients[3].val -= (burger[2].val * countOfProduct);

                                return 'Success';
                            } else {
                                let notEnoughIngredient = '';
                                if ((burger[0].val * countOfProduct) > totalIngredients[1].val) {
                                    notEnoughIngredient = burger[0].key;
                                } else if ((burger[1].val * countOfProduct) > totalIngredients[2].val) {
                                    notEnoughIngredient = burger[1].key;
                                } else {
                                    notEnoughIngredient = burger[2].key;
                                }

                                return `Error: not enough ${notEnoughIngredient} in stock`;
                            }

                        } else
                            if (tokens[1] === 'eggs') {

                                let countOfProduct = Number(tokens[2]);
                                if (((eggs[0].val * countOfProduct) < totalIngredients[0].val) &&
                                    ((eggs[1].val * countOfProduct) < totalIngredients[2].val) && ((eggs[2].val * countOfProduct) < totalIngredients[3].val)) {

                                    totalIngredients[0].val -= (eggs[0].val * countOfProduct);
                                    totalIngredients[2].val -= (eggs[1].val * countOfProduct);
                                    totalIngredients[3].val -= (eggs[2].val * countOfProduct);

                                    return 'Success';
                                } else {
                                    let notEnoughIngredient = '';
                                    if ((eggs[0].val * countOfProduct) > totalIngredients[0].val) {
                                        notEnoughIngredient = eggs[0].key;
                                    } else if ((eggs[1].val * countOfProduct) > totalIngredients[2].val) {
                                        notEnoughIngredient = eggs[1].key;
                                    } else {
                                        notEnoughIngredient = eggs[2].key;
                                    }

                                    return `Error: not enough ${notEnoughIngredient} in stock`;
                                }
                            } else
                                if (tokens[1] === 'turkey') {

                                    let countOfProduct = Number(tokens[2]);
                                    if (((turkey[0].val * countOfProduct) < totalIngredients[0].val) &&
                                        ((turkey[1].val * countOfProduct) < totalIngredients[1].val) &&
                                        ((turkey[2].val * countOfProduct) < totalIngredients[2].val) &&
                                        ((turkey[3].val * countOfProduct) < totalIngredients[3].val)) {

                                        totalIngredients[0].val -= (turkey[0].val * countOfProduct);
                                        totalIngredients[1].val -= (turkey[1].val * countOfProduct);
                                        totalIngredients[2].val -= (turkey[2].val * countOfProduct);
                                        totalIngredients[3].val -= (turkey[3].val * countOfProduct);

                                        return 'Success';
                                    } else {
                                        let notEnoughIngredient = '';
                                        if ((turkey[0].val * countOfProduct) > totalIngredients[0].val) {
                                            notEnoughIngredient = turkey[0].key;
                                        } else if ((turkey[1].val * countOfProduct) > totalIngredients[1].val) {
                                            notEnoughIngredient = turkey[1].key;
                                        } else if ((turkey[2].val * countOfProduct) > totalIngredients[2].val) {
                                            notEnoughIngredient = turkey[2].key;
                                        }
                                        else {
                                            notEnoughIngredient = turkey[3].key;
                                        }

                                        return `Error: not enough ${notEnoughIngredient} in stock`;
                                    }
                                }
            } else if (tokens[0] === 'report') {
                return `protein=${totalIngredients[0].val} carbohydrate=${totalIngredients[1].val} fat=${totalIngredients[2].val} flavour=${totalIngredients[3].val}`;
            }

    }

}

let manager = solution();

console.log(manager("prepare turkey 1"));
console.log(manager("prepare lemonade 4"));

/**
 * function solution() {

    let supplies = { protein: 0, carbohydrate: 0, fat: 0, flavour: 0 }

    let foodRecipes = {
        apple: { protein: 0, carbohydrate: 1, fat: 0, flavour: 2 },
        lemonade: { protein: 0, carbohydrate: 10, fat: 0, flavour: 20 },
        burger: { protein: 0, carbohydrate: 5, fat: 7, flavour: 3 },
        eggs: { protein: 5, carbohydrate: 0, fat: 1, flavour: 1 },
        turkey: { protein: 10, carbohydrate: 10, fat: 10, flavour: 10 },
        cookRecipe(recipe, quantity) {

            let deductedQuantity = {};

            for (const value in this[recipe]) {
                if (this[recipe][value] * quantity > supplies[value]) {
                    return `Error: not enough ${value} in stock`;
                }
                deductedQuantity[value] = supplies[value] - this[recipe][value] * quantity;
            }

            Object.assign(supplies, deductedQuantity);
            return 'Success';

        }
    }

    return controller = (str) => {

        if (str.includes('restock')) {
            let [, nutrient, quantity] = str.split(' ');
            supplies[nutrient] += Number(quantity);
            return 'Success';
        }

        if (str.includes('prepare')) {
            let [, recipe, quantity] = str.split(' ');
            return foodRecipes.cookRecipe(recipe, Number(quantity));
        }

        return `protein=${supplies.protein} carbohydrate=${supplies.carbohydrate} fat=${supplies.fat} flavour=${supplies.flavour}`;

    }

}
 */
