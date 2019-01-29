
public abstract class ProdutoDuravel extends Produto {

	private String material_predominante;
	private String durabilidade;

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
	 * @param material_predominante
	 *            material de composi��o predominante
	 * @param durabilidade
	 *            seu potencial de durabilidade
	 */
	public ProdutoDuravel(String nome, double preco, String marca, String descricao, String data_fabricacao, String id,
			String material_predominante, String durabilidade) {
		super(nome, preco, marca, descricao, data_fabricacao, id);
		this.material_predominante = material_predominante;
		this.durabilidade = durabilidade;
	}

	public abstract boolean disponivel();
	public abstract boolean eletronico();

	/**
	 * Retorna o material predominante
	 */
	public String getMaterial_predominante() {
		return material_predominante;
	}

	/**
	 * Seta o material predominante
	 * 
	 * @param material
	 *            material predominante
	 */
	public void setMaterial_predominante(String material) {
		this.material_predominante = material;
	}

	/**
	 * Retorna a durabilidade
	 */
	public String getDurabilidade() {
		return durabilidade;
	}

	/**
	 * Retorna a durabilidade
	 * 
	 * @param durability
	 *            durabilidade do material
	 */
	public void setDurabilidade(String durability) {
		this.durabilidade = durability;
	}
	
	public void impressao() {
		super.impressao();
		System.out.print(" MATERIAL PREDOMINANTE: " + getMaterial_predominante() + " DURABILIDADE " + getDurabilidade());
	}

}
