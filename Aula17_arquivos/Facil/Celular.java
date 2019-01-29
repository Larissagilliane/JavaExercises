
public class Celular extends ProdutoDuravel {

	private int creditos;

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
	 * @param material_predominante
	 *            material de composição predominante
	 * @param durabilidade
	 *            seu potencial de durabilidade
	 * @param creditos
	 *            saldo de creditos no celular
	 */
	public Celular(String nome, double preco, String marca, String descricao, String data_fabricacao, String id,
			String material_predominante, String durabilidade, int credit) {
		super(nome, preco, marca, descricao, data_fabricacao, id, material_predominante, durabilidade);
		this.creditos = credit;
	}

	@Override
	public boolean disponivel() {
		
		return true;
	}

	@Override
	public boolean eletronico() {
		return true;

	}

	/**
	 * Retorna o saldo do celular
	 */
	public int getCreditos() {
		return creditos;
	}

	/**
	 * Seta o valor de creditos do celular
	 * 
	 * @param credit
	 *            credito desejado
	 */
	public void setCreditos(int credit) {
		this.creditos = credit;
	}

	/**
	 * Recarrega creditos no celular
	 * 
	 * @param credit
	 *            valor a ser adicionado
	 * @return novo saldo do celular
	 */
	public int recarregar(int credit) {
		return (creditos + credit);
	}

}
