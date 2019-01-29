/* *     
   * Implementação da clase PessoaJuridica, classe filha da classe Cliente    
   *     
   * @author Larissa Moura  
   * @version 1.0 (Agosto 2017)  
*/
public class PessoaJuridica extends Cliente
{
	private String cnpj_empresa;
	private String fantasia_empresa;

	/**      
	  * Construtor da classe     
	  *      
	  * @param nome Nome do cliente    
	  * @param endereco Endereço da empresa    
	  * @param telefone telefone da empresa
	  * @param cnpj cnpj da empresa
	  * @param fantasia Nome da empresa
	*/
	public PessoaJuridica(String nome, String endereco, String telefone, String cnpj, String fantasia)
	{	
		super(nome, endereco, telefone);
		this.cnpj_empresa = cnpj;
		this.fantasia_empresa = fantasia;
	}

    /**      
      * Retorna o cnpj da empresa
    */
	public String getCnpj_empresa()
	{
		return cnpj_empresa;
	}

    /**      
      * Retorna o nome da empresa
    */
	public String getFantasia_empresa()
	{
		return fantasia_empresa;
	}

    /**      
      * Modifica o nome da empresa
    */
	public void setFantasia_empresa(String fantasia)
	{
		this.fantasia_empresa = fantasia;
	}

	/**      
      * Imprime os dados referentes ao cliente
    */
	public void imprimirDados()
	{
		super.imprimirDados();
		System.out.println("CNPJ da empresa: " + getCnpj_empresa());
		System.out.println("NOME FANTASIA da empresa: " + getFantasia_empresa());
	}
}
