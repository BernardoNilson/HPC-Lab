---
layout: docs
title: 4.2. Comando "squeue"
category: slurm
order: 420
---

Semelhante ao comando sinfo, o squeue também é utilizado para verificar informações. Neste caso, usamos para visualizar a fila de execução dos jobs. O squeue exibe tanto os jobs em execução quando os jobs aguardando liberação de recursos.

Utilização:

<div class="code">
    user@cluster:~$ squeue
</div>

\
Exemplo de uso:

<div class="code">
    user@pantanal:~$ squeue
</div>

~~~

JOBID PARTITION  NAME    USER    ST  TIME  NODES NODELIST(REASON)

829  LAD_geral  exemplo_  usuario4  PD  0:00   2   (Resources)

826  LAD_geral  batchjob  usuario1  R  2:36   1   pantanal02

827  LAD_geral  exemplo_  usuario2  R  1:14   2   pantanal[02-03]

828  LAD_geral  batchjob  usuario3  R  0:45   2   pantanal[04-05]
~~~
{: .output}

\
Em "ST" (State) observamos que o cluster está executando 3 jobs (R - Running) e possui 1 job na fila de espera (PD - Pending) aguardando recursos.