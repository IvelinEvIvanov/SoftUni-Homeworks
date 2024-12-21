class List {
    constructor() {
        this.elements = [];
        this.size = 0
    }
 
 
    add(num) {
        this.elements.push(num)
        this.size++;
        return this.elements.sort((a, b) => a - b);
    }
 
    remove(index) {
        if (index >= 0 && index < this.elements.length) {
            this.elements = this.elements.filter((x, y) => y !== index)
            this.size--;
        } else {
            throw new Error('Index otside boundary');
        }
 
        return this.elements.sort((a, b) => a - b);
    }
 
    get(index) {
        if (index >= 0 && index < this.elements.length) {
            return this.elements[index];
        } else {
            throw new Error('Index otside boundary');
        }
    }
 
}