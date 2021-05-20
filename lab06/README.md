# Lab06: O Mundo de Wumpus
* Você controla um herói que precisa encontrar o ouro e sair da caverna sem morrer para o monstro Wumpus ou cair em algum buraco.
* Comandos para jogar: 
  * w : movimento para cima
  * a : movimento para esquerda
  * s : movimento para baixo
  * d : movimento para direita
  * c : pega o ouro
  * k : equipa a flecha
  * q : sai do jogo
* Para iniciar o jogo, digite o endereço do arquivo de montagem da caverna e seu nome separados por espaço.
* https://github.com/Zolet1/MC322/tree/main/lab06/src/mc322/lab06
# Destaques da arquitetura:
* Aqui vou falar porque acho que meu codigo ficou bom
  ## Organização:
    * Cada classe tem sua função bem definida e respeitada, seguindo os conceitos de orientação objeto.
      * Por exemplo: A classe sala abriga os componentes, diz o que tem nada sala, qual comoponente tem prioridade na hora do print, remove e adiciona componentes e verifica se é possivel adicionar.
  ## Possibilidade de extenção:
     * O codigo permite extenção de suas funcionalidades para outras situções, como por exemplo um maior numero de componentes por sala:
    ![blasfisahdpçhsf](https://user-images.githubusercontent.com/80828532/118996140-1082bd00-b95e-11eb-8676-b848ee1aa908.PNG)
  ## Heroi controla seus itens:
     * Cabe a classe heroi o controle de seus itens, o que ajuda na organização:
      ![safasdasf](https://user-images.githubusercontent.com/80828532/118996786-8be46e80-b95e-11eb-92df-7711f6755247.PNG)
  ## Observação explicativa:
     * A classe sala retorna um inteiro que indica o que deve ser printado ao final de um movimento (movimento é solicitado ao heroi,que solicita para a caverna,que solicita para a sala) para a classe controle do jogo:
       * Retorna 0 se for uma jogada invalida
       * Retorna 1 para um movimento normal
       * Retorna 2 se o heroi cair no buraco
       * Retorna 3 se o heroi matar o Wumpus
       * Retorna 4 se o heroi morrer para o wumpus
       * Retorna 8000 se o heroi vencer o jogo
       * Soma 10 ao retorno se o heroi sentir uma brisa
       * Soma 100 ao retorno se o heroi senti fedor
       * Soma 1000 se o heroi achar o ouro
     
