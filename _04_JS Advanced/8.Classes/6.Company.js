class Company {
    constructor() {
        this.departments = new Map();
    }

    set setName(name) {
        if (!name) {
            throw new Error('Invalid input!');
        }

        this.name = name;
    }

    set setSalary(salary) {
        if (!salary || salary < 0) {
            throw new Error('Invalid input!');
        }

        this.salary = salary;
    }

    set setPosition(position) {
        if (!position) {
            throw new Error('Invalid input!');
        }

        this.position = position;
    }

    set setDepartment(department) {
        if (!department) {
            throw new Error('Invalid input!');
        }

        this.department = department;
    }

    addEmployee(name, salary, position, department) {
        this.setName = name;
        this.setSalary = salary;
        this.setPosition = position;
        this.setDepartment = department;

        let employee = {};
        employee.name = this.name;
        employee.salary = this.salary;
        employee.position = this.position;
        employee.department = this.department;

        if (!this.departments.has(department)) {
            this.departments.set(department, new Array());
            this.departments.get(department).push(employee);
        } else {
            this.departments.get(department).push(employee);
        }

        return `New employee is hired. Name: ${name}. Position: ${position}`;
    }

    bestDepartment() {

        let bestAverage = -1;
        let departmentName;

        //get best average
        for (let [key, val] of this.departments) {
            let employeeCount = val.length;

            let tempAverage = val.reduce(function (acc, curr) {
                return acc += curr.salary;
            }, 0);

            tempAverage = tempAverage / employeeCount;

            if (tempAverage > bestAverage) {
                bestAverage = tempAverage;
                departmentName = key;
            }
        }

        //sort employees
        let sortedEmployees = this.departments.get(departmentName);
        sortedEmployees = sortedEmployees.sort(function (a, b) {
            let temp = b.salary - a.salary;

            if (temp == 0) {
                return a.name.localeCompare(b.name);
            }

            return temp;
        });

        //print reslut
        let result = `Best Department is: ${departmentName}\n`;
        result += `Average salary: ${bestAverage.toFixed(2)}\n`;
        sortedEmployees.forEach(e => result += `${e.name} ${e.salary} ${e.position}\n`);

        return result.trim();

    }

}

let c = new Company();
c.addEmployee("Stanimir", 2000, "engineer", "Human resources");
c.addEmployee("Pesho", 1500, "electrical engineer", "Construction");
c.addEmployee("Slavi", 500, "dyer", "Construction");
c.addEmployee("Stan", 2000, "architect", "Construction");
c.addEmployee("Stanimir", 1200, "digital marketing manager", "Marketing");
c.addEmployee("Pesho", 1000, "graphical designer", "Marketing");
c.addEmployee("Gosho", 1350, "HR", "Human resources");
console.log(c.bestDepartment());

