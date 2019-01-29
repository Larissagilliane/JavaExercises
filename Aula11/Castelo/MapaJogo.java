/* *     
   * Implementação da clase MapaJogo que representa o tabuleiro do jogo
   *     
   * @author Larissa Moura  
   * @version 1.0 (Agosto 2017)  
*/
public class MapaJogo 
{
	private Campo[][] mapa;
	private int tamanhoMatriz;

	/* *     
	   * Construtor da classe
	   * @param tamanho O tamanho da matriz 
	*/
	public MapaJogo(int tamanho)
	{
		this.tamanhoMatriz=tamanho;
		this.mapa = new Campo[tamanho][tamanho];

		for(int linhas=0; linhas < tamanhoMatriz; linhas++)
		{
			for (int colunas=0; colunas < tamanhoMatriz; colunas++)
			{
				mapa[linhas][colunas] = new Campo();
			
			}
		}	
	}

	/**      
	  * Exibe o mapa do jogo com suas posições
	*/
	public void exibirMapa()
	{	
		int linhas,colunas;
		for(linhas=0; linhas < tamanhoMatriz; linhas++)
		{
			for (colunas=0; colunas < tamanhoMatriz; colunas++)
			{
				if(!(mapa[linhas][colunas].getPreenchido()))
					System.out.print("0");
				else
					System.out.print(mapa[linhas][colunas].getConteudo_posicao().codigo());
			}
			System.out.println();
		}
	}

	/**      
	  * Preenche o mapa com as posições - apenas pra teste o intuito seria preencher na classe jogo :( -
	*/
	public void preencheMapa(int x, int y)
	{	
		Japones j = new Japones(4.0, 9.0, 10.0, "Teste", 3);
		mapa[x][y].setPreenchido(true);
		mapa[x][y].setConteudo_posicao(j);
	}

}
