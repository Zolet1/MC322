package mc322.lab04;

public class Tabuleiro {
	public Peca tab[][];
	
	public Tabuleiro() {
	}
	
	public Peca[][] criaTabuleiro() {
		this.tab = new Peca[7][7];
		for(int linha = 0; linha < 7; linha++) {
			for(int coluna = 0; coluna < 7; coluna++) {
				if(linha == 3 && coluna == 3) {
					this.tab[linha][coluna] = new Peca(linha,coluna,0); 
					this.tab[linha][coluna].atribui(linha,coluna,0);
				}
				else {
					this.tab[linha][coluna] = new Peca(linha,coluna,1);
				}
			}
		}
		//ESPAÇOS FORA DO TABULEIRO:
		this.tab[0][0]=null;
		this.tab[0][1]=null;
		this.tab[0][5]=null;
		this.tab[0][6]=null;
		
		this.tab[1][0]=null;
		this.tab[1][1]=null;
		this.tab[1][5]=null;
		this.tab[1][6]=null;
		
		this.tab[5][0]=null;
		this.tab[5][1]=null;
		this.tab[5][5]=null;
		this.tab[5][6]=null;
		
		this.tab[6][0]=null;
		this.tab[6][1]=null;
		this.tab[6][5]=null;
		this.tab[6][6]=null;
		return this.tab;
	}
	
	public void executaJogada(int Yp, int Xp, int Yj, int Xj){
		if(this.tab[Yj][Xj] == null || this.tab[Yj][Xj] == null) {
			return;
		}
		if (Yp>6 || Yj>6 || Xp>6 || Xp>6 || this.tab[Yp][Xp].ocupado == 2) { // PARTE NOVA Q BOTEI N SEI SE FUNÇA
			return;
		}
		if(Yp==Yj) { //anda pro lado
			if(this.tab[Yj][Xj].ocupado == 0) { // verifica se a nao tem peça na posição que vai ser jogada
				if( Xj>Xp) { // ANDA PRA DIREITA
					if(this.tab[Yj][Xj-1].ocupado == 1) {  //verifica se vai comer alguma peça
						this.tab[Yj][Xj-1].atribui(Yj, Xj-1, 0); //peça comida fica vazio
						this.tab[Yj][Xj].atribui(Yj, Xj, 1);// peça chega na nova posição
						this.tab[Yp][Xp].atribui(Yp, Xp, 0);// peca na posição inicial fica vazio
					}
					else if(this.tab[Yj][Xj-1].ocupado == 0) { // ANDA PRA DIREITA E NAO COME NGM
						this.tab[Yj][Xj].atribui(Yj, Xj, 1);// peça chega na nova posição
						this.tab[Yp][Xp].atribui(Yp, Xp, 0);// peca na posição inicial fica vazio
					}
				}
				if( Xj<Xp){ // ANDA PRA DIREITA
					if( this.tab[Yj][Xj+1].ocupado == 1) { // verifica se vai comer alguma peça
							this.tab[Yj][Xj+1].atribui(Yj, Xj+1, 0); //peça comida fica vazio
							this.tab[Yj][Xj].atribui(Yj, Xj, 1); // peça chega na nova posição
							this.tab[Yp][Xp].atribui(Yp, Xp, 0); // peca na posição inicial fica vazio
					}
					else if(this.tab[Yj][Xj+1].ocupado == 0) { //não come ngm
						this.tab[Yj][Xj].atribui(Yj, Xj, 1); // peça chega na nova posição
						this.tab[Yp][Xp].atribui(Yp, Xp, 0); // peca na posição inicial fica vazio
					}
				}
			}
		}
		if(Xp==Xj) { //anda pra cima
			if(this.tab[Yj][Xj].ocupado == 0) { // verifica se a nao tem peça na posição que vai ser jogada
				if( Yj>Yp) { // ANDA PRA CIMA
					if(this.tab[Yj-1][Xj].ocupado == 1) {  //verifica se vai comer alguma peça
						this.tab[Yj-1][Xj].atribui(Yj-1, Xj, 0); //peça comida fica vazio
						this.tab[Yj][Xj].atribui(Yj, Xj, 1);// peça chega na nova posição
						this.tab[Yp][Xp].atribui(Yp, Xp, 0);// peca na posição inicial fica vazio
					}
					else if(this.tab[Yj-1][Xj].ocupado == 0) { // ANDA PRA CIMA E NAO COME NGM
						this.tab[Yj][Xj].atribui(Yj, Xj, 1);// peça chega na nova posição
						this.tab[Yp][Xp].atribui(Yp, Xp, 0);// peca na posição inicial fica vazio
					}
				}
				if( Yj<Yp){ // ANDA PRA BAIXO
					if( this.tab[Yj+1][Xj].ocupado == 1) { //verifica se vai comer alguma peça
							this.tab[Yj+1][Xj].atribui(Yj+1, Xj, 0); //peça comida fica vazio
							this.tab[Yj][Xj].atribui(Yj, Xj, 1); // peça chega na nova posição
							this.tab[Yp][Xp].atribui(Yp, Xp, 0); // peca na posição inicial fica vazio
					}
					else if(this.tab[Yj+1][Xj].ocupado == 0) { // ANDA PRA ESQUERDA e não come ngm
						this.tab[Yj][Xj].atribui(Yj, Xj, 1); // peça chega na nova posição
						this.tab[Yp][Xp].atribui(Yp, Xp, 0); // peca na posição inicial fica vazio
					}
				}
			}
		}
		
	}
	public void printTabuleiro() {
		for(int linha = 0; linha < 7; linha++) {
			for(int coluna = 0; coluna < 7; coluna++) {
				if (coluna == 0) {
					System.out.print(7 - linha);
					System.out.print(" ");
				}
				if (coluna != 0) {
					System.out.print(" ");
				}
				if(this.tab[linha][coluna] == null) {
					System.out.print(" ");
					continue;
				}
				if (this.tab[linha][coluna].ocupado == 1) {
					System.out.print(this.tab[linha][coluna].ocupado);
				}
				else {
					System.out.print("-");
				}
				}
			System.out.println("");
		}
		System.out.println("  a b c d e f g ");
	}
	
	
	
}
