package thinIceController;

import java.util.Scanner;
import thinIceModel.IPuffle;
import thinIceView.ISubject;
import thinIceView.Subject;

public class Controle implements IControl{
	private Montador montador;
	private String[][] posicaoEntidades, atualizacao;
	private IPuffle Puffle;
	private CSVHandling csv; 
	private ISubject subject;
	private String comando;
	
	public Controle() {
		montador = new MontadorDoLabirinto();
	}
	
	public void executaJogo(String endereco) {
		montador.criaMapa();
		csv = new CSVHandling();
		csv.setDataSource(endereco);
		posicaoEntidades = csv.requestCommands();
		Puffle = montador.montaMapa(posicaoEntidades);
		if(Puffle != null) {
			subject = new Subject();
			subject.montaEspelho(posicaoEntidades);
			subject.print();
		}
		Scanner scanf = new Scanner(System.in);
		while(true) {
			comando = scanf.nextLine();
			atualizacao = Puffle.movimenta(comando);
			subject.atualiza(atualizacao);
			if( atualizacao != null) {
					if (atualizacao[1][1].equals("p")) {
						System.out.println("Afogou");
					}
					//ADICIONAR: PONTOS++
			}
			
		}
		
		
		
	}
}
