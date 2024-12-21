var data = [{
    zIndex: 99,
    name: 'sravan',
    age: 25,
    position: 'architect',
    amount: '100k',
    manager: 'mammu'
},
{
    zIndex: 100,
    name: 'sravan',
    age: 25,
    position: 'architect',
    amount: '100k',
    manager: 'mammu'
}];


let x = Object.entries(data[0]);

console.log(x);

let ent = Object.entries(data[0]).sort((a, b) => {
    if (a[0] < b[0]) 1;
    if (a[0] > b[0]) -1;

    return 0;
});

ent = ent.reduce(function (o, [k, v]) {
    o[k] = v;
    return o;
}, {});

console.log(ent);


