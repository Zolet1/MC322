package thinIceModel;
 
public class Puffle extends Entidade implements IPuffle{
	private boolean chave = false;

	public Puffle() {
		super();
		Type = "P";
	}
	
	public String posiciona(int Xp, int Yp , Mapa labirinto) {
		this.Xp = Xp;
		this.Yp = Yp;
		this.labirinto = labirinto;
		return labirinto.posiciona(Xp, Yp, this);	
	}
	
	public void pegaChave() {
		chave = true;
	}
	
	public boolean getChave() {
		return chave;
	}
	
	public String[][] movimenta(String c) {
		String vet[][] =null;
		switch(c){
		
		case "w":
			vet = labirinto.rePosiciona(Xp, Yp, Xp, Yp+1, this);
			if(vet!= null) {
				Yp++;
				if(labirinto.verificaAfogamento(Xp,Yp,chave)) {
					vet[1][1] = "p"; 
				}
			}
				break;
		case "a":
			vet = labirinto.rePosiciona(Xp, Yp, Xp-1, Yp, this);
			if(vet!= null) {
				Xp--;
				if(labirinto.verificaAfogamento(Xp,Yp,chave)) {
					vet[1][1] = "p"; 
				}
			}
				break;
		case "s":
			vet = labirinto.rePosiciona(Xp, Yp, Xp, Yp-1, this);
			if(vet!= null) {
				Yp--;
				if(labirinto.verificaAfogamento(Xp,Yp,chave)) {
					vet[1][1] = "p"; 
				}
			}
				break;
		case "d":
			vet = labirinto.rePosiciona(Xp, Yp, Xp+1, Yp, this);
			if(vet!= null) {
				Xp++;
				if(labirinto.verificaAfogamento(Xp,Yp,chave)) {
					vet[1][1] = "p"; 
				}
			}
				break;
			
		}
		return vet;
		
	}
}
