# LabLAD - PUCRS Ideia

- **Acesso:** [https://lad-pucrs.github.io](https://lad-pucrs.github.io)

Jekyll é um gerador de sites estáticos simples, escrito em Ruby. Ele é usado para criar sites simples e rápidos, sem a necessidade de um servidor web dinâmico.

O recurso que usamos para hospedar nosso site é o GitHub Pages, que utiliza o Jekyll por baixo dos panos, por isso a compatibilidade.

### Ferramentas

- [Ruby](https://www.ruby-lang.org/pt/): 3.0.2

- [Jekyll](https://jekyllrb.com/): 4.3.2

- [Bundler](https://bundler.io/): 2.4.21

- [Bootstrap](https://getbootstrap.com/): 5.3.2

### Arquivo _config.yml

O arquivo _config.yml é o arquivo de configuração do Jekyll. Ele é usado para definir parâmetros de configuração do site, além de outras informações variáveis, como o título, o autor, as URLs e os temas:

    title: LabLAD
    email: 
        support: suporte.lad@pucrs.br
        contact: contato.lad@pucrs.br
    phone: +55 51 3353-8001

Esses dados evitam repetições e facilitam o acesso, sem necessidade de alterar em diversos locais.

> ex. {{ site.title }}

#### Liquid

Liquid é uma linguagem de template usada no Jekyll para processar as páginas do site. Ela permite que você adicione lógica e conteúdo dinâmico ao seu site, como variáveis, condicionais e loops.

### Diretórios _includes e _layouts

Os diretórios `_includes` e `_layouts` são usados para armazenar conteúdos e layouts que podem ser reutilizados em várias páginas do site.

* `_includes`: contém conteúdos que podem ser inseridos em qualquer página, como cabeçalhos, rodapés, menus e barras laterais.
* `_layouts`: contém layouts de páginas, que são usados para definir o layout geral de uma página.

O seguinte exemplo usa o diretório `_includes` para inserir um cabeçalho em todas as páginas do site:

~~~html
<!DOCTYPE html>
<html>
<head>
  <title>{{ site.title }}</title>
</head>
<body>
  {% include 'header.html' %}

  {% include 'footer.html' %}
</body>
</html>
~~~

Enquanto isso, temos um código mais conciso e limpo no arquivp `header.html`:

O arquivo `header.html` contém o conteúdo do cabeçalho:

~~~html
<header>
  <h1>{{ site.title }}</h1>
  <nav>
    <a href="#">Home</a>
    <a href="#">Sobre</a>
    <a href="#">Contato</a>
  </nav>
</header>
~~~

### Estrutura de diretórios e Páginas

O site é organizado em um diretório principal, que contém os conteúdos das páginas do site, em arquivos .markdown (.md). As sub-urls do site correspondem às pastas do diretório principal.

> exemplo da estrutura utilizada:

    docs
    ├── intro.md
    ├── acess
        ├── overview.md
        ├── internal.md
        ├── ...
    ├── slurm
        ├── overview.md
        ├── scancel.md
    ├── guide.md

A sub-url `lad-pucrs.github.io/docs/acess/overview.html` corresponde ao arquivo `overview.md` localizado no diretório `acess` do diretório principal `docs`.

> ex. baseurl/docs/information/yyy.html


### Instalação do Jekyll e do Ruby

- Instalação do Ruby: `sudo apt update` E `sudo apt install ruby3.0-dev` no Ubuntu 22.04

- Instalação do Jekyll: `gem install jekyll bundler`, `jekyll new lablad` e, por fim, `bundle exec jekyll serve`

> Obs. If you are using Ruby version 3.0.0 or higher, step 5 may fail. You may fix it by adding webrick to your dependencies: bundle add webrick. 

Mais informações em: [Jekyll Quick Start](https://jekyllrb.com/docs/)

### Padrões utilizados no desenvolvimento

Jekyll Theme: https://olivier3lanc.github.io/Jekyll-LibDoc/

- Padrão de Título dentro da seção:

```
##### **Heading**
```

- Padrão de entrada:

```
    <div class="code">
        Exemplo de entrada
    </div>
```

- Padrão de saída:

```
    ~~~
    Exemplo de saída
    ~~~
    {: .output}
```

- Padrão de imagens:

```
    ![alt](link){: .img-fluid}
```
> Exemplo:

```
    ![name]({{ '/assets/img/docs/name.jpg' | relative_url }}){: .img-fluid}
```

- Padrão de Breakline:

```
\ ou <br>
```

- Caracteres Especiais:

```
"<" -> &lt;
">" -> &gt;
"$" -> &#36;
```

