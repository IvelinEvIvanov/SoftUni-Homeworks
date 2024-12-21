const pizzUni = require('./pizza');
const { assert, expect, should } = require('chai');


describe("Tests …", function () {

    describe("makeAnOrder()", function () {

        it("makeAnOrder() - error", function () {
            let obj = {};
            assert.throws(() => { pizzUni.makeAnOrder(obj) });
        });

        it("makeAnOrder() - only drink", function () {
            let obj = {
                orderedDrink: 'mydrink'
            };
            assert.throws(() => { pizzUni.makeAnOrder(obj) });
        });

        it("makeAnOrder() - full order", function () {
            let obj = {
                orderedPizza: 'mypizza',
                orderedDrink: 'mydrink'
            }
            assert(pizzUni.makeAnOrder(obj), `You just ordered ${obj.orderedPizza}  and ${obj.orderedDrink}.`);
        });

        it("makeAnOrder() - only pizza", function () {
            let obj = {
                orderedPizza: 'mypizza'
            }
            assert(pizzUni.makeAnOrder(obj), `You just ordered ${obj.orderedPizza}`);
        });
    });

    describe("getRemainingWork()", function () {


        it("getRemainingWork() - still preparing", function () {
            let statusArr = [{
                pizzaName: 'mypizza',
                status: 'preparing'
            }];

            const remainingArr = statusArr.filter(s => s.status != 'ready');

            let pizzaNames = remainingArr.map(p => p.pizzaName).join(', ');
            let pizzasLeft = `The following pizzas are still preparing: ${pizzaNames}.`;

            assert.equal(pizzUni.getRemainingWork(statusArr), pizzasLeft);

        });


        it("getRemainingWork() - no orders", function () {
            let statusArr = [{
                pizzaName: 'mypizza',
                status: 'ready'
            }];

            const remainingArr = statusArr.filter(s => s.status != 'ready');

            let pizzaNames = remainingArr.map(p => p.pizzaName).join(', ');
            let pizzasLeft = `The following pizzas are still preparing: ${pizzaNames}.`;

            assert.equal(pizzUni.getRemainingWork(statusArr), 'All orders are complete!');
        });

        it("getRemainingWork() - all ready", function () {
            let statusArr = [];
            assert.equal(pizzUni.getRemainingWork(statusArr), 'All orders are complete!');
        });

    });

    describe("orderType()", function () {

        it("orderType - Carry Out", function () {
            let totalSum = 10;
            let typeOfOrder = 'Carry Out';

            assert.equal(pizzUni.orderType(totalSum, typeOfOrder), totalSum -= (totalSum * 0.1));
        });

        it("orderType - Delivery", function () {
            let totalSum = 10;
            let typeOfOrder = 'Delivery';

            assert.equal(pizzUni.orderType(totalSum, typeOfOrder), totalSum);
        });
    });

});

/***
 describe("TODO …", function() {

        it("TODO …", function() {
            // TODO: …
        });
     });

 */