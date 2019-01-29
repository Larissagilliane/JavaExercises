package FishSimulator.Organisms;

import FishSimulator.Ocean;
import FishSimulator.Cell;
import java.util.List;

/**
 * Representa todos os seres no oceano.
 */
public abstract class Organism {

    //Informa se o organismo está vivo ou não.
    protected boolean alive;
    //O oceano do organismo.
    protected Ocean ocean;
    //A posição do organismo no oceano.
    protected Cell cell;

    /**
     * Cria um novo Organismo na localização do oceano fornecida.
     *
     * @param ocean O oceano que o organismo ocupa.
     */
    public Organism(Ocean ocean) {
        this.alive = true;
        this.ocean = ocean;
    }

    /**
     * Faz o organismo agir, isto é, o organismo fazer qualquer coisa que ele
     * queira/precise.
     *
     * @param newOrganisms Uma lista para adicionar organismos recém nascidos.
     */
    public abstract void act(List<Organism> newOrganisms);

    /**
     * Checa se o organismo está vivo ou não.
     *
     * @return true se o organismo ainda está vivo.
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * Indiaca que o organismo não está mais vivo. É removido do oceano.
     */
    public abstract void setDead();

    /**
     * @return A localização do organismo.
     */
    public Cell getCell() {
        return cell;
    }

    /**
     * Coloca o organismo na nova localização do oceano.
     *
     * @param newCell A nova localização do organismo.
     */
    public abstract void setCell(Cell newCell);

    /**
     * Retorna o oceano do organismo.
     *
     * @return O oceano do organismo.
     */
    public Ocean getOcean() {
        return ocean;
    }

     /**
     * Generate a number representing the number of births,
     * if it can breed.
     * @return The number of births (may be zero).
     */
    public abstract int breed();
}
