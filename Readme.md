# Desafio spring - Digital House

### Repositório da solução do desafio spring

A seguir está descrito o passo a passo para configuracao e teste do desafio:

#### 1. Cadastro dos usuários

<p><code>Method: POST</code><br><code>Sign: http://localhost:8080/users</code></p>
<pre>
<code><span style="font-size: medium">Body(Vendedor):</span> </code>

    {
        "userName":"Vicente",
        "type":"seller"
    }


<code><span style="font-size: medium">Response (Status: 201 - Created):</span></code>

    {
        "userName":"Vicente",
        "type":"SELLER"
    }

<code><span style="font-size: medium">Body(Comprador):</span> </code>

    {
        "userName":"Brenda",
        "type":"buyer"
    }


<code><span style="font-size: medium">Response (Status: 201 - Created):</span></code>

    {
        "userName":"Brenda",
        "type":"BUYER"
    }
</pre>

<pre>
<table>
<tr><th colspan="3">Parâmetros</th></tr>
<tr style="text-align: left"><th>Parâmetro</th><th>Tipo</th><th>Descrição/Exemplo</th></tr>
<tr style="text-align: left"><td>userName</td><td>String</td><td>Nome do usuário a ser cadastrado</td></tr>
<tr style="text-align: left"><td>type</td><td>String</td><td>Tipo do usuário a ser cadastrado (buyer ou seller)</td></tr>
</table>
</pre>

É possível consultar os usuários cadastrados com o seguinte endpoint:

<p><code>Method: GET</code><br><code>Sign: http://localhost:8080/users</code></p>
<pre>
<code><span style="font-size: medium">Response (Status: 202 - Accepted):</span></code>

    [
        {
            "userId": 0,
            "userName":"Vicente"
        },
        {  
            "userId": 1,
            "userName":"Brenda"
        },
        {
            ...
        }
    ]

</pre>

<pre>
<table>
<tr><th colspan="3">Parâmetros</th></tr>
<tr style="text-align: left"><th>Parâmetro</th><th>Tipo</th><th>Descrição/Exemplo</th></tr>
<tr style="text-align: left"><td>userId</td><td>int</td><td>Identificador único do usuário</td></tr>
<tr style="text-align: left"><td>userName</td><td>String</td><td>Nome do usuário cadastrado</td></tr>
</table>
</pre>

E também consultar um usuário específico através do id com o seguinte endpoint:

<p><code>Method: GET</code><br><code>Sign: http://localhost:8080/users/{id}</code></p>
<pre>
<code><span style="font-size: medium">Exemplo: http://localhost:8080/users/1</span></code>
<code><span style="font-size: medium">Response (Status: 202 - Accepted):</span></code>

    
    {  
        "userId": 1,
        "userName":"Brenda"
    }
    

</pre>

<pre>
<table>
<tr><th colspan="3">Parâmetros</th></tr>
<tr style="text-align: left"><th>Parâmetro</th><th>Tipo</th><th>Descrição/Exemplo</th></tr>
<tr style="text-align: left"><td>id</td><td>int</td><td>Identificador único do usuário</td></tr>
<tr style="text-align: left"><td>userId</td><td>int</td><td>Identificador único do usuário</td></tr>
<tr style="text-align: left"><td>userName</td><td>String</td><td>Nome do usuário cadastrado</td></tr>
</table>
</pre>

<p><span style="font-style: italic">A partir deste ponto o sistema está pronto para seguir a documentação fornecida no enunciado do desafio.</span></p>

Todavia, seguir estão os endpoints exemplificados:

#### 2. Dar follow em um vendedor/seller (US 0001)

<p><code>Method: POST</code><br><code>Sign: http://localhost:8080/users/{userId}/follow/{userIdToFollow}</code></p>
<pre>
<code><span style="font-size: medium">Exemplo: http://localhost:8080/users/1/follow/0</span></code>
<code><span style="font-size: medium">Response (Status: 201 - Created):</span></code>

    {
        "message": "Seguidor vinculado"
    }

</pre>

