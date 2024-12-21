function add(num) {
    let sum = num;

    function calc(num2) {
        sum += num2;
        return calc;
    }

    calc.toString = function () { return sum };
    return calc;
}


/**
 *
 *  let add = (function () {
    let total = 0;
    return function sum(a) {
        total += a;
        sum.toString = () => total;
        return sum;
    }
})();
*/

console.log(add(1)(6)(-3).toString());