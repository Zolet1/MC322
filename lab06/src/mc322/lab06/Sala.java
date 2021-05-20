package mc322.lab06;

import java.util.ArrayList;

public class Sala {
	private ArrayList<Componente> componentesNaSala = new ArrayList();
	private int visitada = 0; // se o heroi visitou a sala;
	
	//CONSTRUTOR:
	public Sala() {
		
		
	}
	
	
	public String oquePrintar() {
		String[] vet = oqueTemNaSala();
		String print = "-";
		if(visitada==1) {
			print = "#";
			for(int j=0; j<vet.length;j++) {
				if(vet[j].equals("W") || vet[j].equals("B") || vet[j].equals("O")) {
					print = vet[j];
					return print;
				}
				else if(vet[j].equals("f") && (print.equals("#") || print.equals("b")) ){
					print = vet[j];
				}
				else if(vet[j].equals("b") && print.equals("#") ) {
					print = vet[j];
				}
			}
		}
		for(int i=0; i<vet.length ; i++) {
			if( vet[i].equals("P") && (print.equals("-") || print.equals("f") || print.equals("b") || print.equals("#")) ) {
				print = vet[i];
			}
		}
		return print;
	}
	
	public String[] oqueTemNaSala() { //retorna vertor de strings do que tem na sala;
		String[] vet;
		if(componentesNaSala.isEmpty()==false) {
			vet = new String[componentesNaSala.size()];
			for(int i=0; i < componentesNaSala.size(); i++) {
				vet[i] = componentesNaSala.get(i).getType();
			}
			return vet;
		}
		vet = new String[1];
		vet[0] = "";
		
		return vet;
		
		
	}
	
	
	public int podePosicionar(Componente componente) { // verifica se pode posicionar na hora de montar a caverna, se sim retorna true e posiciona
		int aux=1;
		switch(componente.getType()) {
		
			case "P":
				for(int i=0; i<componentesNaSala.size();i++) {
					if(componentesNaSala.get(i).getType().equals("B") ){
//						System.out.println(" Herói: AAAAAAAAAAAAAAAAA ");
//						System.out.println(" Game Over: O herói caiu no buraco ");
//						System.out.println(" Você perdeu =( ... ");
//						System.exit(0);
						visitada = 1;
						return 2;
					}
					if(componentesNaSala.get(i).getType().equals("W")) {
						if(componente.getFlecha()==1 ){
							componentesNaSala.remove(i);
//							System.out.println(" Heroi: Matei o Wumpus! ");
							componente.atiraFlecha();
							visitada = 1;
							 aux = 3;
						}
						else {
//							System.out.println(" Wumpus: Herói fraco, Wumpus matar mesmo ");
//							System.out.println(" Game Over: O Wumpus matou o heroi ");
//							System.out.println(" Você perdeu =( ... ");
							return 4;
						}
					}
				}
				componentesNaSala.add(componente);
				visitada = 1;
				componente.atiraFlecha();
				for(int i=0; i<componentesNaSala.size();i++) {
					if(componentesNaSala.get(i).getType().equals("b")) {
						//System.out.println(" Herói: Sinto uma brisa. ");
						aux=aux+10;
					}
					if(componentesNaSala.get(i).getType().equals("f")) {
						//System.out.println(" Herói: Sinto fedor forte. ");
						aux=aux+100;
					}
					if(componentesNaSala.get(i).getType().equals("O")) {
						//System.out.println(" Herói: Achei o ouro! ");
						aux=aux+1000;
							
					}
		
				}
				return aux;
		
			case "W":
				for(int i=0; i<componentesNaSala.size();i++) {
					if(componentesNaSala.get(i).getType().equals("B") || componentesNaSala.get(i).getType().equals("P") || componentesNaSala.get(i).getType().equals("O")) {
						return 0;
					}
				}
				componentesNaSala.add(componente);
				return 1;
			
			case "B":
				for(int i=0; i<componentesNaSala.size();i++) {
					if(componentesNaSala.get(i).getType().equals("P") || componentesNaSala.get(i).getType().equals("W") || componentesNaSala.get(i).getType().equals("O")) {
						return 0;
					}
				}
				componentesNaSala.add(componente);
				return 1;
			
			case "O":
				for(int i=0; i<componentesNaSala.size();i++) {
					if(componentesNaSala.get(i).getType().equals("B") || componentesNaSala.get(i).getType().equals("W") || componentesNaSala.get(i).getType().equals("P")) {
						return 0;
					}
				}
				componentesNaSala.add(componente);
				return 1;
				
			case "b":
				componentesNaSala.add(componente);
				return 1;
				
			case "f":
				componentesNaSala.add(componente);
				return 1;
				
			case "_":
				
		}
		return 0;
	}
	
	public void desposiciona(Componente componente) {
		for(int i=0;i<componentesNaSala.size(); i++) {
			if(componentesNaSala.get(i).getType().equals(componente.getType())) {
				componentesNaSala.remove(i);
			}
		}
	}
	
	public boolean pegaOuro() {
		for(int i=0;i<componentesNaSala.size(); i++) {
			if(componentesNaSala.get(i).getType().equals("O")) {
				componentesNaSala.remove(i);
				return true;
			}
		}
		
		return false;
	}
	public void removeFedor() {
		for(int i=0;i<componentesNaSala.size(); i++) {
			if(componentesNaSala.get(i).getType().equals("f")) {
				componentesNaSala.remove(i);
			}
		}
	}
	public void verificaVitoria() {
		
	}
}
