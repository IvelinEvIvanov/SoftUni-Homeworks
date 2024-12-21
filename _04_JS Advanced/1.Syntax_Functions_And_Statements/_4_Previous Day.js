function solve(year, month, day) {

    const date = year + '-' + month + '-' + day;
    let event = new Date(date);
    event.setDate(day - 1);
    console.log(event.getFullYear() + '-' + Number(event.getMonth() + 1) + '-' + event.getDate());
}
//const date = new Date(year, month - 1, day);
    //const result = new Date();
    //const milSeconds=1000*60*60*24;
    //result.setDate(date.getDate() - 1);
    //console.log(result);