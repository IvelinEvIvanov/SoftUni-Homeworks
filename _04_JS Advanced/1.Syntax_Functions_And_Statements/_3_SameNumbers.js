function findIfDigitsAreSame(num) {

    console.log(areSame(num));
    console.log(getSum(num));


    function areSame(num) {

        var first = num % 10;
        while (num) {
            if (num % 10 !== first) {
                return false;
            }

            num = Math.floor(num / 10);
        }
        return true;
    }

    function getSum(num) {
        
        let sum = 0;
        while (num) {
            sum += num % 10;
            num = Math.floor(num / 10);
        }
        return sum;
    }
}

