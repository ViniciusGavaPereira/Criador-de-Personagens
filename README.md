# Criador de personagens

A ideia para este projeto é praticar a criação de Api's que consomem outras Api's.

Para desenvolvere esta habilidade decidi usar uma Api publica do jogo Dungeon and Dragons.

#### Link da API: https://www.dnd5eapi.co/ 

Colocando apenas um nome e o sexo, o sistema gera um level e busca de três api's que o site acima provisiona, trazendo informações diferentes que comopõem um personagem de RPG: raça, alinhamento e classe. 

Para criar um personagem aleatório para cada chamada de Api, o sistema faz a chamada, mede o tamanho da resposta e busca um número aleatória entre zero, e o valor máximo de respostas.

# Entidades


## Personagem 

### Get: 

    - Buscar todos: localhost:8080/character/all
    - Buscar por Id: localhost:8080/character/{id}

### Post:

    - Criar persoangem: localhost:8080/character/createCharacter/v1/{id_usuário}/{"name": "Vinicius","sex": "man"}


### Put

    - Modificador de personagem: localhost:8080/character/{id_personagem}/{"name": "Jane","sex": "woman","race": "dwarf","level": 10,"characterClass": "Warrior","alignments": "lawfull-evil"}


### Delete

    - Deletar personagem: localhost:8080/character/{id personagem}


## Usuário 

### Get: 

    - Buscar todas as contas: localhost:8080/account/all
    - Buscar conta por Id: localhost:8080/account/{id}

### Post:

    - Criar conta: localhost:8080/account/{"name": "Gabriel","email": "gabriel-gava@outlook.com.br","cpf": "06527498870","password": "Gabriel@12"}

### Put

    - Modificador conta:localhost:8080/account/{Id usuário}/{"name": "Gabriel Azinheira","email": "gabriel-gava@outlook.com.br","cpf": "06527498870","password": "Gabriel@12"}


### Delete

    - Deletar usuário: localhost:8080/account/{id usuário}