<pre>
<table>
<tr><th colspan="3">Parâmetros</th></tr>
<tr style="text-align: left"><th>Parâmetro</th><th>Tipo</th><th>Descrição/Exemplo</th></tr>
<tr style="text-align: left"><td>userId</td><td>int</td><td>Identificador único do usuário que irá seguir</td></tr>
<tr style="text-align: left"><td>userIdToFollow</td><td>int</td><td>Identificador único do usuário que será seguido</td></tr>
<tr style="text-align: left"><td>message</td><td>String</td><td>Mensagem retornada do servidor</td></tr>
</table>
</pre>

#### 3. Obter o resultado do número de usuários que seguem um determinado vendedor (US 0002)

<p><code>Method: GET</code><br><code>Sign: http://localhost:8080/users/{userId}/followers/count/</code></p>
<pre>
<code><span style="font-size: medium">Exemplo: http://localhost:8080/users/0/followers/count/</span></code>
<code><span style="font-size: medium">Response (Status: 202 - Accepted):</span></code>

    {
        "userId": 0,
        "userName": "Vicente",
        "followers_count": 1
    }

</pre>

<pre>
<table>
<tr><th colspan="3">Parâmetros</th></tr>
<tr style="text-align: left"><th>Parâmetro</th><th>Tipo</th><th>Descrição/Exemplo</th></tr>
<tr style="text-align: left"><td>userId</td><td>int</td><td>Identificador único do determinado usuário/vendedor</td></tr>
<tr style="text-align: left"><td>userName</td><td>String</td><td>Nome do determinado usuário/vendedor</td></tr>
<tr style="text-align: left"><td>followers_count</td><td>int</td><td>Quantidade de seguidores</td></tr>
</table>
</pre>

#### 4. Obter uma lista de todos os usuários que seguem um determinado vendedor (quem me segue?) (US 0003 / US 0008)

<p>
    <code>Method: GET</code><br>
    <code> Sign (Ordenação padrão): http://localhost:8080/users/{userId}/followers/list</code><br>
    <code> Sign (Alfabética - userName): http://localhost:8080/users/{userId}/followers/list?order={order}</code>
</p>

<table>
<tr><th>Parâmetro (order)</th><th>Descrição</th></tr>
<tr><td>name_asc</td><td>Ordena os nomes de forma crescente</td></tr>
<tr><td>name_desc</td><td>Ordena os nomes de forma descrescente</td></tr>
</table>
<pre>
<code><span style="font-size: medium">Exemplo 1: http://localhost:8080/users/0/followers/list</span></code>
<code><span style="font-size: medium">Exemplo 2: http://localhost:8080/users/0/followers/list?order=name_asc</span></code>
<code><span style="font-size: medium">Exemplo 3: http://localhost:8080/users/0/followers/list?order=name_desc</span></code>
<code><span style="font-size: medium">Response (Status: 202 - Accepted):</span></code>

    {
        "userId": 0,
        "userName": "Vicente",
        "followers": [
                        {
                            "userId": 1,
                            "userName": "Brenda"
                        },
                        {
                            ...
                        }
                    ]
    }

</pre>

<pre>
<table>
<tr><th colspan="3">Parâmetros</th></tr>
<tr style="text-align: left"><th>Parâmetro</th><th>Tipo</th><th>Descrição/Exemplo</th></tr>
<tr style="text-align: left"><td>userId</td><td>int</td><td>Identificador único do usuário</td></tr>
<tr style="text-align: left"><td>userName</td><td>String</td><td>Nome do usuário</td></tr>
<tr style="text-align: left"><td>followers</td><td>Object List</td><td>Lista de usuários que seguem o determinado usuário/vendedor</td></tr>
</table>
</pre>

#### 5. Obter uma lista de todos os vendedores que um determinado usuário segue (quem estou seguindo?) (US 0004)

<p>
    <code>Method: GET</code><br>
    <code>Sign: http://localhost:8080/users/{userId}/followed/list</code><br>
    <code> Sign (Alfabética - userName): http://localhost:8080/users/{userId}/followed/list?order={order}</code>
</p>

