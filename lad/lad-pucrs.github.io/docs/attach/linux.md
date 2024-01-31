---
layout: docs
title: Anexo I - Conhecimentos básicos de Linux
category: attach
order: 1010
---

##### **Principais Comandos**

| Comando | Funcionalidade                                   | Exemplo                                                                                                                                                                                       |
| ------- | ------------------------------------------------ | ------------------------------------------------------------------------------------------------ |
| clear   | Limpa a tela                                     | **clear** (limpa a tela)                                                                                                                                                                      |
| ls      | Lista os arquivos de um diretório                | **ls -a** (lista todos os arquivos, inclusive ocultos)<br>**ls -l** (lista os arquivos e permissões)<br>**ls /LADAPPs** (lista o conteúdo do diretório /LADAPPs)                              |
| pwd     | Mostra o diretório atual                         | **pwd** (mostra o diretório atual)                                                                                                                                                            |
| df      | Mostra o espaço livre/ocupado de cada partição   | **df** (Mostra o espaço livre/ocupado da partição)                                                                                                                                            |
| cd      | Entra em um diretório                            | **cd ~** (retorna ao diretório /home do usuário)<br>**cd -** (retorna ao diretório acessado antes)<br>**cd ..** (retorna um diretório acima)<br>**cd /LADAPPs** (entra no diretório /LADAPPs) |
| cat     | Mostra o conteúdo de um arquivo (binário ou txt) | **cat arquivo.txt** (mostra o conteúdo do arquivo arquivo.txt)                                                                                                                                |
| mv      | Move ou renomeia arquivos e diretórios           | **mv meunomeantigo.txt meunomenovo.txt** (renomeia o arquivo)                                                                                                                                 |
| rm      | Apaga arquivos                                   | **rm arquivo.txt** (remove o arquivo "arquivo.txt")                                                                                                                                           |
| rm -r   | Apaga diretorios                                 | **rm -r pasta** (remove o diretório "pasta")                                                                                                                                                  |
| cp      | Copia arquivos                                   | **cp aum.txt adois.txt** (copia o valor de "aum" para "adois")<br>**cp -v aum.txt adois.txt** (copia o valor e mostra o que está sendo copiado)                                               |
| zip     | Compacta arquivos                                | **zip docs.zip arquivo.txt arquivo2.txt** (compacta os arquivos para docs.zip)                                                                                                                |
| unzip   | Descompacta arquivos                             | **unzip docs.zip** (descompacta o arquivo docs.zip)                                                                                                                                           |
| mkdir   | Cria um diretório no sistema                     | **mkdir pasta** (cria o diretório "pasta") <br>**mkdir pasta1 pasta2 --verbose** (mostra uma mensagem para cada diretório criado)                                                             |
{: .table .table-light .table-striped .table-hover}

##### **Permissões de arquivos**

Todos os arquivos no Linux possuem 3 tipos de permissões associadas a 3 tipos de usuários.

As permissões são de:

- leitura, representada pela letra "r"(read);
- escrita, representada pela letra “w” (write);
- execução, representada pela letra “x” (execute).

Os tipos de usuários são:

- O proprietário (usuário) do arquivo;
- Os usuários de um determinado grupo (por padrão, é o mesmo
  grupo do usuário);
- Outros usuários.

Podemos verificar as permissões dos arquivos através do comando “ls”, com o uso dos parâmetros “l” e “a”:

<div class="code">
    user@pantanal:/LADAPPs/qiime$ ls -la
</div>

~~~

total 20

drwxr-xr-x 4 root root 4096 Oct 25 12:27 .

drwxr-xr-x 25 root root 4096 Mar 21 13:22 ..

drwxr-xr-x 16 root root 4096 Oct 11 21:38 qiime2-2021.8

drwxr-xr-x 16 root root 4096 Sep 15  2021 qiime2-2021.8.bak

-rwxr-xr-x 1 root root  676 Oct 11 22:05 qiime2-2021.8-vars.sh

lrwxrwxrwx 1 root root  21 Sep 15  2021 qiime2-vars.sh -> qiime2-2021.8-vars.sh
~~~
{: .output}

\
Esse comando listará todos os objetos do local atual, mas permite especificar outro local após o parâmetro “-la”. Essa lista conterá informações sobre o tipo do objeto, permissões, proprietário (usuário) e grupo.

Na saída acima, a primeira letra de cada arquivo é o tipo de objeto, exemplo: “d” é diretório e “l” é um link simbólico a outro arquivo. Após a primeira letra vem as permissões do arquivo, com as 3 sequências de 3 letras. Também apresenta o proprietário, o “root” (nesse caso), e o grupo, que também se chama “root”.

A primeira sequência são as permissões do proprietário do arquivo, a segunda sequência é dos usuários do “grupo dono“ do arquivo (não necessariamente é o grupo ao qual o proprietário pertence) e a terceira sequência são as permissões para os outros usuários.

![permissions]({{ '/assets/img/docs/permissions.png' | relative_url }}){: .img-fluid}

Para fazer alguma alteração nas permissões de um certo arquivo ou diretório, temos o comando “chmod”. O uso dele é bastante simples:

<div class="code">
    user@pantanal:~$ chmod &lt;permissão> &lt;arquivo/diretório>
</div>

<div class="code">
    user@pantanal:~$ chmod -R &lt;permissão> &lt;diretório>
</div>

\
O parâmetro “-R” quer dizer recursivo, ou seja, aplicará a alteração da permissão recursivamente para todos os objetos localizados dentro do diretório. Caso o usuário mude a permissão de um diretório sem o parâmetro de recursividade, as permissões afetarão apenas o diretório e não seu conteúdo interno.

A variável “permissão” pode ser definida de várias formas, para esse texto, explicaremos a definição com 3 números, para a permissão do usuário, grupo e outros, respectivamente. O número para cada um é obtido a partir do valor em decimal do binário formado pela sequência de 0 (permissão não concedida) e 1 (permissão concedida) para cada tipo de permissão. Caso no lugar da letra tenha um sinal “-” significa que o objeto não possui aquela permissão.

![permissions_table]({{ '/assets/img/docs/permissions_table.png' | relative_url }}){: .img-fluid}

Exemplos: 

<div class="code">
    user@pantanal:~$ chmod 775 arquivo.pl
</div>

\
No caso acima, no arquivo “arquivo.pl”, estamos atribuindo todas as permissões (leitura, escrita e de execução) para o proprietário e para o grupo. Para os outros usuários, atribuindo somente as permissões de leitura e execução.

<div class="code">
    user@pantanal:~$ chmod 777 arquivo.pl
</div>

\
No caso anterior, estamos atribuindo total acesso (leitura, escrita e execução) ao arquivo para todos os tipos de usuários.

<div class="code">
    user@pantanal:~$ chmod -R 750 pasta
</div>

\
No exemplo acima, estamos atribuindo ao diretório “pasta” e recursivamente para todo o conteúdo nele contido, as 3 permissões para o proprietário, somente leitura e execução para o grupo proprietário e nenhuma permissão para os outros usuários.
