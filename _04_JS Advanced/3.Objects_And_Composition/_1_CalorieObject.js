function solve(arr){
    let calories={}
    const arrCalories=[];
    const result=[];

    for (let index = 0; index < arr.length; index+=2) {
        calories={
            name:arr[index],
            grams:arr[index+1]
        }
        
        arrCalories.push(calories);
    }

    arrCalories.forEach(element => {
        result.push(element.name+': '+element.grams);
    });

    
    console.log('{ '+result.join(', ')+' }');
}

solve(['Yoghurt', '48', 'Rise', '138', 'Apple', '52']);