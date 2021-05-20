package mc322.lab06;

public class Heroi extends Componente {
	private int Yh,Xh; //coordenadas Y e X do heroi;
	private int flecha=0; // 0 -> tem flecha,mas nao equipou. 1 -> flecha equipada. -1 -> não tem flecha  
	private boolean temOuro=false;
	//CONTRUTOR:
	public Heroi(Caverna caverna) {
		super(caverna);
		type = "P";
	}
	public int getFlecha() {
		return flecha;
	}

	public void setFlecha(int flecha) {
		this.flecha = flecha;
	}
	public boolean isTemOuro() {
		return temOuro;
	}

	public void setTemOuro(boolean temOuro) {
		this.temOuro = temOuro;
	}
	
	public int posiciona(Caverna caverna, int Yc, int Xc) {
		Yh=Yc;
		Xh=Xc;
		return caverna.posiciona(Yc, Xc, this);
		
	}
	
	public int rePosiciona(String comando ) {
		int aux=0;
		switch(comando) {
		case "w":
			if(Yh-1>-1) {
				aux = caverna.posiciona(Yh-1, Xh, this);
				if(aux!=0) {
					caverna.desposiciona(Yh, Xh, this);
					Yh--;
				}
			}
			return aux;

		case "a":
			if(Xh-1>-1) { 
				aux = caverna.posiciona(Yh, Xh-1, this);
				if(aux!=0) {
					caverna.desposiciona(Yh, Xh, this);
					Xh--;
				}
			}
			
			return aux;
		case "s":
			if(Yh+1<4) { 
				aux = caverna.posiciona(Yh+1, Xh, this);
				if(aux!=0) {
					caverna.desposiciona(Yh, Xh, this);
					Yh++;
				}
			}
			
			return aux;
		case "d":
			if(Xh+1<4) {
				aux = caverna.posiciona(Yh, Xh+1, this);
				if(aux!=0) {
					caverna.desposiciona(Yh, Xh, this);
					Xh++;
				}
			}
			return aux;
		}
		return 0;
	}

	public boolean pegaOuro() {
		if(caverna.pegaOuro(Yh, Xh)) {
			temOuro=true;
			return temOuro;
		}
		return false;
	}
	public int equipaFlecha() {
		if(flecha==0) {
			flecha = 1;
			return 1;
		}
		else if(flecha==1) {
			return 2;
		}
		else if(flecha==-1) {
			return 3;
		}
		return 5;
	}
	public void atiraFlecha() {
		if(flecha==1) {
			flecha = -1;
		}
	}
	
}