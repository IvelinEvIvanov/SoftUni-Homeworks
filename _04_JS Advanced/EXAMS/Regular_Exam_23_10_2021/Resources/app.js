window.addEventListener('load', solve);

function solve() {
    let genre = document.querySelector('#genre');
    let songName = document.querySelector('#name');
    let author = document.querySelector('#author');
    let date = document.querySelector('#date');

    document.querySelector('#add-btn').addEventListener('click', btnSubmitHandler);

    let divHitsInfo = document.querySelector('.all-hits-container');

    let divTotalLikes = document.querySelector('#total-likes');


    function btnSubmitHandler(ev) {
        ev.preventDefault();

        let valGenre = genre.value;
        let valSongName = songName.value;
        let valAuthor = author.value;
        let valDate = date.value;

        if (valGenre !== '' && valSongName !== '' && valAuthor !== '' && valDate !== '') {

            //create
            let div = document.createElement('div');
            let img = document.createElement('img');
            let h2Genre = document.createElement('h2');
            let h2SongName = document.createElement('h2');
            let h2Author = document.createElement('h2');
            let h3Date = document.createElement('h3');

            let btnSave = document.createElement('button');
            let btnLike = document.createElement('button');
            let btnDelete = document.createElement('button');

            //set elements
            div.classList.add('hits-info');
            img.setAttribute('src', './static/img/img.png');
            h2Genre.textContent = `Genre: ${valGenre}`;
            h2SongName.textContent = `Name: ${valSongName}`;
            h2Author.textContent = `Author: ${valSongName}`;
            h3Date.textContent = `Date: ${valDate}`;

            btnSave.textContent = 'Save song';
            btnSave.classList.add('save-btn');
            btnSave.addEventListener('click', btnSaveHandler);

            btnLike.textContent = 'Like song';
            btnLike.classList.add('like-btn');
            btnLike.addEventListener('click', btnLikeHandler);

            btnDelete.textContent = 'Delete';
            btnDelete.classList.add('delete-btn');
            btnDelete.addEventListener('click', btnDeleteHandler);



            //append
            div.appendChild(img);
            div.appendChild(h2Genre);
            div.appendChild(h2SongName);
            div.appendChild(h2Author);
            div.appendChild(h3Date);

            div.appendChild(btnSave);
            div.appendChild(btnLike);
            div.appendChild(btnDelete);

            //append to root
            divHitsInfo.appendChild(div);

        }

    }

    function btnDeleteHandler(ev) {
        let parentEl = ev.target.parentElement;
        parentEl.remove();
    }

    function btnLikeHandler(ev) {
        let pTotalLikes = divTotalLikes.querySelector('p');
        let numberOfLikes = Number(pTotalLikes.textContent.split(': ')[1]);
        numberOfLikes++;

        pTotalLikes.textContent = '';
        pTotalLikes.textContent = `Total Likes: ${numberOfLikes}`;

        ev.target.disabled = true;
    }

    function btnSaveHandler(ev) {
        let copyMusic = document.querySelector('.hits-info');
        copyMusic = copyMusic.cloneNode(true);

        let saveDiv = document.querySelector('.saved-container');


        let parentEl = ev.target.parentElement;
        parentEl.remove();

        saveDiv.appendChild(copyMusic);


        let savebtn = saveDiv.querySelector('.save-btn');
        savebtn.remove();

        let likebtn = saveDiv.querySelector('.like-btn');
        likebtn.remove();

        let del = saveDiv.querySelector('.delete-btn');
        del.addEventListener('click', btnDeleteHandler);


    }


}