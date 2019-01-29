import java.util.ArrayList;
import java.util.Arrays;

/* *     
   * Implementação da clase Banco que faz a gestão de clientes e suas contas  
   *     
   * @author Larissa Moura  
   * @version 1.0 (Agosto 2017)  
*/
public class Banco
{
	private ArrayList<ContaBancaria> contas_banco;

    /**      
	  * Construtor da classe     
	*/
	public Banco()
	{	
		contas_banco = new ArrayList<>();
	}

	/**      
      * Adiciona contas ao sistema
      * @param conta Conta que será adicionada
    */
	public void adicionarContas(ContaBancaria conta)
	{
		contas_banco.add(conta);
	}

	/**      
      * Imprime a lista de contas no sistema
    */
	public void imprimirContas()
	{
		System.out.println("Quantidade total de contas no sistema: " + contas_banco.size() + "\n");
		int i=0;
		for(ContaBancaria conta : contas_banco)
		{
			i++;
			System.out.println("CONTA " + i + ": " + conta);
		}
	}
}