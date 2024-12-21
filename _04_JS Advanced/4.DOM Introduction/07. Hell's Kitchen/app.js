/*function solve() {
   document.querySelector('#btnSend').addEventListener('click', onClick);

   function onClick() {
      let input = document.getElementById('inputs');
      input = input.getElementsByTagName('textarea')[0].value;
      input = JSON.parse(input);

      let mapRestaurants = new Map();

      input.reduce(function (prev, current) {
         prev = current.split('-');

         let restaurantName = prev[0].trim();
         let workers = prev[1].trim();
         workers = workers.split(', ');

         if (!mapRestaurants.has(restaurantName)) {
            mapRestaurants.set(restaurantName, new Map());
         }

         let mapValue = mapRestaurants.get(restaurantName);
         for (let index = 0; index < workers.length; index++) {
            let workerName = workers[index].split(' ')[0];
            let salary = Number(workers[index].split(' ')[1]);

            mapValue.set(workerName, salary);

         }

         mapRestaurants.set(restaurantName, mapValue);
      }, []);//reduce

      let bestRestaurant = '';
      let bestAverageSalary = 0;

      for (let [keyNameOfRestaurant, valueWorkers] of mapRestaurants) {
         let counter = valueWorkers.size;
         let currentAverageSalary = 0;
         let tempAverageSalary = 0;
         bestRestaurant = keyNameOfRestaurant;

         for (let [keyWorkerName, valueWorkerSalary] of valueWorkers) {
            tempAverageSalary += valueWorkerSalary;
         }

         tempAverageSalary = tempAverageSalary / counter;
         if (tempAverageSalary > bestAverageSalary) {
            bestAverageSalary = tempAverageSalary;
            bestRestaurant = keyNameOfRestaurant;
         }

      }//for

      bestAverageSalary = bestAverageSalary.toFixed(2);

      let bestWorkers = mapRestaurants.get(bestRestaurant);
      bestWorkers = new Map([...bestWorkers.entries()].sort((w1, w2) => w2[1] - w1[1]));
      let bestWorkerSalary = bestWorkers.entries().next().value[1];

      let restaurant = document.getElementById('bestRestaurant');
      restaurant = restaurant.getElementsByTagName('p')[0];
      restaurant.textContent = `Name: ${bestRestaurant} Average Salary: ${bestAverageSalary} Best Salary: ${bestWorkerSalary.toFixed(2)}`;

      restaurant = document.getElementById('workers');
      restaurant = restaurant.getElementsByTagName('p')[0];
      restaurant.textContent="";

      for (let [keyName, valueSalary] of bestWorkers) {
         restaurant.textContent += `Name: ${keyName} With Salary: ${valueSalary} `;
      }
   }
}*/

function solve() {
   document.querySelector('#btnSend').addEventListener('click', onClick);

   function onClick() {
      let input = JSON.parse(document.querySelector('textarea').value);
      let bestRestaurantOutput = document.querySelector('#bestRestaurant p');
      let bestWorkersOutput = document.querySelector('#workers p');

      let restaurant = [0, 0, 0, 0];

      input.forEach(line => {
         line = line.match(/[^-,\s]+/g);
         let restaurantName = line.shift();
         let workers = line.filter(e => isNaN(e));
         let salaries = line.filter(e => !isNaN(e));

         if (restaurant[0] === restaurantName) {
            restaurant[2].push(...workers);
            restaurant[3].push(...salaries);
            restaurant[1] = calcAverageSalary(restaurant[3]);
         } else {
            let averageSalary = calcAverageSalary(salaries);
            if (averageSalary > restaurant[1]) {
               restaurant[0] = restaurantName;
               restaurant[1] = averageSalary;
               restaurant[2] = workers;
               restaurant[3] = salaries;
            }
         }
      });

      function calcAverageSalary(salaries) {
         return salaries.reduce((a, b) => Number(a) + Number(b)) / salaries.length;
      }
      function calcHighestSalary() {
         return Math.max.apply(null, restaurant[3]);
      }
      function sortSalaries() {
         let workersAndSalaries = {};
         restaurant[2].forEach((e, i) => {
            workersAndSalaries[e] = restaurant[3][i];
         });
         let sorted = Object.entries(workersAndSalaries).sort((a, b) => b[1] - a[1]);
         print(sorted);
      }
      sortSalaries();

      function print(sorted) {
         bestRestaurantOutput.textContent =
            `Name: ${restaurant[0]} Average Salary: ${(restaurant[1]).toFixed(2)} Best Salary: ${(calcHighestSalary()).toFixed(2)}`
         sorted.forEach(([name, salary]) => bestWorkersOutput.textContent += `Name: ${name} With Salary: ${salary} `);
      }
   }
}