<table>
<tr><th>Parâmetro (order)</th><th>Descrição</th></tr>
<tr><td>name_asc</td><td>Ordena os nomes de forma crescente</td></tr>
<tr><td>name_desc</td><td>Ordena os nomes de forma descrescente</td></tr>
</table>
<pre>
<code><span style="font-size: medium">Exemplo 1: http://localhost:8080/users/1/followed/list</span></code>
<code><span style="font-size: medium">Exemplo 2: http://localhost:8080/users/1/followed/list?order=name_asc</span></code>
<code><span style="font-size: medium">Exemplo 3: http://localhost:8080/users/1/followed/list?order=name_desc</span></code>
<code><span style="font-size: medium">Response (Status: 202 - Accepted):</span></code>

    {
        "userId": 1,
        "userName": "Brenda",
        "followed": [
                        {
                            "userId": 0,
                            "userName": "Vicente"
                        },
                        {
                            ...
                        }
                    ]
    }
</pre>

<pre>
<table>
<tr><th colspan="3">Parâmetros</th></tr>
<tr style="text-align: left"><th>Parâmetro</th><th>Tipo</th><th>Descrição/Exemplo</th></tr>
<tr style="text-align: left"><td>userId</td><td>int</td><td>Identificador único do usuário/comprador</td></tr>
<tr style="text-align: left"><td>userName</td><td>String</td><td>Nome do usuário</td></tr>
<tr style="text-align: left"><td>followed</td><td>Object List</td><td>Lista de usuários que o determinado comprador segue</td></tr>
</table>
</pre>

#### 6. Cadastrar uma nova publicação (US 0005)

<p><code>Method: POST</code><br><code>Sign: http://localhost:8080/products/newpost</code></p>
<pre>
<code><span style="font-size: medium">Exemplo: http://localhost:8080/products/newpost</span></code>
<code><span style="font-size: medium">Body:</span> </code>

    {
        "userId": 0,
        "id_post" : 0,
        "date" : "09-07-2021",
        "detail" :
                { 
                    "product_id" : 0,
                    "productName" : "Cadeira Gamer",
                    "type" : "Gamer",
                    "brand" : "DT3 Racer",
                    "color" : "Black",
                    "notes" : "Elise - Racer"
                },
        "category" : 100,
        "price" : 1300.50
    }

<code><span style="font-size: medium">Response (Status: 201 - Created):</span></code>

    {
        "userId": 0,
        "idPost": 0,
        "date": "09-07-2021",
        "detail": {
            "productId": 0,
            "productName": "Cadeira Gamer",
            "type": "Gamer",
            "brand": "DT3 Racer",
            "color": "Black",
            "notes": "Elise - Racer"
        },
        "category": 100,
        "price": 1300.50
    }

</pre>

<pre>
<table>
<tr><th colspan="3">Parâmetros</th></tr>
<tr style="text-align: left"><th>Parâmetro</th><th>Tipo</th><th>Descrição/Exemplo</th></tr>
<tr style="text-align: left"><td>userId</td><td>int</td><td>Identificador único do usuário/vendedor </td></tr>
<tr style="text-align: left"><td>idPost</td><td>int</td><td>Identificador único do post</td></tr>
<tr style="text-align: left"><td>date</td><td>String</td><td>Data do post</td></tr>
<tr style="text-align: left"><td>detail</td><td>Object</td><td>Produto do post</td></tr>
<tr style="text-align: left"><td>productId</td><td>int</td><td>Identificador único do produto</td></tr>
<tr style="text-align: left"><td>productName</td><td>String</td><td>Nome do produto</td></tr>
<tr style="text-align: left"><td>type</td><td>String</td><td>Tipo do produto</td></tr>
<tr style="text-align: left"><td>brand</td><td>String</td><td>Marca do produto</td></tr>
<tr style="text-align: left"><td>color</td><td>String</td><td>Cor do produto</td></tr>
<tr style="text-align: left"><td>notes</td><td>String</td><td>Observações a respeito do produto</td></tr>
<tr style="text-align: left"><td>category</td><td>int</td><td>Categoria do post</td></tr>
<tr style="text-align: left"><td>price</td><td>double</td><td>Preço do produto</td></tr>
</table>
</pre>

#### 7. Obter uma lista das publicações feitas pelos vendedores que um usuário segue nas últimas duas semanas (US 0006 / US0009)

