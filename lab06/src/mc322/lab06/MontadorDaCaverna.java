package mc322.lab06;

public class MontadorDaCaverna {
	private Caverna caverna;
	private Componente componente;
	private String[] vetorAuxiliar = new String[4];
	private String[] vetorAuxiliar2 = new String[2];
	private String componenteType;
	private int Yc,Xc;  //Coordenada Y e coordenada X do componente
	private int Yw,Xw; // Y do wumpus e X do Wumpus;
	
	//CONSTRUTOR:
	public MontadorDaCaverna() {
	
	}
	public void criaCaverna() {
		caverna= new Caverna();
		caverna.criaCaverna();
	}
	
	public Componente posicionaComponentes(String[][] posicaoComponentes){ //lê matriz das posições e componentes,cria componentes e verifica se pode posicionar(se puder posiciona)
		Componente heroi = null;
		for(int linha=0; linha<16; linha++) {
				vetorAuxiliar = posicaoComponentes[linha][0].split("",0);
				Yc = Integer.parseInt(vetorAuxiliar[0])-1;
				Xc = Integer.parseInt(vetorAuxiliar[2])-1;
				vetorAuxiliar2 = posicaoComponentes[linha][1].split("",0);
				componenteType = vetorAuxiliar2[0];
				
				switch(componenteType) {
					
					case "P":
						componente = new Heroi(caverna);
						heroi = componente;
						if((componente.posiciona(caverna, Yc, Xc))==0) {
							 System.exit(0);
						}
						break;
					case "W":
						componente = new Wumpus(caverna);
						if((componente.posiciona(caverna, Yc, Xc))==0) {
							System.exit(0);
						}
						else {
							Yw = Yc;
							Xw = Xc;
							if(Yc+1<4) {
								componente = new Fedor(caverna);
								componente.posiciona(caverna, Yc+1, Xc);
								
							}
							if(Yc-1>-1) {
								componente = new Fedor(caverna);
								componente.posiciona(caverna, Yc-1, Xc);
							}
							if(Xc+1<4) {
								componente = new Fedor(caverna);
								componente.posiciona(caverna, Yc, Xc+1);
								
							}
							if(Xc-1>-1) {
								componente = new Fedor(caverna);
								componente.posiciona(caverna, Yc, Xc-1);
								
							}
						}
						break;
						
					case "B":
						componente = new Buraco(caverna);
						if((componente.posiciona(caverna, Yc, Xc))==0) {
							 // PRECISA DESLIGAR O PROGRAMA;
						}
						else {
							if(Yc+1<4) {
								componente = new Brisa(caverna);
								componente.posiciona(caverna, Yc+1, Xc);
								
							}
							if(Yc-1>-1) {
								componente = new Brisa(caverna);
								componente.posiciona(caverna, Yc-1, Xc);
							}
							if(Xc+1<4) {
								componente = new Brisa(caverna);
								componente.posiciona(caverna, Yc, Xc+1);
								
							}
							if(Xc-1>-1) {
								componente = new Brisa(caverna);
								componente.posiciona(caverna, Yc, Xc-1);
								
							}
						}
						break;
						
					case "O":
						componente = new Ouro(caverna);
						if((componente.posiciona(caverna, Yc, Xc))==0) {
							System.exit(0);
						}
						break;
						
					case "_": 
						componente = new Componente(caverna);
						componente.posiciona(caverna, Yc, Xc);
						break;
				}
		}
		return heroi;
	}
	public void printaCaverna() {
		caverna.imprimirCaverna();
	}
	public void removeFedor() {
		if(Yw+1<4) {
			caverna.removeFedor(Yw+1,Xw);
			
		}
		if(Yw-1>-1) {
			caverna.removeFedor(Yw-1,Xw);
			
		}
		if(Xw+1<4) {
			caverna.removeFedor(Yw,Xw+1);
			
		}
		if(Xw-1>-1) {
			caverna.removeFedor(Yw,Xw-1);
			
			
		}
		
	}
}
