/**
 * A class that implements the vehicle types in the project.
 * 
 * @author Larissa
 */
public abstract class Vehicle
{
    // Unique ID for the vehicle.
    private String id;
    // The next destination of this vehicle on its
    // circular route.
    private String destination;
    // The location of this vehicle.
    private String location;

    /**
     * Constructor for objects of class Vehicle
     * @param id Unique ID for the vehicle
     */
    public Vehicle(String id)
    {
        this.id = id;
        destination = null;
    }
    
    /**
     * @return Whether or not this vehicle is free.
     */
    public abstract boolean isFree();


    /**
     * Return the unique ID for the vehicle
     * @return The ID for the vehicle
     */
    public String getID()
    {
        return id;
    }
    
    /**
     * Return the status of this vehicle.
     * @return The status.
     */
    public String getStatus()
    {
        if(getDestination() == null)
        {
            return id + " is free";
        }
        else
        {
            return id + " at " + location + " headed for " + destination;
        }
    }

    /**
     * Return the location of the vehicle.
     * @return The location of the vehicle.
     */
    public String getLocation()
    {
        return location;
    }

    /**
     * Modify the location of the vehicle.
     */
    public void setLocation(String locati)
    {
        this.location=locati;
    }

    /**
     * Return the destination of the vehicle.
     * @return The destination of the vehicle.
     */
    public String getDestination()
    {
        return destination;
    }

    /**
     * Set the intented destination of the vehicle.
     * @param destination The intended destination.
     */
    public void setDestination(String destination)
    {
        this.destination = destination;
    }


    public String toString()
    {
        return id;
    } 

}
