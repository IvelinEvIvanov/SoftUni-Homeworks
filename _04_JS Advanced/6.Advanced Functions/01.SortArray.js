function solve(arr, param) {
    let myarr = Array.from(arr);

    const myfunc = function (n1, n2) {
        if (param === 'asc') {
            return n1 - n2;
        } else if (param === 'desc') {
            return n2 - n1
        }
    }

    let sortedResult = myarr.sort(myfunc);

    return sortedResult;
}

solve([14, 7, 17, 6, 8], '');