/**
 * Passenger who will pick up a vehicle
 * @author Larissa
 */
public class Passenger
{
    // The name of the Passenger
    private String name;

    // The destination that the passenger wants to go.
    private String destination;

    /**
     * Constructor for objects of class Passenger.
     * @param name The name of this Passenger.
     * @param destino The destination
     */
    public Passenger(String nome, String destino)
    {
        this.name = nome;
        this.destination = destino;
    }

     public String toString()
     {
        return "Passenger " + name + " travelling to " + destination;
     }   
    
    /**
     * Returns the name of the passenger
     */
    public String getNome()
    {
        return name;
    }

    /**
     * Modifies the name of the passenger
     */
    public void setNome(String nome)
    {
        this.name =nome;
    }

    /**
     * Returns the destination
     */
    public String getDestination()
    {
        return destination;
    }

    /**
     * Modifies the destination.
     */
    public void setDestination(String destino)
    {
        this.destination =destino;
    }   
}
