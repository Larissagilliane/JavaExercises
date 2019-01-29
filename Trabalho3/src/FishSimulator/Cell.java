package FishSimulator;

import FishSimulator.Organisms.Fishes.Fish;
import FishSimulator.Organisms.Seaweeds.Seaweed;

/**
 * Represent a Cell in a rectangular grid.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class Cell
{
    // Row and column positions.
    private int row;
    private int col;
    // Largura e altura total do grid
    private static int WIDTH;
    private static int HEIGHT;
    
    private Ocean ocean;

    /**
     * Seta a largura do grid
     * @param width 
     */
    public static void setWidth(int width){
        Cell.WIDTH = width;
    }
    /**
     * Seta a altura do grid
     * @param height 
     */
    public static void setHeight(int height){
    	Cell.HEIGHT = height;
    }
    
    /**
     * Represent a row and column.
     * @param row The row.
     * @param col The column.
     */
    public Cell(Ocean ocean,int row, int col)
    {
        this.row = row;
        this.col = col;
        this.ocean = ocean;
    }
    
    /**
     * Soma duas coordenadas.
     * @param loc1
     * @param loc2
     * @return a coordenada resultante.
     */
    public Cell addCell(Cell loc1, Cell loc2){
        int newRow = loc1.getRow() + loc2.getRow();
        int newCol = loc1.getCol() + loc2.getCol();
        
        if(newRow<0)
            newRow = Cell.HEIGHT-1;
        if(newRow >= Cell.HEIGHT)
            newRow = 0;
        
        if(newCol<0)
            newCol = Cell.WIDTH-1;
        if(newCol >= Cell.WIDTH)
            newCol = 0;
        
        return new Cell(ocean,newRow,newCol );
       
    }
    
    /**
     * Subtrai duas coordenadas
     * @param loc1
     * @param loc2
     * @return a subtração loc1 - loc2
     */
     public  Cell subtractCell(Cell loc1, Cell loc2){
        int newRow = loc1.getRow() - loc2.getRow();
        int newCol = loc1.getCol() - loc2.getCol();
        
        return new Cell(ocean, newRow,newCol );
       
    }
     
     /**
      * Inverte uma coordenada (multiplica por -1).
      * @param loc
      * @return a coordenada inversa.
      */
      public Cell inverseCell(Cell loc){
        int newRow = loc.getRow()*(-1);
        int newCol = loc.getCol()*(-1);
        
        return new Cell(ocean, newRow,newCol );
       
    }
    
    /**
     * Implement content equality.
     * @return true se as Cells forem iguais.
     */
    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof Cell) {
            Cell other = (Cell) obj;
            return row == other.getRow() && col == other.getCol();
        }
        else {
            return false;
        }
    }
    
    /**
     * Return a string of the form row,column
     * @return A string representation of the Cell.
     */
    @Override
    public String toString()
    {
        return row + "," + col;
    }
    
    /**
     * Use the top 16 bits for the row value and the bottom for
     * the column. Except for very big grids, this should give a
     * unique hash code for each (row, col) pair.
     * @return A hashcode for the Cell.
     */
    @Override
    public int hashCode()
    {
        return (row << 16) + col;
    }
    
    /**
     * @return The row.
     */
    public int getRow()
    {
        return row;
    }
    
    /**
     * @return The column.
     */
    public int getCol()
    {
        return col;
    }
    
    /**
     * @return O peixe na determinar c�lula.
     */
    public Fish getFish()
    {
        return (Fish) ocean.getFishAt(row, col);
    }
    
    /**
     * Add a new fish to the cell. Any existing occupant is discarded
     * @param fish the fish to add. Use null to empty the cell
     */
    public void setFish(Fish fish)
    {
        ocean.placeFish(fish, row, col);
    }
    
    /**
     * Get the plancton level at this location
     * @return plancton level
     */
    public Seaweed getSeaweed()
    {
    	return (Seaweed) ocean.getSeaweedAt(row, col);
    }
    
    /**
     * Set the plancton level at this locatopn
     * @param p the new plancton level
     */
    public void setPlancton(double p)
    {
    	ocean.placeSeaweed(p, row, col);
    }
}
