function solve(pNumber, ...pArr) {

    number = pNumber;
    substract = 0;

    for (let index = 0; index < pArr.length; index++) {

        switch (pArr[index]) {
            case 'chop':
                number = number / 2;
                console.log(number);
                break;

            case 'dice':
                number = Math.sqrt(number);
                console.log(number);
                break;

            case 'spice':
                number += 1;
                console.log(number);
                break;

            case 'bake':
                number *= 3;
                console.log(number);
                break;

            case 'fillet':
                substract = number * 0.2;
                number -= substract;
                console.log(number);
                break;


        }

    }


}

solve('9', 'dice', 'spice', 'chop', 'bake', 'fillet');
