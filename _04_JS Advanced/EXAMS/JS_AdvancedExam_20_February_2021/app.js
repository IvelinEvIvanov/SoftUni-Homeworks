function solve() {
   const author = document.querySelector('#creator');
   const title = document.querySelector('#title');
   const category = document.querySelector('#category');
   const content = document.querySelector('#content');

   const createButton = document.querySelector('.btn.create');
   createButton.addEventListener('click', btnCreateHandler);

   function btnCreateHandler(e) {
      e.preventDefault();
      const section = document.querySelector('main > section');

      const articlePost = document.createElement('article');

      const h1Title = document.createElement('h1');
      h1Title.textContent = title.value;
      articlePost.appendChild(h1Title);

      const pCategory = document.createElement('p');
      pCategory.textContent = 'Category: ';
      const strongCategory = document.createElement('strong');
      strongCategory.textContent = category.value;
      pCategory.appendChild(strongCategory);
      articlePost.appendChild(pCategory);

      const pCreator = document.createElement('p');
      pCreator.textContent = 'Creator: ';
      const strongCreator = document.createElement('strong');
      strongCreator.textContent = author.value;
      pCreator.appendChild(strongCreator);
      articlePost.appendChild(pCreator);

      const pContent = document.createElement('p');
      pContent.textContent = content.value;
      articlePost.appendChild(pContent);

      //Buttons
      const div = document.createElement('div');
      div.classList.add('buttons');

      const btnDlelete = document.createElement('button');
      btnDlelete.classList.add('btn', 'delete');
      btnDlelete.textContent = 'Delete';
      btnDlelete.addEventListener('click', btnDeleteHandler);
      div.appendChild(btnDlelete);

      const bntArchive = document.createElement('button');
      bntArchive.classList.add('btn', 'archive');
      bntArchive.textContent = 'Archive';
      bntArchive.addEventListener('click', btnArchiveHandler);
      div.appendChild(bntArchive);

      articlePost.appendChild(div);

      section.appendChild(articlePost);
   }

   function btnDeleteHandler(e) {
      let deleteArticlePost = e.target.parentElement.parentElement;
      deleteArticlePost.remove();
   }

   function btnArchiveHandler(e) {
      const li = document.createElement('li');

      let deleteArticlePost = e.target.parentElement.parentElement;
      li.textContent = deleteArticlePost.querySelector('h1').textContent;

      const section = document.querySelector('.archive-section > ol');
      let liArr = Array.from(section.querySelectorAll('li'));
      liArr.push(li);

      deleteArticlePost.remove();

      liArr.sort(function (a, b) {
         return a.textContent.localeCompare(b.textContent);
      }).forEach(function (el) {
         section.appendChild(el);
      });


   }


}
