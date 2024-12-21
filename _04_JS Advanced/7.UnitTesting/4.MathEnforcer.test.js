const mathEnforcer = require('./4.MathEnforcer');
const { assert, expect, should } = require('chai');

describe('mathEnforcer', function () {

    describe('addFive', function () {
        it('not a number', function () {
            assert.equal(mathEnforcer.addFive('123'), undefined);
        });

        it('working', function () {
            assert.equal(mathEnforcer.addFive(5), 10);
        });

        it('working with negative number', function () {
            assert.equal(mathEnforcer.addFive(-1), 4);
        });

        it('working with float number', function () {
            assert.closeTo(mathEnforcer.addFive(5.01), 10.01, 0.01);
        });

    });

    describe('subtractTen', function () {
        it('not a number', function () {
            assert.equal(mathEnforcer.subtractTen('123'), undefined);
        });

        it('working', function () {
            assert.equal(mathEnforcer.subtractTen(20), 10);
        });

        it('working with negative number', function () {
            assert.equal(mathEnforcer.subtractTen(-1), -11);
        });

        it('working with float number', function () {
            assert.closeTo(mathEnforcer.subtractTen(10.01), 0.009999999999999787, 0.01);
        });

    });

    describe('sum', function () {
        it('not a number num1', function () {
            assert.equal(mathEnforcer.sum('123', 1), undefined);
        });

        it('not a number num2', function () {
            assert.equal(mathEnforcer.sum(1, '123'), undefined);
        });

        it('working', function () {
            assert.equal(mathEnforcer.sum(5, 5), 10);
        });

        it('working with negative number num1', function () {
            assert.equal(mathEnforcer.sum(-1, 3), 2);
        });

        it('working with negative number num2', function () {
            assert.equal(mathEnforcer.sum(3, -2), 1);
        });

        it('working with float num1', function () {
            assert.closeTo(mathEnforcer.sum(1, 1.01), 2.01, 0.01);
        });

        it('working with float num2', function () {
            assert.closeTo(mathEnforcer.sum(1.01, 1), 2.01, 0.01);
        });
    });
});

/**
 * describe("mathEnforcer", function () {
   describe('addFive', function () {
      it("should return undefined for non-number parameter",function () {
          expect(mathEnforcer.addFive("5")).to.be.equal(undefined);
      });
       it("should return correct result for positive integer parameter", function () {
           expect(mathEnforcer.addFive(10)).to.be.equal(15);
       });
       it("should return correct result for negative integer parameter", function () {
           expect(mathEnforcer.addFive(-5)).to.be.equal(0);
       });
       it("should return correct result for floating point parameter", function () {
           expect(mathEnforcer.addFive(3.14)).to.be.closeTo(8.14, 0.01);
       });
   });

    describe('subtractTen', function () {
        it("should return undefined for non-number parameter",function () {
            expect(mathEnforcer.subtractTen("5")).to.be.equal(undefined);
        });
        it("should return correct result for positive integer parameter", function () {
            expect(mathEnforcer.subtractTen(10)).to.be.equal(0);
        });
        it("should return correct result for negative integer parameter", function () {
            expect(mathEnforcer.subtractTen(-5)).to.be.equal(-15);
        });
        it("should return correct result for floating point parameter", function () {
            expect(mathEnforcer.subtractTen(3.14)).to.be.closeTo(-6.86, 0.01);
        });
    });

    describe('sum', function () {
        it("should return undefined for non-number first parameter", function () {
            expect(mathEnforcer.sum("5", 5)).to.be.equal(undefined);
        });
        it("should return undefined for non-number second parameter", function () {
            expect(mathEnforcer.sum(5, "5")).to.be.equal(undefined);
        });
        it("should return correct result for integer parameters", function () {
            expect(mathEnforcer.sum(5, -3)).to.be.equal(2);
        });
        it("should return correct result for floating point parameters", function () {
            expect(mathEnforcer.sum(2.7, 3.4)).to.be.closeTo(6.1, 0.01);
        })
    })
});
 */