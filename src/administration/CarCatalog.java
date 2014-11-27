package administration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import enums.*;



public class CarCatalog
{
	List<Car> carCatalog = new ArrayList<Car>();
	Scanner scan = new Scanner(System.in);
	
	public CarCatalog()
	{
		
	}
	
	public void addNewCar(Car car)
	{
		carCatalog.add(car);
	}
	
	public void updateCarbyLicenseNumber(String licenseNum)
	{
		
		Car tempCar = new Car();
														//  ToDo - handle exception for license number not matching any car. also in searchByLicenseNum
		
		tempCar = this.searchByLicenseNumber(licenseNum);   
		System.out.println("The current license number is " + tempCar.getLicenseNum() + ". Please enter a new value>\n");
		String newLicenseNumber = scan.next();
		tempCar.setLicenseNum(newLicenseNumber);
		System.out.println("The current top speed is " + tempCar.getTopSpeed() + ". Please enter a new value>\n");
		int newTopSpeed = scan.nextInt();
		tempCar.setTopSpeed(newTopSpeed);
		System.out.println("The current number of seats is " + tempCar.getNumSeats() + ". Please enter a new value>\n");
		int newNumSeats = scan.nextInt();
		tempCar.setNumSeats(newNumSeats);
		System.out.println("The current fuel type is " + tempCar.getFuelType().toString().substring(0,1)+ tempCar.getFuelType().toString().substring(1).toLowerCase());
		System.out.println("Please choose the fuel type from these options:\n" + 
							"1. Diesel\n" +
							"2. Benzine\n" +
							"3. Gas\n\n");
	
		int inputFTMenu = scan.nextInt();
	
		switch(inputFTMenu)
		{
		case 1:
		{
			tempCar.setFuelType(FuelType.DIESEL);
			break;
		}
		case 2:
		{
			tempCar.setFuelType(FuelType.BENZINE);
			break;
		}
		case 3:
		{
			tempCar.setFuelType(FuelType.GAS);
			break;
		}
		default:
		{
			System.out.println("This choice does not exist. Please choose from the given options!\n");
			break;
		}
		}
		System.out.println("The current car type is " + tempCar.getCarType().toString().substring(0,1) + tempCar.getCarType().toString().substring(1).toLowerCase());
		System.out.println("Please choose the car type from these options:\n" + 
							"1. Mini\n" +
							"2. Family\n" +
							"3. Sport\n\n");

		int inputCTMenu = scan.nextInt();
	
		switch(inputCTMenu)
		{
		case 1:
		{
			tempCar.setCarType(CarType.MINI);
			break;
		}
		case 2:
		{
			tempCar.setCarType(CarType.FAMILY);
			break;
		}	
		case 3:
		{
			tempCar.setCarType(CarType.SPORT);
			break;
		}
		default:
		{
			System.out.println("This choice does not exist. Please choose from the given options!\n");
			break;
		}
		}
		System.out.println("The current price per day is " + tempCar.getPricePerDay() + ". Please enter a new value>\n");
		int newPricePerDay = scan.nextInt();
		tempCar.setPricePerDay(newPricePerDay);
		
		
	}
	
	public void deleteCar(Car car)
	{
		carCatalog.remove(car);
	}
	
	public Car searchByLicenseNumber(String licenseNumber)
	{
		int i;
		for( i = 0; i < carCatalog.size(); i++)
		{
			if (carCatalog.get(i).getLicenseNum().equalsIgnoreCase(licenseNumber))
			{
				break;
			}
		}
		return carCatalog.get(i);
	}
	
	public void displayAllCars()
	{
		System.out.println("\nAll cars :\n");
		for (int i = 0; i < carCatalog.size(); i++)
		{
			System.out.println("Car no. " + (i+1) + ":\n");
			System.out.println("License number: " + carCatalog.get(i).getLicenseNum() + "\n");
			System.out.println("Top Speed: " + carCatalog.get(i).getTopSpeed() + "\n");
			System.out.println("Number of seats: " + carCatalog.get(i).getNumSeats() + "\n");
			System.out.println("Fuel type is: " + carCatalog.get(i).getFuelType() + "\n");
			System.out.println("Car Type is: " + carCatalog.get(i).getCarType() + "\n");
			System.out.println("The price per day for this car is " + carCatalog.get(i).getPricePerDay() + "\n");
			if  (carCatalog.get(i).isAvailable())
			{
				System.out.println("This car is available for rental\n\n");
			}
			else
			{
				System.out.println("This car is NOT available for rental\n\n");
			}
		}
	}
	
	public ArrayList<Car> searchCarsForRent(CarType carType, FuelType fuelType)
	{
		List<Car> carsForRentList = new ArrayList<Car>();
		
		for (int i = 0; i < carCatalog.size(); i++)
		{
			if (carCatalog.get(i).isAvailable() && (carCatalog.get(i).getCarType().equals(carType) || carCatalog.get(i).getFuelType().equals(fuelType)))
			{
				carsForRentList.add(carCatalog.get(i));
			}
			
		}
		return (ArrayList<Car>) carsForRentList;
	}
	
	public int getCatalogSize(CarCatalog catalog)
	{
		return carCatalog.size();
	}
	
	public void saveCatalogToFile()
	{
		
	}
	
	public void loadCatalogFromFile()
	{
		
	}
	
	
	
}
