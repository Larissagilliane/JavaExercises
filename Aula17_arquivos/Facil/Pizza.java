
public class Pizza extends ProdutonaoDuravel {

	private int pedacos;

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
	 * @param data_validade
	 *            data de validade do produto
	 * @param genero
	 *            qual genero do produto
	 * @param pedacos
	 *            tamanho em peda�os do produto
	 */
	public Pizza(String nome, double preco, String marca, String descricao, String data_fabricacao, String id,
			String data_validade, String genero, int pedacos) {
		super(nome, preco, marca, descricao, data_fabricacao, id, data_validade, genero);
		this.pedacos = pedacos;
	}

	@Override
	public boolean disponivel() {
		return true;

	}

	@Override
	public boolean valido() {
		return true;

	}

	/**
	 * Retorna a quantidade de peda�os do produto
	 */
	public int getPedacos() {
		return pedacos;
	}

	/**
	 * Seta a quanti de pedacos do produto
	 * 
	 * @param pedacos
	 *            quantidade
	 */
	public void setPedacos(int pedac) {
		this.pedacos = pedac;
	}

	/**
	 * Diminui a quantidade de pedacos do produto
	 * 
	 * @param valor
	 *            valor a ser retirado
	 * @return nova quantidade de peda�os do produto
	 */
	public int partir(int valor) {
		return (pedacos - valor);
	}

}
