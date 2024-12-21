const isOddOrEven = require('./2.EvenOrNot');
const { assert, expect, should } = require('chai');

describe('isOddOrEven tests',function(){
    it('Is String',function(){
        assert.isUndefined(isOddOrEven(123),undefined);
    });

    it('Is Even',function(){
        assert.equal(isOddOrEven('1234'),'even');
    });

    it('Is Odd',function(){
        assert.equal(isOddOrEven('123'),'odd');
    });
});