---
layout: docs
title: 1. Infraestrutura - Entendendo o ambiente
category: docs
children:
  - url: /docs/infra/account.html
  - url: /docs/infra/directories_and_quotas.html
  - url: /docs/infra/resource_management.html
order: 100
---

No LAD, cada cluster possui uma máquina responsável pela gerência dos recursos disponíveis em seu conjunto (head node). Estas máquinas são como centrais de acesso, onde os usuários podem alocar e acessar as máquinas do cluster. Lembramos que a conta e os arquivos pessoais (home) do usuário são os mesmos em qualquer máquina, mesmo que cada cluster seja independente.

Atualmente o LAD possui 6 clusters, são eles: **Amazônia**, **Atlântica**, **Cerrado**, **Grad**, **Pantanal** e **Nimbus**. Parte dos equipamentos do LAD são reservados para alocação 24x7, onde os usuários tem acesso administrativo a uma máquina física ou virtual para hospedagem de serviços que devem ficar disponíveis 24 horas por dia. Outra parte é utilizada para processamento em cluster, onde os usuários fazem alocações momentâneas de máquinas com maior capacidade computacional para a execução de aplicações paralelas.

Para mais informações sobre cada cluster e suas configurações, acesse: [https://www.pucrs.br/ideia/lablad/](https://www.pucrs.br/ideia/lablad/)