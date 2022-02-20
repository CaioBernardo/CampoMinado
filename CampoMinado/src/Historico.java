
public class Historico {

	private String dataJogo;
	private String duracao;
	private String dificuldade;

	public Historico() {
	}

	public Historico(String dataJogo, String duracao, String dificuldade) {
		super();
		this.dataJogo = dataJogo;
		this.duracao = duracao;
		this.dificuldade = dificuldade;
	}

	public String getDataJogo() {
		return dataJogo;
	}

	public void setDataJogo(String dataJogo) {
		this.dataJogo = dataJogo;
	}

	public String getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(String dificuldade) {
		this.dificuldade = dificuldade;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

}
