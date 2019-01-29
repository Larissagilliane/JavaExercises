
public class Buraco {

	private String localizacao;
	private int gravidade;
	private int tamanho;
	private String identificacao;
	private int prioridade;
	private String distrito;
	

	public Buraco(String localizacao, int gravidade, int tamanho, String identificacao, int prioridade,
			String distrito) {
		super();
		this.localizacao = localizacao;
		this.gravidade = gravidade;
		this.tamanho = tamanho;
		this.identificacao = identificacao;
		this.prioridade = prioridade;
		this.distrito = distrito;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public int getGravidade() {
		return gravidade;
	}
	public void setGravidade(int gravidade) {
		this.gravidade = gravidade;
	}
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	public String getIdentificacao() {
		return identificacao;
	}
	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}
	public int getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	
}
