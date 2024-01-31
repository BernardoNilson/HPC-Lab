/* 
    Elabore um algorítmo que calcule o valor que deve ser
    pago por um produto, considerando o preço de etqueta
    e a forma de pagamento.

    Utilize os códigos da tabela a seguir para ler qual a
    condição de pagamento escolhida e efetuar os cálculos adequados.

    Còdigo e condição de pagamento:
    1 - Débito recebe 10% de desconto;
    2 - Dinheiro ou PIX recebe 15% de desconto;
    3 - Crédito ou Crédito em 2X é o preço sem alteração, sem juros;
    4 - Cŕedito em mais de 2X possui um juros de 10%;
*/

const price = 100;
let paymentCode = 3;

let finalPrice;

if (paymentCode === 1) finalPrice = price * 0.9;
else if (paymentCode === 2) finalPrice = price * 0.85;
else if (paymentCode === 3) finalPrice = price;
else finalPrice = price * 1.1;

console.log(`The final price is $${finalPrice.toFixed(2)}!`)