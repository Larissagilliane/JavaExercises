package FishSimulator;

public class Main {
	public static void main(String[] args) {
		Simulator sim = new Simulator(100, 100);
		try {
			sim.run();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
