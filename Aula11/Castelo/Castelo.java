/* *     
   * Implementação da clase Castelo classe super para as classes Europeu e Japones
   *     
   * @author Larissa Moura  
   * @version 1.0 (Agosto 2017)  
*/
public abstract class Castelo extends Peca
{
	protected double defesas_castelo;
	protected double localizacao_castelo;
	protected double pontos_vida;
	protected String nome_castelo;

    /**      
	  * Construtor da classe   
	  * @param defesas Valor de defesa do castelo
	  * @param localizacao Localização do castelo
	  * @param pontos Pontos de vida do castelo
	  * @param nome Nome do castelo
	*/
	public Castelo (double defesas, double localizacao, double pontos, String nome)
	{	
		
		this.defesas_castelo = defesas;
		this.localizacao_castelo = localizacao;
		this.pontos_vida = pontos;
		this.nome_castelo = nome;
	}

    	/**      
	  * Retorna o valor de defesa do castelo 
	*/
	public double getDefesas_castelo()
	{
		return defesas_castelo;
	}

    /**      
	  * Retorna o valor de localização do castelo 
	*/
	public double getLocalizacao_castelo()
	{
		return localizacao_castelo;
	}

    /**      
	  * Retorna o valor de pontos de vida do castelo 
	*/
	public double getPontos_vida()
	{
		return pontos_vida;
	}

    /**      
	  * Retorna o nome do castelo 
	*/
	public String getNome_castelo()
	{
		return nome_castelo;
	}

    /**      
	  * Modifica o valor de defesa do castelo 
	*/
	public void setDefesas_castelo(double defesas)
	{
		this.defesas_castelo = defesas;
	}

   /**      
	  * Modifica o valor da localização do castelo 
	*/
	public void setLocalizacao_castelo(double localizacao)
	{
		this.localizacao_castelo = localizacao;
	}

    /**      
	  * Modifica o valor de vidas do castelo 
	*/
	public void setPontos_vida(double pontos)
	{
		this.pontos_vida = pontos;
	}

    /**      
	  * Modifica o nome do castelo 
	*/
	public void setNome_castelo(String nome)
	{
		this.nome_castelo = nome;
	}
	
	/**      
	  * Mostra a situação do castelo e todas as suas pontuações
	*/
	public void mostrarSituacao()
	{
		System.out.println("Castelo: " +  getNome_castelo());
		System.out.println("Localizacao do castelo: " +  getLocalizacao_castelo());
		System.out.println("Defesas do castelo: " +  getDefesas_castelo());
		if (getPontos_vida() <= 0.0)
			System.out.println("Castelo destruído");
		else
			System.out.println("Vidas do castelo: " +  getPontos_vida());

	}

	/**      
	  * Ataca por parte do castelo
	*/
	public void ataque(double defesas)
	{
		double vida = getPontos_vida();
		if(defesas > 0.0)
		{
			defesas-=1.0;
			setDefesas_castelo(defesas);
		}
		else
		{
			vida-=1.0;
			setPontos_vida(vida);
		}
	}

	public abstract String codigo();

}
