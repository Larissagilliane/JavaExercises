import java.util.Scanner;

public class main 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int number;

		BallDemo balls = new BallDemo();

		System.out.println("Desenhando um quadro");
		balls.drawFrame();

		System.out.println("Digite a quantidade de bolinhas que serão animadas ");
		number = in.nextInt();
		balls.bounce(number);

		System.out.println("Desenhando outro quadro");
		balls.drawFrame();
	}
}