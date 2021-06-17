package thinIceModel;

public class Labirinto implements Mapa {
	private Sala salas[][];
	
	public Labirinto() {
		
	}
	
	public void criaMapa() {
		salas = new Sala[19][15];
		for(int x=0; x<19; x++) {
			for(int y=0; y<15 ; y++) {
				salas[x][y] = new Sala();
			}
		}
	}
	
	public String posiciona(int Xp, int Yp, IEntidade entidade) {
		return salas[Xp][Yp].posiciona(entidade);
	}
	public String posiciona(int Xp, int Yp, IPuffle puffle) {
		return salas[Xp][Yp].posiciona(puffle);
	}
//	public String posiciona(int Xp, int Yp, Teleporte teleporte) {
//		salas[Xp][Yp] = teleporte;
//		return "T";
//	}
	public String[][] rePosiciona(int Xi, int Yi,int Xf,int Yf, IEntidade entidade) { // retorna matriz 2x2: posição <-> oq printar
		String vet[][]= new String[2][2];
		vet[0][0] = ""+ Xi +"," +Yi;
		vet[1][0] = ""+ Xf +"," +Yf;
		vet[1][1] = salas[Xf][Yf].posiciona(entidade);
		if(vet[1][1]!=null) {
			vet[0][1] = salas[Xi][Yi].desposiciona(entidade);
			return vet;
		}
		return null;
	}
	public String[][] rePosiciona(int Xi, int Yi,int Xf,int Yf, IPuffle entidade) { // retorna matriz 2x2: posição <-> oq printar
		String vet[][]= new String[2][2];
		vet[0][0] = ""+ Xi +"," +Yi;
		vet[1][0] = ""+ Xf +"," +Yf;
		vet[1][1] = salas[Xf][Yf].posiciona(entidade);
		if(vet[1][1]!=null) {
			vet[0][1] = salas[Xi][Yi].desposiciona(entidade);
			return vet;
		}
		return null;
	}
	public boolean verificaAfogamento(int Xp,int Yp, boolean chave) { // return true-> AFOGOU
		if(salas[Xp+1][Yp].derretidaOuOcupada(chave) && salas[Xp-1][Yp].derretidaOuOcupada(chave) && salas[Xp][Yp+1].derretidaOuOcupada(chave) && salas[Xp][Yp-1].derretidaOuOcupada(chave)) {
			return true;
		}
		return false;
	}
	
	
}
