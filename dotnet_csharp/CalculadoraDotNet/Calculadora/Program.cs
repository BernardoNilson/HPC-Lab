using Calculadora.Services;

CalculadoraImp c = new CalculadoraImp();
int numUm = 5;
int numDois = 10;

Console.WriteLine($"{numUm} + {numDois} = {c.Somar(numUm, numDois)}");