/* *     
   * Implementação da ContaPoupanca que é a classe filha da classe ContaBancaria
   * @author Larissa Moura  
   * @version 1.0 (Agosto 2017)  
*/
public class ContaPoupanca extends ContaBancaria
{
	private int dia_rendimento;


    /**      
	  * Construtor da classe   
	  * @param cliente Cliente dono da conta
	  * @param num Numero da conta do cliente  
	  * @param saldo Saldo da conta do cliente
	  * @param dia Dia de rendimento do saldo da conta
	*/
	public ContaPoupanca(String cliente, int num, double saldo, int dia)
	{
		super(cliente, num, saldo);
		this.dia_rendimento=dia;
	}

    /**      
	  * Retorna o dia de rendimento    
	*/
	public int getDia_rendimento()
	{
		return dia_rendimento;
	}

    /**      
	  * Modifica o dia de rendimento    
	*/
	public void setDia_rendimento(int dia)
	{
		this.dia_rendimento=dia;
	}

	/**      
	  * Calcula o novo saldo da conta depois do rendimento
	  * @param taxa_rendimento Porcentagem de rendimento
	*/
	public void calcularNovoSaldo(double taxa_rendimento)
	{	
		double valor_aux = super.getSaldo_conta();
		if (taxa_rendimento <=0 )
		{
			System.out.println("Digite um valor válido para a taxa de rendimento\n");
		}
		else
		{
			valor_aux=(valor_aux*taxa_rendimento)+valor_aux;
			super.setSaldo_conta(valor_aux);
		}
	}

	/**      
	  * @return String que caracteriza o objeto
	*/
	public String toString()
	{	
		return super.toString() + " e rendimento no dia " + getDia_rendimento() + "\n";
	}
}