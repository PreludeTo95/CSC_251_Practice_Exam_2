public class Land 
{
    private String idNumber;
    private double acreage;
    private String zone;
    private boolean hasBuilding;
    private Building building;

    //no-args constructor
    public void Land()
    {
      idNumber = "No ID exists";
      acreage = 0;
      zone = "Zone not set";
      hasBuilding = false;
      building = new Building();
    }
    
    //args constructor
    public void Land(String idNumber, double acreage, String zone, boolean hasBuilding, Building building)
    {
       this.idNumber = idNumber;
       this.acreage = acreage;
       this.zone = zone;
       this.hasBuilding = hasBuilding;
       this.building = new Building(building);
    }

    //getters and setters
    public void setIdNumber(String idNumber)
    {
      this.idNumber = idNumber;
    }

    public String getIdNumber()
    {
      return idNumber;
    }

    public void setAcreage(double acreage)
    {
      this.acreage = acreage;
    }

    public double getAcreage()
    {
      return acreage;
    }

    public void setZone(String zone)
    {
      this.zone = zone;
    }

    public String getZone()
    {
      return zone;
    }

    public void setHasBuilding(boolean hasBuilding)
    {
      this.hasBuilding = hasBuilding;
    }

    public boolean getHasBuilding()
    {
      return hasBuilding;
    }

    public void setBuilding(Building building)
    {
      this.building = building;
    }

    public Building getBuilding()
    {
      return building;
    }

    //calcuate the property tax for a parcel of land based on its characteristics
    public double calculatePropertyTax()
    {
      double taxPerAcre = 0;
      double buildingTax = 0;
      
      if (zone.equalsIgnoreCase("residential"))
      {
         taxPerAcre = 500;
         if (hasBuilding)
         {
            if (building.getSquareFootage() < 2000)
            {
               buildingTax = building.squareFootage * 0.50;
            } else {
               buildingTax = building.squareFootage * 0.75;
            }
         }
      } else {
         taxPerAcre = 2000;
         if (hasBuilding)
         {
            if (building.squareFootage < 4000)
            {
               buildingTax = building.squareFootage * 1.00;
            } else {
               buildingTax = building.squareFootage * 1.50;
            }
         }
      }
      return ((acreage * taxPerAcre) + buildingTax);
    }

    public String toString()
    {
      return 
      (
        "ID Number: " + idNumber +
        "\nAcreage: " + acreage +
        "\nZone: " + zone +
        "Building present: " + hasBuilding +
        "Building Info: " + building.toString()
      );
    }
}