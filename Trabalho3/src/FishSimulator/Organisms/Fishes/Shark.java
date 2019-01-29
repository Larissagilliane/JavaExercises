package FishSimulator.Organisms.Fishes;

import FishSimulator.Cell;
import FishSimulator.Ocean;
import FishSimulator.Organisms.Organism;
import FishSimulator.Randomizer;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Modelo de tubarão.
 *
 * @see Fish
 */
public class Shark extends Fish {

	// A probabilidade de nascimento de tubarão.
	private double BREEDING_PROBABILITY = 0.10;
	// O número máximo de filhos.
	private int MAX_LITTER_SIZE = 1;
	// O valor alimentar de uma única sardinha. Na prática, é o número de passos
	// que um tubarão leva para comer sardinha novamente.
	private int SARDINE_FOOD_VALUE = 4;

	// Um gerador de números aleatórios.
	private Random rand = Randomizer.getRandom();

	/**
	 * Cria um novo tubarão na localização do oceano fornecida.
	 *
	 * @param randomAge
	 *            indica se o organismo deve ser criado com uma idade aleatória
	 * @param ocean
	 *            O oceano ocupado atualmente.
	 * @param Cell
	 *            A localização no oceano.
	 */
	public Shark(boolean randomAge, Ocean ocean, Cell Cell, int breedAge, int maxAge, int maxEat) {
		super(ocean, Cell, breedAge, maxAge, maxEat);
		if (randomAge) {
			this.setAge(rand.nextInt(getMaxAge()));
			this.setFoodLevel(rand.nextInt((SARDINE_FOOD_VALUE >= getMaxEat()) ? SARDINE_FOOD_VALUE : getMaxEat()));
		} else {
			this.setAge(0);
			this.setFoodLevel((SARDINE_FOOD_VALUE >= getMaxEat()) ? SARDINE_FOOD_VALUE : getMaxEat());
		}
	}

	/**
	 * Incrementa a idade. Podendo resultar na morte do tubarão, se ele atingir a
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
	 * Faz o tubarão agir. Comer atum preferencialmente. Se não encontrar, come
	 * sardinha. Nada na direção oposta de outros tubarões próximos.
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

	@Override
	public void move(List<FishSimulator.Cell> adjacentCells) {
		Cell newDir;
		Cell nextShark = findShark();
		if (nextShark != null) {
			newDir = cell.subtractCell(nextShark, cell);
			newDir = cell.inverseCell(newDir);
			newDir = cell.addCell(cell, newDir);
			this.setCell(newDir);
		} else {
			newDir = eat();
			if (newDir != null) {
				setCell(newDir);
			} else {
				if (!adjacentCells.isEmpty()) {
					newDir = adjacentCells.get(0);
					setCell(newDir);
				} else {
					setDead();
				}
			}
		}

	}

	/**
	 * Procura por atuns, se não encontrar, proura por sardinhas para comer em
	 * posições adjacentes à localização do tubarão. Apenas o primeiro
	 * organismo vivo encontrado é comido.
	 *
	 * @param Cell
	 *            Onde o atum está localizado.
	 * @return Localização onde a comida foi encontrada, ou null se não foi
	 *         encontrada.
	 */
	protected Cell eat() {
		Cell loc = findTuna();
		if (loc == null) {
			loc = findSardine();
		}
		return loc;
	}

	/**
	 * Procura por sardinhas em posições adjacentes à localização do tubarão.
	 * Apenas a primeira sardinha viva encontrada é comida.
	 *
	 * @return Localização onde a comida foi encontrada, ou null se não foi
	 *         encontrada.
	 */
	private Cell findSardine() {
		List<Cell> adjacent = ocean.adjacentCells(getCell());
		Iterator<Cell> it = adjacent.iterator();
		while (it.hasNext()) {
			Cell where = it.next();
			Object organism = ocean.getFishAt(where);
			if (organism instanceof Sardine) {
				Sardine sardine = (Sardine) organism;
				if (sardine.isAlive()) {
					sardine.setDead();
					foodLevel = SARDINE_FOOD_VALUE;
					return where;
				}
			}
		}
		return null;
	}

	/**
	 * Procura por atuns em posições adjacentes à localização do tubarão.
	 * Apenas o primeiro atum vivo encontrado é comido.
	 *
	 * @return Localização onde a comida foi encontrada, ou null se não foi
	 *         encontrada.
	 */
	private Cell findTuna() {
		List<Cell> adjacent = ocean.adjacentCells(getCell());
		Iterator<Cell> it = adjacent.iterator();
		while (it.hasNext()) {
			Cell where = it.next();
			Object organism = ocean.getFishAt(where);
			if (organism instanceof Tuna) {
				Tuna tuna = (Tuna) organism;
				if (tuna.isAlive()) {
					tuna.setDead();
					foodLevel = getMaxEat();
					return where;
				}
			}
		}
		return null;
	}

	/**
	 * Procura o primeiro tubarão adjacente à localização atual, para fugir
	 * dele.
	 *
	 * @return Localização do primeiro tubarão encontrado.
	 */
	private Cell findShark() {
		List<Cell> adjacent = ocean.adjacentCells(getCell());
		Iterator<Cell> it = adjacent.iterator();
		while (it.hasNext()) {
			Cell where = it.next();
			Object organism = ocean.getFishAt(where);
			if (organism instanceof Shark) {
				return where;
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
			Shark young = new Shark(false, ocean, loc, 10, 22, 8);
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
