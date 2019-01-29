public class Retangulo extends Forma {

	private float lado;
	private float altura;

	/**
	 * Construtor da classe
	 * 
	 * @param lado
	 *            tamando do lado da forma
	 * @param altura
	 *            tamanho da altura da forma
	 */
	public Retangulo(float lado, float altura) {
		this.lado = lado;
		this.altura = altura;
	}

	/**
	 * Retorna o lado da forma
	 */
	public float getLado() {
		return lado;
	}

	/**
	 * Modifica o valor do lado
	 * 
	 * @param lado
	 *            tamanho do lado da forma
	 */
	public void setLado(float lado) {
		this.lado = lado;
	}

	/**
	 * Retorna a altura da forma
	 */
	public float getAltura() {
		return altura;
	}

	/**
	 * Modifica o valor da altura
	 * 
	 * @param altura
	 *            tamanho da altura da forma
	 */
	public void setAltura(float altura) {
		this.altura = altura;
	}

	@Override
	/**
	 * Calcula a área da forma
	 */
	public float calcularArea() {
		return (altura * lado);
	}

	@Override
	/**
	 * Calcula o perimetro da forma
	 */
	public float cacularPerimetro() {
		return (2 * (lado + altura));
	}

	public String toString() {
		return "Retangulo";
	}

}
