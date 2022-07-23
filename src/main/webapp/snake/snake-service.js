export default class SnakeService {
    async getSnake() {
        return fetch("/restservices/snake")
            .then(response => response.json())
    }

    async updateSnake(updatedSnake) {
        //TODO: update je slang aan de server-kant met de nieuwe gegevens
        let fetchOptions = {
            method: "PUT",
            body: JSON.stringify(updatedSnake),
            headers:{"Content-Type" : "application/json"}
        }
        return fetch("/restservices/snake/updatesnake",fetchOptions)
            .then(response=>response.json())
            .then(function (myJson){
                console.log(myJson)
            })
    }
}
