package mc322.lab05b;

public class Peao extends Peca {

	public Peao(boolean O, int C) {
		super(O, C);
		if( C==1) {
			type = "b";
		}
		else {
			type="p";
		}
	}
	
	public int movimenta(String vet[]) {
		int comeu=1; //0 nao move, 1 move, 2 come;
		int Tvet = vet.length;
		if(Tvet>3 || vet[Tvet-1].equals("-") == false){
			return 0;
		}
		for(int i=1; i<Tvet; i++){
			if(vet[0].equalsIgnoreCase(vet[i])) {
				return 0;
			}
			else if(vet[i].equals("-")==false) {
					comeu = 2;
			}
		}
		
		return comeu;
	}

}
