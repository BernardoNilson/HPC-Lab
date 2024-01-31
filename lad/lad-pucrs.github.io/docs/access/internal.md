---
layout: docs
title: 2.1. Acesso SSH via rede interna ou IP liberado
category: access
order: 210
---

Após obter uma conta, deve-se efetuar o login no servidor de acesso do LAD através de SSH:

<div class="code">
    user@localhost:~$ ssh &lt;usuário&gt;@&lt;cluster&gt;.lad.pucrs.br
</div>

\
Exemplo:

<div class="code">
user@localhost:~$ ssh joao.silva@pantanal.lad.pucrs.br
</div>

\
Para usuários de máquinas com o Sistema Operacional Windows, existem diversas ferramentas para se fazer o acesso SSH, por exemplo, o “PuTTY” ([http://www.putty.org](http://www.putty.org)).

Para mudar a senha da sua conta, digite o comando abaixo após realizar o ssh e siga as instruções que serão apresentadas:

<div class="code">
user@cluster:~$ yppasswd
</div>