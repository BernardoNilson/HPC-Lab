
using Calculadora.Services;
using Xunit;
namespace CalculadoraTestes;

public class CalcTests
{
    private readonly CalculadoraImp _calc;

    public CalcTests()
    {
        _calc = new CalculadoraImp();
    }

    [Fact]
    public void DeveSomarCincoComDezERetornarQuinze()
    {
        // Arrange
        int numUm = 5;
        int numDois = 10;

        // Act
        int result = _calc.Somar(numUm, numDois);

        // Assert
        Assert.Equal(15, result);
    }

    [Fact]
    public void DeveSomarDezComDezERetornarVinte()
    {
        // Arrange
        int numUm = 10;
        int numDois = 10;

        // Act
        int result = _calc.Somar(numUm, numDois);

        // Assert
        Assert.Equal(20, result);
    }

    [Fact]
    public void DeveVerificarSeQuatroEhParERetornarTrue()
    {
        // Arrange
        int num = 4;

        // Act
        bool result = _calc.EhPar(num);

        // Assert
        Assert.True(result);
    }

    [Theory]
    [InlineData(2)]
    [InlineData(4)]
    [InlineData(6)]
    [InlineData(8)]
    [InlineData(10)]
    public void DeveVerificarSeOSNumerosSaoParesERetornarTrue(int num)
    {
        // Act
        bool result = _calc.EhPar(num);        

        // Assert
        Assert.True(result);
    }

    [Theory]
    [InlineData(new int[] {2, 4})]
    [InlineData(new int[] {6, 12, 16, 100})]
    public void DeveVerificarSeOSNumerosDoArraySaoParesERetornarTrue(int[] numeros)
    {
        // Act / Assert
        Assert.All(numeros, num => Assert.True(_calc.EhPar(num)));
    }
}
