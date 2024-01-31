/* 
    Crie uma classe que represente o objeto "carro".

    Os carros possuem uma marca, uma cor e um distância média percorrida com um litro de gasolina.
    Crie um método que dado a quantidade de kms e o preço do combustível retorne o valor gasto para realizar esse percurso.
*/

class Car {
    brand;
    color;
    distanceInKmWithOneLiterOfGas;

    constructor(brand, color, distanceInKmWithOneLiterOfGas) {
        this.brand = brand;
        this.color = color;
        this.distanceInKmWithOneLiterOfGas = distanceInKmWithOneLiterOfGas;
    }

    calcPriceOfTrip(km, gasPrice) {
        return (km / this.distanceInKmWithOneLiterOfGas) * gasPrice;
    }
}

let car = new Car('BMW', 'White', 12);

const km = 70;
const gasPrice = 5;

console.log(`The price of a trip of ${km} km with the ${car.brand} is R$${car.calcPriceOfTrip(km, gasPrice).toFixed(2)}!`);