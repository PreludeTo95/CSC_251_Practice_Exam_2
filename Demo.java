import java.util.Scanner;
import java.util.ArrayList;

public class Demo
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);
        ArrayList<Land> lands = new ArrayList<Land>();
        ArrayList<Building> buildings = new ArrayList<Building>();
        int willToGoOn;
        double runningTotal;

        //land details
        String idNumber;
        double acreage;
        String zone;
        boolean buildingPresent = false;

        //building details
        String address;
        int size;
        
        System.out.println("This program will calculate analyze information you enter about a propert and return pricing.");
        System.out.println("");

        do 
        {

            System.out.println("What is your property's ID number?");
            idNumber = userInput.nextLine();

            System.out.println("How many acres is your property?");
            acreage = userInput.nextDouble();

            while (acreage <= 0)
            {
                System.out.println("Acreage cannot be less than or equal to zero.\nHow many acres is your property?");
                acreage = userInput.nextDouble();
            }

            System.out.println("Under what zoning does your property fall?");
            System.out.println("\t1 - Residential");
            System.out.println("\t2 - Commercial");
            int zoneInput = userInput.nextInt();
            if (zoneInput == 1)
            {
                zone = "Residential";
            } else if (zoneInput == 2) 
            {
                zone = "Commercial";
            }
            
            System.out.println("Is there a building associated with your property?");
            System.out.println("\t1 - Yes");
            System.out.println("\t2 - No");
            int buildingInput = userInput.nextInt();

            if (buildingInput == 1)
            {
                buildingPresent = true;
            } else if (buildingInput == 2)
            {
                buildingPresent = false;
            }

            //create a default instance of building so land object can be constructed if no building is present
            Building building = new Building();

            if (buildingPresent == true)
            {
                //clear the buffer
                userInput.nextLine();
                System.out.println("What is the street address?");
                address = userInput.nextLine();
                
              
                System.out.println("What is the square footage?");
                size = userInput.nextInt();
                
                while(size <= 0)
                {
                    System.out.println("Square footage cannot be below zero.\nWhat is the square footage?");
                    size = userInput.nextInt();
                }

                building = new Building(address, size);
                //System.out.println(building);
            }

            //create an instance of the land class, not sure why this is not working
            Land land = new Land(idNumber, acreage, zone, buildingPresent, building);
            //add the instance of land to the array list
            lands.add(land);

            runningTotal += land.calculatePropertyTax();

            System.out.println("Would you like to process another parcel of land?");
            willToGoOn = userInput.nextInt();
         } while (willToGoOn == 1);

         for (int i = 0; i < lands.size(); i++)
        {
            //call toString() on this array element
            System.out.println(lands.get(i));
            //find the property tax for this array element
            System.out.println("Total tax: " + lands.get(i).calculatePropertyTax());
            System.out.println();  
        }

         //divide the total property tax by the size of the array list to find the average
         System.out.println("The average property tax on your lands is: " + (runningTotal / lands.size()));
    }
}