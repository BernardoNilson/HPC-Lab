---
layout: docs
title: 2.2. Acesso SSH via rede externa (Sparta)
category: access
order: 220
---

O procedimento para acessar o LAD via Sparta é semelhante ao visto anteriormente, a diferença é que antes de executar o ssh para o cluster, devemos executar este comando para acessar a Sparta:

<div class="code">
    user@localhost:~$ ssh portoalegre\\&lt;matricula&gt;@sparta.pucrs.br
</div>

\
Importante: no Putty, preencha o campo "hostname" com `sparta.pucrs.br`. Ao realizar o login, use `portoalegre\<matricula>` (com apenas uma contrabarra).

Feito login na Sparta, agora é só repetir os passos da [Seção 2.1]({{ '/docs/acess/internal.html' | relative_url }}) para acessar o cluster:

<div class="code">
    &lt;matricula&gt;@poa01spa01:~$ ssh &lt;usuário&gt;@&lt;cluster&gt;.lad.pucrs.br
</div>