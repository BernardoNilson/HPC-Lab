---
layout: docs
title: 4.6. Comandos "sstat", "sacct" e análise de consumo de recursos
category: slurm
order: 460
---

Os comandos "sstat" e "sacct" são utilizados para verificar (e contabilizar) o consumo de recursos computacionais por jobs. Na página do Slurm é possível identificar todas as informações que podem ser apresentadas (sempre sobre o parâmetro "--format") por cada comando, mas a sintaxe ideal será apresentada na descrição de cada comando.

O "sstat" ([https://slurm.schedmd.com/sstat.html](https://slurm.schedmd.com/sstat.html)) apresenta as informações de consumo por jobs em tempo real.

Utilização:
<div class="code">
    user@pantanal:~$ sstat \[&lt;OPTION&gt;\] \[--format info1\[%text\_size\]\[,info2\[%text\_size\]\]\[,info[%text\_size\\]\]...\] -j &lt;job(.stepid)&gt;
</div>

\
Exemplo de uso:

<div class="code">
    user@pantanal:~$ sstat --format JobID%5,NTasks%6,MinCPU,MaxVMSize,MaxDiskRead,MaxDiskWrite -j 799
</div>

~~~

JobID  NTasks  MinCPU  MaxVMSize  MaxDiskRead  MaxDiskWrite

-----  ------  ------  ---------  ------------  -----------

799.3   2   06:56.000 9284092K    76554    2147483800
~~~
{: .output}

\
O "sacct" ([https://slurm.schedmd.com/sacct.html](https://slurm.schedmd.com/sacct.html)) apresenta as informações de consumo de jobs finalizados, sendo essa a principal diferença entre os dois comandos.

Utilização:

<div class="code">
    user@pantanal:~$ sacct \[&lt;OPTION&gt;\] \[--format info1\[%text\_size\]\[,info2\[%text\_size\]\]\[,info3\[%text\_size\]\]...\] \[-j &lt;job(.stepid)&gt;\]
</div>

\
Exemplo de uso:

<div class="code">
    user@pantanal:~$ sacct -j 317 --format TotalCPU,Elapsed,MaxVMSize,AllocNodes,maxRSS%8
</div>

~~~

TotalCPU  Elapsed  MaxVMSize  AllocNodes  MaxRSS

--------  --------  --------  ----------  -------

12:28.926  00:20:01  353980K    1     15644K
~~~
{: .output}

\
Para monitorar o uso de recursos da máquina o usuário também pode fazer uso do "[bpytop](https://github.com/aristocratos/bpytop)", uma ferramenta que oferece uma visualização mais dinâmica sobre os processos em execução e o consumo de recursos.

Quando iniciado, o bpytop mostra um dashboard dividido em 4 telas, apresentando informações de cpu(1), mem/disk(2), network(3) e proc(4). É possível modificar quais telas são mostradas no dashboard pressionando os respectivos números de cada informação. Para fechar o bpytop, digite `q` ou `Ctrl+c`.

Exemplo de utilização em uma alocação no cluster Pantanal com informações de cpu (1), mem/disk(2) e net(3):
<div class="code">
    user@pantanal02:~$ bpytop
</div>

![bpytop_program]({{ '/assets/img/docs/bpytop.png' | relative_url }}){: .img-fluid}
  
Uma forma de monitorar o uso de recursos ao disparar um job é dividindo o terminal em dois painéis, de forma que o usuário possa executar a ferramenta de monitoramento em um painel e no outro disparar o job.

Veja um exemplo de utilização do bpytop com o [tmux](https://github.com/tmux/tmux/wiki), uma ferramenta que permite abrir vários painéis dentro de uma mesma janela de terminal:

Alocação:

<div class="code">
    user@pantanal:~$ srun -N 1 -n 8 -t 10 --pty bash -i
</div>

\
Iniciar tmux:

<div class="code">
    user@pantanal02:~$ tmux
</div>

\
Os comandos do tmux são precedidos por `Ctrl+b`, ou seja, antes de indicar o comando é necessário utilizar essa chave de prefixo.

Para dividir a janela em dois painéis horizontais, como no exemplo abaixo, use a chave de prefixo `Ctrl+b` seguido de `"`:

![tmux_panel]({{ '/assets/img/docs/tmux.png' | relative_url }}){: .img-fluid}
  
O usuário pode "navegar" entre os painéis pressionando `Ctrl+b` seguido de `;`. Além disso, é possível alterar o tamanho dos painéis pressionando Ctrl+seta (Up, Down, Left, Right), por exemplo, ao selecionar o painel de baixo, basta digitar `Ctrl+b` seguido de `Ctrl+Down` para diminuir o tamanho do painel.

Iniciar bpytop em um dos painéis:
<div class="code">
    user@pantanal02:~$ bpytop
</div>


![bpytop_tmux_panel]({{ '/assets/img/docs/bpytop_tmux.png' | relative_url }}){: .img-fluid}
  
Após o ajuste no tamanho dos painéis o usuário poderá disparar um job e monitorar os recursos utilizados em tempo real. Executar o comando `exit` (ou `Ctrl+d`) encerra a sessão do painel atual, migrando o cursor para o outro painel automaticamente.