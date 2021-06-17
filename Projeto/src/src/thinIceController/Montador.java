package thinIceController;

import thinIceModel.IPuffle;

public interface Montador {
	
	public void criaMapa();
	
	public IPuffle montaMapa(String[][] posicoes);
	
}
