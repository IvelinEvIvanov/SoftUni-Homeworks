function solve(arr) {

    let theArr = Array.from(arr);
    theArr.sort((a, b) => a - b);

    let resultArr = [];

    while (theArr.length>0) {
        resultArr.push(theArr.shift());

        if(theArr.length!=0){
            resultArr.push(theArr.pop());
        }
    }

    return resultArr;

}

console.log(solve([1, 65, 3, 52, 48, 63, 31, -3, 18]));