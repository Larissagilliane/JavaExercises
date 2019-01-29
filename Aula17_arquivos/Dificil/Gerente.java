
public class Gerente extends Funcionario {

	public Gerente(String nome, String nascimento, String cpf, double salario) {
		super(nome, nascimento, cpf, salario);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Retorna a bonifica��o concedida para o funcion�rio
	 */
	public double getBonificacao()
	{
		return this.getSalario() * 0.1;
	}

	@Override
	public String toString() {
		return "Gerente | " + super.toString() ;
	}
	
	
}
