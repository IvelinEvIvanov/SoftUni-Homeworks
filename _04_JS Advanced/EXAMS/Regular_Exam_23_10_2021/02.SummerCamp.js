class SummerCamp {
    constructor(organizer, location) {
        this.organizer = organizer;
        this.location = location;
        this.priceForTheCamp = {
            'child': 150,
            'student': 300,
            'collegian': 500
        }
        this.listOfParticipants = [];
    }

    registerParticipant(name, condition, money) {
        let keys = Object.keys(this.priceForTheCamp);
        if (!keys.includes(condition)) {
            throw new Error(`Unsuccessful registration at the camp.`);
        }

        if (this.priceForTheCamp[condition] > Number(money)) {
            return `The money is not enough to pay the stay at the camp.`;
        }

        for (const obj of this.listOfParticipants) {
            if (obj.name === name) {
                return `The ${name} is already registered at the camp.`;
            }
        }

        let newParticipant = {
            name,
            condition,
            power: 100,
            wins: 0
        };

        this.listOfParticipants.push(newParticipant);

        return `The ${name} was successfully registered.`;
    }

    unregisterParticipant(name) {
        let flag = false;
        for (const obj of this.listOfParticipants) {
            if (obj.name === name) {
                flag = true;
                this.listOfParticipants = this.listOfParticipants.filter(el => el.name !== name);

                return `The ${name} removed successfully.`;
            }
        }

        if (flag === false) {
            throw new Error(`The ${name} is not registered in the camp.`);
        }

    }

    timeToPlay(typeOfGame, participant1, participant2) {
        let flag = false;
        let flag1 = false;

        let objParticipant1 = {};

        if (typeOfGame === 'Battleship' && participant2 === undefined) {

            for (const obj of this.listOfParticipants) {
                if (obj.name === participant1) {
                    flag = true;
                    obj.power += Number(20);

                    objParticipant1 = obj;

                    return `The ${participant1} successfully completed the game ${typeOfGame}.`
                }
            }
        }

        if (participant1 !== undefined) {
            for (const obj of this.listOfParticipants) {
                if (obj.name === participant1) {
                    flag = true;
                    objParticipant1 = obj;
                    break;
                }
            }
        }

        if (flag === false) {
            throw new Error(`Invalid entered name/s.`);
        }

        if (typeOfGame === 'WaterBalloonFights' && flag === true && participant2 !== undefined) {
            for (const objParticipant2 of this.listOfParticipants) {
                if (objParticipant2.name === participant2) {
                    flag1 = true;

                    if (objParticipant1.condition === objParticipant2.condition) {
                        if (objParticipant1.power > objParticipant2.power) {
                            objParticipant1.wins++;

                            return `The ${objParticipant1.name} is winner in the game ${typeOfGame}.`;
                        } else if (objParticipant1.power < objParticipant2.power) {
                            objParticipant2.wins++;

                            return `The ${objParticipant2.name} is winner in the game ${typeOfGame}.`;
                        } else if (objParticipant1.power === objParticipant2.power) {
                            return `There is no winner.`;
                        }
                    } else {
                        throw new Error(`Choose players with equal condition.`);
                    }

                }
            }
        }

        if (flag1 === false) {
            throw new Error(`Invalid entered name/s.`);
        }

    }

    toString() {
        let result = [];
        let numberOfParticipants = this.listOfParticipants.length;
        result.push(`${this.organizer} will take ${numberOfParticipants} participants on camping to ${this.location}`);

        this.listOfParticipants.sort((p1, p2) => p1.wins - p2.wins).forEach(el => result.push(`${el.name} - ${el.condition} - ${el.power} - ${el.wins}`));

        return result.join('\n');

    }
}

const summerCamp = new SummerCamp("Jane Austen", "Pancharevo Sofia 1137, Bulgaria");
console.log(summerCamp.registerParticipant("Petar Petarson", "child", 300));
//console.log(summerCamp.timeToPlay("Battleship", "Petar Petarson"));
console.log(summerCamp.registerParticipant("Sara Dickinson", "child", 200));
console.log(summerCamp.timeToPlay("Battleship", "Sara Dickinson"));
//console.log(summerCamp.registerParticipant("Dimitur Kostov", "student", 300));
console.log(summerCamp.timeToPlay("WaterBalloonFights", "Petar Petarson", "Sara Dickinson"));

// The Petar Petarson was successfully registered.
// The Petar Petarson successfully completed the game Battleship.
// The Sara Dickinson was successfully registered.
// Uncaught Error: Choose players with equal condition.
// The Dimitur Kostov was successfully registered.
// The Petar Petarson is winner in the game WaterBalloonFights.