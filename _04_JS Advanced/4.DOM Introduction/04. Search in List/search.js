function search() {
   let myul = document.getElementById('towns');
   let myli = myul.getElementsByTagName('li');

   let searchText = document.getElementById('searchText');

   let filter = searchText.value.toUpperCase();

   let txtValue = '';
   let counter=0;
   for (let index = 0; index < myli.length; index++) {
      txtValue = myli[index].textContent || myli[index].innerText;

      if (txtValue.toUpperCase().indexOf(filter) > -1) {
         myli[index].style.textDecoration = 'underline';
         myli[index].style.fontWeight = 'bold';

         counter++;
      }
   }

   document.getElementById('result').innerText=`${counter} matches found`;
   counter=0;

}
