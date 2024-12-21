const f = (function () {
    let counter = 0;
    return function () {
        console.log(++counter);
    }
})();

console.log(f());