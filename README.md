# Criador de personagens
A ideia para este projeto é praticar a criação de Api's que consomem outras Api's.

Para desenvolvere esta habilidade decidi usar uma Api publica do jogo Dungeon and Dragons e a API paga do chatGPT

#### Link da API de Dungeon and Dragons: https://www.dnd5eapi.co/
Colocando apenas um nome e o sexo, o sistema gera um level e busca de três endpoint's que o site acima provisiona, trazendo informações diferentes que compõem um personagem de RPG: raça, alinhamento e classe.

Para criar um personagem aleatório para cada chamada da Api, o sistema faz a chamada, mede o tamanho da resposta e busca um número aleatória entre zero, e o valor máximo de respostas.

Após a criação dos status básicos do personagem, o sistema pega estas informações e solicita que o chatGPT crie um background para o personagem com os status aleatórios previamente criados.


> [!IMPORTANTE]  
> A API do chatGPT é paga, por isso não posso disponibilizar um sistema com a minha chave, pois iria descontar da minha conta. Para usufruir da experiência completa do sistema, siga os próximos passos:

1 - Crie uma conta no site da OpenAi e carregue com créditos a sua escolha

#### Link para criação de conta: https://platform.openai.com/

2 - Baixe o repositório

3 - Vá no arquivo "application.properties" e substitua a url e a chave da API pelas suas próprias

#### Linhas que precisam ser alteradas:

openai.api.url=

openai.api.key=

#### Vídeo para auxiliar a configuração da API do chatGPT: https://youtube.com/watch?v=HlDkuFy8xRM

# Entidades

Para criar um persoagem, é necessário que ele esteja vinculado a uma conta, então primeiramente, você deve cria-la

> [!NOTA]  
> Qualquer informação envolta em colchetes {}, é uma informação que precisa ser dada pelo usuário, em casos que existem mais do que apenas um dado dentro do colchete, quer dizer que o endpoint necessita de um objetos, que deve receber as informações dentro dos colchetes.



## Endpoints da entidade Usuário 

### Get: 

    - Buscar todas as contas: localhost:8080/account/all
    - Buscar conta por Id: localhost:8080/account/{id}

### Post:

    - Criar conta: localhost:8080/account/{"name": "Gabriel","email": "gabriel-gava@outlook.com.br","cpf": "06527498870","password": "Gabriel@12"}

### Put

    - Modificador conta:localhost:8080/account/{Id usuário}/{"name": "Gabriel Azinheira","email": "gabriel-gava@outlook.com.br","cpf": "06527498870","password": "Gabriel@12"}


### Delete

    - Deletar usuário: localhost:8080/account/{id usuário}



## Endpoints da entidade Personagem
 

### Get: 

    - Buscar todos: localhost:8080/character/all
    - Buscar por Id: localhost:8080/character/{id}

### Post:

    - Criar persoangem: localhost:8080/character/createCharacter/v1/{id_usuário}/{"name": "Vinicius","sex": "man"}


### Put

    - Modificador de personagem: localhost:8080/character/{id_personagem}/{"name": "Jane","sex": "woman","race": "dwarf","level": 10,"characterClass": "Warrior","alignments": "lawfull-evil"}


### Delete

    - Deletar personagem: localhost:8080/character/{id personagem}
