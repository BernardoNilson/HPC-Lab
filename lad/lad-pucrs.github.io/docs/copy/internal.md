---
layout: docs
title: 3.1. Cópia de arquivos via SCP (rede interna)
category: copy
order: 310
---

O uso do SCP é definido abaixo:

<div class="code">
    &#36; scp &lt;ArquivoOrigem&gt; &lt;LocalDestino&gt;
</div>

\
Ou no caso de diretórios, para realizar a cópia devemos apenas acrescentar o parâmetro “-r”:

<div class="code">
    &#36; scp -r &lt;DiretórioOrigem&gt; &lt;LocalDestino&gt;
</div>

\
Para copiar arquivos ou diretórios do LAD para a sua máquina local, temos a definição abaixo, notando que o usuário deverá estar realizando o comando localmente da sua máquina, ou seja, não conectado ao LAD.

<div class="code">
    &#36; scp &lt;usuário&gt;@&lt;cluster&gt;.lad.pucrs.br:&lt;Arq/DirComCaminhoCompleto&gt; &lt;DirLocalDestino&gt;
</div>

\
Por exemplo, o usuário “joao.silva” deseja copiar o arquivo “arquivo.txt” localizado em “/home/joao.silva/testes/” para o seu diretório local “/home/joao/Desktop/” através do cluster "Pantanal":

<div class="code">
    &#36; scp joao.silva@pantanal.lad.pucrs.br:/home/joao.silva/testes/arquivo.txt /home/joao/Desktop/
</div>

\
Outro exemplo, o usuário “joao.silva” deseja copiar todo o diretório “dir\_1” localizado em “/home/joao.silva/testes/” para o seu diretório local “/home/joao/Desktop/”:

<div class="code">
    &#36; scp -r joao.silva@pantanal.lad.pucrs.br:/home/joao.silva/testes/dir\_1/ /home/joao/Desktop/
</div>

\
Já para copiar um arquivo da sua máquina local para o seu diretório no LAD, temos a definição abaixo, notando que o usuário deverá executar o comando também da sua máquina local.

<div class="code">
    &#36; scp &lt;ArqComCaminhoCompleto&gt; &lt;usuário&gt;@&lt;cluster&gt;.lad.pucrs.br:&lt;DirComCaminhoCompleto&gt;
</div>

\
Por exemplo, o usuário “joao.silva” deseja copiar o arquivo “arquivo.txt” localizado na sua máquina local em “/home/joao/Desktop/” para o seu diretório no LAD “/home/joao.silva/teste/” através do cluster "Cerrado":

<div class="code">
    &#36; scp /home/joao/Desktop/arquivo.txt joao.silva@cerrado.lad.pucrs.br:/home/joao.silva/teste/
</div>

\
Outro exemplo, o usuário “joao.silva” deseja copiar todo o diretório “diretorio\_1” localizado na sua máquina local em “/home/joao/Desktop/” para o seu diretório no LAD “/home/joao.silva/teste/”:

<div class="code">
    &#36; scp -r /home/joao/Desktop/diretorio\_1 joao.silva@cerrado.lad.pucrs.br:/home/joao.silva/teste/x
</div>