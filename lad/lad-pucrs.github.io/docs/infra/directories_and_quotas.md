---
layout: docs
title: 1.2. Diretórios compartilhados e quotas
category: infra
order: 120
---

O LAD possui alguns diretórios compartilhados na rede. Diretórios de usuários (/home) e pastas dedicadas a grupos (sem distinção por usuário) são compartilhados por todos os clusters, enquanto que a pasta "/LADAPPs" (onde estão as aplicações) é específica para cada cluster.

O LAD também possui um sistema de quota para limitar o uso de armazenamento nos diretórios de usuários (/home). Inicialmente, cada usuário possui uma quota de 10 Gigabytes.

A quota pode ser visualizada quando é feito o acesso à conta no LAD ou atraveś do comando abaixo:
<div class="code">
    user@cluster:~$ usoQuota
</div>

~~~
    
Check quota disk for your user:

Total:  10240 MB

Used:  0 MB
~~~
{: .output}

\
Havendo necessidade de um espaço de armazenamento maior, o usuário pode contactar o suporte (suporte.lad@pucrs.br) para solicitar um aumento da quota de usuário ou a utilização de um novo diretório compartilhado (com tamanho limitado) para uso livre do grupo (sem distinção por usuário). Em ambos os casos, o coordenador do grupo deve ser copiado no e-mail para o devido "de acordo".

Além disso, lembramos que os processos de leitura e gravação de arquivos podem ser mais lentos quando comparados a um disco local pois o acesso é feito através da rede.