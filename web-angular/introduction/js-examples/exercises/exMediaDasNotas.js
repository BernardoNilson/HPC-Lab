/* 
    Faça um algorítmo que calcula e imprima as notas alcançadas por um aluno conforme a classicação abaixo. Considere 3 notas.

    Média = (nota 1 + nota 2 + nota 3) / 3

    Classificação:
    - Média menor que 5, reprovação;
    - Média entre 5 e 7, recuperação;
    - Média maior que 7, aprovação.
*/

const notaUm = 1;
const notaDois = 7;
const notaTres = 4;

const media = (notaUm + notaDois + notaTres) / 3;
let resultado;

if (media >= 7) resultado = 'Aprovação!';
else if (media >= 5) resultado = 'Recuperação!';
else resultado = 'Reprovação';

console.log(`O aluno ficou com uma média de ${media.toFixed(1)}: ${resultado}`);