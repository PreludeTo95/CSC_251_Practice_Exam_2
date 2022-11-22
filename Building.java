public class Building 
{
    public String address;
    public int squareFootage;

    //no-args constructor
    public Building() 
    {
        address = "N/A";
        squareFootage = 0;
    }

    //args constructor
    public Building(String address, int squareFootage) 
    {
        this.address = address;
        this.squareFootage = squareFootage;
    }

    //copy constructor
    public Building(Building original)
    {
        address = original.address;
        squareFootage = original.squareFootage;
    }

    //getters and setters
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    public String getAddress()
    {
        return address;
    }

    public void setSquareFootage(int squareFootage)
    {
        this.squareFootage = squareFootage;
    }

    public int getSquareFootage()
    {
        return squareFootage;
    }

    //overwrite default toString()
    public String toString()
    {
      return("Address: " + address + "\nSquare Footage: " + squareFootage);
    }

}
