---
layout: docs
title: 4.1. Comando "sinfo"
category: slurm
order: 410
---

Este comando é utilizado para verificar o estado atual das máquinas do respectivo cluster. Para visualizar informações mais completas de cada nó, utilizamos alguns parâmetros juntamente com o comando.

Utilização:

<div class="code">
    user@cluster:~$ sinfo -l -N
</div>

\
Exemplo de uso:
<div class="code">
    user@pantanal:~$ sinfo -l -N
</div>

~~~

NODELIST  NODES PARTITION  STATE CPUS  S:C:T  MEMORY  TMP_DISK WEIGHT REASON

pantanal02  1  LAD_geral*  idle  48  2:12:2  192112   0    1   none

pantanal03  1  LAD_geral*  idle  48  2:12:2  192112   0    1   none

pantanal04  1  LAD_geral*  idle  48  2:12:2  192112   0    1   none

pantanal05  1  LAD_geral*  idle  48  2:12:2  192112   0    1   none
~~~
{: .output}