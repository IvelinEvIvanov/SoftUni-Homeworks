function solve() {
    let inputs = Array.from(document.getElementsByTagName('input'));
    let modulesDiv = document.getElementsByClassName("modules")[0];
    let nameInput = inputs[0];
    let dateInput = inputs[1];

    let moduleSelect = Array.from(document.getElementsByTagName('select'))[0];
    let addButton = Array.from(document.getElementsByTagName("button"))[0];
    addButton.addEventListener("click", addLecture);

    let modulesArr = [];

    function addLecture(e) {
        e.preventDefault();
        let lName = nameInput.value;
        let lDate = dateInput.value;
        console.log(typeof lDate)
        let lModule = moduleSelect.options[moduleSelect.selectedIndex].textContent;

        if (lName.length > 0 && lDate.length > 0 && lModule !== "Select module...") {
            let d = lDate.substring(0, lDate.indexOf("T"));
            let h = lDate.substring(lDate.indexOf("T") + 1);

            let normDate = d.split("-").join("/");
            let fullDate = `${normDate} - ${h}`;
            let fullDesc = `${lName} - ${fullDate}`;


            if (modulesArr.includes(lModule) == false) {
                let modDiv = document.createElement("div");
                modDiv.className = "module";
                modDiv.id = lModule;
                let moduleH = document.createElement("h3");
                let mhtext = `${lModule.toLocaleUpperCase()}-MODULE`
                moduleH.textContent = mhtext;
                modDiv.appendChild(moduleH);
                let modUl = document.createElement("ul");
                let lectureLi = document.createElement("li");
                lectureLi.id = normDate;
                lectureLi.className = "flex";
                let descriptionH = document.createElement("h4");
                descriptionH.textContent = fullDesc;
                let delBtn = document.createElement("button");
                delBtn.className = "red";
                delBtn.textContent = "Del";
                delBtn.addEventListener("click", delLecture);
                lectureLi.appendChild(descriptionH);
                lectureLi.appendChild(delBtn);
                modUl.appendChild(lectureLi);
                modDiv.appendChild(modUl);
                modulesDiv.appendChild(modDiv);

                modulesArr.push(lModule);
            } else {
                let modDiv = document.getElementById(lModule);
                console.log(modDiv);

                let modUl = modDiv.querySelector('ul');
                let lectureLi = document.createElement("li");
                lectureLi.id = normDate;
                lectureLi.className = "flex";
                let descriptionH = document.createElement("h4");
                descriptionH.textContent = fullDesc;
                let delBtn = document.createElement("button");
                delBtn.className = "red";
                delBtn.textContent = "Del";
                delBtn.addEventListener("click", delLecture);
                lectureLi.appendChild(descriptionH);
                lectureLi.appendChild(delBtn);
                modUl.appendChild(lectureLi);
                sortUl(modUl);
            }
        }

        function delLecture(e) {
            let parentLi = e.target.parentNode;
            let parentUl = parentLi.parentNode;
            parentUl.removeChild(parentLi);
            sortUl(parentUl);
            let activeLectures = Array.from(parentUl.querySelectorAll('li'));
            if (activeLectures.length == 0) {
                console.log('delete entire div');
                let divToDelete = parentUl.parentNode;

                let indexOfMod = -1;

                for (let i = 0; i < modulesArr; i++) {
                    if (modulesArr[i] == divToDelete.id) {
                        indexOfMod = i;
                    }
                }
                modulesArr.splice(indexOfMod, 1);
                modulesDiv.removeChild(divToDelete);
            }
        }

        function sortUl(ul) {
            let liArr = Array.from(ul.querySelectorAll('li'));
            let sortedLis = liArr.sort((a, b) => a.id.localeCompare(b.id));
            ul.innerHtml = "";
            sortedLis.forEach(l => {
                ul.appendChild(l);
            })
        }

    }
};