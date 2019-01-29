/* *     
   * Implementação da clase Campo que representa as posições do tabuleiro
   *     
   * @author Larissa Moura  
   * @version 1.0 (Agosto 2017)  
*/
public class Campo
{
	private Peca conteudo_posicao;
	private boolean preenchido;
	private Peca peca;
	
	/* *     
	   * Construtor da classe
	*/
	public Campo() 
	{
		this.preenchido=false;
	}	
	
   	/**      
	  * Modifica o conteudo da posicao
	*/
	public void setConteudo_posicao(Peca conteudo) 
	{
		conteudo_posicao = conteudo;
	}

	/**      
	  * Retorna o conteudo da posicao
	*/
	public Peca getConteudo_posicao() 
	{
		return conteudo_posicao;
	}

   	/**      
	  * Modifica o status da posicao
	*/
	public void setPreenchido(boolean status)
	{
		this.preenchido=status;
	} 

	/**      
	  * Retorna o status da posicao
	*/
	public boolean getPreenchido()
	{
		return preenchido;
	}

	/**      
	  * Retorna a peça do tabuleiro
	*/
	public Peca getPeca()
	{
		return peca;
	}

	/**      
	  * Modifica a peça do tabuleiro
	*/
	public void setPeca(Peca simbolo)
	{
		this.peca=simbolo;
	}
}
