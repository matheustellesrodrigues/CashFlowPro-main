# CashFlow
Uma API de controle de despesas pesssoais.


## Endpoints

- Categorias
    - [Listar Todas](#listar-todas)
    - [Detalhar](#detalhar-categoria)
    - [Cadastrar](#cadastrar-categoria)
    - [Apagar](#apagar-categoria)
    - [Editar](#editar-categoria)

- Movimentações 

---
### Listar Todas

`GET` / categoria 

Retorna um array com todas as ctegorias cadastradas.

**Exemplo de Resposta**

```js
[
    {
    "id": 1,
    "nome": "alimentação",
    "icone": "fast-food"
    }
]
```
**Códigos de Status**

| código | descrição|
|--------|----------|
|200|Dados retornados com sucesso

--- 

### Detalhar Categoria

`GET` /categoria/{id}  para pegar uma categoria especifica 

Retornar os dados da categoria com o `id` informado.

**Exemplo de Resposta**

```js
{
    "id": 1,
    "nome": "alimentação",
    "icone": "fast-food"
}
```

**Códigos de Status**

| código | descrição|
|--------|----------|
|200|Dados retornados com sucesso
|404| Id da categoria não encontrado 

--- 

### Cadastrar Categoria

`POST` /categoria

Insere uma nova categoria.

**Corpo da requisição**

|campo|tipo|obrigatório|descrição
|-----|----|:-----------:|---------
|nome|string|✅|um nome curto para a categoria
|icone|string|❌|O nome do ícone conforme Material Icons


```js
{
    "nome": "alimentação",
    "icone": "fast-food"
}
```

**Exemplo de Resposta**

```js
{
    "id": 1,
    "nome": "alimentação",
    "icone": "fast-food"
}
```

**Códigos de Status**

| código | descrição|
|--------|----------|
|200|Dados retornados com sucesso
|400| Erro de validação - verifique o corpo da requisição

---

### Apagar Categoria

`DELETE` /categoria/{id}  para pegar uma categoria especifica 

Apaga a categoria com o `id` informado.

**Códigos de Status**

| código | descrição|
|--------|----------|
|204|Categoria apagada com sucesso
|404| Id da categoria não encontrado 

--- 


### Editar Categoria

`PUT` /categoria

Atualizar os dados das informações do `id` informado.

**Corpo da requisição**

|campo|tipo|obrigatório|descrição
|-----|----|:-----------:|---------
|nome|string|✅|um nome curto para a categoria
|icone|string|✅|O nome do ícone conforme Material Icons


```js
{
    "nome": "alimentação",
    "icone": "fast-food"
}
```

**Exemplo de Resposta**

```js
{
    "id": 1,
    "nome": "alimentação",
    "icone": "fast-food"
}
```

**Códigos de Status**

| código | descrição|
|--------|----------|
|200|Categoria atualizada com sucesso
|400| A validação falhou - verifique o corpo da requisição
|404| Id da categoria não encontrado

---
