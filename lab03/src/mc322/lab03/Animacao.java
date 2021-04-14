package mc322.lab03;

public class Animacao {
	 public int j= 6;
	 public int ncmds;
	 public String str;
	 public String a,b,c;
  	 public int taq;
  	 public int tlomb;
  	 public int posi;
  	 public String[] vet;
  	 public AquarioLombriga Lombriga;
  	 
  	 public Animacao(String str){
  		 
		 this.str = str;
		 
		 this.vet= this.str.split("",0);
		 
		 this.ncmds = this.str.length();
		 
		 this.a= this.vet[0] + this.vet[1];
		 
	  	 this.b= this.vet[2] + this.vet[3];
	  	 
		 this.c= this.vet[4] + this.vet[5];
		 
		 this.taq = Integer.parseInt(this.a); //taq= TAMANHO DO AQUARIO
		 
		 this.tlomb = Integer.parseInt(this.b); // tlomb= TAMANHO DA LOMBRIGA
		 
		 this.posi = Integer.parseInt(this.c); // posi= posição da cabeça
		 
		 this.Lombriga = new AquarioLombriga(taq, tlomb, posi);
	 }
	 
	 public void apresenta() {
		 Lombriga.apresenta();
	 }
	 
	 public void passo(){
		 if(vet[this.j].equals("C")){
			 Lombriga.crescer();
	     }
		 
	     if(this.vet[this.j].equals("M")){
	    	 Lombriga.mover();
	     }
	     
	     if(this.vet[this.j].equals("V")){
	    	 Lombriga.virar();
	     }
	     
	     if(this.j<this.ncmds){
	         this.j++;
	     }    
	 }
}
