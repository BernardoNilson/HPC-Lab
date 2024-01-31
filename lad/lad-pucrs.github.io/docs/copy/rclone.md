---
layout: docs
title: 3.3. Cópia de arquivos via Rclone
category: copy
order: 330
---

O [Rclone](https://rclone.org/) é uma ferramenta para quem busca realizar a cópia de arquivos/diretórios entre sua conta na nuvem e o LAD. O Rclone também pode ser uma alternativa mais rápida para cópia de arquivos caso o usuário esteja acessando o LAD via Sparta e tenha seus arquivos na nuvem, pois o procedimento de cópia é realizado dentro da home do usuário, enquanto que utilizando o scp via Sparta seria necessário realizar duas etapas de cópias (uma cópia para a Sparta e outra cópia da Sparta para o cluster). Nesta seção serão apresentados os comandos básicos do Rclone, porém, para utilizar essa ferramenta é necessário que o usuário configure o acesso à sua conta no serviço de nuvem pelo Rclone. Essa configuração deve ser feita uma única vez e, por isso, os passos dessa configuração estão descritas no Anexo II - Instalação e configuração do Rclone.

##### **Uso do Rclone**

Padrões nos comandos mais usados:

`rclone [subcommand] [remote]:[remote_path]`

`rclone [subcommand] [source_path] [remote]:[remote_path]`

`rclone [subcommand] [remote]:[remote_path] [source_path]`

##### **Listar arquivos e diretórios do Onedrive**

Sintaxe:

`rclone lsf [remote]:`
  
Exemplo:

<div class="code">
    user@pantanal:~$ rclone lsf meu\_onedrive:
</div>

~~~

Documentos/
Estudos/
nova_pasta/
teste.txt
~~~
{: .output}
<br>

##### **Listar arquivos e diretórios dentro de uma pasta do Onedrive**

Sintaxe:

`rclone lsf [remote]:[remote_path]`

Exemplo:

<div class="code">
    user@pantanal:~$ rclone lsf meu\_onedrive:Estudos
</div>

~~~

C++/
Python/  
~~~
{: .output}
<br>

##### **Criar pasta no Onedrive**

Sintaxe:

`rclone mkdir [remote]:[remote_path]`

Exemplo:

<div class="code">
    user@pantanal:~$ rclone mkdir meu\_onedrive:Artigos
</div>

\
Usando o comando para listar `lsf` verificamos que a pasta _Artigos_ foi criada:

<div class="code">
    user@pantanal:~$ rclone lsf meu\_onedrive:
</div>

~~~

Artigos/
Documentos/
Estudos/
nova_pasta/
teste.txt
~~~
{: .output}

\
Seguindo a mesma sintaxe, é possível criar pastas dentro de outros diretórios apenas modificando o caminho depois de `:`

Exemplo:

<div class="code">
    user@pantanal:~$ rclone mkdir meu\_onedrive:Artigos/HPC
</div>

\
Neste caso, a pasta _HPC_ foi criada dentro da pasta _Artigos_. É possível verificar usando o comando `lsf`:

<div class="code">
    user@pantanal:~$ rclone lsf meu\_onedrive:Artigos
</div>

~~~
    
HPC/
~~~
{: .output}                    
<br>

##### **Copiar arquivos**

O comando `copy` faz uma cópia de um determinado arquivo ou de vários arquivos, caso o caminho indicado seja uma pasta (neste caso o comando não realiza a cópia da pasta, mas sim dos arquivos que esta contém). O comando também sobrescreve os arquivos na saída se estes tiverem o mesmo nome.

Sintaxe:

*   Cópia do cluster para o Onedrive:
    *   `rclone copy [source_path] [remote]:[remote_path]`
*   Cópia do Onedrive para o cluster:
    *   `rclone copy [remote]:[remote_path] [source_path]`

Exemplo de cópia do cluster para o Onedrive:

<div class="code">
    user@pantanal:~$ rclone copy /home/user/resumo.txt meu\_onedrive:Artigos
</div>

\
Aqui, o arquivo _resumo.txt_ (cluster) foi copiado para a pasta _Artigos_ (Onedrive). É possível usar o comando `lsf` para verificar:

<div class="code">
    user@pantanal:~$ rclone lsf meu\_onedrive:Artigos
</div>

~~~
    
HPC/
resumo.txt                        
~~~
{: .output} 

\
Exemplo de cópia do Onedrive para o cluster:

<div class="code">
    user@pantanal:~$ rclone copy meu\_onedrive:Artigos /home/user/arquivos\_do\_onedrive
</div>

\
Aqui, todo o conteúdo da pasta _Artigos_ (Onedrive) foi copiado para a pasta _arquivos\_do\_onedrive_ (cluster).