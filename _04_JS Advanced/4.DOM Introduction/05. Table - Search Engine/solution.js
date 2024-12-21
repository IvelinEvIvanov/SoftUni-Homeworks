function solve() {
   document.querySelector('#searchBtn').addEventListener('click', onClick);
   let selectedIndexes = [];

   function onClick() {
      let myTable = document.getElementsByClassName('container')[0];
      let myTbody = myTable.getElementsByTagName('tbody')[0];
      let rows = myTbody.getElementsByTagName('tr');

      let filter = document.getElementById('searchField').value.toUpperCase();

      for (let index = 0; index < selectedIndexes.length; index++) {
         rows[selectedIndexes[index]].classList.remove('select');
      }

      selectedIndexes = [];

      for (let index = 0; index < rows.length; index++) {
         let cols = Array.from(rows[index].getElementsByTagName('td'));

         if ((cols[0].textContent.toUpperCase().indexOf(filter) > -1) ||
            (cols[1].textContent.toUpperCase().indexOf(filter) > -1) ||
            (cols[2].textContent.toUpperCase().indexOf(filter) > -1)) {

            rows[index].className = 'select';

            selectedIndexes.push(index);
         }

      }

      document.getElementById('searchField').value = "";

   }
}