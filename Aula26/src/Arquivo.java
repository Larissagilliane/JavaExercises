
public class Arquivo {

	private Cliente cliente;
	private Buraco buraco;
	private Servico servico;

	public Arquivo(Cliente cliente, Buraco buraco, Servico servico) {
		super();
		this.cliente = cliente;
		this.buraco = buraco;
		this.servico = servico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Buraco getBuraco() {
		return buraco;
	}

	public void setBuraco(Buraco buraco) {
		this.buraco = buraco;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

}
