import java.util.ArrayList;

public class ControleDeBonificacoes {

	private ArrayList<Funcionario> funcionarios;
	private int totalDeBonificacoes;

	/**
	 * Construtor da classe
	 */
	public ControleDeBonificacoes() {
		funcionarios = new ArrayList<>();
		totalDeBonificacoes = 0;
	}

	/**
	 * Registra a bonificação para tal funcionario
	 * 
	 * @param funcionario
	 *            Funcionario que receberá a bonificação
	 */
	public void registraBonificacao(Funcionario funcionario) {
		if (totalDeBonificacoes < 10 && funcionario.getBonificacoes() < 5) {
			System.out.println("Bonificando o funcionario: " + funcionario + " em: " + funcionario.getBonificacao());
			funcionario.getBonificacao();
			totalDeBonificacoes += 1;
			funcionario.setBonificacoes(funcionario.getBonificacoes() + 1);
		} else {
			System.out.println("Você já bonificou demais");
		}
	}

	/**
	 * Adiciona funcionário a sistema
	 * 
	 * @param funcionario
	 *            Funcionario que será adicionado a lista
	 */
	public void adicionarFuncionario(Funcionario funcionario) {
		funcionarios.add(funcionario);
	}

	/**
	 * Lista os funcionários bonificados e não bonificados
	 */
	public void listar() {
		ArrayList<Funcionario> bonificados = new ArrayList<>();
		ArrayList<Funcionario> naoBonificados = new ArrayList<>();

		for (Funcionario f : funcionarios) {
			if (f.getBonificacoes() != 0) {
				bonificados.add(f);
			} else {
				naoBonificados.add(f);
			}
		}
		System.out.println("\nBONIFICADOS");
		for (Funcionario b : bonificados) {
			System.out.println(b);
		}
		System.out.println("\nNÃO BONIFICADOS");
		for (Funcionario n : naoBonificados) {
			System.out.println(n);
		}
	}

}
