---
layout: docs
title: 3.2. Cópia de arquivos via SCP (Sparta)
category: copy
order: 320
---

Neste caso, o usuário deve realizar o processo de cópia duas vezes, uma da máquina local para a Sparta e outra da Sparta para o LAD, por exemplo:

**Passo 1** - Na máquina local: copiar arquivo da máquina local para a Sparta

<div class="code">
    &#36; scp &lt;ArqComCaminhoCompleto&gt; portoalegre\\&lt;matricula&gt;@sparta.pucrs.br:&lt;DirComCaminhoCompleto&gt;
</div>

\
**Passo 2** - Na Sparta: copiar arquivo da Sparta para o LAD

<div class="code">
    &#36; scp &lt;ArqComCaminhoCompleto&gt; &lt;user&gt;@&lt;cluster&gt;.lad.pucrs.br:&lt;DirComCaminhoCompleto&gt;
</div>

\
O processo de cópia de arquivos/diretórios do LAD para a máquina local via Sparta usa um modelo parecido:

**Passo 1** - No cluster: copiar arquivo do LAD para a Sparta

<div class="code">
    &#36; scp &lt;ArqComCaminhoCompleto&gt; portoalegre\\&lt;matricula&gt;@sparta.pucrs.br:&lt;DirComCaminhoCompleto&gt;
</div>

\
**Passo 2** - Na máquina local: copiar arquivo da Sparta para a máquina local

<div class="code">
    &#36; scp portoalegre\\&lt;matricula&gt;@sparta.pucrs.br:&lt;ArqComCaminhoCompleto&gt; &lt;DirComCaminhoCompleto&gt;
</div>
