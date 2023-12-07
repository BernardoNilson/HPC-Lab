Apresentação da história do .NET, como surgiu, aplicações e as possibilidades de tarefas com ele

A evolução da plataforma .NET

Principais IDEs

Fundamentos de programação e algortitmos

Vamos usar C#

Plataforma de desenvolvimento de sistemas e aplicações

C# é usada no .NET

Criado pela Microsoft, open-source

Desktop: WPF, Windows Forms e UWP
Web: ASP .NET
Cloud: Azure
Mobile: Xamarin
Game: Unity
IoT: ARM 32 ou 64
AI: ML.NET, Apache Spark

Microsoft criou o .NET para competir com o Java. Java é multiplataforma por conta da sua JVM 

Diferença entre o .NET Framework e .NET

Framework é a versão legado, que só funciona no Windows
.NET é a versão atual, multiplataforma

Compilação

O compilador transforma a linguagem de programação de alto nível em baixo nível, que o computador compreende.

Compilador do .NET

Compila as classes do C#
Vamos ter um IL Code (Interdiate Language), com o programa.exe e o programa.dll. Código intermediário, independente de máquina
Tudo em tempo de compilação
Agora em tempo de execução
JIT Compiler (Just In Time) compila mais uma vez para a arquitetura específica da sua máquina

Tudo bem parecido com os conceitos do Java: Common Language Runtime é a Java Virtual Machine do .NET

Transpilador

Consiste na conversão de uma linguagem para outra. Existe a transformação de alto nível para alto nível

Exemplo: Typescript para Javascript 

Tipos de linguagens:

Linguagem compilada depende de um compilador, como o C# ou o Java

Linguagem interpreta não possui um compilador, a interpretação do código acontece diretamente da linguagem

IDE: Integrated Development Environment

Visual Studio é interessante para C#, C++, Python, Node.js, Unity e Mobile
Várias ferramentas de debug, possui versão gratuita.  

Desvantagens: exige muitos recursos da máquina e não está disponível para Linux.

VS Code é totalmente gratuito e abre a possibilidade de instalação de extensões para desenvolvimento. Performance leve e está disponível em diversas plataformas. VS Code é Open-Source

Jetbrains Rider é rico em funcionalidades, possui forte integração com o .NET, além de recomendar pontos de refatoração de código. Diversos atalhos e comando. Porém ele é pago e exige muitos recursos da máquina.

Instalação do .NET SDK
https://dotnet.microsoft.com/download

Cria o projeto .NET através de `dotnet new console`
Executar o projeto através de `dotnet run`

Executar no VS Code definimos:
sudo ln -s /snap/dotnet-sdk/current/dotnet /usr/local/bin/dotnet
Além de:
sudo snap alias dotnet-sdk.dotnet dotnet

Program.cs é a nossa classe do C-Sharp
.csproj tem as informações do .NET, serve como base para os outros projetos e classes
pasta obj possui os arquivos de compilação
pasta bin possui os arquivos binários

## Classes no C#
Programação Orientada a Objetos

Mesma lógica do Java




