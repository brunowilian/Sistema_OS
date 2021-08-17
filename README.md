# Sistema OS
## Sistema para controle de ordem de serviços 

#### Foi usando o MySQL como banco de dados.

### Tela de Login 
![WhatsApp Image 2021-08-17 at 00 16 02](https://user-images.githubusercontent.com/81261373/129658260-834667fe-1800-48b3-aee3-d14f5ac80d6c.jpeg)
#### O sistema tem dois tipos de login, o administrador e o usuario básico, caso entre como usuario, a tela de cadastro de usuarios será desabilitada. caso não tenha conexão com o banco de dados, a imagem com conexão irá mudar.

### Tela Principal
![WhatsApp Image 2021-08-17 at 00 16 30](https://user-images.githubusercontent.com/81261373/129658479-aba1c46b-c5a0-4877-9a36-f4194ce4d3e8.jpeg)

### Tela de cadastro de usuarios
![Usuarios](https://user-images.githubusercontent.com/81261373/129658610-d45063bf-c338-46e8-a65c-aacddf1affed.jpeg)
#### O primeiro botão é para adicionar um usuario básico no sistema ou colocar um novo administrador no sistema, O segundo botão é para pesquisar o usuario pelo id, o terceiro botão é para fazer uma alteração no perfil do usuario pesquisado, o quarto botão é para excluir um usuario, tanto um administrador ou um usuario básico.

### Tela de Clientes
![clientes](https://user-images.githubusercontent.com/81261373/129659340-eb87607b-d973-49c3-bf5a-8d714cd8ea14.jpeg)
#### Essa tela é para cadastrar um novo clientes, fazer uma alteração de um antigo ou excluir o mesmo. No momento que é realizado uma pesquisa no banco de dados e selecionado um cliente já cadastrado, a opção de cadastrar um novo cliente fica indisponivel, assim só podendo realizar uma alteração ou excluir o cliente. No momento da pesquisa do cliente, a tabela já é preenchida com os resultados correspondentes, quando clicar no nome ele preenche todos os campos.

### Tela OS
![OS](https://user-images.githubusercontent.com/81261373/129659888-c1154fe0-a8ae-43d6-826b-16e6508ac0f0.jpeg)
#### Tela para fazer uma ordem de serviço, Uma OS pode ter um mesmo id, que é o mesmo do cliente, porém não pode ter o mesmo número de OS, quando é realizado a buscar pela cliente e selecionado o cliente ele já colocar o id do cliente na ordem de serviço, o número de OS, a data e o Id não pode ser modificados. Os botãoes, tem opção de adicionar uma OS, pesquisar uma OS (caso for realizado uma pesquisa o botão de adicioanr é desabilidado), alterar um OS e excluir uma OS.
