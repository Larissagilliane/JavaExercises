package FishSimulator.Organisms.Fishes;

import FishSimulator.Cell;
import FishSimulator.Ocean;
import FishSimulator.Organisms.Organism;
import FishSimulator.Randomizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Bando de sardinhas.
 */
public class SardineFlock extends Organism {

    // Lista de todas as sardinhas que pertencem ao bando.
    private List<Organism> sardines;
    // probabilidade de um bando mudar de direção
    private double CHANGE_DIRECTION_PROBABILITY = 0.25;
    // gerador de numeros aleatórios
    private Random rand = Randomizer.getRandom();

    /**
     * Cria um bando de sardinhas.
     * 
     * O atributo Cell deve possuir valores entre -1, 0 e 1. Serve para indicar a direção que o bando deve seguir e não uma posição específica no grid.
     * @param ocean 
     */
    public SardineFlock(Ocean ocean) {
        super(ocean);
        sardines = new ArrayList<>();
        int row = rand.nextInt(3)-1;
        int col = rand.nextInt(3)-1;
        cell = new Cell(getOcean(),row,col);
    }

    /**
     * Adiciona sardinha ao bando.
     * @param sardine 
     */
    public void addSardine(Sardine sardine){
        sardines.add(sardine);
    }
    /**
     * Remove sardinha do bando.
     * @param sardine 
     */
    public void removeSardine(Sardine sardine){
        sardines.remove(sardine);
    }
    
    /**
     * Percorre a lista de sardinhas do bando.
     * Faz todas as sardinhas agirem, comerem e se moverem na mesma direção.
     * @param newOrganisms 
     */
    @Override
    public void act(List<Organism> newOrganisms) {
        if(rand.nextDouble() <= CHANGE_DIRECTION_PROBABILITY )
        	cell = new Cell(getOcean(),rand.nextInt(3)-1,rand.nextInt(3)-1);
        
        if (sardines != null) {
            for (int i=0; i<sardines.size(); i++) {
                
                Sardine organismo = (Sardine) sardines.get(i);
                List<Organism> newSardines = organismo.actFlocking(newOrganisms);
                if (!organismo.isAlive()) {
                    sardines.remove(i);
                }
                this.sardines.addAll(newSardines);
                
            }
        }
    }

    /**
     * Indiaca que o organismo não está mais vivo. É removido do oceano.
     */
    @Override
    public void setDead() {
    }

    /**
     * Coloca o organismo na nova localização do oceano.
     *
     * @param newCell A nova localização do organismo.
     */
    @Override
    public void setCell(Cell newCell) {
    }


     /**
     * Generate a number representing the number of births,
     * if it can breed.
     * @return The number of births (may be zero).
     */
    @Override
    public int breed() {
        return -1;
    }
}
