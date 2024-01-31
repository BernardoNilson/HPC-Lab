---
layout: docs
title: 2.4. OpenSSH Proxyjump
category: access
order: 240
---

O ProxyJump da [OpenSSH](https://www.openssh.com/manual.html) é uma configuração que facilita e automatiza a conexão a servidores remotos através de um servidor intermediário. Em vez de se conectar manualmente a cada servidor, o ProxyJump permite que o OpenSSH gerencie as conexões.

O comando possui o seguinte formato:

<div class="code">
    user@localhost:~$ ssh -J <user@jump-server> <user@remote-server>
</div>

\
Exemplo:

<div class="code">
    user@localhost:~$ ssh -J 08042022@sparta.pucrs.br examples.lad@pantanal.lad.pucrs.br
</div><br>
 
##### **Configurando no Linux / Windows 11**

No arquivo de configurações do SSH, acessado em `./etc/ssh/ssh_config` no Linux, podemos incluir os hosts. No Windows 11, as configurações se encontram no diretório `C:\Users\User\.ssh\config`.

Se o arquivo "config" não existir, você pode criá-lo.

<div class="code">
    Host sparta  
     User &lt;matricula&gt;  
     Hostname sparta.pucrs.br  
    
    Host cluster  
     User &lt;usuário&gt; 
     Hostname &lt;cluster&gt;.lad.pucrs.br  
     ProxyJump sparta
</div>

\
Exemplo:

<div class="code">
    Host sparta  
     User 08042022  
     Hostname sparta.pucrs.br  
    
    Host pantanal  
     User examples.lad  
     Hostname pantanal.lad.pucrs.br  
     ProxyJump sparta
</div>

\
Nesse caso, para o acesso remoto:

<div class="code">
    user@localhost:~$ ssh pantanal
</div><br>

##### **Configurando no Windows PuTTY**

Para configurar o OpenSSH no Windows PuTTY:

Na seção **Session**

*   Host Name: `<cluster>.lad.pucrs.br`

![putty-host]({{ '/assets/img/docs/putty-host.png' | relative_url }}){: .img-fluid}
  
Na seção Connection > **Data**

*   Auto-login username: `<usuário>`

![putty-data]({{ '/assets/img/docs/putty-data.png' | relative_url }}){: .img-fluid}
  
Na seção Connection > **Proxy**

*   Proxy type: "SSH to proxy and use port forward"
*   Proxy hostname: jump-server `sparta.pucrs.br`
*   Port: 22
*   Username: `<matrícula>`

![putty-proxy]({{ '/assets/img/docs/putty-proxy.png' | relative_url }}){: .img-fluid}

Na seção **Session**

*   Saved Sessions: "name"

![putty-save-config]({{ '/assets/img/docs/putty-save-config.png' | relative_url }}){: .img-fluid}

Por fim, entre no Windows PuTTY clicando em "Open".