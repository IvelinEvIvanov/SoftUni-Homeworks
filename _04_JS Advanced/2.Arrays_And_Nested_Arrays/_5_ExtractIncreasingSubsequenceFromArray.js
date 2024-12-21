function solve(arr) {
    const theArr = Array.from(arr);


    for (let index = 0; index < theArr.length - 1; index++) {

        if (!(theArr[index] <= theArr[index + 1])) {
            theArr.splice(index + 1, 1);
            index--;
        }

    }

    return theArr;

}

