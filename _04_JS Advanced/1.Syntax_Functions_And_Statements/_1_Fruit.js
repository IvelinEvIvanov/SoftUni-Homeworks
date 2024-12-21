function calculatePrice(friut, weight, money) {
    let kilos = weight / 1000;
    let totalPrice = kilos * money;

    return `I need $${totalPrice.toFixed(2)} to buy ${kilos.toFixed(2)} kilograms ${friut}.`;

}

console.log(calculatePrice('apple', 1563, 2.35));