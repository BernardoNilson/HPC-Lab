---
layout: docs
title: 5.2. Arquivo ".bashrc"
category: application
order: 520
---

No diretório “home” do usuário temos um arquivo chamado “.bashrc”, o qual é automaticamente executado quando uma sessão do usuário é iniciada. Caso o usuário sempre utilize uma mesma aplicação (por exemplo, “qiime2”), não é necessário sempre estar executando “source /LADAPPs/qiime/qiime2-vars.sh”, apenas é necessário a inserção desse comando ao final do arquivo “.bashrc”. Desta forma, sempre que o usuário fizer o login, o comando é executado. Não aconselhamos usar esse método, pois podem haver conflitos entre bibliotecas de diferentes aplicações que um mesmo usuário execute.

O modo aconselhado é, sempre que for utilizar uma aplicação, antes executar “source” para o arquivo “-vars.sh” da mesma, evitando que bibliotecas de outras aplicações possam gerar conflitos. No caso do batchjob, o comando pode ser inserido antes da(s) linha(s) com o(s) comando(s) de execução. Assim, caso o usuário queira usar uma outra aplicação e desfazer as definições de variáveis feitas, somente deverá encerrar a sessão atual e iniciar outra, pois as variáveis modificadas terão efeito somente na sessão atual do usuário.