/*
*   Trabalho I de POO   
*
*   Classe: Principal.java
*
*   Alunos: Ana Paula Pacheco
*           Elias Eduardo Silva Rodrigues
*
*/

package visao;

import dao.ControleCentral;
import gui.GUIPrincipal;
import connection.DriveConnection;

public class Principal {
	public static void main(String[] args) {
		ControleCentral controle = new ControleCentral("arqEsquadrao.json", "arqFloresta.json");
		new GUIPrincipal(controle).setVisible(true);
	}
}