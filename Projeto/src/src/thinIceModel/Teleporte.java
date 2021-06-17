package thinIceModel;

import java.util.ArrayList;

public class Teleporte implements ISala{
	private ArrayList<IEntidade> entidadesNaSala = new ArrayList<IEntidade>();
	private Teleporte B;
	int Xt,Yt;
	
	
	public void conecta(Teleporte B) {
		this.B = B;
		B.conecta(this);
	}
	public void posiciona(int Xp, int Yp , Mapa labirinto) {
		Xt = Xp;
		Yt = Yp;
		labirinto.posiciona(Xp,Yp,this);
	}
	
	public void posiciona(IPuffle puffle) {
		B.Teleporta(puffle);
		
	}
	
	public void Teleporta(IPuffle puffle) {
		entidadesNaSala.add(puffle);
	}
	
}
