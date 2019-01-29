/* *     
   * Implementação da clase Cliente, classe super para as demais classes    
   *     
   * @author Larissa Moura  
   * @version 1.0 (Agosto 2017)  
*/
public abstract class Cliente
{
	private String nome_cliente;
	private String endereco_cliente;
	private String telefone_cliente;

  /**      
    * Construtor da classe     
    *      
    * @param nome Nome do cliente     
    * @param endereco Endereço do cliente     
    * @param telefone telefone do cliente  
  */
	public Cliente (String nome, String endereco, String telefone)
	{	
		this.nome_cliente = nome;
		this.endereco_cliente = endereco;
		this.telefone_cliente = telefone;
	}

   /**      
     * Retorna o nome do cliente
   */
	public String getNome_cliente()
	{
		return nome_cliente;
	}

  	/**      
      * Retorna o endereço do cliente
    */
	public String getEndereco_cliente()
	{
		return endereco_cliente;
	}

	/**      
      * Altera o endereço do cliente
    */
	public void setEndereco_cliente(String endereco)
	{
		this.endereco_cliente = endereco;
	}
	
	/**      
      * Retorna o telefone do cliente
    */
	public String getTelefone_cliente()
	{
		return telefone_cliente;
	}

	/**      
      * Altera o telefone do cliente
    */
	public void setTelefone_cliente(String telefone)
	{
		this.telefone_cliente = telefone;
	}

	/**      
      * Imprime os dados referentes ao cliente
    */
	public void imprimirDados()
	{
		System.out.println("NOME do cliente: " + getNome_cliente());
		System.out.println("ENDEREÇO do cliente: " + getEndereco_cliente());
		System.out.println("TELEFONE do cliente: " + getTelefone_cliente());
	}
}
