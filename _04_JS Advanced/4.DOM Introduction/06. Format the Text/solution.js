function solve() {
  let mydiv = document.getElementById('output');
  let textArr = document.getElementById('input').innerHTML.split('.');
  delete textArr[textArr.length - 1];

  let counter = 0;
  let result = '';
  for (let index = 0; index < textArr.length; index++) {

    if (textArr.length <= 3) {
      result += (textArr[index] + '.');
      continue;
    }

    if (++counter === 3) {
      result += (textArr[index] + '.');
      mydiv.innerHTML = `<p>${result}</p>`;
      counter = 0;
      continue;
    }

    result += (textArr[index] + '.');

  }//for

  if (textArr.length <= 3) {
    mydiv.innerHTML = `<p>${result}</p>`;
  } else if (textArr.length % 3 != 0) {
    mydiv.innerHTML = `<p>${result}</p>`;
  }

}

/*function solve() {
  let inputStr = document.getElementById('input').value;
  let output = document.getElementById('output');

  let input = inputStr.split('.').filter((p) => p.length > 0);

  for (let i = 0; i < input.length; i += 3) {
      let arr = [];
      for (let y = 0; y < 3; y++) {
          if (input[i + y]) {
              arr.push(input[i + y]);
          }
      }
      let paragraph = arr.join('. ') + '.';
      output.innerHTML += `<p>${paragraph}</p>`;
  }
}*/



