package central;

import gui.*;

public class Principal {
	public static void main(String[] args) {
		ControleCentral controle = new ControleCentral("arqEsquadrao.json", "arqFloresta.json");
		new GUIPrincipal(controle).setVisible(true);
	}
}