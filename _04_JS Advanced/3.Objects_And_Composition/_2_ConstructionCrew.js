function solve(inputObj) {
    let temp = 0;
    let myObj = new Object(inputObj);

    for (const key in myObj) {
        if (myObj['dizziness'] === true) {
            temp = myObj['experience'] * 0.1;
            temp = temp * myObj['weight'];
            myObj['levelOfHydrated'] += temp;

            myObj['dizziness'] = false;

            temp = 0;
        }
    }
    return myObj;
}

solve({
    weight: 120,
    experience: 20,
    levelOfHydrated: 200,
    dizziness: true
});