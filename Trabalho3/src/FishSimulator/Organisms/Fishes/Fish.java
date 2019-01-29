package FishSimulator.Organisms.Fishes;

import FishSimulator.Cell;
import FishSimulator.FishParams;
import FishSimulator.Ocean;
import FishSimulator.Organisms.Organism;

/**
 * Representa todos os peixes no oceano.
 *
 * @see Organism
 */
public abstract class Fish extends Organism implements FishParams {

    // Nivel de comida do peixe. Que aumenta conforme o peixe come.
    protected int foodLevel;
    //a idade do organismo
    protected int age;
    

    private int breedAge;
    private int maxAge;
    private int maxEat;
    
    /**
     * Cria um novo peixe na localização do oceano fornecida.
     *
     * @param ocean O oceano ocupado atualmente.
     * @param Cell A localização no oceano.
     */
    public Fish(Ocean ocean, Cell Cell , int breedAge,
            int maxAge, int maxEat) {
        super(ocean);
        setCell(Cell);
   
        this.breedAge = breedAge;
        this.maxAge = maxAge;
        this.maxEat = maxEat;
    }
    
    public void setBreedAge(int breedAge) {
        this.breedAge = breedAge;
    }

    public int getBreedAge() {
        return breedAge;
    }
    
    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }
    
    public  int getMaxAge() {
        return maxAge;
    }

    public  void setMaxEat(int maxEat) {
        this.maxEat = maxEat;
    }
    
    public int getMaxEat() {
        return maxEat;
    }
    
     /**
     * Deixa o peixe mais faminto, o peixe poderá morrer de fome.
     */
    protected void incrementHunger()
    {
        foodLevel--;
        if(foodLevel <= 0) {
            setDead();
        }
    }
    
    /**
     * Indica que o organismo não está mais vivo. É removido do oceano.
     */
    @Override
    public void setDead() {
        alive = false;
        if (cell != null) {
            ocean.clearFish(cell);
            cell = null;
            ocean = null;
        }
    }

    /**
     * Coloca o organismo na nova localização do oceano.
     *
     * @param newCell A nova localização do organismo.
     */
    @Override
    public void setCell(Cell newCell) {
        if (cell != null) {
            ocean.clearFish(cell);
        }
        cell = newCell;
        ocean.placeFish(this, newCell);
    }

    /**
     * Seta o nível de comida do peixe.
     * 
     * @param foodLevel nível de comida.
     */
    public void setFoodLevel(int foodLevel){
        this.foodLevel = foodLevel;
    }
    
    /**
     * Retorna a idade do organismo.
     *
     * @return a idade do organismo.
     */
    public int getAge() {
        return age;
    }

    /**
     * Seta a idade do organismo.
     *
     * @param age iade do organismo.
     */
    public void setAge(int age) {
        this.age = age;
    }
    
    /**
     * Retorna o nível de comida do peixe.
     * 
     * @return int O nível de comida do peixe.
     */
    public int getFoodLevel(){
        return this.foodLevel;
    }
    
    /**
     * Quantida de filhos que um peixe terá nesse passo.
     * @return número de filhos.
     */
    @Override
    public abstract int breed();
    
}
