function getArticleGenerator(articles) {
    let div = document.querySelector('#content');

    index = 0;

    return function () {
        let article = document.createElement('article');
        let p = document.createElement('p');

        if (index < articles.length) {
            let nextString = articles[index++];
            
            let textnode = document.createTextNode(nextString);
            p.appendChild(textnode);            
            article.appendChild(p);
            div.appendChild(article);
        }
    };
}
