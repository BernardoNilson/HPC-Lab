---
layout: docs
title: 6. Processamento paralelo e MPI
category: docs
children:
  - url: /docs/parallel/mpi.html
order: 600
---

O processamento paralelo se trata de uma forma de processamento onde são usados múltiplos processadores para resolver um mesmo problema, visando um menor tempo de execução. Por padrão, a grande maioria das aplicações não são paralelas, ou seja, apenas um processo é criado e, consequentemente, apenas um processador (core/núcleo) irá executar o processo. Para que uma aplicação execute de forma paralela, é necessário que:

*   Seu código tenha sido preparado para isso, ou seja, os desenvolvedores já a tenham programado para executar paralelamente.
    
*   Tenha sido compilada e instalada com as bibliotecas necessárias para tal.
    
    *   Dependendo das bibliotecas utilizadas, pode ser que a aplicação precise ser executada através de algum sistema “extra” (como o mpirun), que crie o ambiente para execução.

Existem várias formas de programar para que a aplicação execute em paralelo. Uma delas é através do MPI (Message Passing Interface), o qual o uso é muito comum entre os usuários do LAD. O MPI é um padrão para comunicação de dados entre processos, ou seja, permite que diferentes processos troquem mensagens entre si.

Existem diversas implementações deste padrão, como OpenMPI, IntelMPI, MPICH e outros. A utilizada como padrão do LAD é a OpenMPI, mas outras estão instaladas no “/LADAPPs” e o usuário pode utilizá-las. É importante frisar que o usuário só utilizará alguma outra implementação do MPI se ele mesmo quiser compilar a aplicação (desenvolvida por ele ou a partir de seu código fonte aberto), pois a aplicação precisa ser executada pela mesma implementação do MPI que foi utilizada em sua compilação. Para aplicações já instaladas no "/LADAPPs”, o usuário não precisa se preocupar com a implementação utilizada, pois a mesma será configurada no script “-vars.sh” da aplicação.

Estas implementações do MPI envolvem um conjunto de ferramentas e comandos para compilação e execução da aplicação. No momento da execução ela cria os diversos processos, que podem estar espalhados em diferentes máquinas, e um ambiente para a troca de mensagens entre estes processos. Esse ambiente utiliza diversas bibliotecas capazes de utilizar e otimizar o uso de diferentes plataformas de rede.