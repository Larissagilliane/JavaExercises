/* *     
   * Implementação da clase PessoaFisica, classe filha da classe Cliente    
   *     
   * @author Larissa Moura  
   * @version 1.0 (Agosto 2017)  
*/
public class PessoaFisica extends Cliente
{
	private String cpf_cliente;

	/**      
	  * Construtor da classe     
	  *      
	  * @param nome Nome do cliente     
	  * @param endereco Endereço do cliente     
	  * @param telefone telefone do cliente 
	  * @param cpf cpf do cliente  
	*/
	public PessoaFisica(String nome, String endereco, String telefone, String cpf)
	{	
		super(nome, endereco, telefone);
		this.cpf_cliente = cpf;
	}

    /**      
      * Retorna o cpf do cliente
    */
	public String getCpf_cliente()
	{
		return cpf_cliente;
	}

	/**      
      * Imprime os dados referentes ao cliente
    */
	public void imprimirDados()
	{
		super.imprimirDados();
		System.out.println("CPF do cliente: " + getCpf_cliente());
	}

}
