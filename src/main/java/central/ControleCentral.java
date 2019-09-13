package central;

import java.util.List;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ControleCentral {
	
	private List<Esquadrao> esquadrao = new ArrayList<>(10);
	private List<Floresta>  floresta  = new ArrayList<>(10);
	private String arqEsquadrao;
	private String arqFloresta;
	
	public ControleCentral() {
	}
	
	public ControleCentral(String arqEsquadrao, String arqFloresta) {
		this.arqEsquadrao = arqEsquadrao;
		this.arqFloresta = arqFloresta;
		//this importaDados();
	}
	
	public int cadastrarEsquadrao(String nomeEsq, EspecialidadeEsq especialidadeEsq,
			int tamEsq) {
		if (this.esquadrao.isEmpty()) {
			Esquadrao esq = new Esquadrao();
			esq.setNomeEsq(nomeEsq);
			esq.setEspecialidadeEsq(especialidadeEsq);
			esq.setTamEsquadrao(tamEsq);
			esquadrao.add(esq);
			System.out.println(esq.toString());
			return 1;
		} else {
			if (!this.contemEsquadrao(nomeEsq)) {
				Esquadrao esq = new Esquadrao();
				esq.setNomeEsq(nomeEsq);
				esq.setEspecialidadeEsq(especialidadeEsq);
				esq.setTamEsquadrao(tamEsq);
				esquadrao.add(esq);
				return 1;				
			}
		}
		return 0;
	}
	
	
	public boolean contemEsquadrao(String nomeEsq) {
		for (Esquadrao esq : esquadrao) {
			if (!(esq.getNomeEsq().equals(nomeEsq))) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

    public void enviarDados() {
        if (esquadraoToJson(this.arqEsquadrao)) {
            JOptionPane.showMessageDialog(null, "Dados enviados.", "Informação", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "ERRO: Dados não enviados.", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }
	
	public boolean esquadraoToJson(String nomeArq) {
        Gson gson = new Gson();
        try {
            try (FileWriter writer = new FileWriter(nomeArq)) {
                for (int i = 0; i < esquadrao.size(); i++) {
                    if (esquadrao.get(i) != null) {
                        String aux = gson.toJson(esquadrao.get(i));
                        System.out.println(aux);
                        writer.write(aux);
                        writer.write("\n");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
	}

}
