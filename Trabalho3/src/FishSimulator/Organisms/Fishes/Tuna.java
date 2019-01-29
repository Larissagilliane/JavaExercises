package FishSimulator.Organisms.Fishes;

import FishSimulator.Cell;
import FishSimulator.Ocean;
import FishSimulator.Organisms.Organism;
import FishSimulator.Randomizer;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Modelo de Atum.
 *
 * @see Fish
 */
public class Tuna extends Fish {

	// A probabilidade de nascimento de atuns.
	private double BREEDING_PROBABILITY = 0.25;
	// O número máximo de filhos.
	private int MAX_LITTER_SIZE = 2;

	// Um gerador de números aleatórios para controlar o nascimento de atum.
	private Random rand = Randomizer.getRandom();

	/**
	 * Cria um novo atum na localização do oceano fornecida.
	 *
	 * @param randomAge
	 *            indica se o organismo deve ser criado com uma idade aleatória
	 * @param ocean
	 *            O oceano ocupado atualmente.
	 * @param Cell
	 *            A localização no oceano.
	 */
	public Tuna(boolean randomAge, Ocean ocean, Cell Cell, int breedAge, int maxAge, int maxEat) {
		super(ocean, Cell, breedAge, maxAge, maxEat);
		if (randomAge) {
			this.setAge(rand.nextInt(getMaxAge()));
			this.setFoodLevel(rand.nextInt(getMaxEat()));
		} else {
			this.setAge(0);
			this.setFoodLevel(getMaxEat());
		}
	}

	/**
	 * Incrementa a idade. Podendo resultar na morte do atum, se ele atingir a idade
	 * máxima.
	 */
	@Override
	public void incrementAge() {
		age++;
		if (age > getMaxAge()) {
			setDead();
		}
	}

	/**
	 * Faz o atum agir.
	 *
	 * @param newOrganisms
	 *            Uma lista de recém nascidos para adicionar à simulação.
	 */
	@Override
	public void act(List<Organism> newOrganisms) {

		incrementAge();
		incrementHunger();
		if (isAlive()) {
			giveBirth(newOrganisms);
			move(ocean.getFreeFishAdjacentCells(cell));

		}
	}

	/**
	 * Faz o atum se mover e comer sardinha.
	 *
	 * @param adjacentCells
	 *            Uma lista de células adjacentes
	 */
	@Override
	public void move(List<Cell> adjacentCells) {
		Cell newCell = eat();
		if (newCell == null) {
			// No food found - try to move to a free Cell.
			if (!adjacentCells.isEmpty()) {
				newCell = adjacentCells.get(0);
				setCell(newCell);
			} else {
				// Overcrowding.
				setDead();
			}
		}
	}

	/**
	 * Procura por sardinhas para comer em posições adjacentes à localização do
	 * atum. Apenas a primeira sardinha viva encontrada é comida.
	 *
	 * @param Cell
	 *            Onde o atum está localizado.
	 * @return Localização onde a comida foi encontrada, ou null se não foi
	 *         encontrada.
	 */
	protected Cell eat() {
		List<Cell> adjacent = ocean.adjacentCells(getCell());
		Iterator<Cell> it = adjacent.iterator();
		while (it.hasNext()) {
			Cell where = it.next();
			Object organism = ocean.getFishAt(where);
			if (organism instanceof Sardine) {
				Sardine sardine = (Sardine) organism;
				if (sardine.isAlive()) {
					sardine.setDead();
					foodLevel = getMaxEat();
					return where;
				}
			}
		}
		return null;
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
			Tuna young = new Tuna(false, ocean, loc, 5, 60, 7);
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
	private boolean canBreed() {
		return age >= getBreedAge();
	}

	@Override
	public void initParams(int breedAge, int maxAge, int maxEat) {
		// TODO Auto-generated method stub

	}
}
