public class Main 
{
	public static void main(String[] args) 
	{
		TaxiCo empresa = new TaxiCo("Taxistas");
		empresa.addTaxi();
		empresa.addShuttle();
		empresa.addTaxi();
		empresa.addShuttle();
		empresa.addTaxi();
		empresa.addTaxi();
		empresa.addShuttle();

		Taxi taxi1 = (Taxi) empresa.lookup("Car #6");       
        taxi1.book("Whitstable");

		empresa.showStatus();

		Passenger pessoa = new Passenger("Maria" , "Whitstable");
		System.out.println("\n" + pessoa + " on vehicle " + empresa.callVehicle(pessoa) + "\n");
	}
}


