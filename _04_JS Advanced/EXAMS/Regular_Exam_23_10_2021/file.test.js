let library = require("./library");
const { assert, expect, should } = require('chai');

describe('Tests', function () {

    describe("calcPriceOfBook", function () {

        it("typeof string - error", function () {
            assert.throws(() => { library.calcPriceOfBook(123, 123) });
        });

        it("typeof number - error", function () {
            assert.throws(() => { library.calcPriceOfBook('name', 'name1') });
        });

        it("year <= 1980", function () {
            let total = 20 - (20 * 0.5);

            assert.equal(library.calcPriceOfBook('Potter', 1979), `Price of ${'Potter'} is ${total.toFixed(2)}`);
        });

        it("year > 1980", function () {
            let total = 20;

            assert.equal(library.calcPriceOfBook('Potter', 1984), `Price of ${'Potter'} is ${total.toFixed(2)}`);
        });

    });

    describe("findBook", function () {
        it("arr - empty error", function () {
            assert.throws(() => { library.findBook([], 'Potter') });
        });

        it("no book - error", function () {
            assert.equal(library.findBook(['book1', 'book2', 'book3'], 'Potter'), 'The book you are looking for is not here!');
        });

        it("working - error", function () {
            assert.equal(library.findBook(['book1', 'Potter', 'book3'], 'Potter'), 'We found the book you want.');
        });

    });

    describe("arrangeTheBooks", function () {

        it("not a number - error", function () {
            assert.throws(() => { library.arrangeTheBooks('123') });
        });

        it("< 0 - error", function () {
            assert.throws(() => { library.arrangeTheBooks(-10) });
        });

        it("Great job, the books are arranged.", function () {
            assert.equal(library.arrangeTheBooks(30), 'Great job, the books are arranged.');
        });

        it("Insufficient space, more shelves need to be purchased.", function () {
            assert.equal(library.arrangeTheBooks(50), 'Insufficient space, more shelves need to be purchased.');
        });


    });

});