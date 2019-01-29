public abstract class Funcionario {

	private String nome;
	private String nascimento;
	private String cpf;
	private double salario;
	private int bonificacoes;

	/**
	 * Construtor da classe
	 * 
	 * @param nome
	 *            nome do funcionario
	 * @param nascimento
	 *            data de nascimento do funcionario
	 * @param cpf
	 *            cpf do funcionario
	 * @param salario
	 *            salario do funcionario
	 */
	public Funcionario(String nome, String nascimento, String cpf, double salario) {
		this.nome = nome;
		this.nascimento = nascimento;
		this.cpf = cpf;
		this.salario = salario;
		bonificacoes = 0;
	}

	public abstract double getBonificacao();

	/**
	 * Retorna a quantidade de bonificações do funcionario
	 */
	public int getBonificacoes() {
		return bonificacoes;
	}

	/**
	 * Modifica a quantidade de bonificações do funcionario
	 */
	public void setBonificacoes(int bonificacoes) {
		this.bonificacoes = bonificacoes;
	}

	/**
	 * Retorna o nome do funcionario
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Modifica o nome do funcionario
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna a data do nascimento do funcionario
	 */
	public String getNascimento() {
		return nascimento;
	}

	/**
	 * Modifica a data do nascimento do funcionario
	 */
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	/**
	 * Retorna o cpf do funcionario
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * Modifica o cpf do funcionario
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * Retorna o salario do funcionario
	 */
	public double getSalario() {
		return salario;
	}

	/**
	 * Modifica o salario do funcionario
	 */
	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "[nome=" + getNome() + ", nascimento=" + getNascimento() + ", cpf=" + getCpf() + ", salario="
				+ getSalario() + ", bonificacoes=" + getBonificacoes() + "]";
	}
}
