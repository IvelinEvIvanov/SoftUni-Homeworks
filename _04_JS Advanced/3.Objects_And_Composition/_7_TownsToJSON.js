function solve(inputArr) {
    let arr = [];
    let temp = '';
    for (let index = 0; index < inputArr.length; index++) {
        temp = inputArr[index].slice(1, inputArr[index].length - 1).trim();
        arr.push(temp);
    }

    let result = [];
    temp = {};
    const myKeys = arr[0].split(' | ');
    let myValues = [];
    let myIndex=0;

    for (let index = 1; index < arr.length; index++) {
        myValues = arr[index].split(' | ');

        temp[myKeys[0]] = myValues[0];
        temp[myKeys[1]] = Number(Number(myValues[1]).toFixed(2));
        temp[myKeys[2]] = Number(Number(myValues[2]).toFixed(2));

        result.push(temp);

        temp={};
    }

    return JSON.stringify(result);
}

console.log(solve(['| Town | Latitude | Longitude |',
    '| Veliko Turnovo | 43.0757 | 25.6172 |',
    '| Monatevideo | 34.50 | 56.11 |']));
