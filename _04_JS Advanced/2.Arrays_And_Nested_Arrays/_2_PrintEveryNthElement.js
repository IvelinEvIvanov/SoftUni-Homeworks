function solve(arr,indx){
    const theArr=Array.from(arr);
    arr=[];
    let currentIndex=0;

    for (let index = 0; index < theArr.length; index+=indx) {
        arr[currentIndex++]=theArr[index];
        
    }

   return arr;
}

