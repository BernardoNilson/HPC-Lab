/* 
    Faça um programa que calcule o valor de uma viagem!

    Você terá três variáveis:
    - Preço do combustível;
    - Gasto médio de combustível;
    - Distância percorrida na viagem;

    Imprima no console o valor que será gasto para realizar essa viagem.
*/

const valorCombustivel = 5.19;
const kmPorLitro = 65;
let distanciaViagem = 1500;

let valorGasto = valorCombustivel * (distanciaViagem / kmPorLitro);

console.clear();
console.log('O total gasto com a viagem foi R$' + valorGasto.toFixed(3) 
+ '. Foram percorridos ' + distanciaViagem + 
' quilômetros, com um gasto médio de ' + kmPorLitro + 
' litros de gasolina (R$' + valorCombustivel + ') por km.')
