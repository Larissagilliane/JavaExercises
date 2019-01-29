
public class Presidente extends Funcionario {

	public Presidente(String nome, String nascimento, String cpf, double salario) {
		super(nome, nascimento, cpf, salario);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Retorna a bonifica��o concedida para o funcion�rio
	 */
	public double getBonificacao()
	{
		return this.getSalario() * 0.3;
	}
	
	@Override
	public String toString() {
		return "Presidente | " + super.toString() ;
	}


}
