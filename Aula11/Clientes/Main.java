public class Main 
{
	public static void main (String args[])
	{
		Cadastro empresaClientes = new Cadastro();
		
		PessoaFisica cliente1 = new PessoaFisica("Maria" , "Rua Lima" , " 8851", "1361544446");
		PessoaJuridica empresa1 = new PessoaJuridica("Joao" , "Rua Laranja" , " 335599", "111111", "EmpresaFantasia");
		
		empresaClientes.adicionarClientes(cliente1);
		empresaClientes.adicionarClientes(empresa1);

		empresaClientes.imprimirClientes();
	}
}
