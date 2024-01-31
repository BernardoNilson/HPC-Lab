---
layout: docs
title: Anexo II - Instalação e configuração do Rclone
category: attach
order: 1020
---

##### **Guia de configuração**

Será necessário fazer o download do Rclone na máquina local do usuário apenas para concluir uma etapa da configuração no cluster. O processo de download, configuração e utilização do Rclone está dividido da seguinte forma:

![rclone-guide]({{ '/assets/img/docs/rclone_guide.png' | relative_url }}){: .img-fluid}

##### **Passo 1 - Download e descompactação**

A seguir estão descritos os comandos de download e descompactação do Rclone para a máquina local do usuário (Linux ou Windows). É necessário manter o terminal da máquina local aberto depois de realizar o download.

###### **\- Linux**

No terminal da sua máquina local, execute os comandos a seguir para fazer o download, descompactar e entrar na pasta do Rclone:

<div class="code">
    user@localhost:~$ wget https://downloads.rclone.org/rclone-current-linux-amd64.zip
</div>
<div class="code">
    user@localhost:~$ unzip rclone-current-linux-amd64.zip
</div>
<div class="code">
    user@localhost:~$ cd rclone-v1.57.0-linux-amd64/
</div><br>

###### **\- Windows**

Outra forma de realizar o download do Rclone é através do site, sendo necessário abrir o terminal apenas após o download e descompactação.

