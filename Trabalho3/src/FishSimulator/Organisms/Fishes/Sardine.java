package FishSimulator.Organisms.Fishes;

import FishSimulator.Cell;
import FishSimulator.Ocean;
import FishSimulator.Organisms.Organism;
import FishSimulator.Organisms.Seaweeds.Seaweed;
import FishSimulator.Randomizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Modelo de sardinha.
 *
 * @see Fish
 */
public class Sardine extends Fish {

	// A probabilidade de nascimento de sardinhas.
	private double BREEDING_PROBABILITY = 0.30;
	// O número máximo de filhos.
	private int MAX_LITTER_SIZE = 3;
	// Um gerador de números aleatórios para controlar o nascimento de sardinhas.
	private Random rand = Randomizer.getRandom();

	// Bando ao qual pertence a sardinha
	private SardineFlock sardineFlock;

	/**
	 * Cria uma nova sardinha na localização do oceano fornecida.
	 *
	 * @param randomAge
	 *            indica se o organismo deve ser criado com uma idade aleatória
	 * @param ocean
	 *            O oceano ocupado atualmente.
	 * @param Cell
	 *            A localização no oceano.
	 */
	public Sardine(boolean randomAge, Ocean ocean, Cell cell, int breedAge, int maxAge, int maxEat) {
		super(ocean, cell, breedAge, maxAge, maxEat);
		if (randomAge) {
			this.setAge(rand.nextInt(getMaxAge()));
			this.setFoodLevel(rand.nextInt(getMaxEat()));
		} else {
			this.setAge(0);
			this.setFoodLevel(getMaxEat());
		}
	}

	/**
	 * 
	 * @return Bando ao qual pertence a sardinha.
	 */
	public SardineFlock getSardineFlock() {
		return sardineFlock;
	}

	/**
	 * Seta o bando ao qual pertence a sardinha.
	 * 
	 * @param flock
	 */
	public void setSardineFlock(SardineFlock flock) {
		this.sardineFlock = flock;
	}

	/**
	 * Incrementa a idade. Podendo resultar na morte da sardinha, se ela atingir a
	 * idade máxima.
	 */
	@Override
	public void incrementAge() {
		age++;
		if (age > getMaxAge()) {
			setDead();
		}
	}

	/**
	 * Faz a sardinha agir quando está fora de um bando.
	 *
	 * @param newOrganisms
	 *            Uma lista de recém nascidos para adicionar à simulação.
	 */
	@Override
	public void act(List<Organism> newOrganisms) {
	}

	/**
	 * Faz a sardinha agir quando está de um bando. Se movendo na mesma direção
	 * do bando.
	 *
	 * @param newOrganisms
	 *            Uma lista de algas que foram comidas e degeneradas.
	 * @return Uma lista de sardinhas recém nascidas para adicionar à simulação.
	 */
	public List<Organism> actFlocking(List<Organism> newOrganisms) {
		incrementAge();
		incrementHunger();
		List<Organism> newSardines = new ArrayList<>();
		if (isAlive()) {
			giveBirth(newSardines);

			eatThisFood(newOrganisms);
			move(ocean.getFreeFishAdjacentCells(cell));

		}
		return newSardines;
	}

	@Override
	public void move(List<Cell> adjacentCells) {
		Cell newCell = cell.addCell(sardineFlock.getCell(), this.cell); // manda a dire��o do grupo e n�o a posi��o para
																		// indicar onde a sardinha deve seguir.
		if (ocean.getFishAt(newCell) == null) {

			setCell(newCell);
		} else {
			if (!adjacentCells.isEmpty()) {
				newCell = adjacentCells.get(0);
				setCell(newCell);
			} else {
				this.setDead();
			}

		}
	}

	/**
	 * Come a alga localizada na coordenada atual da sardinha. 'Comer' significa
	 * diminuir o level da alga. O foodlevel da sardinha será proporcional ao level
	 * da alga comida.
	 * 
	 * @param newOrganisms
	 */
	private void eatThisFood(List<Organism> newOrganisms) {

		Object organism = ocean.getSeaweedAt(cell);
		if (organism instanceof Seaweed) {
			Seaweed seaweed = (Seaweed) organism;
			if (seaweed.isAlive()) {
				foodLevel = getMaxEat();
			}
			seaweed.degenerate(newOrganisms);
		}
	}

	/**
	 * Faz o organismo procriar.
	 * 
	 * @param newOrganisms
	 *            lista de novos filhos.
	 */
	@Override
	public void giveBirth(List<Organism> newOrganisms) {
		List<Cell> free = ocean.getFreeFishAdjacentCells(getCell());
		int births = breed();
		for (int b = 0; b < births && free.size() > 0; b++) {
			Cell loc = free.remove(0);
			Sardine young = new Sardine(alive, ocean, loc, 8, 40, 10);

			young.setSardineFlock(sardineFlock);

			newOrganisms.add(young);
		}
	}

	/**
	 * Generate a number representing the number of births, if it can breed.
	 * 
	 * @return The number of births (may be zero).
	 */
	@Override
	public int breed() {
		int births = 0;
		if (canBreed() && rand.nextDouble() <= BREEDING_PROBABILITY) {
			births = rand.nextInt(MAX_LITTER_SIZE) + 1;
		}
		return births;
	}

	/**
	 * A fish can breed if it has reached the breeding age.
	 */
	public boolean canBreed() {
		return age >= getBreedAge();
	}

	@Override
	public void initParams(int breedAge, int maxAge, int maxEat) {
		// TODO Auto-generated method stub

	}

}
