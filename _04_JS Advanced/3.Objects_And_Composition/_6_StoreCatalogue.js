function solve(input) {

  let myMap = new Map();
  for (let itrInput of input) {
    let tokens = itrInput.split(' : ');
    let [product, price] = [tokens[0], Number(tokens[1])];

    let myChar = tokens[0].charAt(0);
    let objArr = [];
    let myObj = {};

    if (!myMap.has(myChar)) {

      //myObj[tokens[0]] = tokens[1];
      //objArr.push(myObj);

      myMap.set(myChar, []);
    }
    //let temp = myMap.get(myChar);
    //myObj[tokens[0]] = tokens[1];

    //temp.push(myObj);

    //myMap.set(myChar, temp);

    myMap.get(myChar).push({ title: product, value: price });

  }

  function customComparator(productA, productB) {
    return productA.title.toLowerCase().localeCompare(productB.title.toLowerCase());
  }

  let sortedCategories = [...myMap.keys()].sort();

  for (let category of sortedCategories) {
    console.log(category);

    let products = myMap.get(category).sort(customComparator);
    products.forEach(p => console.log(`  ${p.title}: ${p.value}`));
  }

  /*myMap = new Map([...myMap.entries()].sort());

  let arrKeys = Array.from(myMap.keys());
  let index = 0;

  for (let arr of myMap.values()) {

    for (let obj of arr) {
      for (const key in obj) {
        console.log(`  ${key}: ${obj[key]}`);
      }
    }
  }*/

}

solve(['Appricot : 20.4',
  'Apple : 1.25',
  'Fridge : 1500',
  'Anti-Bug Spray : 15',
  'TV : 1499',
  'Deodorant : 10',
  'Boiler : 300',
  'T-Shirt : 10']);