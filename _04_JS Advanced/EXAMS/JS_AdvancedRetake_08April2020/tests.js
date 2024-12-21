let { Repository } = require("./solution.js");
const { assert, expect, should } = require('chai');

/********* 
describe(" ", function() {
    
let properties = {
    name: "string",
    age: "number",
    birthday: "object"
};

let rep = new Repository(properties);

let entity = {
    name: "Pesho",
    age: 22,
    birthday: new Date(1998, 0, 7)
};

rep.add(entity); 

    it(" ", function() {
        
    });
 });
 **********/


describe("Tests", function () {

    /**@type {Repository} */
    let ref = {}

    beforeEach(() => ref = new Repository({
        name: 'string',
        age: 'number',
        birthday: 'object'
    }));

    describe('test get count prop', function () {

        it('count - 0', function () {
            assert.equal(ref.count, 0);

        });

    });

    describe('test add()', function () {

        it("working", function () {
            assert.equal(ref.add({
                name: "Pesho",
                age: 22,
                birthday: new Date(1998, 0, 7)
            }), 0);
        });
    });

    describe('test getId()', function () {

        it("error", function () {
            assert.throws(() => { ref.getId(1) });
        })
    });

    describe('test update', function () {

        it("error - id does not exist", function () {
            assert.throws(() => { ref.update(0, {}) });
        })

        it("error - property is missing", function () {
            ref.add({
                name: "Pesho",
                age: 22,
                birthday: new Date(1998, 0, 7)
            });

            assert.throws(() => {
                ref.update(0, {
                    age: 1,
                    birthday: { date: 0 }
                })
            });
        })

        it("error - name != string", function () {
            ref.add({
                name: "Pesho",
                age: 22,
                birthday: new Date(1998, 0, 7)
            });

            assert.throws(() => {
                ref.update(0, {
                    name: 1,
                    age: 1,
                    birthday: { date: 0 }
                })
            });
        })

        describe('test del()', function () {

            it("working", function () {
                ref.add({
                    name: "Pesho",
                    age: 22,
                    birthday: new Date(1998, 0, 7)
                });

                ref.add({
                    name: "Pesho",
                    age: 22,
                    birthday: new Date(1998, 0, 7)
                });

                ref.del(1);

                assert.equal(ref.data.has(1), false);
            })
        });

        it("error - index does not exist", function () {
            assert.throws(() => { ref.del(-1) });
        })

    });
});

/******
    describe('', function () {

       it("", function () {

        })
    });
 ******/
