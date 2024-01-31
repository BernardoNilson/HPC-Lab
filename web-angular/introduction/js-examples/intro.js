const num = 9232;
let numeroEhPar = (num % 2) === 0;
console.log(numeroEhPar)

let nome = 10; // Variavel que pode receber diversos valores
const pi = 3.14; // Constante, não pode receber novos valores

console.log('Impressão');

// Operações básicas
let soma = 10 + 19;
let subtracao = 10 - 2;
let multiplicacao = 5 * 8;
let divisao = 12 / 2;

//Importação e exportação de arquivos facilita a divisão de trabalhos e códigos entre diferentes arquivos.

const archive = require('caminho do arquivo');
// Só é importado aquilo que é exportado no arquivo

// No arquivo, deve existir algo parecido com isso:
/* 
    module.exports = {
        gets,
        print
    };
*/

// Podemos facilitar o importando tratando-o como se fossem funções: const { gets, print } = require('caminho');
// Conceito de destructuring