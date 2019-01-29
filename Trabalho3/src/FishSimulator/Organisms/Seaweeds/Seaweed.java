package FishSimulator.Organisms.Seaweeds;

import FishSimulator.Cell;
import FishSimulator.Ocean;
import FishSimulator.Organisms.Organism;
import FishSimulator.Randomizer;
import java.util.List;
import java.util.Random;

/**
 * Representa todas as algas no oceano.
 *
 * @see Organism
 */
public class Seaweed extends Organism {

	// A probabilidade de regenera��o de algas.
	private double BREEDING_PROBABILITY = 0.50;
	// O número máximo de 'filhos'.
	private int MAX_LITTER_SIZE = 4;
	// Um gerador de números aleatórios para controlar o regenera��o de algas.
	private Random rand = Randomizer.getRandom();


	/**
	 * Cria uma nova alga na localização do oceano fornecida.
	 *
	 * @param randomAge
	 *            indica que a ideda inicial será um valor aleatório menor que a
	 *            idade máxima.
	 * @param ocean
	 *            O oceano ocupado atualmente.
	 * @param Cell
	 *            A localização no oceano.
	 */
	public Seaweed(Ocean ocean, Cell cell) {
		super(ocean);
		setCell(cell);
	}

	/**
	 * Indiaca que o organismo não está mais vivo. É removido do oceano.
	 */
	@Override
	public void setDead() {
		alive = false;
		if (cell != null) {
			ocean.clearSeaweed(cell);
			cell = null;
			ocean = null;
		}
	}

	/**
	 * Coloca o organismo na nova localização do oceano.
	 *
	 * @param newCell
	 *            A nova localização do organismo.
	 */
	@Override
	public void setCell(Cell newCell) {
		if (cell != null) {
			ocean.clearSeaweed(cell);
		}
		cell = newCell;
		ocean.placeSeaweed(this, newCell);
	}

	/**
	 * Faz a alga agir, isto é: Incrementar a idade até a idade máxima e morrer.
	 * Reproduzir (se espalhar ao redor). E se regenerar.
	 *
	 * @param newOrganisms
	 *            Uma lista para adicionar organismos recém nascidos.
	 */
	@Override
	public void act(List<Organism> newOrganisms) {
			if (isAlive()) {
				regenerate(newOrganisms);
			}
	}

	/**
	 * Gera um número representando o número de novas algas que a alga regenerará
	 *
	 * @return O número pode ser zero.
	 */
	@Override
	public int breed() {
		int births = 0;
		if (rand.nextDouble() <= BREEDING_PROBABILITY) {
			births = rand.nextInt(MAX_LITTER_SIZE) + 1;
		}
		return births;
	}

	/**
	 * Regenera a alga
	 *
	 * @param newOrganisms
	 *          
	 */
	public void regenerate(List<Organism> newOrganisms) {
		List<Cell> free = ocean.getFreeSeaweedAdjacentCells(getCell());
		int births = breed();
		for (int b = 0; b < births && free.size() > 0; b++) {
			Cell loc = free.remove(0);
			Seaweed young = new Seaweed(ocean, loc);
			newOrganisms.add(young);
		}
	}

	/**
	 * Degenera a alga. Este método é chamado quando a sardinha come a alga.
	 *
	 * @param newOrganisms
	 *           
	 */
	public void degenerate(List<Organism> newOrganisms) {
		
		this.setDead();
	}

}
