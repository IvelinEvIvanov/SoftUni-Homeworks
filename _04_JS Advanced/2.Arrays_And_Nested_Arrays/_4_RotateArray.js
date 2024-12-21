function solve(arr, counter) {
    let theArr = Array.from(arr);
    let firstElement = '';
    let lastElement = '';

    for (let index = 0; index < counter; index++) {
        lastElement = theArr.pop();
        theArr.unshift(lastElement);
    }

    console.log(theArr.join(' '));

}
