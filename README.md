# qualqrum API

## Overview

> API geradora de dados pessoais fictícios aleatórios.

## Demo

```

### Acesso a todos os recursos

```no-highlight
GET http://localhost:8081/
    
[
    {
        "description": "Gerar uma lista de pessoas física",
        "method": "GET",
        "href": "http://127.0.1.1:8081/pessoa/fisica/list",
        "queryParams": [
            "value=QTDE"
        ]
    },
    .
    ...
]

```

### Exemplo de saída

```no-highlight
GET http://127.0.0.1:8081/pessoa/fisica

{
    "nome": "Yago Cavalcanti",
    "email": "yago_cavalcanti@1musicrow.com",
    "telefone": "(69) 8221-1033",
    "celular": "(69) 96741-6470",
    "endereco": {
        "cep": "99.557-668",
        "logradouro": "Rua Haddock Lobo",
        "bairro": "Jardim Ângela",
        "cidade": "Guajará-Mirim",
        "estado": "Rondônia",
        "uf": "RO",
        "numero": 686
    },
    "tipoPessoa": "FISICA",
    "rg": "08.100.630-3",
    "cpf": "748.840.878-01",
    "pis": "123.456.789",
    "estadoCivil": "Casado",
    "cns": "207618434390005",
    "cnae": "123456789",
    "sexo": "Masculino",
    "dataNascimento": "8/10/1951",
    "profissao": "Atuário",
    "senha": "Mg56RK8A",
    "idade": 69,
    "filiacao": {
        "nomeMae": "Maya Infante",
        "nomePai": "Leonardo Galvão"
    },
    "sexoAbreviado": "M"
}

```