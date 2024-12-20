function solve(input) {
    let result = [];

    for (const itr of input) {
        let [name, level, items] = itr.split(' / ');
        level = Number(level);
        items = items ? items.split(', ') : [];

        result.push({name,level,items});
    }

    console.log(JSON.stringify(result));
}

solve(['Isacc / 25 / Apple, GravityGun',
'Derek / 12 / BarrelVest, DestructionSword',
'Hes / 1 / Desolator, Sentinel, Antara']);