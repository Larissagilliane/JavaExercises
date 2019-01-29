/* *     
   * Implementação da clase Japoneses classe filha da classe Castelo
   *     
   * @author Larissa Moura  
   * @version 1.0 (Agosto 2017)  
*/
public class Japones extends Castelo
{
	protected int num_Samurais;

    /**      
	  * Construtor da classe   
	  * @param defesas Valor de defesa do castelo
	  * @param localizacao Localização do castelo
	  * @param pontos Pontos de vida do castelo
	  * @param nome Nome do castelo
	  * @param samurais Quantidade de samurais presentes no castelo
	*/
	public Japones(double defesas, double localizacao, double pontos, String nome, int samurais)
	{	
		super(defesas, localizacao, pontos, nome);
		this.num_Samurais = samurais;
	}

    /**      
	  * Retorna o numero de samurais
	*/
	public int getNum_Samurais()
	{
		return num_Samurais;
	}

    /**      
	  * Modifica o numero de samurais
	*/
	public void setNum_Samurais(int samurais)
	{
		this.num_Samurais = samurais;
	}

	/**      
	  * Mostra a situação do castelo e todas as suas pontuações
	*/
	public void mostrarSituacao()
	{
		super.mostrarSituacao();
	}

	public void ataque(double defesas)
	{
		//ERRADO ainda
		int guerreiros = getNum_Samurais();
		if (getNum_Samurais() > 0)
		{
			guerreiros-=2;
			setNum_Samurais(guerreiros);
		}
		else
		{
			super.ataque(defesas);
		}
	}

	public String codigo()
	{
		return "J";
	}

}
