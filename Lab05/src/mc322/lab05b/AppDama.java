package mc322.lab05b;


public class AppDama {
	public static Tabuleiro tabuleiro;
	public static String[] commands;
	public static String StringTabuleiro;
	public static String[] vet;
	public static String[] vetor;
	public static int Yp,Yj,Xp,Xj,ncmds,flag=0;
	
	public AppDama() {
		tabuleiro = new Tabuleiro();
	}
	public static void jogador( String[] commands) {
		int cont=1;
		ncmds = commands.length;
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
			else if(vet[0].equals("h")) {
				Xp = 7;
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
			else if(vet[3].equals("h")) {
				Xj = 7;
  			}
			int mov=tabuleiro.solicitaMovimento(Yp, Xp, Yj, Xj);
			if(mov==0) {
				System.out.println("Movimento invalido!");
				if(cont==ncmds) {
					flag=1;
				}
			}
			else {
				System.out.println("Source: " + vet[0] + vet[1]);
				System.out.println("Target: " + vet[3] + vet[4]);
				tabuleiro.imprimirTabuleiro();
			}
			cont++;
		}
	}
	public static String executaJogo(String path, String saida){
		CSVHandling csv = new CSVHandling();
		csv.setDataSource(path);
		csv.setDataExport(saida);
		commands = csv.requestCommands();
		tabuleiro.criaTabuleiro();
		tabuleiro.imprimirTabuleiro();
		jogador(commands);
		StringTabuleiro = tabuleiro.transformTabtoString(tabuleiro);
		tabuleiro.exportarArquivo(saida, flag);
//		if(flag==0) {
//			vetor = tabuleiro.vet();
//			//tabuleiro.exportarArquivo(csv, vetor);
//			csv.exportState(vetor);
//		}
//		else {
//			vetor = new String[1];
//			vetor[0] = "erro";
//		//	tabuleiro.exportarArquivo(csv, vetor);
//			csv.exportState(vetor);
//			
//		}
		return StringTabuleiro;
	}
	
	
	
	

}
