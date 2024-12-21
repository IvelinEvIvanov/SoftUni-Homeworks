'use strict'



function doFunctions(arr) {
  sum(arr);
  sumInverse(arr);
  concat(arr);

  function sum(arr) {

    let result = 0;
    for (let index = 0; index < arr.length; index++) {
      result += arr[index];
    }

    console.log(result);

  }

  function sumInverse(arr) {
    let result = 0;
    for (let index = 0; index < arr.length; index++) {
      result += (1 / arr[index]);
    }

    console.log(result);
  }

  function concat(arr) {
    let result = "";
    for (let index = 0; index < arr.length; index++) {
      result += arr[index];
    }

    console.log(result);
  }
}

doFunctions([1,2,3]);


