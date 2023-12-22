using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Threading.Tasks;
using Calculadora.Services;
using Xunit;

namespace CalculadoraTestes
{
    public class ValidacaoStringTests
    {
        private readonly ValidacaoString _validacao;

        public ValidacaoStringTests()
        {
            _validacao = new ValidacaoString();
        }

        [Fact]
        public void DeveContarTresCaracteresEmOlaERetornarTres()
        {
            // Arrange
            string text = "Ola";

            // Act
            int result = _validacao.ContarCaracteres(text);

            // Assert
            Assert.Equal(3, result);
        }
    }
}