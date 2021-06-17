package thinIceModel;

public interface IEntidade {

	public String posiciona(int Xp, int Yp , Mapa labirinto);
	
	public void rePosiciona(int Xi, int Yi,int Xf,int Yf);
	
	public String getType();
	
}
