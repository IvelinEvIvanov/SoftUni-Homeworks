const { assert, expect, should } = require('chai');
const ChristmasMovies = require('./02. Christmas Movies_Resources');

/********* 
describe("TODO …", function() {
    it("TODO …", function() {
        // TODO: …
    });
 });
 **********/

describe("Tests …", function () {

    describe("test buyMovie()", function () {

        it("buyMovie() - error", function () {
            let christmas = new ChristmasMovies();
            christmas.buyMovie('Home Alone', ['Macaulay Culkin', 'Joe Pesci', 'Daniel Stern']);

            assert.throws(() => { christmas.buyMovie('Home Alone', ['Macaulay Culkin', 'Joe Pesci', 'Daniel Stern']); });

        });

        it("buyMovie() - working", function () {
            let christmas = new ChristmasMovies();


            assert.equal('You just got Home Alone to your collection in which Macaulay Culkin, Joe Pesci, Daniel Stern are taking part!',
                christmas.buyMovie('Home Alone', ['Macaulay Culkin', 'Joe Pesci', 'Daniel Stern']));

        });
    });

    describe("test discardMovie()", function () {

        it("discardMovie() - error no movie", function () {
            let christmas = new ChristmasMovies();
            christmas.buyMovie('Home Alone', ['Macaulay Culkin', 'Joe Pesci', 'Daniel Stern']);

            assert.throws(() => { christmas.discardMovie('movie') });
        });

        it("discardMovie() - error not watched", function () {
            let christmas = new ChristmasMovies();
            christmas.buyMovie('Home Alone', ['Macaulay Culkin', 'Joe Pesci', 'Daniel Stern']);

            assert.throws(() => { christmas.discardMovie('Home Alone') });
        });

        it("discardMovie() - watched", function () {
            let christmas = new ChristmasMovies();
            christmas.buyMovie('Home Alone', ['Macaulay Culkin', 'Joe Pesci', 'Daniel Stern']);
            christmas.watchMovie('Home Alone');


            assert.equal(`You just threw away Home Alone!`, christmas.discardMovie('Home Alone'));
        });

    });

    describe("test watchMovie()", function () {

        it("watchMovie() - error", function () {
            let christmas = new ChristmasMovies();
            christmas.buyMovie('Home Alone', ['Macaulay Culkin', 'Joe Pesci', 'Daniel Stern']);

            assert.throws(() => { christmas.watchMovie('movie') });
        });

        it("watchMovie() - working for first watch", function () {
            let christmas = new ChristmasMovies();
            christmas.buyMovie('Home Alone', ['Macaulay Culkin', 'Joe Pesci', 'Daniel Stern']);

            christmas.watchMovie('Home Alone');
            assert.equal(1, christmas.watched['Home Alone']);

        });

        it("watchMovie() - working for same movie watched", function () {
            let christmas = new ChristmasMovies();
            christmas.buyMovie('Home Alone', ['Macaulay Culkin', 'Joe Pesci', 'Daniel Stern']);

            christmas.watchMovie('Home Alone');
            christmas.watchMovie('Home Alone');
            assert.equal(2, christmas.watched['Home Alone']);

        });
    });

    describe("test favouriteMovie()", function () {

        it("favouriteMovie() - error", function () {
            let christmas = new ChristmasMovies();
            christmas.buyMovie('Home Alone', ['Macaulay Culkin', 'Joe Pesci', 'Daniel Stern']);

            assert.throws(() => { christmas.favouriteMovie() });
        });

        it("favouriteMovie() - working", function () {
            let christmas = new ChristmasMovies();
            christmas.buyMovie('Home Alone', ['Macaulay Culkin', 'Joe Pesci', 'Daniel Stern']);
            christmas.buyMovie('Home Alone 2', ['Macaulay Culkin']);
            christmas.buyMovie('Last Christmas', ['Emilia Clarke', 'Henry Golding']);
            christmas.buyMovie('The Grinch', ['Benedict Cumberbatch', 'Pharrell Williams']);

            christmas.watchMovie('Home Alone');
            christmas.watchMovie('Home Alone');
            christmas.watchMovie('Home Alone');
            christmas.watchMovie('Home Alone 2');

            assert.equal(`Your favourite movie is Home Alone and you have watched it 3 times!`,
                christmas.favouriteMovie());
        });
    });

    describe("mostStarredActor()", function () {

        it("mostStarredActor() - error", function () {
            let christmas = new ChristmasMovies();

            assert.throws(() => { christmas.mostStarredActor() });
        });

        it("mostStarredActor() - erworkingror", function () {
            let christmas = new ChristmasMovies();
            christmas.buyMovie('Home Alone', ['Macaulay Culkin', 'Joe Pesci', 'Daniel Stern']);
            christmas.buyMovie('Home Alone 2', ['Macaulay Culkin']);
            christmas.buyMovie('Last Christmas', ['Emilia Clarke', 'Henry Golding']);

            assert.equal(christmas.mostStarredActor(), 'The most starred actor is Macaulay Culkin and starred in 2 movies!');
        });
    });
});


