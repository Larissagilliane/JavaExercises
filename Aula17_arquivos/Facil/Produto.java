
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
	 *            o pre�o do produto em reais
	 * @param marca
	 *            a marca do produto
	 * @param descricao
	 *            descri��o do produto e suas caracter�sticas
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
	 * Retorna o pre�o do produto
	 */
	public double getPreco() {
		return preco;
	}

	/**
	 * Seta o pre�o do produto
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
	 * Retorna a descri��o do produto
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Seta a descri��o do produto
	 * 
	 * @param desc
	 */
	public void setDescricao(String desc) {
		this.descricao = desc;
	}

	/**
	 * Retorna a data de fabrica��o do produto
	 */
	public String getData_fabricacao() {
		return data_fabricacao;
	}

	/**
	 * Seta a data de fabrica��o do produto
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
		System.out.print("Atributos s�o " + getNome() + " ID: " + getId() + " FABRICA��O " + getData_fabricacao()
				+ " DESCRI��O: " + getDescricao());
		System.out.print(" MARCA: " + getMarca() + " PRE�O " + getPreco());
	}
}