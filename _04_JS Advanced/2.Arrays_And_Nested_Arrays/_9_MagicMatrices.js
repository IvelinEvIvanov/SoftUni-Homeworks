function solve(arr) {
    const $2dArr = Array.from(arr);
    let sum1 = 0;
    let sum2 = 0;




    if ($2dArr.length === $2dArr[0].length) {
        for (let rows = 0; rows < $2dArr.length; rows++) {
            for (let cols = 0; cols < $2dArr[0].length; cols++) {
                sum1 += $2dArr[rows][cols];
            }
            break;
        }


        for (let rows = 1; rows < $2dArr.length; rows++) {
            for (let cols = 0; cols < $2dArr[0].length; cols++) {
                sum2 += $2dArr[rows][cols];
            }

            if (sum1 !== sum2) {
                return false;
            }

            sum2 = 0;

        }

        return true;
    }

    return false;
}

console.log(solve([[1, 0, 0],
[0, 0, 1],
]));