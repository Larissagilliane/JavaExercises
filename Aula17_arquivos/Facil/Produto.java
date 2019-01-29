
public abstract class Produto {
	private String id;
	private String nome;
	private double preco;
	private String marca;
	private String descricao;
	private String data_fabricacao;

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
	 */
	public Produto(String nome, double preco, String marca, String descricao, String data_fabricacao, String id) {
		this.nome = nome;
		this.preco = preco;
		this.marca = marca;
		this.descricao = descricao;
		this.data_fabricacao = data_fabricacao;
		this.id = id;
	}

	public abstract boolean disponivel();
	
	/**
	 * Retorna o nome do produto
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Seta o nome do produto
	 * 
	 * @param name
	 */
	public void setNome(String name) {
		this.nome = name;
	}

	/**
	 * Retorna o preço do produto
	 */
	public double getPreco() {
		return preco;
	}

	/**
	 * Seta o preço do produto
	 * 
	 * @param price
	 */
	public void setPreco(double price) {
		this.preco = price;
	}

	/**
	 * Retorna a marca do produto
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Seta a marca do produto
	 * 
	 * @param marc
	 */
	public void setMarca(String marc) {
		this.marca = marc;
	}

	/**
	 * Retorna a descrição do produto
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Seta a descrição do produto
	 * 
	 * @param desc
	 */
	public void setDescricao(String desc) {
		this.descricao = desc;
	}

	/**
	 * Retorna a data de fabricação do produto
	 */
	public String getData_fabricacao() {
		return data_fabricacao;
	}

	/**
	 * Seta a data de fabricação do produto
	 * 
	 * @param date
	 */
	public void setData_fabricacao(String date) {
		this.data_fabricacao = date;
	}

	/**
	 * Retorna o id do produto
	 */
	public String getId() {
		return id;
	}

	/**
	 * Seta o id do produto
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Imprime os atributos
	 */
	public void impressao() {
		System.out.print("Atributos são " + getNome() + " ID: " + getId() + " FABRICAÇÃO " + getData_fabricacao()
				+ " DESCRIÇÃO: " + getDescricao());
		System.out.print(" MARCA: " + getMarca() + " PREÇO " + getPreco());
	}
}