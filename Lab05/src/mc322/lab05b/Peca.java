package mc322.lab05b;

public class Peca {
	protected boolean Ocupado; //true = ocupado
	protected int Cor;
	protected String type = "-";
	//CONTRUTOR:
	public Peca(boolean O, int C) {
		Ocupado = O;
		Cor = C;
		
		
	}

//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public boolean isOcupado() {
		return Ocupado;
	}

	public void setOcupado(boolean ocupado) {
		Ocupado = ocupado;
	}

	public int getCor() {
		return Cor;
	}

	public void setCor(int cor) {
		Cor = cor;
	}
	public String getType() {
		return type;
	}
	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public int movimenta(String vet[]) {
		return 0;
	}
	
}
