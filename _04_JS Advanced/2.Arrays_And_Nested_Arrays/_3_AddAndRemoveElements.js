function solve(arr){
    const theArr=Array.from(arr);
    let number=1;
    let arrResult=[];

    for (let index = 0; index < theArr.length; index++) {
        
        if(theArr[index]==='add'){
            arrResult[index]=number++;
        }else if(theArr[index]==='remove'){
            arrResult.pop();
            number++;
        }

        
        
    }

    if(arrResult.length==0){
        console.log('Empty');
    }else{
        arrResult.forEach(element => {
            console.log(element);
        });
    }

}

