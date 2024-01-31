---
layout: docs
title: 5.1. Scripts "-vars.sh"
category: application
order: 510
---

Para a utilização das aplicações, temos os scripts “&lt;aplicação>-vars.sh”, os quais estão localizados dentro do diretório de cada aplicação. Caso a aplicação possua mais de uma versão, existirá um script para cada versão da mesma e um script sem versão definida, que será apenas um link para a versão mais recente.

Esses scripts são responsáveis por preparar todo o ambiente para a utilização da aplicação. O mais comum é a definição de variáveis de ambiente (variáveis da sessão do usuário). Para que as variáveis ali definidas sejam aplicadas na sessão do usuário, devemos executar os scripts através do comando “source” (source script-vars.sh). O comando “source” irá aplicar à sessão atual todas as alterações nas variáveis de ambiente feitas pelo script, e não apenas durante a execução do mesmo.

Exemplo de execução de uma aplicação com o comando `source`:

<div class="code">
    user@pantanal:~$ source /LADAPPs/qiime/qiime2-vars.sh
</div>