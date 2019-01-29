
public class Diretor extends Gerente {

	public Diretor(String nome, String nascimento, String cpf, double salario) {
		super(nome, nascimento, cpf, salario);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Retorna a bonificação concedida para o funcionário
	 */
	public double getBonificacao()
	{
		return this.getSalario() * 0.2;
	}

	@Override
	public String toString() {
		return "Diretor | " + "[nome=" + getNome() + ", nascimento=" + getNascimento() + ", cpf=" + getCpf() + ", salario=" + getSalario()
		+ ", bonificacoes=" + getBonificacoes() + "]";
	}
}
