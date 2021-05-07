package mc322.lab05b;

public class Tabuleiro {
	private Peca Tab[][];
	
	// CONSTRUTOR:
	public Tabuleiro() {
		
	}
		
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public Peca[][] getTab() {
		return Tab;
	}
	public void setTab(Peca tab[][]) {
		Tab = tab;
	}
	

	public void criaTabuleiro() {
		Tab = new Peca[8][8];
		for(int linha=0;linha<8;linha++) {
			for(int coluna=0; coluna <8; coluna++) {
				Tab[linha][coluna] = new Peca(false, 0);
			}
		}
		//BRANCAS:
		for(int linha=0 ; linha<3 ; linha++ ) {
			for(int coluna=linha%2 ; coluna<8 ; coluna = coluna+2) {
				Tab[linha][coluna] = new Peao(true, 1);
			}
		}
		//PRETAS:
		for(int linha=5 ; linha<8 ; linha++ ) {
			for(int coluna=linha%2 ; coluna<8 ; coluna = coluna+2) {
				Tab[linha][coluna] = new Peao(true, 0);
			}
		}
	}
	
	public void imprimirTabuleiro(){
		for(int linha=7 ; linha>=0  ; linha-- ) {
			for(int coluna=0 ; coluna <8 ; coluna++ ){
				if (coluna == 0) {
					System.out.print(linha+1);
					System.out.print(" ");
				}
				if (coluna != 0) {
					System.out.print(" ");
				}
				if(this.Tab[linha][coluna] == null) {
					System.out.print(" ");
					continue;
				}
				System.out.print(Tab[linha][coluna].getType());
			}
				System.out.println("");
		}
		System.out.println("  a b c d e f g h");
	}

	public int solicitaMovimento(int Yp, int Xp, int Yj, int Xj) {
		if(Yp==Yj || Xp==Xj || Yj>7 || Yj<0 || Xj>7 || Xj<0) {
			return 0;
		}
		int mov; // 0 jogada invalida || 1 movimetnto normal || 2 comeu
		String vet[] = criaStrVet(Yp,Xp,Yj,Xj);
		mov = Tab[Yp][Xp].movimenta(vet); 
		if(mov!=0) {
			Tab[Yj][Xj] = Tab[Yp][Xp];
			Tab[Yp][Xp] = new Peca(false, 0);
			if(Yj==0 && Tab[Yj][Xj].type.equals("p") ) {
				Tab[Yj][Xj]= new Dama(true,0);
			}
			else if(Yj==7 && Tab[Yj][Xj].type.equals("b") ) {
				Tab[Yj][Xj]= new Dama(true,1);
			}
		}
		if(mov==2) {
			limpaTrajeto(vet,Yp,Xp,Yj,Xj);
		}
		return mov;
						
		
	}
	private String[] criaStrVet(int Yp, int Xp, int Yj, int Xj){
		int Tvet;
		int dy; 
		int dx;
		if((Yp-Yj)>0) {
			Tvet= 1 + (Yp-Yj);
			dy=-1;
		}
		else {
			Tvet= 1 + (Yj-Yp);
			dy=1;
		}
		if(Xp>Xj) {
			dx=-1;
		}
		else {
			dx=1;
		}
		int cont=0;
		String vet[] = new String [Tvet];
		while(cont<Tvet) {
			vet[cont]= Tab[Yp][Xp].getType();
			Yp=Yp+dy;
			Xp=Xp+dx;
			cont++;
		}
		return vet;
	}

	private void  limpaTrajeto(String vet[], int Yp, int Xp, int Yj, int Xj ) {
		int cont=1;
		int Tvet;
		int dy; 
		int dx;
		if((Yp-Yj)>0) {
			Tvet= 1 + (Yp-Yj);
			dy=-1;
		}
		else {
			Tvet= 1 + (Yj-Yp);
			dy=1;
		}
		if(Xp>Xj) {
			dx=-1;
		}
		else {
			dx=1;
		}
		Yp=Yp+dy;
		Xp=Xp+dx;
		if(vet[0].equalsIgnoreCase("b")) {
			while(cont<Tvet-1) {
				if(vet[cont].equalsIgnoreCase("p")) {
					Tab[Yp][Xp] = new Peca(false,0);				
				}
				Yp=Yp+dy;
				Xp=Xp+dx;
				cont++;
			}
		}
		if(vet[0].equalsIgnoreCase("p")) {
			while(cont<Tvet-1) {
				if(vet[cont].equalsIgnoreCase("b")) {
					Tab[Yp][Xp] = new Peca(false,0);
				}
				Yp=Yp+dy;
				Xp=Xp+dx;
				cont++;
			}
		}
	}
	
	public String transformTabtoString(Tabuleiro tabuleiro) {
		String transformAux = null;
		for(int linha = 7; linha >-1; linha--) {
			for(int coluna = 0; coluna < 8; coluna++) {
					transformAux += Tab[linha][coluna].getType();
		
			}
			transformAux += "\n";
		}
		return transformAux;
	}
	

	private String[] vet() {
		int contadora=0;
		String vetor[] = new String [64];
		for(int coluna = 0; coluna < 8; coluna++) {
			for(int linha = 0; linha <8; linha++) {
					vetor[contadora] = "";
					if(coluna==7) {
						vetor[contadora] += "h";
					}
					else if(coluna==6) {
						vetor[contadora] += "g";
					}
					else if(coluna==5) {
						vetor[contadora] += "f";
					}
					else if(coluna==4) {
						vetor[contadora] += "e";
					}
					else if(coluna==3) {
						vetor[contadora] += "d";
					}
					else if(coluna==2) {
						vetor[contadora] += "c";
					}
					else if(coluna==1) {
						vetor[contadora] += "b";
					}
					else if(coluna==0) {
						vetor[contadora] += "a";
					}
					vetor[contadora] += (linha+1);
					if(Tab[linha][coluna].getType().equals("-")) {
						vetor[contadora] += "_";
					
					}
					else {
						vetor[contadora] += Tab[linha][coluna].getType();
					}
					contadora++;
				}
		}	
		return vetor;
	}
		
	//public void exportarArquivo(CSVHandling csv, String[] vetor) {
		//csv.exportState(vetor);
	//}
		
	public void exportarArquivo(String saida, int flag) {
		String[] vetor;
		CSVHandling csv = new CSVHandling();
		csv.setDataExport(saida);
		if(flag==0) {
			vetor = vet();
			csv.exportState(vetor);
		}
		else {
			vetor = new String[1];
			vetor[0] = "erro";
			csv.exportState(vetor);
			
		}
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
	
}
