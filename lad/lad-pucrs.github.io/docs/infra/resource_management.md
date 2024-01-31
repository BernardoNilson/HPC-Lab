---
layout: docs
title: 1.3. Gerenciador de recursos
category: infra
order: 130
---

Um ambiente de alto desempenho deve fornecer aos usuários uma forma eficiente para executar e monitorar os trabalhos submetidos. Para atender as demandas e obter resultados de modo rápido, um gerenciador de recursos possui três funções principais:

*   Alocação de recursos para usuários (nós computacionais)
*   Monitoramento de trabalhos nos nós
*   Gerenciamento de fila de trabalhos pendentes

O LAD utiliza o **Slurm** ([https://slurm.schedmd.com/](https://slurm.schedmd.com/)) como gerenciador de recursos, uma ferramenta utilizada em diversos centros de computação de alto desempenho. A forma de utilizar o Slurm e seus principais comandos estão listados na Seção 4 deste manual.

Como forma de utilização responsável e otimização dos recursos do laboratório, o gerenciador Slurm possui um sistema de filas de trabalhos, no qual são aplicadas algumas regras de limites, dependendo do cluster, do usuário ou da quantidade de horas disponíveis. As informações das regras padrões de limites são exibidas ao logar no cluster, como segue o exemplo do cluster pantanal:

![pantanal_limits]({{ '/assets/img/docs/pantanal_limits.png' | relative_url }}){: .img-fluid}

  
Na imagem acima:

*   *"max user queueable"* representa a quantidade de trabalhos que o usuário pode possuir na fila.
*   *"max walltime"* representa o limite de horas que cada trabalho pode exigir.