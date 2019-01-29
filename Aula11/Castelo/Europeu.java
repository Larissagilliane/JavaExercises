/* *     
   * Implementação da clase Europeu classe filha da classe Castelo
   *     
   * @author Larissa Moura  
   * @version 1.0 (Agosto 2017)  
*/
public class Europeu extends Castelo
{
	protected int num_Paladinos;

    /**      
	  * Construtor da classe   
	  * @param defesas Valor de defesa do castelo
	  * @param localizacao Localização do castelo
	  * @param pontos Pontos de vida do castelo
	  * @param nome Nome do castelo
	  * @param paladinos Quantidade de paladinos presentes no castelo
	*/
	public Europeu(double defesas, double localizacao, double pontos, String nome, int paladinos)
	{	
		super(defesas, localizacao, pontos, nome);
		this.num_Paladinos = paladinos;
	}

    /**      
	  * Retorna o numero de paladinos
	*/
	public int getNum_Paladinos()
	{
		return num_Paladinos;
	}

    /**      
	  * Modifica o numero de paladinos
	*/
	public void setNum_Paladinos(int paladinos)
	{
		this.num_Paladinos = paladinos;
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
		int guerreiros = getNum_Paladinos();
		if (getNum_Paladinos() > 0)
		{
			guerreiros-=2;
			setNum_Paladinos(guerreiros);
		}
		else
		{
			super.ataque(defesas);
		}
	}

	public String codigo()
	{
		return "E";
	}

}
