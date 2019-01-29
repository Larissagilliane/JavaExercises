package FishSimulator;

import java.util.List;

import FishSimulator.Organisms.Organism;

/**
 * Interface for classes that provide parameters for newly created fish.
 * Implemented by the basic class SFP but could be imnplemented by
 * a more elaborate class with a GUI panel
 * @author jdb
 * @version 28/11/2008
 */
public interface FishParams {

    public void initParams( int breedAge,
                    int maxAge, int maxEat);

    public int getBreedAge();
    public int getMaxAge();
    public int getMaxEat();
    
    public void move(List<Cell> adjacentCells);
    
    /**
     * Incrementa a idade do organismo. Isso pode resultar na morte do
     * organismo, caso ele chegue a idade máxima.
     */
    public void incrementAge();
    
    /**
     * Faz o organismo procriar.
     * @param newOrganisms lista de novos filhos.
     */
    public abstract void giveBirth(List<Organism> newOrganisms);
}
