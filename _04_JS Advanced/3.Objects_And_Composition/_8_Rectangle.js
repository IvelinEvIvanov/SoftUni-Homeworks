
function rectangle(pwidth, pheight, pcolor) {
    return {
        width: Number(pwidth),
        height: Number(pheight),
        color: ''+pcolor[0].toUpperCase() + 
        pcolor.slice(1),
        calcArea: function () {
            return this.width * this.height;
        }

    }
}

let rect = rectangle(4, 5, 'red');
console.log(rect.width);
console.log(rect.height);
console.log(rect.color);
console.log(rect.calcArea());
