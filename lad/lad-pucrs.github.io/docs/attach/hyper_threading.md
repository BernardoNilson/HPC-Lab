---
layout: docs
title: Anexo III - Otimização com Hyper-threading
category: attach
order: 1030
---

As máquinas do LAD não possuem fisicamente todos os processadores especificados, a maioria das máquinas possuem 2 processadores físicos com X núcleos cada, todas com _Hyper-threading_.

_Hyper-threading_ (ou HT) é uma tecnologia da Intel que permite com que cada núcleo físico seja capaz de executar 2 processos a cada ciclo de clock, assim, o sistema operacional identifica 2 núcleos “virtuais” de processamento para cada núcleo físico. Por exemplo: em uma máquina com 2 processadores (cada um com 2 núcleos de processamento), sem _Hyper-threading_, ao executarmos o comando “htop” veremos 4 núcleos, porém, caso os processadores tenham a tecnologia da Intel, veremos 8 núcleos (virtuais).

O uso do _Hyper-threading_ não significa que cada core tenha o dobro de desempenho, simplesmente contém algumas features que, na maioria das vezes, trazem ganhos no tempo total de processamento. O indicado é que o usuário faça simulações iguais, mas com diferentes números de processos por máquina para verificar o comportamento de sua aplicação dependendo do modo de alocação desses recursos.

Exemplo:

<div class="code">
    user@pantanal:~$ srun -n 48
</div>

\
Aqui são alocados 48 núcleos, sendo 24 físicos e 24 virtuais. No entanto, em algumas aplicações o desempenho pode ser melhor ao alocar apenas núcleos físicos e em modo exclusivo. Considerando a expectativa de [_speedup_](https://en.wikipedia.org/wiki/Speedup) e expectativa de desempenho do HT, espera-se que o desempenho caia pela metade ao reduzir o número de processos pela metade (utilizando apenas cores fisicos):

<div class="code">
    user@pantanal:~$ srun -n 24 --exclusive
</div>

\
Uma outra forma de avaliar o desempenho do HT é com o mesmo número de processos (48), mas dividido em 2 hosts, utilizando apenas os 24 cores físicos de cada um. Considerando que o uso de mais hosts exige a troca de mensagens pela rede, espera-se que o desempenho seja inferior (não tão significativamente) ao uso dos 48 processos em um único nó (isso se o HT estiver gerando o desempenho desejado).

<div class="code">
    user@pantanal:~$ srun -N 2 -n 48 --exclusive
</div>

\
Para fins de teste e acompanhamento da execução, é possível visualizar os processos em execução e a utilização dos processadores como demonstrado na [Seção 4.6]({{ '/docs/slurm/analysis.html' | relative_url }}).