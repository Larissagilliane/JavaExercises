
public abstract class ProdutonaoDuravel extends Produto {

	private String data_validade;
	private String genero;

	/**
	 * Construtor da classe
	 * 
	 * @param nome
	 *            Nome do produto
	 * @param preco
	 *            o preço do produto em reais
	 * @param marca
	 *            a marca do produto
	 * @param descricao
	 *            descrição do produto e suas características
	 * @param data_fabricacao
	 *            a data em que foi fabricado
	 * @param data_validade
	 *            data de validade do produto
	 * @param genero
	 *            qual genero do produto
	 */
	public ProdutonaoDuravel(String nome, double preco, String marca, String descricao, String data_fabricacao,
			String id, String data_validade, String genero) {
		super(nome, preco, marca, descricao, data_fabricacao, id);
		this.data_validade = data_validade;
		this.genero = genero;
	}

	public abstract boolean disponivel();
	public abstract boolean valido();
	
	/**
	 * Retorna a data de validade do produto
	 */
	public String getData_validade() {
		return data_validade;
	}

	/**
	 * Seta a data de validade do produto
	 * 
	 * @param date
	 *            data de validade do produto
	 */
	public void setData_validade(String date) {
		this.data_validade = date;
	}

	/**
	 * Retorna o genero do produto
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * Seta o genero do produto
	 * 
	 * @param gender
	 *            genero do produto
	 */
	public void setGenero(String gender) {
		this.genero = gender;
	}
	
	public void impressao() {
		super.impressao();
		System.out.print(" DATA DE VALIDADE PREDOMINANTE: " + getData_validade() + " GENERO " + getGenero());
	}

}
