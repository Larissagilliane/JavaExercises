/* *     
   * Implementação da ContaEspecial que é a classe filha da classe ContaBancaria
   * @author Larissa Moura  
   * @version 1.0 (Agosto 2017)  
*/
public class ContaEspecial extends ContaBancaria
{
	private double limite_conta;

    /**      
	  * Construtor da classe   
	  * @param cliente Cliente dono da conta
	  * @param num Numero da conta do cliente  
	  * @param saldo Saldo da conta do cliente
	  * @param limite Limite da conta do cliente
	*/
	public ContaEspecial(String cliente, int num, double saldo, double limite)
	{
		super(cliente, num, saldo);
		this.limite_conta=limite;
	}

    /**      
	  * Retorna o limite    
	*/
	public double getLimite_conta()
	{
		return limite_conta;
	}

	/**      
	  * Altera o valor o limite 
	*/
	public void setLimite_conta(double limite)
	{
		this.limite_conta=limite;
	}

	/**      
	  * Faz a operação de saque do saldo de uma conta
	  * @param valor_saque Valor a ser sacado da conta
	*/
	public void sacar(double valor_saque)
	{	
		double valor_aux = super.getSaldo_conta();
		if (valor_saque <=0 || valor_saque > getLimite_conta())
		{
			System.out.println("Digite um valor válido para o saque\n");
		}
		else
		{
			valor_aux-=valor_saque;
			if(valor_aux >= getLimite_conta())
				super.setSaldo_conta(valor_aux);
		}
	}


	/**      
	  * @return String que caracteriza o objeto
	*/
	public String toString()
	{	
		return super.toString() + " e limite de " + getLimite_conta() + "\n";
	}
}