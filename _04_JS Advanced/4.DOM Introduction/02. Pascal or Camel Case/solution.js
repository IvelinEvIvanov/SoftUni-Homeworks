function solve() {
  let input = document.getElementById('text').value;
  let currentCase = document.getElementById('naming-convention').value;

  let temp = new String(input);
  temp = temp.toLowerCase();
  temp = temp.split(/\s+/);

  let result;

  if (currentCase === 'Camel Case') {
    result = temp.reduce(function (prev, current, index, arr) {
      if (index === 0) {
        prev += current;
      } else {
        prev += current[0].toUpperCase();
        prev += current.slice(1);

      }

      return prev;
    }, '');
  } else if (currentCase === 'Pascal Case') {
    result = temp.reduce(function (prev, current) {
      prev += current[0].toUpperCase();
      prev += current.slice(1);;
      return prev;
    }, '');
  } else {
    result = 'Error!'
  }

  document.getElementById('result').textContent = result;

}