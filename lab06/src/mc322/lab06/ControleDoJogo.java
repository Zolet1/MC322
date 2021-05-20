package mc322.lab06;

import java.util.Scanner;

public class ControleDoJogo {
	private MontadorDaCaverna montador;
	private String[][] posicaoComponentes;
	private String comando,nomeDoJogador;
	private Componente heroi;
	private int aux;
	private int pontos = 0;
	private int contadora = 0;
	
	public ControleDoJogo() {
		montador = new MontadorDaCaverna(); 
	}
	
	public void executaJogo(String path, String nick) {
		nomeDoJogador = nick; 
		montador.criaCaverna();
		CSVHandling csv = new CSVHandling();
		csv.setDataSource(path);
		posicaoComponentes = csv.requestCommands();
		heroi = montador.posicionaComponentes(posicaoComponentes);
		montador.printaCaverna();
		System.out.println("Player: "+nomeDoJogador);
		System.out.println("Score: "+pontos);
		
		Scanner scanf = new Scanner(System.in);
		while(true) {
			comando = scanf.nextLine();
			if(comando.equals("k")) {
					 aux = heroi.equipaFlecha();
					montador.printaCaverna();
					switch(aux) {
					case 1:
						System.out.println("Player: "+nomeDoJogador);
						System.out.println("Score: "+pontos); 
						pontos = pontos-100;
						System.out.println("Herói: Equipei a flecha!");
						
						
						break;
					case 2:
						System.out.println("Player: "+nomeDoJogador);
						System.out.println("Score: "+pontos); 
						System.out.println("Herói: Minha flecha já está equipada");
						break;
					case 3:
						System.out.println("Player: "+nomeDoJogador);
						System.out.println("Score: "+pontos); 
						System.out.println("Herói: Não tenho mais flexas");
						
					}
			}
			else if(comando.equals("c")) {
				if(heroi.pegaOuro()) {
					montador.printaCaverna();
					System.out.println("Player: "+nomeDoJogador);
					System.out.println("Score: "+pontos); 
					System.out.println("Herói: Peguei o ouro!");
				}
				else {
					System.out.println("Player: "+nomeDoJogador);
					System.out.println("Score: "+pontos); 
					System.out.println("Herói: Não tem ouro aqui.");
				}
			}
			else if(comando.equals("q")) {
				System.out.println("Volte sempre !");
				System.exit(0);
			}
			else {
				aux=heroi.rePosiciona(comando);
				if(aux==3||aux==13) {
					montador.removeFedor();
				}
				montador.printaCaverna();
				switch(aux) {
					case 0:
						if(contadora>=2) {
							pontos=pontos-100000000;
							System.out.println("Player: "+nomeDoJogador);
							System.out.println("Score: "+pontos);
							System.out.println("Professor tentando achar problema no meu programa? -100000000 pontos");
							
						}
						else {
							pontos = pontos-100;
							System.out.println("Player: "+nomeDoJogador);
							System.out.println("Score: "+pontos);
							System.out.println("Comando invalido! -100 pontos pra deixar de ser besta (-_-;)");
						}
						contadora++;
						break;
					case 1:
						pontos=pontos-15;
						System.out.println("Player: "+nomeDoJogador);
						System.out.println("Score: "+pontos);
						break;
					case 2:
						pontos=pontos-15;
						pontos=pontos-1000;
						System.out.println("Player: "+nomeDoJogador);
						System.out.println("Score: "+pontos); 
						System.out.println("Herói: AAAAAAAAAAAAAAaaa... ");
						System.out.println("Game Over: O herói caiu no buraco ");
						System.out.println("Você perdeu =( ... ");
						System.exit(0);
						
						break;
					case 3:
						pontos = pontos+500;
						pontos = pontos-15;
						System.out.println("Player: "+nomeDoJogador);
						System.out.println("Score: "+pontos); 
						System.out.println("Herói: Matei o Wumpus! ");
						break;
					case 13:
						pontos = pontos+500;
						pontos = pontos-15;
						System.out.println("Player: "+nomeDoJogador);
						System.out.println("Score: "+pontos); 
						System.out.println("Herói: Matei o Wumpus! ");
						System.out.println("Herói: Sinto uma brisa. ");
						break;
					case 4:
						pontos = pontos -15;
						pontos = pontos-1000;
						System.out.println("Player: "+nomeDoJogador);
						System.out.println("Score: "+pontos); 
						System.out.println("Wumpus: Herói fraco, Wumpus matar mesmo ");
						System.out.println("Game Over: O Wumpus matou o heroi ");
						System.out.println("Você perdeu =( ... ");
						
						break;
					case 11:
						pontos=pontos-15;
						System.out.println("Player: "+nomeDoJogador);
						System.out.println("Score: "+pontos);  
						System.out.println("Herói: Sinto uma brisa. ");
						break;
					case 101:
						pontos=pontos-15;
						System.out.println("Player: "+nomeDoJogador);
						System.out.println("Score: "+pontos); 
						System.out.println("Herói: Sinto fedor forte. ");
						break;

					case 1001:
						pontos=pontos-15;
						System.out.println("Player: "+nomeDoJogador);
						System.out.println("Score: "+pontos); 
						System.out.println("Herói: Achei o ouro! ");
						break;
					case 111:
						pontos=pontos-15;
						System.out.println("Player: "+nomeDoJogador);
						System.out.println("Score: "+pontos); 
						System.out.println("Herói: Sinto uma brisa. ");
						System.out.println("Herói: Sinto fedor forte. ");
						break;
					case 1011:
						pontos=pontos-15;
						System.out.println("Player: "+nomeDoJogador);
						System.out.println("Score: "+pontos); 
						System.out.println("Herói: Achei o ouro! ");
						System.out.println("Herói: Sinto uma brisa. ");
						break;
					case 1101:
						pontos=pontos-15;
						System.out.println("Player: "+nomeDoJogador);
						System.out.println("Score: "+pontos); 
						System.out.println("Herói: Achei o ouro! ");
						System.out.println("Herói: Sinto fedor forte. ");
						break;
					case 1111:
						pontos=pontos-15;
						System.out.println("Player: "+nomeDoJogador);
						System.out.println("Score: "+pontos);
						System.out.println("Herói: Achei o ouro! ");
						System.out.println("Herói: Sinto uma brisa. ");
						System.out.println("Herói: Sinto fedor forte. ");
					case 8000:
						pontos= pontos-15;
						pontos= pontos+1000;
						System.out.println("Player: "+nomeDoJogador);
						System.out.println("Score: "+pontos);
						System.out.println("O herói saiu da caverna! ");
						System.out.println("Você ganhou =D !!! ");
						System.exit(0);
				}
			}
			
		}
		
		
		
		
		
	}
}
