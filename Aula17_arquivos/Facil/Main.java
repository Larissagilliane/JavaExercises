public class Main {
	public static void main(String args[]) {
		Deposito despenca = new Deposito();

		Celular produto1 = new Celular("1100", 1220.0, "nokia", "funciona bem", "2002", "2313", "metal", "50 anos", 10);
		Carro produto2 = new Carro("carrinho", 300000.0, "ferrari", "bem veloz", "2015", "4442", "aço", "10 anos", 100);
		Pizza produto3 = new Pizza("peperoni", 40.75, "pizza hut", "saborosa", "01/2017", "3413", "02/2017", "alimenticio", 7);
		Chocolate produto4 = new Chocolate("amargo", 2.75, "garoto", "doce", "07/2017", "434224", "08/2017", "alimenticio", 3);

		System.out.println("\nAdicionando produtos  ");
		despenca.adicionarProduto(produto1);
		despenca.adicionarProduto(produto2);
		despenca.adicionarProduto(produto3);
		despenca.adicionarProduto(produto4);

		System.out.println("Quanditade:  " + despenca.quantidadeProduto());
		despenca.maiorValor();

		System.out.println("\nRemovendo produtos ");
		despenca.removerProduto(1);
		despenca.removerProduto(0);

		System.out.println("\nQuanditade:  " + despenca.quantidadeProduto());
		despenca.maiorValor();

		System.out.println("\nRemovendo produtos ");
		despenca.removerProduto(1);
		despenca.removerProduto(0);

		if (despenca.vazio()) {
			System.out.println("\nVazia a despença\n");
		} else {
			System.out.println("\n Erro");
		}
	}

}