---
layout: docs
title: 6.1. Compilação e execução de aplicações com MPI
category: parallel
order: 610
---

Por padrão, processos mpi são gerados com o comando "mpirun", no caso do LAD isso só ocorre caso as bibliotecas mpi utilizadas sejam diferentes da padrão do sistema. Caso contrário, deve-se utilizar o "srun", um comando do Slurm para disparar processos que está integrado a biblioteca mpi padrão. Para compilar um programa com OpenMPI, a sintaxe segue a linguagem em que o programa foi escrito (c ou c++).

Sintaxe para programas em c:

<div class="code">
    user@cluster:~$ mpicc -o &lt;programa> &lt;script.c>
</div>
  
\
Sintaxe para programas em c++:

<div class="code">
    user@cluster:~$ mpic++ -o &lt;programa> &lt;script.cpp>
</div>

\
No exemplo abaixo o script "program\_mpi.c" é compilado com OpenMPI e depois executado com o comando "srun":

<div class="code">
    user@pantanal:~$ mpicc -o program\_mpi program\_mpi.c
</div>

<div class="code">
    user@pantanal:~$ srun -N 2 -n 96 ./program\_mpi
</div>

\
Esse comando dispara 96 processos da aplicação "program\_mpi", sendo dividos em duas máquinas com limite de 48 processos cada. Informações e estratégias de otimização estão descritas no [Anexo III - Otimização com Hyper-threading]({{ '/docs/attach/hyper.html' | relative_url }}).