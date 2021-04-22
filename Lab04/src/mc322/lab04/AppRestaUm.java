package mc322.lab04;


public class AppRestaUm {
	
	public static Tabuleiro tabuleiro;
	public static String[] commands;
	public static String transformAux;
	public static String StringTabuleiro;
	public static String[] vet; 
	public static int Yp,Yj,Xp,Xj;
	
	public AppRestaUm() {
		AppRestaUm.commands = null;
		AppRestaUm.transformAux = "";
		AppRestaUm.StringTabuleiro = null;
		tabuleiro = new Tabuleiro();
	}
	public static void jogador( String[] commands) {
		int ncmds = commands.length;
		for (int i=0; i < ncmds;i++) {
			vet = commands[i].split("",0);
			Yp= Integer.parseInt(vet[1]) -1;
			Yj= Integer.parseInt(vet[4]) -1;
			if(vet[0].equals("a")) {
				Xp = 0;
  			}
			else if(vet[0].equals("b")) {
				Xp = 1;
  			}
			else if(vet[0].equals("c")) {
				Xp = 2;
  			}
			else if(vet[0].equals("d")) {
				Xp = 3;
  			}
			else if(vet[0].equals("e")) {
				Xp = 4;
  			}
			else if(vet[0].equals("f")) {
				Xp = 5;
  			}
			else if(vet[0].equals("g")) {
				Xp = 6;
  			}
			if(vet[3].equals("a")) {
				Xj = 0;
  			}
			else if(vet[3].equals("b")) {
				Xj = 1;
  			}
			else if(vet[3].equals("c")) {
				Xj = 2;
  			}
			else if(vet[3].equals("d")) {
				Xj = 3;
  			}
			else if(vet[3].equals("e")) {
				Xj = 4;
  			}
			else if(vet[3].equals("f")) {
				Xj = 5;
  			}
			else if(vet[3].equals("g")) {
				Xj = 6;
  			}
			tabuleiro.executaJogada(Yp, Xp, Yj, Xj);
			System.out.println("Source: " + vet[0] + vet[1]);
			System.out.println("Target: " + vet[3] + vet[4]);
			tabuleiro.printTabuleiro();
		}
	}
	
	public static String transformTabtoString(Tabuleiro tabuleiro) {
		for(int linha = 0; linha < 7; linha++) {
			for(int coluna = 0; coluna < 7; coluna++) {
				if(tabuleiro.tab[linha][coluna] == null) {
					transformAux += " ";
					continue;
				}
				if(tabuleiro.tab[linha][coluna].ocupado == 0) {
					transformAux += "-";
					continue;
				}
				if(tabuleiro.tab[linha][coluna].ocupado == 1) {
					transformAux += "P";
					continue;
				}
		
			}
			transformAux += "\n";
		}
		return transformAux;
	}
	
	public static String executaJogo(String path){
		CSVReader csv = new CSVReader();
		csv.setDataSource(path);
		commands = csv.requestCommands();
		tabuleiro.criaTabuleiro();
		System.out.println("Tabuleiro Inicial");
		tabuleiro.printTabuleiro();
		jogador(commands);
		StringTabuleiro = transformTabtoString(tabuleiro);
		return StringTabuleiro;
	}
}