/* 
    Faça um programa que calcule o valor de uma viagem!

    Você terá cinco variáveis:
    - Preço da gasolina;
    - Preço do etanol;
    - Gasto médio de combustível;
    - Tipo de combustível utilizado;
    - Distância percorrida na viagem;

    Imprima no console o valor que será gasto para realizar essa viagem.
*/

const valorEtanol = 6.09;
const valorGasolina = 5.19;
const kmPorLitro = 65;
const tipoCombustivel = 'Gasolina';
let distanciaViagem = 36;

let valorGasto = 0;

console.clear();

if (tipoCombustivel === 'Etanol') {
    valorGasto = valorEtanol * (distanciaViagem / kmPorLitro);
    console.log('O total gasto com a viagem foi R$' + valorGasto.toFixed(3)
        + '. Foram percorridos ' + distanciaViagem +
        ' quilômetros, com um gasto médio de ' + kmPorLitro +
        ' litros de etanol (R$' + valorEtanol + ') por km.')
} else if (tipoCombustivel === 'Gasolina') {
    valorGasto = valorGasolina * (distanciaViagem / kmPorLitro);
    console.log('O total gasto com a viagem foi R$' + valorGasto.toFixed(3)
        + '. Foram percorridos ' + distanciaViagem +
        ' quilômetros, com um gasto médio de ' + kmPorLitro +
        ' litros de gasolina (R$' + valorGasolina + ') por km.')
} else {
    console.log('Tipo de combustível inválido!');
}
