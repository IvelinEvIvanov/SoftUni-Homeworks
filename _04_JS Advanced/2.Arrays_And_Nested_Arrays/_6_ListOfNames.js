function solve(arr) {
    const theArr = Array.from(arr);
    let index = 1;

    theArr.sort((a,b)=>a.localeCompare(b));

   for (const itr of theArr) {
    console.log('' + index++ + '.' + itr);
   }

}

solve(["John", "Bob", "Christina", "Ema"]);