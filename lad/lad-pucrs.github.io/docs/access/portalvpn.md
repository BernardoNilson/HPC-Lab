---
layout: docs
title: 2.3. Acesso via PortalVPN
category: access
order: 230
---

Este serviço funciona como uma área de trabalho remota através de um navegador web. É necessário solicitar acesso ao suporte do LAD ([suporte.lad@pucrs.br](mailto:suporte.lad@pucrs.br)) e não é possível realizar transferências de arquivos por essa plataforma (neste caso, utiliza-se o Rclone).

Com o acesso liberado, o usuário deve acessar o portalVPN através do endereço [portalvpn.pucrs.br](https://vpn.pucrs.br/sslvpn/Login/Login) e realizar o login com as credenciais de acesso à rede da PUCRS:

![portalvpn_login]({{ '/assets/img/docs/portalvpn_login.png' | relative_url }}){: .img-fluid}

Nesta etapa pode aparecer uma mensagem perguntando se o usuário permite que o site tenha acesso a área de transferência de textos/imagens (imagem abaixo). É necessário permitir o acesso para que seja possível realizar comandos de copiar e colar textos entre o portalVPN e a máquina local do usuário.

![portalvpn_clipboard_permission]({{ '/assets/img/docs/portalvpn_clipboard_permission.png' | relative_url }}){: .img-fluid}
  
Essa função funciona bem nos navegadores Google Chrome e Microsoft Edge, mas o navegador Mozilla Firefox não oferece esse suporte sem o uso de extensões. Se não for possível copiar/colar os textos de forma direta entre a máquina local e o portalVPN, é possível usar o comando `Ctrl + Alt + Shift` para abrir um menu lateral dentro do PortalVPN (depois de acessar o cluster) e utilizar a área de transferência do menu:

![portalvpn_clipboard]({{ '/assets/img/docs/portalvpn_clipboard.png' | relative_url }}){: .img-fluid}

Seguindo para a página inicial, o usuário deve clicar no link "acesso remoto":

![portalvpn_home]({{ '/assets/img/docs/portalvpn_home.png' | relative_url }}){: .img-fluid}
  
Uma tela de login será aberta novamente, digite as mesmas credenciais de acesso usadas anteriormente e, ao voltar para a página inicial, clique novamente no link de "acesso remoto".

Um nova portal para autenticação será aberto no formato a seguir:

![portalvpn_remote]({{ '/assets/img/docs/portalvpn_remote.jpg' | relative_url }}){: .img-fluid}

Use as mesmas credenciais usadas nas autenticações anteriores. A página a seguir deve mostrar os recursos liberados para sua conta. Exemplo:

![portalvpn_resources]({{ '/assets/img/docs/portalvpn_resources.jpg' | relative_url }}){: .img-fluid}

Ao selecionar um host, use suas credenciais de acesso ao LAD para realizar o login no cluster. A partir desta etapa é possível utilizar os recursos do cluster normalmente, com exceção de cópia de arquivos via scp, que não deve funcionar neste modo de acesso.

No tópico a seguir demonstramos como utilizar o Rclone, uma ferramenta que possibilita copiar arquivos/diretórios do LAD para uma conta na nuvem, independente da forma como o usuário se conecta ao ambiente do LAD.

Para se desconectar do cluster, basta utilizar o comando "exit" e selecionar a opção para desconectar e voltar à página de recursos do portalVPN ou sair do portal.

Para se desconectar do portalVPN, selecione a opção "sair" no canto superior direito da tela:

![portalvpn_resources_exit]({{ '/assets/img/docs/portalvpn_resources_exit.jpg' | relative_url }}){: .img-fluid}