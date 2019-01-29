import java.util.ArrayList;

public class Deposito {

	private ArrayList<Produto> produtos;

	public Deposito() {
		produtos = new ArrayList<>();
	}

	/**
	 * Adiciona um produto ao deposito
	 * 
	 * @param product
	 *            produto a ser adicionado
	 */
	public void adicionarProduto(Produto product) {
		produtos.add(product);
	}

	/**
	 * Remove o produto de determina posicao
	 * 
	 * @param index
	 *            posicao ao qual o produto deve ser retirado
	 */
	public void removerProduto(int index) {
		produtos.remove(produtos.get(index));
	}

	/**
	 * Retorna a quantidade dos produtos no deposito
	 * 
	 * @return a quantidade dos produtos no deposito
	 */
	public int quantidadeProduto() {
		return produtos.size();
	}

	/**
	 * Informa se a lista esta fazia
	 * 
	 * @return true caso esteja vazia e false caso nao
	 */
	public boolean vazio() {
		if (produtos.isEmpty())
			return true;
		else
			return false;
	}

	/**
	 * Informa o produto que esta mais caro
	 * 
	 * @return o produto mais caro
	 */
	public Produto maiorValor() {
		double maior = 0;
		int i;
		Produto aux = produtos.get(0);
		
		for (i = 0; i < produtos.size(); i++) {
			if (produtos.get(i).getPreco() > maior) {
				aux = produtos.get(i);
				maior = produtos.get(i).getPreco();
			}
		}
		System.out.println("Maior preço:  " + maior);
		return aux;
	}
}
