---
layout: docs
title: 4.3. Comando "srun"
category: slurm
order: 430
---

Este comando é usado para a execução de aplicações, alocando recursos (ou utilizando recursos já alocados). Pode ser utilizado para iniciar uma alocação com uma sessão batch interativa.

Utilização:

<div class="code">
    user@cluster:~$ srun -N &lt;máquinas&gt; &lt;demais parâmetros&gt;
</div>

\
Exemplo de utilização:

<div class="code">
    user@pantanal:~$ srun -N 2 -t 5 -n 2 hostname
</div>

~~~

pantanal03

pantanal02
~~~
{: .output}

\
Nesse caso foram alocadas duas máquinas (-N) pelo tempo de 5 minutos (-t), sendo executados dois processos (-n) do comando hostname. Neste tipo de alocação não é necessário acessar o host, o comando realizou a alocação e finalizou os processos de forma direta.

Exemplo de utilização no modo interativo:

Neste modo o usuário realiza a alocação e é redirecionado para uma das máquinas alocadas.

<div class="code">
    user@pantanal:~$ srun -N 2 -n 8 -t 5 --pty bash -i
</div>

~~~

user@pantanal02:~$`
~~~
{: .output}                    

\
Nesse caso foram alocadas duas máquinas (-N) pelo tempo de 5 minutos (-t) e 8 processos (-n). Os comandos podem ser executados de dentro do nó alocado, como no exemplo abaixo:

<div class="code">
    user@pantanal02:~$ srun -n 8 hostname
</div>

~~~

pantanal02

pantanal02

pantanal02

pantanal02

pantanal03

pantanal03

pantanal03

pantanal03
~~~
{: .output}            

\
Caso o comando solicite mais processos do que foi alocado, uma mensagem de erro deve aparecer:

<div class="code">
    user@pantanal02:~$ srun -n 9 hostname
</div>

~~~

srun: error: Unable to create step for job 670: More processors requested than permitted`
~~~
{: .output}                       

\
Exemplos de utilização em modo exclusivo:

Também é possível realizar a alocação das máquinas em modo exclusivo, sendo alocados todos os processadores das máquinas requisitadas:

<div class="code">
    user@pantanal:~$ srun -N 2 -t 5 -n 2 --exclusive hostname
</div>

~~~

pantanal03

pantanal02
~~~
{: .output}            

\
Neste caso o usuário optou por rodar apenas dois processos, mas por estar no modo exclusivo a limitação de processos se dá pela capacidade do conjunto de nós alocados. Como cada nó do cluster Pantanal possui 48 cpus (para verificar use o comando sinfo), o limite de processos nessa alocação seria 96 (2x48).

No próximo exemplo realizamos uma alocação interativa, porém nesta etapa não é necessário especificar a quantidade de processos a serem executados:

<div class="code">
    user@pantanal:~$ srun -N 2 -t 5 --exclusive --pty bash -i
</div>

~~~

user@pantanal02:~$
~~~
{: .output}           

\
A quantidade de processos deve ser especificado apenas na etapa de execução dentro da máquina em que o usuário foi redirecionado, como no exemplo abaixo:

<div class="code">
    user@pantanal02:~$ srun -n 8 hostname
</div>

~~~

pantanal02

pantanal02

pantanal02

pantanal02

pantanal03

pantanal03

pantanal03

pantanal03
~~~
{: .output} 