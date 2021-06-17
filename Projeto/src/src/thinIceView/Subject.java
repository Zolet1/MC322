package thinIceView;

public class Subject implements ISubject{
	private String[][] espelho;
	private int Xe,Ye;
	private String[] vetorAuxiliar = new String[4];
	private String[] vetorAuxiliar2 = new String[2];
	private String[] vetorAuxiliar3;
	
	
	public Subject() {		
	}
	
	public void montaEspelho(String[][] posicoes) {
		espelho = new String[19][15];
		for(int linha=0; linha<285; linha++) {
			vetorAuxiliar = posicoes[linha][0].split("",0);
			Xe = (Integer.parseInt(vetorAuxiliar[0])*10 + Integer.parseInt(vetorAuxiliar[1]))-1;
			Ye = (Integer.parseInt(vetorAuxiliar[3])*10 + Integer.parseInt(vetorAuxiliar[4]))-1;
			vetorAuxiliar2 = posicoes[linha][1].split("",0);
			espelho[Xe][Ye] = vetorAuxiliar2[0];
			
		}
	}
	public void atualiza(String[][] atualizacao) {
		if(atualizacao!=null) {
			for(int i=0; i<2; i++) {  // COMO FAZER ESSE LAÇO PRA MATRIZES DE QUALUQE DIMENÇÕES
				vetorAuxiliar3 = atualizacao[i][0].split(",",0);
				Xe = Integer.parseInt(vetorAuxiliar3[0]);
				Ye = Integer.parseInt(vetorAuxiliar3[1]);
				if(atualizacao[i][1].equals("p")) {
					espelho[Xe][Ye] = "P";
				}
				else {
				espelho[Xe][Ye] = atualizacao[i][1];
				}
			}
			print();
		}
	}
	public void print() {
		for (int y = 14; y>-1; y--) {
			for(int x = 0; x<19; x++) {
				if(x!=0) {
					System.out.print(" ");
				}
				System.out.print(espelho[x][y]);
				
				if(x==18) {
					System.out.println("");
				}
			}
		}
	}
	
}
