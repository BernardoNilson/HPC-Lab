using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Calculadora.Services
{
    public class CalculadoraImp
    {
        public int Somar(int numUm, int numDois)
        {
            return numUm + numDois;
        }

        public bool EhPar(int num)
        {
            return num % 2 == 0;
        }
    }
}