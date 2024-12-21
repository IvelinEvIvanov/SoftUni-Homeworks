function create(words) {
   let div;
   let paragraph;
   let text;

   let content = document.querySelector('#content');

   for (let index = 0; index < words.length; index++) {
      div = document.createElement('div');
      paragraph = document.createElement('p');
      text = document.createTextNode(words[index]);

      paragraph.appendChild(text);
      paragraph.style.display = 'none';

      div.appendChild(paragraph);

      div.addEventListener('click', displayP);

      content.appendChild(div);

   }


   function displayP(e) {
      let myp = e.target.querySelector('p');
      myp.style.display = 'block';
   }
}