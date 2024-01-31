---
layout: docs
title: 5. Aplicações
category: docs
children:
  - url: /docs/application/varssh.html
  - url: /docs/application/bashrc.html
order: 500
---

As aplicações disponíveis nos clusters podem variar para cada conjunto, mas o caminho para o diretório em que estão localizadas é o mesmo. No exemplo abaixo podemos ver algumas aplicações que estão disponíveis no cluster Pantanal:

<div class="code">
    user@pantanal:~$ ls /LADAPPs
</div>

~~~

BBTools      GTDB-Tk         Paleomix    TensorFlow

CheckM       HMMER         PyRadiomics   XGBoost

fastANI  Intel_Cluster_Studio_XE_2017  qiime      RevBayes

GATE        Java          mOTUlizer

Geant4       OpenMPI        SciKit-Learn
~~~
{: .output}

\
As aplicações localizadas nesse diretório são instaladas pelos administradores do LAD. O usuário pode instalar aplicações que deseje no seu diretório “/home/<usuário>”, sendo possível também solicitar a instalação de alguma aplicação contatando o suporte do LAD por email.