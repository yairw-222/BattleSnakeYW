export default class LoginService {
    isLoggedIn() {
        //TODO: hoe ga je bepalen of iemand ingelogd is (geweest)?
        return false;
    }

    login(user, password) {
        let formData = new FormData(document.querySelector("#login"))
        let jsonRequestBody = {}
        let promise = new Promise((resolve, reject)=>{
            formData.forEach((key, value) => jsonRequestBody[key] = value)
            fetch("restservices/users",{method: "POST", body: jsonRequestBody})
                .then(function(response){
                    if(response.ok)return response.json();
                    else throw "Wrong username/password"
                })
                .then(myJson=> window.sessionStorage.setItem("myJWT",myJson.JWT))
                .catch(error=>console.log(error));
        });
        return promise
    }

    getUser() {
        //TODO: deze GET method test je token op server-side problemen. Je kunt client-side op zich wel 'ingelogd' zijn
        //maar het zou altijd zomaar kunnen dat je token verlopen is, of dat er server-side iets anders aan de hand is.
        //Dus het is handig om te checken met een -echte fetch- of je login-token wel echt bruikbaar is.
        return Promise.resolve(null);
    }

    logout() {
        //TODO: hoe ga je eigenlijk iemand 'uitloggen'?
        return Promise.resolve();
    }
}
