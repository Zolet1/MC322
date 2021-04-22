package mc322.lab04;

public class Peca {
	public int x;
	public int y;
	public int ocupado; // 0: vaziu 1:ocupado 2: fora do tabuleiro

	public Peca(int Y, int X, int ocupado) {
        this.y = Y;
        this.ocupado = ocupado;
        this.x = X;
	}
	
	public void atribui(int Y, int X, int ocupado) {
        this.y = Y;
        this.ocupado = ocupado;
        this.x = X;
	}
}
