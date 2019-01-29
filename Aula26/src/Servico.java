/**
 * Implementação da clase Servico
 * 
 */
public class Servico {
	private String hora;
	private Funcionarios funcionarios;
	private Equipamento equipamento;
	private Buraco buraco;
	private Custo custo;

	public Servico(String hora, Funcionarios funcionarios, Equipamento equipamento, Buraco buraco, Custo custo) {
		super();
		this.hora = hora;
		this.funcionarios = funcionarios;
		this.equipamento = equipamento;
		this.buraco = buraco;
		this.custo = custo;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Funcionarios getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Funcionarios funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public Buraco getBuraco() {
		return buraco;
	}

	public void setBuraco(Buraco buraco) {
		this.buraco = buraco;
	}

	public Custo getCusto() {
		return custo;
	}

	public void setCusto(Custo custo) {
		this.custo = custo;
	}

}