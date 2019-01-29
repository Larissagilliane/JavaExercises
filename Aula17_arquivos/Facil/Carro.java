
public class Carro extends ProdutoDuravel {

	private int velocidade;

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
	 * @param velocidade
	 *            a velocidade em que o carro consegue chegar
	 */
	public Carro(String nome, double preco, String marca, String descricao, String data_fabricacao, String id,
			String material_predominante, String durabilidade, int velocidade) {
		super(nome, preco, marca, descricao, data_fabricacao, id, material_predominante, durabilidade);
		this.velocidade = velocidade;
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
	 * Retorna a velocidade do veiculo
	 */
	public int getVelocidade() {
		return velocidade;
	}

	/**
	 * Seta a Retorna a velocidade do veiculo
	 * 
	 * @param vel
	 *            velocidade desejada
	 */
	public void setVelocidade(int vel) {
		this.velocidade = vel;
	}

	/**
	 * Acelera o carro
	 * 
	 * @param aceleracao
	 *            valor que se deseja acelerar
	 * @return valor do carro acelerado
	 */
	public int acelerar(int aceleracao) {
		return (velocidade * aceleracao);
	}

}
