package FishSimulator;

import java.awt.*;
import javax.swing.*;
import java.util.HashMap;
import java.awt.event.*;

/**
 * A graphical view of the simulation grid. The view displays a colored
 * rectangle for each Cell representing its contents. It uses a default
 * background color. Colors for each type of species can be defined using the
 * setColor method.
 *
 * @author David J. Barnes and Michael Kolling
 * @version 2003.12.22
 */
public class SimulatorView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Colors used for empty Cells.
	private static final Color EMPTY_COLOR = Color.white;

	// Velocidade da simulação em milisegundos.
	private int sleepTime;

	// Color used for objects that have no defined color.
	private static final Color UNKNOWN_COLOR = Color.GRAY;

	private final String STEP_PREFIX = "Step: ";
	private final String POPULATION_PREFIX = "Population: ";
	private JLabel stepLabel, population;
	private OceanView oceanView;

	private JPanel manipPanel, simulatorbuttons, speedPanel;
	private JLabel speed;
	private Button setSpeed, Start, Pause, Continue;
	private JTextField speedField;

	// A map for storing colors for participants in the simulation
	private HashMap<Class<?>, Color> colors;
	// A statistics object computing and storing simulation information
	private OceanStats stats;

	/**
	 * Create a view of the given width and height.
	 *
	 * @param height
	 *            The simulation height.
	 * @param width
	 *            The simulation width.
	 */
	public SimulatorView(int height, int width) {
		stats = new OceanStats();
		colors = new HashMap<Class<?>, Color>();
		sleepTime = 100;

		setTitle("Ocean Simulator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		stepLabel = new JLabel(STEP_PREFIX, JLabel.CENTER);
		population = new JLabel(POPULATION_PREFIX, JLabel.CENTER);
		manipPanel = new JPanel();
		speedPanel = new JPanel();
		
		simulatorbuttons = new JPanel();

		// Speed Manip
		speed = new JLabel("Speed simulation: " + getSleepTime());
		speedField = new JTextField();
		speedField.setColumns(5);
		setSpeed = new Button("Set Speed");
		speedPanel.add(speed);
		speedPanel.add(speedField);
		speedPanel.add(setSpeed);

		oceanView = new OceanView(height, width);

		// Manipulation Panel
		Start = new Button("Start");
		Pause = new Button("Pause");
		Continue = new Button("Continue");
		Pause.setEnabled(false);
		Continue.setEnabled(false);
		
		simulatorbuttons.add(Start);
		simulatorbuttons.add(Pause);
		simulatorbuttons.add(Continue);
		
		
		manipPanel.setLayout(new GridLayout(2, 1, 0, 0));
		manipPanel.add(speedPanel);
		manipPanel.add(simulatorbuttons);
		Container contents = getContentPane();
		setVisible(true);
		setLocation(100, 50);

		oceanView = new OceanView(height, width);

		contents.add(stepLabel, BorderLayout.NORTH);
		contents.add(oceanView, BorderLayout.CENTER);
		contents.add(population, BorderLayout.SOUTH);
		contents.add(manipPanel, BorderLayout.NORTH);
		pack();
		setVisible(true);
	}

	/**
	 * Get the button start values
	 * 
	 * @return Start
	 */
	public Button getStart() {
		return Start;
	}
	

	/**
	 * get the button pause values
	 * 
	 * @return Pause
	 */
	public Button getPause() {
		return Pause;
	}

	/**
	 * get the button speed values
	 * 
	 * @return sleepTime
	 */
	public int getSleepTime() {
		return sleepTime;
	}

	/**
	 * set the speed values
	 * 
	 * @param sleepTime
	 */
	public void setSleepTime(int sleepTime) {
		this.sleepTime = sleepTime;
	}

	/**
	 * Define a color to be used for a given class of fish.
	 */
	public void setColor(Class<?> animalClass, Color color) {
		colors.put(animalClass, color);
	}

	/**
	 * @return The color to be used for a given class of fish.
	 */
	private Color getColor(Class<? extends Object> animalClass) {
		Color col = colors.get(animalClass);
		if (col == null) {
			// no color defined for this class
			return UNKNOWN_COLOR;
		} else {
			return col;
		}
	}

	/**
	 * Show the current status of the ocean.
	 *
	 * @param step
	 *            Which iteration step it is.
	 * @param ocean
	 *            The ocean whose status is to be displayed.
	 */
	public void showStatus(int step, Ocean ocean) {
		if (!isVisible()) {
			setVisible(true);
		}

		stepLabel.setText(STEP_PREFIX + step);

		stats.reset();
		oceanView.preparePaint();

		for (int row = 0; row < ocean.getHeight(); row++) {
			for (int col = 0; col < ocean.getWidth(); col++) {
				Object animal = ocean.getFishAt(row, col);
				if (animal != null) {
					stats.incrementCount(animal.getClass());
					oceanView.drawMark(col, row, getColor(animal.getClass()));
				} else {
					Object seaweed = ocean.getSeaweedAt(row, col);
					if (seaweed != null) {
						stats.incrementCount(seaweed.getClass());
						oceanView.drawMark(col, row, getColor(seaweed.getClass()));
					} else {
						oceanView.drawMark(col, row, EMPTY_COLOR);
					}
				}
			}
		}
		stats.countFinished();

		population.setText(POPULATION_PREFIX + stats.getPopulationDetails(ocean));
		oceanView.repaint();

		//Action Listeners
		Start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Start.setEnabled(false);
				Pause.setEnabled(true);
				
			}
		});

		Pause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pause.setEnabled(false);
				Continue.setEnabled(true);
				Pause.setVisible(false);
				Continue.setVisible(true);
				
			}
		});

		Continue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Continue.setEnabled(false);
				Pause.setEnabled(true);
				Pause.setVisible(true);
				Continue.setVisible(false);
				
			}
		});
		
        
        setSpeed.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
               int speedaux = Integer.parseInt(speedField.getText());
               setSleepTime(speedaux);
               speed.setText(("Simulation Speed: " + sleepTime));
            }
         });
	}

	/**
	 * Determine whether the simulation should continue to run.
	 *
	 * @return true If there is more than one species alive.
	 */
	public boolean isViable(Ocean ocean) {
		return stats.isViable(ocean);
	}

	/**
	 * Provide a graphical view of a rectangular ocean. This is a nested class (a
	 * class defined inside a class) which defines a custom component for the user
	 * interface. This component displays the ocean. This is rather advanced GUI
	 * stuff - you can ignore this for your project if you like.
	 */
	private class OceanView extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private final int GRID_VIEW_SCALING_FACTOR = 6;

		private int gridWidth, gridHeight;
		private int xScale, yScale;
		Dimension size;
		private Graphics g;
		private Image oceanImage;

		/**
		 * Create a new OceanView component.
		 */
		public OceanView(int height, int width) {
			gridHeight = height;
			gridWidth = width;
			size = new Dimension(0, 0);
		}

		/**
		 * Tell the GUI manager how big we would like to be.
		 */
		public Dimension getPreferredSize() {
			return new Dimension(gridWidth * GRID_VIEW_SCALING_FACTOR, gridHeight * GRID_VIEW_SCALING_FACTOR);
		}

		/**
		 * Prepare for a new round of painting. Since the component may be resized,
		 * compute the scaling factor again.
		 */
		public void preparePaint() {
			if (!size.equals(getSize())) { // if the size has changed...
				size = getSize();
				oceanImage = oceanView.createImage(size.width, size.height);
				g = oceanImage.getGraphics();

				xScale = size.width / gridWidth;
				if (xScale < 1) {
					xScale = GRID_VIEW_SCALING_FACTOR;
				}
				yScale = size.height / gridHeight;
				if (yScale < 1) {
					yScale = GRID_VIEW_SCALING_FACTOR;
				}
			}
		}

		/**
		 * Paint on grid Cell on this ocean in a given color.
		 */
		public void drawMark(int x, int y, Color color) {
			g.setColor(color);
			g.fillRect(x * xScale, y * yScale, xScale - 1, yScale - 1);
		}

		/**
		 * The ocean view component needs to be redisplayed. Copy the internal image to
		 * screen.
		 */
		public void paintComponent(Graphics g) {
			if (oceanImage != null) {
				Dimension currentSize = getSize();
				if (size.equals(currentSize)) {
					g.drawImage(oceanImage, 0, 0, null);
				} else {
					// Rescale the previous image.
					g.drawImage(oceanImage, 0, 0, currentSize.width, currentSize.height, null);
				}
			}
		}
	}
}
