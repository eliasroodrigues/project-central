package central;

public enum ProtecaoFloresta {
	
	PROTEGIDO("Área de proteção."),
	NAO_PROTEGIDO("Área não pretegida.");
	
	private String descricao;
	
	private ProtecaoFloresta(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}

}
