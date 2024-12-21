const numberOperations = require('./03. Number Operations_Resources');
const { assert, expect, should } = require('chai');

describe("Tests …", function () {

    describe("powNumber", function () {

        it("the function returns the power of the given number", function () {
            assert.equal(numberOperations.powNumber(5), 25);
        });

    });

    describe("numberChecker", function () {

        it('If the input is not a number the function throws an error', function () {
            assert.throw(() => { numberOperations.numberChecker('asd') }, Error, 'The input is not a number!');
        });

        it('The number is lower than 100!', function () {
            assert.equal(numberOperations.numberChecker(1), 'The number is lower than 100!');
        });

        it('The number is greater or equal to 100!', function () {
            assert.equal(numberOperations.numberChecker(100), 'The number is greater or equal to 100!');
        });
    });

    describe("sumArrays", function () {
        it('Sum of the two arrays by indexes!', function () {
            let arr1 = [1, 2, 3, 4, 5];
            let arr2 = [1, 2, 3];

            let arr = numberOperations.sumArrays(arr1, arr2);

            assert.deepEqual(arr, [2, 4, 6, 4, 5]);
        });
    });
});