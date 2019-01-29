/* *     
   * Implementação da clase Guereiro classe super para as classes Paladino e Samurai
   *     
   * @author Larissa Moura  
   * @version 1.0 (Agosto 2017)  
*/
public abstract class Guerreiro extends Peca
{
	protected double hit_points;
	protected double forca_guerreiro;
	protected double defesa_guerreiro;
	protected double critico_guerreiro;

    /**      
	  * Construtor da classe   
	  * @param hit Valor de Hit points
	  * @param forca Força do guerreiro
	  * @param defesa Valor de defesa do guerreiro
	  * @param critico 
	*/
	public Guerreiro(double hit, double forca, double defesa, double critico)
	{	
		this.hit_points = hit;
		this.forca_guerreiro = forca;
		this.defesa_guerreiro = defesa;
		this.critico_guerreiro = critico;
	}

    /**      
	  * Retorna o valor de hit points 
	*/
	public double getHit_points()
	{
		return hit_points;
	}

    /**      
	  * Retorna o valor de força do guerreiro
	*/
	public double getForca_guerreiro()
	{
		return forca_guerreiro;
	}

    /**      
	  * Retorna o valor de defesa do guerreiro
	*/
	public double getDefesa_guerreiro()
	{
		return defesa_guerreiro;
	}

    /**      
	  * Retorna o valor crítico do guerreiro
	*/
	public double getCritico_guerreiro()
	{
		return critico_guerreiro;
	}

    /**      
	  * Modifica o valor de hit points 
	*/
	public void setHit_points(double hit)
	{
		this.hit_points = hit;
	}

    /**      
	  * Modifica o valor de força do guerreiro
	*/
	public void setForca_guerreiro(double forca)
	{
		this.forca_guerreiro = forca;
	}

    /**      
	  * Modifica o valor de defesa do guerreiro
	*/
	public void setDefesa_guerreiro(double defesa)
	{
		this.defesa_guerreiro = defesa;
	}

    /**      
	  * Modifica o valor crítico do guerreiro
	*/
	public void setCritico_guerreiro(double critico)
	{
		this.critico_guerreiro = critico;
	}

	public abstract String codigo();
}
