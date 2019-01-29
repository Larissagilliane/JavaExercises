
public class Main {
	public static void main(String[] args) 
	{
		ControleDeBonificacoes sistema = new ControleDeBonificacoes();
		Presidente f1 =  new Presidente ("Maria", "10/08/98", "022.333.222-09", 1000.0);
		Diretor f2 =  new Diretor ("Joao", "01/01/76", "212.444.765-10", 300.0);
		Gerente f3 =  new Gerente ("Luzia", "29/11/90", "444.4444.111-00", 40000.0);
		
		sistema.adicionarFuncionario(f1);
		sistema.adicionarFuncionario(f2);
		sistema.adicionarFuncionario(f3);
		
		System.out.println("\n");
		
		sistema.registraBonificacao(f1);
		sistema.registraBonificacao(f1);
		sistema.registraBonificacao(f1);
		sistema.registraBonificacao(f3);
		sistema.registraBonificacao(f3);
		sistema.registraBonificacao(f3);
		sistema.registraBonificacao(f3);
		sistema.registraBonificacao(f3);
		sistema.registraBonificacao(f3);

		sistema.listar();
		
		sistema.registraBonificacao(f2);
		sistema.registraBonificacao(f2);
		sistema.registraBonificacao(f2);
		
		sistema.listar();
	}

}
