---
layout: docs
title: 3. Cópia de arquivos
category: docs
children:
  - url: /docs/copy/internal.html
  - url: /docs/copy/external.html
  - url: /docs/copy/rclone.html
order: 300
---

É possível realizar cópias de arquivos e diretórios entre a máquina local do usuário e o LAD, sempre através do protocolo SSH. Caso o Sistema Operacional do usuário seja Linux, o usuário poderá copiar os arquivos através do comando “SCP”. Em máquinas Windows (ou até mesmo Linux), outras ferramentas estão disponíveis para cópia de arquivos por SSH, por exemplo, o “FileZilla” ([https://filezilla-project.org](https://filezilla-project.org)). O usuário também pode optar por realizar cópias direto de sua conta na nuvem (Onedrive ou Google Drive, por exemplo) para o LAD (ou do LAD para a nuvem) utilizando o Rclone ([https://rclone.org/](https://rclone.org/)).