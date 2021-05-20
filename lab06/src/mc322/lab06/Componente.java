package mc322.lab06;

public class Componente {
		protected String type;
		protected Caverna caverna;
		
		//CONTRUTOR:
		public Componente(Caverna caverna) {
			this.caverna = caverna;
			type = "-";
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
		
		public int posiciona(Caverna caverna, int Yc, int Xc) {
			return caverna.posiciona(Yc, Xc, this);
		}
		public int rePosiciona(String comando ) {
			return 0;
			
		}
		public boolean pegaOuro() {
			return false;
		}
		public int equipaFlecha( ) {
			return 5;
		}
		public int getFlecha() {
			return -1;
			
		}
		public void atiraFlecha() {
		}
		public boolean isTemOuro() {
			return false;
		}
}
