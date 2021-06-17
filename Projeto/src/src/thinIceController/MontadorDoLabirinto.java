package thinIceController;

import thinIceModel.Bloco;
import thinIceModel.Door;
import thinIceModel.IEntidade;
import thinIceModel.IPuffle;
import thinIceModel.Key;
import thinIceModel.Labirinto;
import thinIceModel.Mapa;
import thinIceModel.Neve;
import thinIceModel.Puffle;

public class MontadorDoLabirinto implements Montador{
	private Mapa labirinto;
	private IEntidade entidade;
	private IPuffle puffle;
	private String[] vetorAuxiliar = new String[5];
	private String[] vetorAuxiliar2 = new String[2];
	private int Ye,Xe;  //Coordenada Y e coordenada X 
	private String Type;
	
	public void criaMapa() {
		labirinto = new Labirinto();
		labirinto.criaMapa();
	}
	public IPuffle montaMapa(String[][] posicoes) {
		for(int linha=0; linha<285; linha++) {
			vetorAuxiliar = posicoes[linha][0].split("",0);
			Xe = (Integer.parseInt(vetorAuxiliar[0])*10 + Integer.parseInt(vetorAuxiliar[1]))-1;
			Ye = (Integer.parseInt(vetorAuxiliar[3])*10 + Integer.parseInt(vetorAuxiliar[4]))-1;
			vetorAuxiliar2 = posicoes[linha][1].split("",0);
			Type = vetorAuxiliar2[0];
			switch(Type) {
			
				case "P":
					puffle = new Puffle();
					if(puffle.posiciona(Xe, Ye, labirinto)==null) {
						System.out.println("Xe:"+Xe +" Ye:"+Ye +" Type="+Type );
						System.exit(0);
					}
					break;
				case "B":
					entidade = new Bloco();
					if(entidade.posiciona(Xe, Ye, labirinto)==null) {
						System.out.println("Xe:"+Xe +" Ye:"+Ye +" Type="+Type );
						System.exit(0);
					}
					break;
				case "D":
					entidade = new Door();
					if(entidade.posiciona(Xe, Ye, labirinto)==null) {
						System.out.println("Xe:"+Xe +" Ye:"+Ye +" Type="+Type );
						System.exit(0);
					}
					break;
				case "K":
					entidade = new Key();
					if(entidade.posiciona(Xe, Ye, labirinto)==null) {
						System.out.println("Xe:"+Xe +" Ye:"+Ye +" Type="+Type );
						System.exit(0);
					}
					break;
				case "N":
					entidade = new Neve();
					if(entidade.posiciona(Xe, Ye, labirinto)==null) {
						System.out.println("Xe:"+Xe +" Ye:"+Ye +" Type="+Type );
						System.exit(0);
					}
			}
		}
		return puffle;
		
		
	}
}
