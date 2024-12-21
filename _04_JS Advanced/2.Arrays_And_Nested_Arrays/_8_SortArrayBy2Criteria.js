function solve(arr) {
    const theArr = Array.from(arr);
    theArr.sort(function (a, b) {
        let itemA = '' + a;
        let itemB = '' + b;

        let myLength = itemA.length - itemB.length;
        if (myLength < 0) {
            return -1;
        }

        if (myLength > 0) {
            return 1;
        }

        if (myLength === 0) {
            if (itemA.toLowerCase() < itemB.toLowerCase()) {
                return -1;
            }

            if (itemA.toLowerCase() > itemB.toLowerCase()) {
                return 1;
            }

            return 0;
        }
    });

    theArr.forEach(element => {
        console.log(element);
    });
}

solve(['test', 
'Deny', 
'omen', 
'Default']);