
public class Gerente extends Funcionario {

	public Gerente(String nome, String nascimento, String cpf, double salario) {
		super(nome, nascimento, cpf, salario);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Retorna a bonificação concedida para o funcionário
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