<p>
    <code>Method: GET</code><br>
    <code>Sign (Ordenação Padrão): http://localhost:8080/products/followed/{userId}/list</code><br>
    <code>Sign (Por data): http://localhost:8080/products/followed/{userId}/list?order={order}</code>
</p>

<table>
<tr><th>Parâmetro (order)</th><th>Descrição</th></tr>
<tr><td>date_asc</td><td>Ordena por data dos posts de forma crescente</td></tr>
<tr><td>date_desc</td><td>Ordena por data dos posts de forma descrescente</td></tr>
<tr><td>name_asc</td><td>Ordena por nome do produto dos posts de forma crescente</td></tr>
<tr><td>name_desc</td><td>Ordena por nome do produto dos posts de forma descrescente</td></tr>
</table>
<pre>
<code><span style="font-size: medium">Exemplo 1: http://localhost:8080/products/followed/1/list</span></code>
<code><span style="font-size: medium">Exemplo 2: http://localhost:8080/products/followed/1/list?order=date_asc</span></code>
<code><span style="font-size: medium">Exemplo 3: http://localhost:8080/products/followed/1/list?order=date_desc</span></code>
<code><span style="font-size: medium">Response (Status: 202 - Accepted):</span></code>

    [
        {
            "userId": 0,
            "posts": [
                {
                    "idPost": 0,
                    "date": "2021-07-09",
                    "detail": {
                        "productId": 0,
                        "productName": "Cadeira Gamer",
                        "type": "Gamer",
                        "brand": "DT3 Racer",
                        "color": "Black",
                        "notes": "Elise - Racer"
                    },
                    "category": 100,
                    "price": 1300.50
                },
                {
                    ...
                }
            ]
        },
        {
            ...
        }
    ]

</pre>

<pre>
<table>
<tr><th colspan="3">Parâmetros</th></tr>
<tr style="text-align: left"><th>Parâmetro</th><th>Tipo</th><th>Descrição/Exemplo</th></tr>
<tr style="text-align: left"><td>userId (endpoint)</td><td>int</td><td>Identificador único do comprador </td></tr>
<tr style="text-align: left"><td>userId (response)</td><td>int</td><td>Identificador único do vendedor </td></tr>
<tr style="text-align: left"><td>posts</td><td>Object List</td><td>Posts do vendedor seguido</td></tr>
<tr style="text-align: left"><td>idPost</td><td>int</td><td>Identificador único do post</td></tr>
<tr style="text-align: left"><td>date</td><td>String</td><td>Data do post</td></tr>
<tr style="text-align: left"><td>detail</td><td>Object</td><td>Produto do post</td></tr>
<tr style="text-align: left"><td>productId</td><td>int</td><td>Identificador único do produto</td></tr>
<tr style="text-align: left"><td>productName</td><td>String</td><td>Nome do produto</td></tr>
<tr style="text-align: left"><td>type</td><td>String</td><td>Tipo do produto</td></tr>
<tr style="text-align: left"><td>brand</td><td>String</td><td>Marca do produto</td></tr>
<tr style="text-align: left"><td>color</td><td>String</td><td>Cor do produto</td></tr>
<tr style="text-align: left"><td>notes</td><td>String</td><td>Observações a respeito do produto</td></tr>
<tr style="text-align: left"><td>category</td><td>int</td><td>Categoria do post</td></tr>
<tr style="text-align: left"><td>price</td><td>double</td><td>Preço do produto</td></tr>
</table>
</pre>

#### 8. Dar unfollow em um vendedor/seller (US 0007)

<p><code>Method: POST</code><br><code>Sign: http://localhost:8080/users/{userId}/unfollow/{userIdToUnfollow}</code></p>
<pre>
<code><span style="font-size: medium">Exemplo: http://localhost:8080/users/1/unfollow/0</span></code>
<code><span style="font-size: medium">Response (Status: 201 - Created):</span></code>

    {
        "message": "Seguidor desvinculado"
    }

</pre>

