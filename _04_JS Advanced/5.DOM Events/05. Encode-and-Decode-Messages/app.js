function encodeAndDecodeMessages() {
   
    //Handlers
    function btnEncode(e) {
        let message = encodedMessage.value;
        let result = '';
        for (let index = 0; index < message.length; index++) {
            result += String.fromCharCode(message[index].charCodeAt(0) + 1);
        }

        encodedMessage.value = '';
        decodedMessage.value = result;
    }

    function btnDecode(e) {
        let message = decodedMessage.value;
        let result = '';
        for (let index = 0; index < message.length; index++) {
            result += String.fromCharCode(message[index].charCodeAt(0) - 1);
        }

        decodedMessage.value = result;
    }


    //Logic
    let encodedDiv = document.querySelector('#main > div:nth-child(1)');
    let decodedDiv = document.querySelector('#main > div:nth-child(2)');

    encodedDiv.querySelector('button').addEventListener('click', btnEncode);
    decodedDiv.querySelector('button').addEventListener('click', btnDecode);

    let encodedMessage = encodedDiv.querySelector('textarea');
    let decodedMessage = decodedDiv.querySelector('textarea');

}

/**
 * function encodeAndDecodeMessages() {
    document.getElementById('main').addEventListener('click', (e) => {
        if (e.target.tagName !== 'BUTTON') {
            return;
        }
 
        let decodedMessage = document.getElementsByTagName('textarea')[0];
        let encodedMessage = document.getElementsByTagName('textarea')[1];
 
        if (e.target.textContent.includes('Encode')) {
            let message = decodedMessage.value;
            let encoded = [];
            for (let i = 0; i < message.length; i++) {
                let currSymbol = message.charCodeAt(i);
                encoded.push(String.fromCharCode(currSymbol + 1));
            }
            decodedMessage.value = '';
            encodedMessage.value = encoded.join('');
        } else if (e.target.textContent.includes('Decode')) {
            let message = encodedMessage.value;
            let decoded = [];
            for (let i = 0; i < message.length; i++) {
                let currSymbol = message.charCodeAt(i);
                decoded.push(String.fromCharCode(currSymbol - 1));
            }
            encodedMessage.value = decoded.join('');
        }
    });
}
 */