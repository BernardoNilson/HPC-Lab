---
layout: docs
title: 4.4. Comando "sbatch"
category: slurm
order: 440
---

Através do comando sbatch o usuário submete seus comandos em um script para ser executado em uma das máquinas alocadas. O job vai para a fila e é iniciado, executado e finalizado sem intervenções do usuário, ou seja, o usuário não precisa se manter conectado ao LAD enquanto o job está em andamento.

Utilização:

<div class="code">
    user@cluster:~$ sbatch &lt;arquivo&gt;
</div>

\
Exemplo de uso:

Aqui construímos um arquivo batchjob que compila e executa o script hello.c (disponível na pasta /home/&lt;usuário&gt;/exemplos/ether) com base no arquivo batchjob de exemplo disponível em /home/&lt;usuário&gt;/exemplos/slurm/batchjob:

~~~

#!/bin/bash

################-> are comments
################-> "#SBATCH" (only one "#") are Batch Script commands

################ Verbose mode

#SBATCH --export=ALL

################

################ Change these parameters according to your requisites

## nodes
#SBATCH -N 2
## or
## tasks (threads)
##SBATCH -n 10

## time
#SBATCH -t 30
## time formats =  "minutes", "minutes:seconds", "hours:minutes:seconds", "days-hours", "days-hours:minutes" and "days-hours:minutes:seconds"

## Exclusive (alloc all threads from each node) or shared (alloc only threads set by "-n" parameter)
#SBATCH --exclusive
## or
##SBATCH --shared

################ Please, change this e-mail address to yours

#SBATCH --mail-type=ALL
#SBATCH --mail-user=example@edu.pucrs.br

################

#SBATCH --no-requeue

################ Output options


## %%     The character "%".
## %A     Job array's master job allocation number.
## %a     Job array ID (index) number.
## %J     jobid.stepid of the running job. (e.g. "128.0")
## %j     jobid of the running job.
## %N     short hostname. This will create a separate IO file per node.
## %n     Node identifier relative to current job (e.g. "0" is the first node of the running job) This will create  a  separate IO file per node.
## %s     stepid of the running job.
## %t     task identifier (rank) relative to current job. This will create a separate IO file per task.
## %u     User name.
## %x     Job name.

## different files for normal output end error output
##SBATCH -o %x.%j.out -e %x.%j.err
## or
## all output in same file
#SBATCH -o %x.%j.out

################

################ Please, change this directory to your working dir.

#SBATCH -D /home/user/exemplos/ether

################

################
echo Running on host `hostname`
echo
echo Initial Time is `date`
echo
echo Directory is `pwd`
echo
echo This jobs runs on the following nodes:
echo $SLURM_JOB_NODELIST
echo
echo JOB_ID:
echo $SLURM_JOBID
echo ################

############# Command example, if using MPI

mpiCC -o hello hello.c
srun -N 2 -n 10 ./hello

################

############# If running a sequential or openMP program

#./application

################

echo Final Time is `date`

~~~
{: .output}

\
No modo Batchjob, todas as linhas que se iniciam com “#SBATCH” são comentários que serão interpretados como parâmetros do comando `sbatch` (alguns parâmetros são iguais aos vistos no `srun`). As linhas que não iniciam especificamente com “#SBATCH” serão interpretadas normalmente como qualquer script bash (como comandos ou comentários). Por exemplo, linhas iniciadas em “##SBATCH” não serão interpretadas pelo sbatch e linhas iniciadas em “SBATCH” serão interpretadas como um comando "SBATCH", que não existe. Os comandos desejados pelo usuário devem ser inseridos após todos os parâmetros do sbatch. O próprio arquivo de exemplo contém informações sobre os parâmetros e locais para a inserção dos comandos desejados para a execução.

As saídas (retornos) dos comandos executados podem ser visualizadas em um arquivo gerado no diretório especificado no parâmetro “-D” do arquivo sbatch. Lembramos também que a definição de tempo de execução é exatamente como no modo interativo, trata-se do número máximo de horas alocadas, não quer dizer que ficará executando todo esse tempo. Caso ultrapasse o tempo definido no parâmetro -t, a execução será interrompida e o job encerrado.

Neste exemplo alocamos 2 máquinas e 10 processos pelo período de até 30 minutos em modo exclusivo. Como o objetivo era compilar e executar o script hello.c, optamos por definir o local de início do job direto na pasta em que o programa estava (também é possível escolher outro local de início e indicar o caminho do script através do comando `cd`).

Finalizamos com o comando de compilação do script (mpiCC -o hello hello.c) e execução (srun -N 2, -n 10 ./hello), respeitando a quantidade de recursos alocados definidos nos parâmetros #SBATCH.

Para submeter o batchjob criado:

<div class="code">
    joao.silva@pantanal:~$ sbatch exemplo\_batchjob
</div>

~~~

Submitted batch job 812
~~~
{: .output}

\
A saída pode ser visualizada no local indicado no parâmetro "#SBATCH -D" (/home/joao.silva/exemplos/ether/):

<div class="code">
    joao.silva@pantanal:~$ ls /home/joao.silva/exemplos/ether/
</div>

~~~

cpi.c  exemplo_batchjob.812.out  hello  hello.c  hello_messages.c  machinefile  mpi_array  mpi_array.c  mpi_cuda.c simpleMPI

~~~
{: .output}

\
Usando o comando `cat` podemos verificar o conteúdo do arquivo:

<div class="code">
    joao.silva@pantanal:~$ cat /home/joao.silva/exemplos/ether/exemplo\_batchjob.812.out
</div>

~~~

Running on host pantanal02

Initial Time is Thu 05 May 2022 02:39:25 PM -03
Directory is /home/joao.silva/exemplos/ether

This jobs runs on the following nodes:
pantanal[02-03]
jOB_ID: 812

Hostname: "pantanal03" Rank: "8" Size: "10"

Hostname: "pantanal03" Rank: "7" Size: "10"

Hostname: "pantanal03" Rank: "6" Size: "10"

Hostname: "pantanal03" Rank: "5" Size: "10"

Hostname: "pantanal03" Rank: "9" Size: "10"

Hostname: "pantanal02" Rank: "0" Size: "10"

Hostname: "pantanal02" Rank: "3" Size: "10"

Hostname: "pantanal02" Rank: "1" Size: "10"

Hostname: "pantanal02" Rank: "4" Size: "10"

Hostname: "pantanal02" Rank: "2" Size: "10"

Final Time is Thu 05 May 2022 02:39:26 PM -03
~~~
{: .output}