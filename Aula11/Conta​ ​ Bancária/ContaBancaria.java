/* *     
   * Implementação da ContaBancaria que é a classe super das demais classes 
   *     
   * @author Larissa Moura  
   * @version 1.0 (Agosto 2017)  
*/
public abstract class ContaBancaria
{
	private String cliente_conta;
	private int num_conta;
	private double saldo_conta;

    /**      
	  * Construtor da classe   
	  * @param cliente Cliente dono da conta
	  * @param num Numero da conta do cliente  
	  * @param saldo Saldo da conta do cliente
	*/
	public ContaBancaria (String cliente, int num, double saldo)
	{
		this.cliente_conta=cliente;
		this.num_conta=num;
		this.saldo_conta=saldo;
	}

    /**      
	  * Retorna o cliente    
	*/
	public String getCliente_conta()
	{
		return cliente_conta;
	}

	/**      
	  * Retorna o número da conta 
	*/
	public int getNum_conta()
	{
		return num_conta;
	}

	/**      
	  * Retorna o saldo da conta
	*/
	public double getSaldo_conta()
	{
		return saldo_conta;
	}

	/**      
	  * Altera o valor do saldo 
	*/
	public void setSaldo_conta(double saldo)
	{
		this.saldo_conta=saldo;
	}

	/**      
	  * Faz a operação de saque do saldo de uma conta
	  * @param valor_saque Valor a ser sacado da conta
	*/
	public void sacar(double valor_saque)
	{	
		double valor_aux = getSaldo_conta();
		if (valor_saque <=0 || valor_saque > valor_aux)
		{
			System.out.println("Digite um valor válido para sacar dinheiro\n");
		}
		else
		{
			valor_aux-=valor_saque;
			setSaldo_conta(valor_aux);
		}
	}

	/**      
	  * Faz a operação de deposito do saldo de uma conta
	  * @param valor_deposito Valor a ser depositado na conta
	*/
	public void depositar(double valor_deposito)
	{	
		double valor_aux = getSaldo_conta();
		if (valor_deposito <=0)
		{
			System.out.println("Digite um valor válido para depositar dinheiro\n");
		}
		else
		{
			valor_aux+=valor_deposito;
			setSaldo_conta(valor_aux);
		}
	}

	/**      
	  * @return String que caracteriza o objeto
	*/
	public String toString()
	{	
		return "O cliente " + getCliente_conta() + " com conta " + getNum_conta() + " possui " + getSaldo_conta() + " de saldo " ;
	}
}