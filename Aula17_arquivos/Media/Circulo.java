import java.lang.Math;

public class Circulo extends Forma {

	private float raio;

	/**
	 * Construtor da classe
	 * 
	 * @param raio
	 *            tamanho do raio da forma
	 */
	public Circulo(float raio) {
		this.raio = raio;
	}

	/**
	 * Retorna o valor do raio
	 */
	public float getRaio() {
		return raio;
	}

	/**
	 * Modifica o valor do raio
	 * 
	 * @param raio
	 *            tamanho do raio da forma
	 */
	public void setRaio(float raio) {
		this.raio = raio;
	}

	@Override
	/**
	 * Calcula a área da forma
	 */
	public float calcularArea() {
		return (float) (Math.PI * Math.pow(raio, 2));
	}

	@Override
	/**
	 * Calcula o perimetro da forma
	 */
	public float cacularPerimetro() {
		return (float) (Math.PI * raio * 2);
	}

	public String toString() {
		return "Circulo";
	}

}
