import java.util.ArrayList;
import java.util.Random;

public class RepositorioFormas {

	private ArrayList<Forma> formas;
	private ArrayList<Forma> temp;

	/**
	 * Construtor da classe
	 */
	public RepositorioFormas() {
		formas = new ArrayList<>();
		temp = new ArrayList<>();
	}

	/**
	 * Cria as formas geométricas utilizadas
	 */
	public void criarFormas() {
		
		Forma forma1 = new Quadrado(3.0f, 3.0f);
		Forma forma2 = new Retangulo(3.0f, 4.6f);
		Forma forma3 = new Circulo(8.0f);
		Forma forma4 = new Circulo(10.0f);

		temp.add(forma1);
		temp.add(forma2);
		temp.add(forma3);
		temp.add(forma4);

	}

	/**
	 * Adiciona os valores randomicamente
	 */
	public void adicionarFormas() {

		Random gerador = new Random();
		int i;
		for (i = 0; i < temp.size(); i++) {
			formas.add(temp.get(gerador.nextInt(temp.size())));
		}
	}

	/**
	 * Calcula as áreas das formas
	 */
	public void calcularAreas() {
		for (Forma figura : formas) {
			System.out.println(figura + " tem área de " + figura.calcularArea());
		}
	}

}