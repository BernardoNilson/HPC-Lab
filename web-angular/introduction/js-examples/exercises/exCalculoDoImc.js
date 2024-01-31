/* 
    O IMC (Indice de Massa Corporal) é um critério da OMS para dar uma indicação sobre a condição de peso de uma pessoa adulta.

    Fórmula do IMC: 
    IMC = Peso / Altura²

    Elabore um algorítmo que mostre sua condição de acordo com a tabela abaixo, com determinado peso e determinada altura.

    Tabela:
    - Abaixo de 18.5 está abaixo do peso:
    - Entre 18.5 e 25 está com peso normal;
    - Entre 25.1 e 30 está acima do peso;
    - Entre 30.1 e 40 está peso;
    - Acima de 40 está obesidade mórbida.
*/

const height = 1.73;
const weight = 120;

const imc = weight / Math.pow(height, 2);
let state;

if (imc < 18.5) state = 'abaixo do peso';
else if (imc <= 25) state = 'com o peso normal';
else if (imc <= 30) state = 'acima do peso';
else if (imc <= 40) state = 'está obeso';
else state = 'está com obesidade mórbida';

console.log(`Você possui um IMC de ${imc.toFixed(1)} e está ${state}!`); 