Link para fazer o download: [https://downloads.rclone.org/rclone-current-windows-amd64.zip](https://downloads.rclone.org/rclone-current-windows-amd64.zip)

Faça a extração da pasta do Rclone na pasta `C:\` como no exemplo a seguir:

![rclone-extraction]({{ '/assets/img/docs/rclone_extraction.png' | relative_url }}){: .img-fluid}

Abra o Prompt de Comando e vá para a pasta do Rclone, que deve estar no caminho `C:\rclone-[versão]-windows-amd64` :

<div class="code">
    C:\\Users\\user> cd C:\\rclone-v1.57.0-windows-amd64    
</div>

~~~

C:\rclone-v1.57.0-windows-amd64>
~~~
{: .output}

\
Mantenha o terminal aberto.

##### **Passo 2 - Configurar acesso à nuvem**

Acesse o cluster (Pantanal, por exemplo) e execute o comando a seguir para acessar o menu da aplicação:

<div class="code">
    user@pantanal:~$ rclone config
</div>

~~~

No remotes found - make a new one

n) New remote

s) Set configuration password

q) Quit config

n/s/q>
~~~
{: .output}         
<br>

<div class="code">
    n
</div>

~~~

name>
~~~
{: .output}

<div class="code">
    &lt;meu\_onedrive>
</div>

\
A partir daqui será configurado o acesso ao Onedrive, no entanto, o Rclone possui diversas opções de conexão a outros serviços de armazenamento em nuvem, basta escolher o tipo de serviço e seguir os passos.

~~~

Option Storage.

Type of storage to configure.

Enter a string value. Press Enter for the default (").

Choose a number from below, or type in your own value.

 1 / 1Fichier

   \ "fichier"

   ...

21 / Microsoft OneDrive

   \ "onedrive"

   ...

31 / http Connection

   \ "http"

32 / premiumize.me

   \ "premiumizeme"

Storage>
~~~
{: .output}

<div class="code">
    onedrive
</div><br>

~~~

** See help for onedrive backend at: https://rclone.org/onedrive/ **

Microsoft App Client Id

Leave blank normally.

Enter a string value. Press Enter for the default (").

client_id>
~~~
{: .output}

<div class="code">
    Enter
</div><br>

~~~

Microsoft App Client Secret

Leave blank normally.

Enter a string value. Press Enter for the default (").

client_secret>
~~~
{: .output}

<div class="code">
    Enter
</div><br>

~~~

Edit advanced config? (y/n)

y) Yes

n) No

y/n>
~~~
{: .output}

<div class="code">
    n
</div><br>

~~~

Remote config

Use auto config?

 * Say Y if not sure

 * Say N if you are working on a remote or headless machine

y) Yes

n) No

y/n>
~~~
{: .output}

<div class="code">
    n
</div>

~~~

For this to work, you will need rclone available on a machine that has
a web browser available.

Execute the folowing on your machine (same rclone version recommended) :

        rclone authorize "onedrive"

Then paste the result below:

result>
~~~
{: .output}

\
Nesta etapa não será possível utilizar o `auto config` dentro do cluster para gerar o token de acesso. Sendo assim, será utilizada a máquina local para gerar esse token enquanto o processo de configuração de acesso ao Onedrive no cluster aguarda o `result`:

* * *

Conforme seu sistema operacional, digite o comando abaixo no terminal da sua máquina local dentro da pasta do Rclone. Aguarde o navegador abrir automaticamente para realizar login em sua conta Onedrive:

###### **Linux**

<div class="code">
    user@localhost:~/rclone-v1.57.0-linux-amd64$ ./rclone authorize "onedrive"
</div><br>

###### **Windows**

<div class="code">
    C:\\rclone-v1.57.0-windows-amd64> rclone authorize "onedrive"
</div>

\
Após o login realizado no navegador, a página exibirá a mensagem "Success! All done. Please go back to rclone.".

No terminal da sua máquina local, independente do sistema operacional, deve aparecer uma mensagem parecida com:

~~~

[aa:mm:dd] [hh:mm:ss] NOTICE: Got code

Paste the folowing into your remote machine --->

{"access_token":"[token gerado]","expiry":"[data-hora]"}

<---End paste
~~~
{: .output}

\
É necessário copiar o **texto completo** entre `Paste the folowing into your remote machine --->` e `<---End paste`

* * *

De volta ao cluster, que deve estar aguardando o token gerado, basta colar o texto copiado na etapa anterior e pressionar `Enter`:

~~~

result>
~~~
{: .output}

<div class="code">
    {"access\_token":"\[token gerado\]","expiry":"\[data-hora\]"}
    Enter
</div>

\
O processo deve continuar apenas no cluster e não será mais necessário utilizar o terminal da sua máquina local.

_Obs: se ocorrer algum problema no processo de copiar e colar do token, pode ser necessário repetir o `passo 2. Configurar acesso à nuvem`._

No cluster:

~~~

Choose a number from below, or type in an existing value

 1 / OneDrive Personal or Business

   \ "onedrive"

 2 / Root Sharepoint site

   \ "sharepoint"

 3 / Type in driveID

   \ "driveid"

 4 / Type in SiteID

   \ "siteid"

 5 / Search a Sharepoint site

   \ "search"

Your choice>
~~~
{: .output}

<div class="code">
    1
</div><br>

~~~

Found 1 drives, please select the one you want to use:

0:  (personal) id=[id]

Chose drive to use:>
~~~
{: .output}

<div class="code">
    0
</div><br>

~~~

Found drive 'root' of type 'personal', URL: https://onedrive.live.com/...
                        
Is that okay?

y) Yes

n) No

y/n>
~~~
{: .output}

<div class="code">
    y
</div><br>

~~~
--------------------

[meu_onedrive]

token = {"access_token":"[token]"}

drive_id = [id]

drive_type = personal

--------------------

y) Yes this is OK

e) Edit this remote

d) Delete this remote

y/e/d/>
~~~
{: .output}

<div class="code">
    y
</div>

\
Finalizada a configuração do acesso ao Onedrive, o menu do Rclone deve aparecer com novas opções:

~~~
Current remotes:

Name              Type

====              ====

meu_onedrive         onedrive

e) Edit existing remote

n) New remote

d) Delete remote

r) Rename remote

c) Copy remote

s) Set configuration password

q) Quit config

e/n/d/r/c/s/q>
~~~
{: .output}
<br>

##### **Passo 3 - Configurar senha**

O token gerado na máquina local e copiado para o cluster permite executar operações no Onedrive, no entanto, esse token não é criptografado. O Rclone possui a opção de configurar uma senha para criptografar o token, exigindo a verificação em toda modificação (copiar, deletar, criar novos arquivos, etc.). Este passo é altamente recomendado para proteger suas informações de login ao Onedrive em sua conta do LAD.

Ainda no menu do Rclone, escolha a opção `set configuration password`:

<div class="code">
    s
</div>

~~~
Your configuration is not encrypted.

If you add a password, you will protect your login information to cloud services.

a) Add Password

q) Quit to main menu

a/q>
~~~
{: .output}
<br>

<div class="code">
    a
</div>

~~~

Enter NEW configuration password:

password:
~~~
{: .output}
<br>

<div class="code">
    [senha]
</div>

~~~

Confirm NEW configuration password:

password:
~~~
{: .output} 
<br>

<div class="code">
    [senha]
</div>

~~~

Password set

Your configuration is encrypted.

c) Change Password

u) Unencrypt configuration

q) Quit to main menu

c/u/q>
~~~
{: .output} 
<br>

<div class="code">
    q
</div>

~~~

Current remotes:

Name              Type

====              ====

meu_onedrive         onedrive

e) Edit existing remote

n) New remote

d) Delete remote

r) Rename remote

c) Copy remote

s) Set configuration password

q) Quit config

e/n/d/r/c/s/q>
~~~
{: .output}

\
A configuração está completa. Selecione a opção `Quit config` para sair do menu.

<div class="code">
    q
</div>