<pre>
<table>
<tr><th colspan="3">Parâmetros</th></tr>
<tr style="text-align: left"><th>Parâmetro</th><th>Tipo</th><th>Descrição/Exemplo</th></tr>
<tr style="text-align: left"><td>userId</td><td>int</td><td>Identificador único do usuário que irá seguir</td></tr>
<tr style="text-align: left"><td>userIdToUnfollow</td><td>int</td><td>Identificador único do usuário que será seguido</td></tr>
<tr style="text-align: left"><td>message</td><td>String</td><td>Mensagem retornada do servidor</td></tr>
</table>
</pre>

#### 9. Realizar a publicação de um novo produto promocional (US 0010)

<p><code>Method: POST</code><br><code>Sign: http://localhost:8080/products/newpromopost</code></p>
<pre>
<code><span style="font-size: medium">Exemplo: http://localhost:8080/products/newpromopost</span></code>
<code><span style="font-size: medium">Body:</span> </code>

    {
        "userId": 0,
        "id_post" : 0,
        "date" : "10-07-2021",
        "detail" :
                { 
                    "product_id" : 0,
                    "productName" : "Cadeira Gamer",
                    "type" : "Gamer",
                    "brand" : "DT3 Racer",
                    "color" : "Black",
                    "notes" : "Elise - Racer"
                },
        "category" : 100,
        "price" : 1200.50,
        "hasPromo":true,
        "discount":200.50
    }

<code><span style="font-size: medium">Response (Status: 201 - Created):</span></code>

    {
        "userId": 0,
        "idPost": 0,
        "date": "10-07-2021",
        "detail": {
            "productId": 0,
            "productName": "Cadeira Gamer",
            "type": "Gamer",
            "brand": "DT3 Racer",
            "color": "Black",
            "notes": "Elise - Racer"
        },
        "category": 100,
        "price": 1200.50,
        "hasPromo": true,
        "discount": 200.50
    }

</pre>

<pre>
<table>
<tr><th colspan="3">Parâmetros</th></tr>
<tr style="text-align: left"><th>Parâmetro</th><th>Tipo</th><th>Descrição/Exemplo</th></tr>
<tr style="text-align: left"><td>userId</td><td>int</td><td>Identificador único do usuário/vendedor </td></tr>
<tr style="text-align: left"><td>idPost</td><td>int</td><td>Identificador único do post</td></tr>
<tr style="text-align: left"><td>date</td><td>String</td><td>Data do post</td></tr>
<tr style="text-align: left"><td>detail</td><td>Object</td><td>Produto do post</td></tr>
<tr style="text-align: left"><td>productId</td><td>int</td><td>Identificador único do produto</td></tr>
<tr style="text-align: left"><td>productName</td><td>String</td><td>Nome do produto</td></tr>
<tr style="text-align: left"><td>type</td><td>String</td><td>Tipo do produto</td></tr>
<tr style="text-align: left"><td>brand</td><td>String</td><td>Marca do produto</td></tr>
<tr style="text-align: left"><td>color</td><td>String</td><td>Cor do produto</td></tr>
<tr style="text-align: left"><td>notes</td><td>String</td><td>Observações a respeito do produto</td></tr>
<tr style="text-align: left"><td>category</td><td>int</td><td>Categoria do post</td></tr>
<tr style="text-align: left"><td>price</td><td>double</td><td>Preço do produto</td></tr>
<tr style="text-align: left"><td>hasPromo</td><td>boolean</td><td>Indicativo de promoção sobre o produto podendo ser true ou false</td></tr>
<tr style="text-align: left"><td>discount</td><td>double</td><td>Valor do desconto</td></tr>
</table>
</pre>

#### 10. Obtenha o quantidade de produtos promocionais de um vendedor específico (US 0011)

<p><code>Method: GET</code><br><code>Sign: http://localhost:8080/products/{userId}/countPromo/</code></p>
<pre>
<code><span style="font-size: medium">Exemplo: http://localhost:8080/products/0/countPromo/</span></code>
<code><span style="font-size: medium">Response (Status: 202 - Accepted):</span></code>

    {
        "userId": 0,
        "userName": "Vicente",
        "promoProductsCount": 1
    }

</pre>

