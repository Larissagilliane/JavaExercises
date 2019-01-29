public class Main 
{
	public static void main (String args[])
	{
		Banco bancoJava = new Banco();
		
		ContaPoupanca cliente0 = new ContaPoupanca("Mariana Limeira" , 8888 , 0.0 , 10);
		ContaPoupanca cliente1 = new ContaPoupanca("Maria Silva" , 2231 , 200.0 , 3);
		ContaEspecial cliente2 = new ContaEspecial("Joao Lima" , 4564 , 10000.00, 10);
		ContaEspecial cliente3 = new ContaEspecial("Joana Lima da Silva" , 5673 , 34.00, -12);
		
		bancoJava.adicionarContas(cliente0);
		bancoJava.adicionarContas(cliente2);

		bancoJava.imprimirContas();

		bancoJava.adicionarContas(cliente1);
		bancoJava.adicionarContas(cliente3);

		cliente0.sacar(200.0);
		cliente0.depositar(200.0);
		cliente1.calcularNovoSaldo(0.3);
		cliente2.depositar(1000.0);
		cliente3.sacar(48.0);
		cliente3.sacar(40.0);

		bancoJava.imprimirContas();		
	}
}