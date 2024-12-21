const testNumbers = require('./03.TestNumbers');
const { assert, expect, should } = require('chai');

describe("Tests", function () {

    describe("sumNumbers", function () {
        it("sumNumbers - are not numbers", function () {
            let num1 = '123';
            let num2 = 'asd';

            let num3 = 123

            assert.equal(testNumbers.sumNumbers(num1, num2), undefined);
            assert.equal(testNumbers.sumNumbers(num1, num3), undefined);
        });

        it("sumNumbers - positive", function () {
            assert.equal(testNumbers.sumNumbers(1, 1.567), 2.57);

        });

        it("sumNumbers - negative", function () {
            assert.equal(testNumbers.sumNumbers(-1, 1.567), 0.57);

        });
    });

    describe("numberChecker", function () {
        it("numberChecker - isNaN", function () {
            assert.throws(() => { testNumbers.numberChecker('adsa') });
        });

        it("numberChecker - even", function () {
           assert.equal(testNumbers.numberChecker(2),'The number is even!')
           assert.equal(testNumbers.numberChecker(-2),'The number is even!')
        });

        it("numberChecker - odd", function () {
            assert.equal(testNumbers.numberChecker(3),'The number is odd!')
         });
    });

     describe("averageSumArray", function() {
        it("averageSumArray - positive array", function() {
           assert.equal(testNumbers.averageSumArray([1,2,3]),2);
        });

        it("averageSumArray - negative number array", function() {
            assert.equal(testNumbers.averageSumArray([-1,2,3]),1.3333333333333333);
         });

         it("averageSumArray - float number array", function() {
            assert.equal(testNumbers.averageSumArray([1.5,2,3]),2.1666666666666666666666666666667);
         });
     });

});
