function calculator() {
    let operand_1;
    let operand_2;
    let result;


    return {
        init(num1,num2,res) {
            operand_1= document.querySelector(num1);
            operand_2 = document.querySelector(num2);
            result = document.querySelector(res);
        },
        add() {
            result.value = Number(operand_1.value) + Number(operand_2.value);
        },
        subtract() {
            result.value = Number(operand_1.value) - Number(operand_2.value);
        }

    }


}

const calculate = calculator();
calculate.init('#num1', '#num2', '#result');


