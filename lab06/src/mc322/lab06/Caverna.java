package mc322.lab06;

public class Caverna {
	private Sala salas[][];
	
	//CONTRUTOR:
	public Caverna() {
		
	}
	

	public Sala[][] getSalas() {
		return salas;
	}

	public void setSalas(Sala salas[][]) {
		this.salas = salas;
	}
	
	
	public void criaCaverna() {
		salas = new Sala[4][4];
		for(int linha=0; linha<4; linha++) {
			for(int coluna=0; coluna<4; coluna++) {
				salas[linha][coluna] = new Sala();
			}
		}
	}
	
	public int posiciona(int Yc,int Xc, Componente componente) {
		if(Yc==0 && Xc==0 && componente.isTemOuro()) {
			return 8000;
		}
		return salas[Yc][Xc].podePosicionar(componente);
			
	}
	public void imprimirCaverna() {
		for(int linha=0 ; linha<4  ; linha++ ) {
			for(int coluna=0 ; coluna <4 ; coluna++ ){
				if (coluna == 0) {
					System.out.print(linha+1);
					System.out.print(" ");
				}
				if (coluna != 0) {
					System.out.print(" ");
				}
				System.out.print(salas[linha][coluna].oquePrintar());
			}
				System.out.println("");
		}
		System.out.println("  1 2 3 4");
	}
	
	public void desposiciona(int Yc,int Xc, Componente componente) {
		salas[Yc][Xc].desposiciona(componente);
	}
	public boolean pegaOuro(int Yh, int Xh) {
		return salas[Yh][Xh].pegaOuro();
		
	}
	public void removeFedor(int Yf, int Xf) {
		salas[Yf][Xf].removeFedor();
		
		
	}
}
