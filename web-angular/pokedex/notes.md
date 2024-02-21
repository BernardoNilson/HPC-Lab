
A ideia aqui é fazer uma Pokedex, usando e consumindo a PokeAPI
Inspiração de design no Dribble 

-g é globalmente
Vamos usar uma biblioteca: npm install -g http-server 
Ela serve apenas para mantermos uma conexão http e continuar exibindo a nossa página via servidor


Requisição HTTP

URL: https://pokeapi.co/api/v2/pokemon/${id} / dinâmico
     ${IP}/${path / caminho de identificação do recutso}

IP: https://pokeaoi.co
     http://127.0.0.1:80 / :3000

Método de requisição:
    GET - Buscar o recurso
    POST - Inserir recursos no URL
    PUT - Atualiza
    DELETE - Deleta

Parâmetros de Path
    ${id} no endereço, que é dinâmico e nos permite acessar recursos do servidor

Query String
?type=grass
?name=Pikachu
Tipo o WHERE do SQL
Usado para filtrar resultados da busca

Header de request ou response são usados para enviar informações adicionais sobre a solicitação ou resposta ao  servidor.

Normalmente são metadados
Podemos dizer quais tipos de arquivos são aceitos pelo cliente (navegador)
Ou, ainda, quais as linguagens aceitas.
accept-languages:
    pt-BR
    pt;q=0.9
Critérios de autenticação também são passados pelo Header de requisição.



Body
    Corpo da nossa requisição
    Ex. Get não tem corpo
    Post, Put, Delete tem corpo.
    body {
        dados do pokemon, tipo json
    }
    Pode ter na resposta também

Status Code
    Significa o resultado na nossa requisição
        100 é Continue
        Sucesso, 2XX.
        3XX é redirect
        4XX Erro do Cliente
        5XX Erro interno
        
