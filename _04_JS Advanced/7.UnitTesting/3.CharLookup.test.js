const lookupChar = require('./3.CharLookup');
const { assert, expect, should } = require('chai');

describe('lookupChar test', function () {
    it('first parameter is NOT a string', function () {
        assert.equal(lookupChar(1, 2), undefined);
    });

    it('second parameter is NOT a number', function () {
        assert.equal(lookupChar('abc', '123'), undefined);
    });

    it('incorect index 1', function () {
        assert.equal(lookupChar('123', -1), 'Incorrect index');
    });

    it('incorect index 2', function () {
        assert.equal(lookupChar('123', 4), 'Incorrect index');
    });

    it('character at the specified index', function () {
        assert.equal(lookupChar('abc', 0), 'a');
    });
});

/**
 * describe("charLookup", function () {
    it(' should return undefined with a non-string as a first parameter', function () {
        expect(lookupChar(13, 0)).to.equal(undefined, "The function did not return correct result");
    });
    it('should return undefined with a non-number as a second parameter', function () {
        expect(lookupChar("test", "wrong")).to.equal(undefined, "The function did not return correct result");
    });
    it('should return undefined with a floating point number as a second parameter', function () {
        expect(lookupChar("test", 3.12)).to.equal(undefined, "The function did not return correct result");
    });
    it(' should return incorrect index with an incorrect index as a value', function () {
        expect(lookupChar("test", 13)).to.equal("Incorrect index", "The function did not return correct result");
    });
    it(' should return incorrect index with a negative index as a value', function () {
        expect(lookupChar("test", -1)).to.equal("Incorrect index", "The function did not return correct result");
    });
    it('with an index value equal to string length, should return incorrect index', function () {
        expect(lookupChar("pesho", 5)).to.equal("Incorrect index", "The function did not return correct result");
    });
    it(' should return incorrect index with an index equal to string length', function () {
        expect(lookupChar("test", 4)).to.equal("Incorrect index", "The function did not return correct result");
    });
    it('should return correct value with correct parameters', function () {
        expect(lookupChar("Rest", 0)).to.equal("R", "The function did not return correct result");
    });
    it('with correct parameters should return correct value', function () {
        expect(lookupChar("testing", 5)).to.equal("n", "The function did not return correct result");
    });
});
 */