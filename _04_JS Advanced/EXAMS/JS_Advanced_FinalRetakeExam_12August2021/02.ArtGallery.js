class ArtGallery {
    constructor(creator) {
        this.creator = creator;
        this.possibleArticles = {
            'picture': 200,
            'photo': 50,
            'item': 250
        };
        this.listOfArticles = [];
        this.guests = [];
    }

    /**
     * 
     * @param {string} articleModel 
     * @param {string} articleName 
     * @param {Number} quantity 
     */
    addArticle(articleModel, articleName, quantity) {
        let possibleArticlesKeys = Object.keys(this.possibleArticles);
        articleModel = articleModel.toLowerCase();
        if (!possibleArticlesKeys.includes(articleModel)) {
            return new Error('This article model is not included in this gallery!');
        }

        let newArticle = {};

        let isThere = false;
        for (const obj of this.listOfArticles) {
            if (obj.articleName === articleName && obj.articleModel === articleModel) {
                obj.quantity += quantity;
                isThere = true;
                break;
            }
        }

        if (isThere === false) {
            newArticle['articleModel'] = articleModel;
            newArticle['articleName'] = articleName;
            newArticle['quantity'] = Number(quantity);

            this.listOfArticles.push(newArticle);
        }

        return `Successfully added article ${articleName} with a new quantity- ${quantity}.`
    }

    inviteGuest(guestName, personality) {
        for (const obj of this.guests) {
            if (obj.guestName === guestName) {
                throw new Error(`${guestName} has already been invited.`);
            }
        }

        let newGuest = {};
        newGuest['guestName'] = guestName;
        if (personality === 'Vip') {
            newGuest['points'] = 500;
        } else if (personality === 'Middle') {
            newGuest['points'] = 250;
        } else {
            newGuest['points'] = 50;
        }
        newGuest['purchaseArticle'] = 0;

        this.guests.push(newGuest);

        return `You have successfully invited ${guestName}!`;
    }

    buyArticle(articleModel, articleName, guestName) {

        let isThere = false;
        let currentArticle = {};
        let articlePoints = 0;

        let possibleArticlesKeys = Object.keys(this.possibleArticles);
        articleModel = articleModel.toLowerCase();
        if (possibleArticlesKeys.includes(articleModel)) {
            for (const obj of this.listOfArticles) {
                if (obj.articleName === articleName && obj.articleModel === articleModel) {
                    isThere = true;
                    currentArticle = obj;
                    articlePoints = this.possibleArticles[articleModel];
                    break;
                }
            }

            if (isThere === false) {
                throw new Error(`This article is not found.`);
            }
        } else if (!possibleArticlesKeys.includes(articleModel)) {
            throw new Error(`This article is not found.`);
        }

        if (currentArticle.quantity === 0) {
            return `The ${articleName} is not available.`;
        }

        let currentGuest = undefined;
        for (const obj of this.guests) {
            if (obj.guestName === guestName) {
                currentGuest = obj;
            }
        }

        if (currentGuest === undefined) {
            return 'This guest is not invited.';
        }


        if (currentGuest.points < articlePoints) {
            return `You need to more points to purchase the article.`;
        }

        currentGuest.points -= articlePoints;
        currentGuest.purchaseArticle++
        currentArticle.quantity--;

        return `${guestName} successfully purchased the article worth ${articlePoints} points.`;
    }

    showGalleryInfo(criteria) {
        let result = [];
        if (criteria === 'article') {
            result.push(`Articles information:`);
            for (const obj of this.listOfArticles) {
                result.push(`${obj.articleModel} - ${obj.articleName} - ${obj.quantity}`);
            }

            return result.join('\n');
        } else if (criteria === 'guest') {
            result.push(`Guests information:`);
            for (const obj of this.guests) {
                result.push(`${obj.guestName} - ${obj.purchaseArticle}`);
            }

            return result.join('\n');
        }
    }
}

const artGallery = new ArtGallery('Curtis Mayfield');
artGallery.addArticle('picture', 'Mona Liza', 3);
artGallery.addArticle('Item', 'Ancient vase', 2);
artGallery.addArticle('picture', 'Mona Liza', 1);
artGallery.inviteGuest('John', 'Vip');
artGallery.inviteGuest('Peter', 'Middle');
artGallery.buyArticle('picture', 'Mona Liza', 'John');
artGallery.buyArticle('item', 'Ancient vase', 'Peter');
console.log(artGallery.showGalleryInfo('article'));
console.log(artGallery.showGalleryInfo('guest'));

// Articles information:
//  picture - Mona Liza - 3
//  item - Ancient vase - 1
//  Guests information:
//  John - 1
//  Peter - 1