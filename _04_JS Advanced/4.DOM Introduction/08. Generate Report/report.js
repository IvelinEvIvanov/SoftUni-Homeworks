function generateReport() {
    let checkboxes = document.querySelectorAll('table>thead>tr>th>input');
    let rows = document.querySelectorAll('tbody>tr');

    let result = [];

    for (let i = 0; i < rows.length; i++) {
        let obj = {};

        let values = Array.from(rows[i].getElementsByTagName('td'));
        
        for (let j = 0; j < checkboxes.length; j++) {
            if (checkboxes[j].checked) {
                obj[checkboxes[j].name] = values[j].textContent;
            }
        }

        result.push(obj);
    }

    document.querySelector('#output').value = JSON.stringify(result,null,'  ');
}