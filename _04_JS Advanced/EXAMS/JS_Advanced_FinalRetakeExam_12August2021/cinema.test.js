const cinema = require('./cinema');
const { assert, expect, should } = require('chai');

describe("Tests", function () {

    describe("showMovies", function () {
        it("arr.length == 0", function () {
            assert.equal(cinema.showMovies([]), 'There are currently no movies to show.');
        });

        it("working", function () {
            let arr = ['King Kong', 'The Tomorrow War', 'Joker'].join(', ');

            assert.equal(cinema.showMovies(['King Kong', 'The Tomorrow War', 'Joker']), arr);
        });

    });

     describe("ticketPrice", function() {
        it("error", function() {
            assert.throws(()=>{cinema.ticketPrice('asd')});
        });

        it("Premiere", function() {
           assert.equal(cinema.ticketPrice('Premiere'),12.00);
        });

        it("Normal", function() {
            assert.equal(cinema.ticketPrice('Normal'),7.50);
         });

         it("Discount", function() {
            assert.equal(cinema.ticketPrice('Discount'),5.50);
         });

     });

     describe("swapSeatsInHall", function() {
        it("only one passed parameter", function() {
            assert.equal(cinema.swapSeatsInHall(1),'Unsuccessful change of seats in the hall.');
        });

        it("not interger", function() {
            assert.equal(cinema.swapSeatsInHall(1,'asd'),'Unsuccessful change of seats in the hall.');
        });

        it("integer > capacity", function() {
            assert.equal(cinema.swapSeatsInHall(21,10),'Unsuccessful change of seats in the hall.');
        });

        it("seats < 0", function() {
            assert.equal(cinema.swapSeatsInHall(-1,10),'Unsuccessful change of seats in the hall.');
        });

        it("seats1 < 0", function() {
            assert.equal(cinema.swapSeatsInHall(5,-1),'Unsuccessful change of seats in the hall.');
        });

        it("seats == 0", function() {
            assert.equal(cinema.swapSeatsInHall(0,10),'Unsuccessful change of seats in the hall.');
        });

        it("seats == 0", function() {
            assert.equal(cinema.swapSeatsInHall(5,0),'Unsuccessful change of seats in the hall.');
        });

        
        it("working", function() {
            assert.equal(cinema.swapSeatsInHall(5,10),'Successful change of seats in the hall.');
            
        });
     });

});