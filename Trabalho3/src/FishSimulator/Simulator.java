package FishSimulator;

import FishSimulator.Organisms.Fishes.Sardine;
import FishSimulator.Organisms.Fishes.SardineFlock;
import FishSimulator.Organisms.Fishes.Shark;
import FishSimulator.Organisms.Fishes.Tuna;
import FishSimulator.Organisms.Organism;
import FishSimulator.Organisms.Seaweeds.Seaweed;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Simula um oceano composto por peixes e algas.
 */
public class Simulator {
	// The default width for the grid.
	private int DEFAULT_WIDTH = 60;
	// The default depth of the grid.
	private int DEFAULT_HEIGHT = 60;
	// Um gerador de números aleatórios.
	private Random rand = Randomizer.getRandom();

	// Lista de organismos no oceano.
	private List<Organism> organisms;
	// O oceano atual.
	private Ocean ocean;
	// The current step of the simulation.
	private int step;
	// A graphical view of the simulation.
	private SimulatorView simView;

	/**
	 * Constroí a simulação com tamanho do grid passado como parametros.
	 * 
	 * @param height
	 * @param width
	 */
	public Simulator(int height, int width) {

		if (width <= 0 || height <= 0) {
			System.out.println("The dimensions must be greater than zero.");
			System.out.println("Using default values.");
			height = DEFAULT_HEIGHT;
			width = DEFAULT_WIDTH;
			Cell.setHeight(DEFAULT_HEIGHT);
			Cell.setWidth(DEFAULT_WIDTH);
		}

		Cell.setHeight(height);
		Cell.setWidth(width);

		organisms = new ArrayList<Organism>();
		ocean = new Ocean(height, width);

		simView = new SimulatorView(height, width);

		// Sardine - vermelho
		simView.setColor(Sardine.class, new Color(255, 0, 0));
		// Tuna - amarelo
		simView.setColor(Tuna.class, new Color(254, 222, 0));
		// Shark - preto
		simView.setColor(Shark.class, new Color(0, 0, 0));
		// alga - verde
		simView.setColor(Seaweed.class, new Color(0, 139, 0));
		// Setup a valid starting point.
		restart();
	}

	/**
	 * Enquanto a simulação for viável, executa passos.
	 * @throws InterruptedException 
	 */
	public void run() throws InterruptedException {
		int speed;
		while (simView.isViable(ocean)) {
			speed = simView.getSleepTime();
			TimeUnit.MILLISECONDS.sleep(speed);
			while (simView.getStart().isEnabled() == true || simView.getPause().isEnabled() == false) {
				TimeUnit.MILLISECONDS.sleep(10);
			}
			try {
				Thread.sleep(simView.getSleepTime());
			} catch (InterruptedException ex) {
			}
			simulateOneStep();
		}
	}

	/**
	 * Run the simulation from its current state for a single step.
	 */
	public void simulateOneStep() {
		step++;

		List<Organism> newOrganisms = new ArrayList<Organism>();

		for (Iterator<Organism> it = organisms.iterator(); it.hasNext();) {
			Organism organismo = it.next();
			organismo.act(newOrganisms);
			if (!organismo.isAlive()) {
				it.remove();
			}
		}
		organisms.addAll(newOrganisms);
		simView.showStatus(step, ocean);
	}

	/**
	 * Reset the simulation to a starting position.
	 */
	public void restart() {
		step = 0;
		organisms.clear();
		populate();

		// Show the starting state in the view.
		simView.showStatus(step, ocean);
	}

	/**
	 * Randomly populate the field.
	 */
	private void populate() {
		ocean.clear();
		int numSeaweed = rand.nextInt(10) + 10;
		List<Organism> seaweeds = new ArrayList<Organism>();
		Cell cell;
		for (int i = 0; i <= numSeaweed; i++) {
			Seaweed seaweed;
			cell = new Cell(ocean, rand.nextInt(ocean.getHeight()), rand.nextInt(ocean.getWidth()));
			int limit = rand.nextInt(100) + 30;
			for (int j = 0; j < limit; j++) {
				seaweed = new Seaweed(ocean, cell);
				organisms.add(seaweed);
				cell = ocean.adjacentCells(cell).get(0);
			}
		}
		organisms.addAll(seaweeds);

		int numSardineFlocks = rand.nextInt(5) + 20;

		List<Organism> sardineFlocks = new ArrayList<Organism>();
		for (int i = 0; i <= numSardineFlocks; i++) {
			SardineFlock newSardineFlock = new SardineFlock(ocean);

			sardineFlocks.add(newSardineFlock);

			cell = new Cell(ocean, rand.nextInt(ocean.getHeight()), rand.nextInt(ocean.getWidth()));
			int limit = rand.nextInt(100) + 50;
			for (int j = 0; j < limit; j++) {
				cell = ocean.adjacentCells(cell).get(0);
				if (cell != null) {
					Sardine sardine = new Sardine(true, ocean, cell, 8, 40, 10);
					sardine.setSardineFlock(newSardineFlock);
					newSardineFlock.addSardine(sardine);
				}
			}
		}
		organisms.addAll(sardineFlocks);

		int numTuna = rand.nextInt(20) + 50;
		List<Organism> tunas = new ArrayList<Organism>();
		for (int i = 0; i <= numTuna; i++) {
			Tuna tuna;
			cell = new Cell(ocean, rand.nextInt(ocean.getHeight()), rand.nextInt(ocean.getWidth()));
			tuna = new Tuna(true, ocean, cell, 5, 60, 7);
			organisms.add(tuna);
			organisms.add(tuna);

		}
		organisms.addAll(tunas);

		int numShark = rand.nextInt(20) + 50;
		List<Organism> sharks = new ArrayList<Organism>();
		for (int i = 0; i <= numShark; i++) {
			Shark shark;
			cell = new Cell(ocean, rand.nextInt(ocean.getHeight()), rand.nextInt(ocean.getWidth()));
			shark = new Shark(true, ocean, cell, 10, 22, 8);
			organisms.add(shark);

		}
		organisms.addAll(sharks);

		for (int row = 0; row < ocean.getHeight(); row++) {
			for (int col = 0; col < ocean.getWidth(); col++) {

			}
		}
	}

}