<pre>
<table>
<tr><th colspan="3">Parâmetros</th></tr>
<tr style="text-align: left"><th>Parâmetro</th><th>Tipo</th><th>Descrição/Exemplo</th></tr>
<tr style="text-align: left"><td>userId</td><td>int</td><td>Identificador único do determinado usuário/vendedor</td></tr>
<tr style="text-align: left"><td>userName</td><td>String</td><td>Nome do determinado usuário/vendedor</td></tr>
<tr style="text-align: left"><td>promoProductsCount</td><td>int</td><td>Quantidade de posts promocionais</td></tr>
</table>
</pre>

#### 11. Obter uma lista de todos os produtos promocionais de um vendedor específico (US 0012 / extra: ordenação)

<p>
    <code>Method: GET</code><br>
    <code>Sign (Ordenação Padrão): http://localhost:8080/products/{userId}/list</code><br>
    <code>Sign (Por data): http://localhost:8080/products/{userId}/list?order={order}</code>
</p>

<table>
<tr><th>Parâmetro (order)</th><th>Descrição</th></tr>
<tr><td>date_asc</td><td>Ordena por data dos posts de forma crescente</td></tr>
<tr><td>date_desc</td><td>Ordena por data dos posts de forma descrescente</td></tr>
<tr><td>name_asc</td><td>Ordena por nome do produto dos posts de forma crescente</td></tr>
<tr><td>name_desc</td><td>Ordena por nome do produto dos posts de forma descrescente</td></tr>
</table>
<pre>
<code><span style="font-size: medium">Exemplo 1: http://localhost:8080/products/0/list</span></code>
<code><span style="font-size: medium">Exemplo 2: http://localhost:8080/products/0/list?order=date_asc</span></code>
<code><span style="font-size: medium">Exemplo 3: http://localhost:8080/products/0/list?order=date_desc</span></code>
<code><span style="font-size: medium">Response (Status: 202 - Accepted):</span></code>

    {
        "userId": 0,
        "posts": [
            {
                "idPost": 1,
                "date": "2021-07-10",
                "detail": {
                    "productId": 1,
                    "productName": "Cadeira Gamer",
                    "type": "Gamer",
                    "brand": "DT3 Racer",
                    "color": "Black",
                    "notes": "Elise - Racer"
                },
                "category": 100,
                "price": 1200.50,
                "hasPromo": true,
                "discount": 200.50
            },
            {
                ...
            }
        ],
        "userName": "Vicente"
    }

</pre>

<pre>
<table>
<tr><th colspan="3">Parâmetros</th></tr>
<tr style="text-align: left"><th>Parâmetro</th><th>Tipo</th><th>Descrição/Exemplo</th></tr>
<tr style="text-align: left"><td>userId</td><td>int</td><td>Identificador único do vendedor </td></tr>
<tr style="text-align: left"><td>posts</td><td>Object List</td><td>Posts do vendedor</td></tr>
<tr style="text-align: left"><td>idPost</td><td>int</td><td>Identificador único do post</td></tr>
<tr style="text-align: left"><td>date</td><td>String</td><td>Data do post</td></tr>
<tr style="text-align: left"><td>detail</td><td>Object</td><td>Produto do post</td></tr>
<tr style="text-align: left"><td>productId</td><td>int</td><td>Identificador único do produto</td></tr>
<tr style="text-align: left"><td>productName</td><td>String</td><td>Nome do produto</td></tr>
<tr style="text-align: left"><td>type</td><td>String</td><td>Tipo do produto</td></tr>
<tr style="text-align: left"><td>brand</td><td>String</td><td>Marca do produto</td></tr>
<tr style="text-align: left"><td>color</td><td>String</td><td>Cor do produto</td></tr>
<tr style="text-align: left"><td>notes</td><td>String</td><td>Observações a respeito do produto</td></tr>
<tr style="text-align: left"><td>category</td><td>int</td><td>Categoria do post</td></tr>
<tr style="text-align: left"><td>price</td><td>double</td><td>Preço do produto</td></tr>
<tr style="text-align: left"><td>hasPromo</td><td>boolean</td><td>Indicativo de promoção sobre o produto podendo ser true ou false</td></tr>
<tr style="text-align: left"><td>discount</td><td>double</td><td>Valor do desconto</td></tr>
<tr style="text-align: left"><td>userName</td><td>String</td><td>Nome do usuário/vendedor</td></tr>
</table>
</pre>