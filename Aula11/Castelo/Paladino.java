/* *     
   * Implementação da clase Paladino classe filha da classe Guerreiro
   *     
   * @author Larissa Moura  
   * @version 1.0 (Agosto 2017)  
*/
public class Paladino extends Guerreiro
{
	/**      
	  * Construtor da classe   
	  * @param hit Valor de Hit points
	  * @param forca Força do guerreiro
	  * @param defesa Valor de defesa do guerreiro
	  * @param critico 
	*/
	public Paladino(double hit, double forca, double defesa, double critico)
	{	
		super(hit,forca, defesa, critico);
	}


	public String codigo()
	{
		return "P";
	}
}
