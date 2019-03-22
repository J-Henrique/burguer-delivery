# Burger Delivery

Configuração do projeto
-----------------------
Para que a aplicação execute consultando dados do backend é necessário subir o serviço que está versionado na pasta **server**, na raiz do projeto.

Design e dependências
---------------------
A aplicação utiliza o padrão MVVM em seu design. Dessa forma, todos os controles de UI passam a ser reativos à eventos ocorridos na camada de acesso a dados, que por sua vez gerencia todas as requisições ao backend.

As principais dependências do projeto são:
  * **Retrofit**: trata as requisições realizadas à API, abstraindo grande parte da complexidade em comunicar com o backend e converter dados do formato JSON para objetos java;
  * **Picasso**: utilizado para obter as imagens dos produtos e as armazenar em cache, evitando requisições desnecessárias;
  * **Material Design**: deixa o layout mais limpo e intuitivo ao usuário, apresentando padrões de design de UI e melhorias de UX;
  * **Parceler**: para trafegar dados entre as activities todo objeto deve ser serializado antes de ser enviado. Sendo assim, esta dependência provê notações que facilitam a conversão de classes Java, evitando a escrita de grande quantidade de código.
  
Melhorias no backend
--------------------
Algumas melhorias poderiam ser realizadas no backend a fim de evitar processamento desnecessário por parte da aplicação. Sendo elas:
  * Ao realizar uma requisição para obter todos lanches, a API poderia trazer para cada item retornado uma lista de objetos do tipo **Ingrediente**, no intuito de evitar que a aplicação necessite realizar novas requisições para cada produto ou que precise realizar laços de repetição para identificar os ingredientes correspondentes;
  * Como os lanches já possuem uma quantidade de ingredientes definida, o valor (sem considerar as promoções) poderia ser calculado no backend;
  * O endpoint que retorna os pedidos já realizados poderia devolver objetos contendo o lanche desejado, ao invés de somente trazer seu ID. Dessa forma, evitaria que o lanche tivesse que ser identificado no código do aplicativo por meio do processamento de uma estrutura de repetição nos itens armazenados em cache.
  
Possíveis features para o futuro
----------------
  * Autenticação de usuários, para que haja um melhor controle de requisições ao backend;
  * Adicionar um campo para que seja possível buscar um lanche específico digitando seu nome, considerando que a quantidade de produtos disponíveis pode crescer com o tempo;
  * Criar um mecanismo de paginação de resultados;
  * Refatorar a UI, adicionando mais componentes de Material Design e definindo uma paleta de cores da marca.
