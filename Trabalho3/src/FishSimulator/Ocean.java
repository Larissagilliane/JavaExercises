package FishSimulator;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Representa um grid retangular. Cada posição pode
 * armazenar, simultaneamnete, um peixe e uma alga.
 */
public class Ocean {

    //Um gerador de números aleatórios para prover locais aleatórios.
    private static final Random rand = Randomizer.getRandom();

    // Altura e Largura do Oceano.
    private int height, width;

    // Armazena organismos. A terceira dimensão armazena Algas na posi��o 0 e Peixe na posi��o 1.
    private Object[][][] ocean;

    /**
     * Representa um oceano e suas dimensões. A 'profundidade' (eixo z) do
     * oceano é 2: existem algas na profundidade 0 e existem peixes na
     * profundidade 1.
     *
     * @param height A altura (eixo x) do oceano.
     * @param width A largura (eixo y) do oceano.
     */
    public Ocean(int height, int width) {
        this.height = height;
        this.width = width;
        ocean = new Object[height][width][2];
    }

    /**
     * Esvazia o oceano. Todas as algas e peixes são removidos do oceano.
     */
    public void clear() {
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                ocean[row][col][0] = null;
                ocean[row][col][1] = null;
            }
        }
    }

    /**
     * Remove a alga do local fornecido.
     *
     * @param Cell O local para remover a alga.
     */
    public void clearSeaweed(Cell Cell) {
        ocean[Cell.getRow()][Cell.getCol()][0] = null;
    }

    /**
     * Remove o peixe do local fornecida.
     *
     * @param Cell O local para remover o peixe.
     */
    public void clearFish(Cell Cell) {
        ocean[Cell.getRow()][Cell.getCol()][1] = null;
    }

    /**
     * Coloca a alga do local fornecido. Se já existe uma alga no local, ela
     * será perdida.
     *
     * @param seaweed A alga a ser colocada no oceano.
     * @param row Coordenada da linha.
     * @param col Coordenada da coluna.
     */
    public void placeSeaweed(Object seaweed, int row, int col) {
        placeSeaweed(seaweed, new Cell(this,row, col));
    }

    /**
     * Coloca a alga do local fornecido. Se já existe uma alga no local, ela
     * será perdida.
     *
     * @param seaweed A alga a ser colocada no oceano.
     * @param Cell As coordenadas do local onde a alga será colocada.
     */
    public void placeSeaweed(Object seaweed, Cell Cell) {
        ocean[Cell.getRow()][Cell.getCol()][0] = seaweed;
    }

    /**
     * Coloca o peixe do local fornecido. Se já existe um peixe no local, ele
     * será perdido.
     *
     * @param fish O peixe a ser colocado no oceano.
     * @param row Coordenada da linha.
     * @param col Coordenada da coluna.
     */
    public void placeFish(Object fish, int row, int col) {
        placeFish(fish, new Cell(this,row, col));
    }

    /**
     * Coloca o pixe do local fornecido. Se já existe um peixe no local, ele
     * será perdido.
     *
     * @param fish O peixe a ser colocado no oceano.
     * @param Cell As coordenadas do local onde o peixe será colocado.
     */
    public void placeFish(Object fish, Cell Cell) {
        ocean[Cell.getRow()][Cell.getCol()][1] = fish;
    }

    /**
     * Retorna a alga na localização dada, se existir.
     *
     * @param Cell Local no oceano.
     * @return A alga na localização dada, ou null se não existe.
     */
    public Object getSeaweedAt(Cell Cell) {
        return getSeaweedAt(Cell.getRow(), Cell.getCol());
    }

    /**
     * Retorna a alga na localização dada, se existir.
     *
     * @param row Coordenada da linha.
     * @param col Coordenada da coluna.
     * @return A alga na localização dada, ou null se não existe.
     */
    public Object getSeaweedAt(int row, int col) {
        return ocean[row][col][0];
    }

    /**
     * Retorna o peixe na localização dada, se existir.
     *
     * @param Cell Local no oceano.
     * @return O peixe na localização dada, ou null se não existe.
     */
    public Object getFishAt(Cell Cell) {
        return getFishAt(Cell.getRow(), Cell.getCol());
    }

    /**
     * Retorna o peixe na localização dada, se existir.
     *
     * @param row Coordenada da linha.
     * @param col Coordenada da coluna.
     * @return O peixe na localização dada, ou null se não existe.
     */
    public Object getFishAt(int row, int col) {
        return ocean[row][col][1];
    }
    


    /**
     * Gera uma localização aleatória que é adjacente ao local fornecido. Não
     * pode ser o próprio local fornecido. O local retornado estará dentro dos
     * limites do oceano.
     *
     * @param Cell O local que se quer gerar uma localização adjacente.
     * @return Um local válido dentro da área do grid.
     */
    public Cell randomAdjacentCell(Cell Cell) {
        List<Cell> adjacent = adjacentCells(Cell);
        return adjacent.get(0);
    }

    /**
     * Retorna uma lista embaralhada de todas as localizações adjacentes que
     * estão livres de algas.
     *
     * @param Cell O local que se quer encontrar adjacentes livres de algas.
     * @return Uma lista de locais adjacentes livres de algas.
     */
    public List<Cell> getFreeSeaweedAdjacentCells(Cell Cell) {
        List<Cell> free = new LinkedList<Cell>();
        List<Cell> adjacent = adjacentCells(Cell);
        for (Cell next : adjacent) {
            if (getSeaweedAt(next) == null) {
                free.add(next);
            }
        }
        return free;
    }

    /**
     * Retorna uma lista embaralhada de todas as localizações adjacentes que
     * estão livres de peixes.
     *
     * @param Cell O local que se quer encontrar adjacentes livres de
     * peixes.
     * @return Uma lista de locais adjacentes livres de peixes.
     */
    public List<Cell> getFreeFishAdjacentCells(Cell Cell) {
        List<Cell> free = new LinkedList<Cell>();
        List<Cell> adjacent = adjacentCells(Cell);
        for (Cell next : adjacent) {
            if (getFishAt(next) == null) {
                free.add(next);
            }
        }
        return free;
    }

    /**
     * Tenta encontrar uma localização adjacente livre de algas. Se não existe,
     * retorna null. O local retornado estará dentro dos limites do oceano.
     *
     * @param Cell O local que se quer encontrar um adjacente livre de alga.
     * @return Um local válido dentro da área do grid.
     */
    public Cell freeSeaweedAdjacentCell(Cell Cell) {
        // The available free ones.
        List<Cell> free = getFreeSeaweedAdjacentCells(Cell);
        if (free.size() > 0) {
            return free.get(0);
        } else {
            return null;
        }
    }

    /**
     * Tenta encontrar uma localização adjacente livre de peixes. Se não existe,
     * retorna null. O local retornado estará dentro dos limites do oceano.
     *
     * @param Cell O local que se quer encontrar um adjacente livre de
     * peixe.
     * @return Um local válido dentro da área do grid.
     */
    public Cell freeFishAdjacentCell(Cell Cell) {
        // The available free ones.
        List<Cell> free = getFreeFishAdjacentCells(Cell);
        if (free.size() > 0) {
            return free.get(0);
        } else {
            return null;
        }
    }

    /**
     * Retorna uma lista embaralhada dos locais adjacentes ao local fornecido. A
     * lista não inclui o próprio local fornecido. Todos os locais estarão
     * dentro dá área do grid.
     *
     * @param Cell O local que se quer descobrir seus locais adjacentes.
     * @return Uma lista dos locais adjacetes ao local fornecido.
     */
    public List<Cell> adjacentCells(Cell Cell) {
        // The list of Cells to be returned.
        List<Cell> Cells = new LinkedList<Cell>();
        if (Cell != null) {
            int row = Cell.getRow();
            int col = Cell.getCol();
            for (int roffset = -1; roffset <= 1; roffset++) {
                int nextRow = row + roffset;
                if (nextRow >= 0 && nextRow < height) {
                    for (int coffset = -1; coffset <= 1; coffset++) {
                        int nextCol = col + coffset;
                        // Exclude invalid Cells and the original Cell.
                        if (nextCol >= 0 && nextCol < width && (roffset != 0 || coffset != 0)) {
                            Cells.add(new Cell(this,nextRow, nextCol));
                        }
                    }
                }
            }

            // Shuffle the list. Several other methods rely on the list
            // being in a random order.
            Collections.shuffle(Cells, rand);
        }
        return Cells;
    }

    /**
     * @return A altura (eixo x) do oceano.
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return A largura (eixo y) do oceano.
     */
    public int getWidth() {
        return height;
    }
}
