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
	 * Registra a bonifica��o para tal funcionario
	 * 
	 * @param funcionario
	 *            Funcionario que receber� a bonifica��o
	 */
	public void registraBonificacao(Funcionario funcionario) {
		if (totalDeBonificacoes < 10 && funcionario.getBonificacoes() < 5) {
			System.out.println("Bonificando o funcionario: " + funcionario + " em: " + funcionario.getBonificacao());
			funcionario.getBonificacao();
			totalDeBonificacoes += 1;
			funcionario.setBonificacoes(funcionario.getBonificacoes() + 1);
		} else {
			System.out.println("Voc� j� bonificou demais");
		}
	}

	/**
	 * Adiciona funcion�rio a sistema
	 * 
	 * @param funcionario
	 *            Funcionario que ser� adicionado a lista
	 */
	public void adicionarFuncionario(Funcionario funcionario) {
		funcionarios.add(funcionario);
	}

	/**
	 * Lista os funcion�rios bonificados e n�o bonificados
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
		System.out.println("\nN�O BONIFICADOS");
		for (Funcionario n : naoBonificados) {
			System.out.println(n);
		}
	}

}
