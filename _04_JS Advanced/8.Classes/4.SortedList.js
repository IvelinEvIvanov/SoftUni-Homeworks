class List {
    constructor() {
        this.items = [];
        this.size = 0;
    }

    add(element) {
        this.items.push(element);
        if (this.items.length > 1) {
            this.items.sort(function (el1, el2) {
                return el1 - el2;
            });
        }

        this.size++;
    }

    remove(index) {
        if (index >= 0 && index < this.size) {
            this.items.splice(index, 1);
            this.size--;
        }
    }

    get(index) {
        if (index >= 0 && index < this.size) {
            return this.items[index];
        }
    }
}

let list = new List();
list.add(5);
list.add(6);
list.add(7);
console.log(list.get(1));
list.remove(1);
console.log(list.get(1));