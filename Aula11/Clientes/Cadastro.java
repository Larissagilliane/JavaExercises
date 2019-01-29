import java.util.ArrayList;
import java.util.Arrays;

/* *     
   * Implementação da clase Cadastro que faz a gestão de clientes no sistema
   *     
   * @author Larissa Moura  
   * @version 1.0 (Agosto 2017)  
*/
public class Cadastro
{
	private ArrayList<Cliente> clientes_cadastro;
	private	ArrayList<Cliente> clientes_fisica;
	private	ArrayList<Cliente> clientes_juridica;
   

    /**      
	  * Construtor da classe     
	*/
	public Cadastro()
	{	
		clientes_cadastro = new ArrayList<>();
		clientes_fisica = new ArrayList<>();
		clientes_juridica = new ArrayList<>();
	}

	/**      
      * Adiciona clientes ao sistema
      * @param clientes_adicionar Cliente que será adicionado
    */
	public void adicionarClientes(Cliente clientes_adicionar)
	{
		clientes_cadastro.add(clientes_adicionar);
	}

	/**      
      * Imprime todos os clientes do sistema e separa os objetos por tipos.
    */
	public void imprimirClientes()
	{

		System.out.println("Quantidade total de clientes: " + clientes_cadastro.size());
		for(Cliente cliente : clientes_cadastro)
		{
			cliente.imprimirDados();
			
			if(cliente instanceof PessoaFisica)	
				clientes_fisica.add(cliente);
			else if (cliente instanceof PessoaJuridica)
				clientes_juridica.add(cliente);
		}

		System.out.println("\nQuantidade total de clientes de pessoa física: " + clientes_fisica.size());

		for(Cliente clienteFisica : clientes_fisica)
			clienteFisica.imprimirDados();

		System.out.println("\nQuantidade total de clientes de pessoa jurídica: " + clientes_juridica.size());
			for(Cliente clienteJuridica : clientes_juridica)
				clienteJuridica.imprimirDados();
		
	}
}
