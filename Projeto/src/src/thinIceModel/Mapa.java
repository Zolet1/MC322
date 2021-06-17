package thinIceModel;

public interface Mapa {
	
	public void criaMapa();

	public String posiciona(int Xp, int Yp, IEntidade entidade);
	public String posiciona(int Xp, int Yp, IPuffle entidade);
	//public String posiciona(int Xp, int Yp, Teleporte teleporte);
	
	public String[][] rePosiciona(int Xi, int Yi,int Xf,int Yf, IEntidade entidade);
	public String[][] rePosiciona(int Xi, int Yi,int Xf,int Yf, IPuffle entidade);
	
	public boolean verificaAfogamento(int Xp,int Yp, boolean chave);
}
