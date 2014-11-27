package mainMenu;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import administration.*;
import carRental.*;
import enums.*;




public class Manager 
{
	
	public static void main(String[] args) 
	{
		CarCatalog catalog = new CarCatalog();
		Orders ordersList = new Orders();
		Scanner scan = new Scanner(System.in);
		
		showMainMenu();
		int mainMenuInput = scan.nextInt();
		while(mainMenuInput != 3)
		{
			switch(mainMenuInput)
			{
			case 1:
			{
				showAdminMenu();
				int adminMenuInput = scan.nextInt();
				switch(adminMenuInput)
				{
				case 1:							// case 1 admin					
				{
					Car tempCar = new Car();
					
					System.out.println("Enter the car license number>\n");
					tempCar.setLicenseNum(scan.next());
					System.out.println("What is the car top speed?>\n");
					tempCar.setTopSpeed(scan.nextInt());
					System.out.println("How many seats does this car have?>\n");
					tempCar.setNumSeats(scan.nextInt());
				
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
					}
					}
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
					System.out.println("Please enter the price per day>\n");
					int newPricePerDay = scan.nextInt();
					tempCar.setPricePerDay(newPricePerDay);
					catalog.addNewCar(tempCar);
					System.out.println("The car has been added.\n");
					mainMenuInput = 1;
					continue;
				}
				case 2:						// case 2 admin
				{
					System.out.println("Please enter the car's license number\n");
					String licenseNum = scan.next();
					catalog.updateCarbyLicenseNumber(licenseNum);
					System.out.println("The car has been updated!\n");
					mainMenuInput = 1;
					continue;
				}
				case 3:								//case 3 admin
				{
					System.out.println("Use with caution! Please enter the car's license number");
					String licenseNum = scan.next();
					catalog.deleteCar(catalog.searchByLicenseNumber(licenseNum));
					System.out.println("The car has been deleted.");
					mainMenuInput = 1;
					continue;
				}
				case 4:								//case 4 admin
				{
					catalog.displayAllCars();
					mainMenuInput = 1;
					continue;
				}
				case 5:								//case 5 admin
				{
					break;
				}
				default:
				{
					System.out.println("This choice does not exist. Please choose from the given options!\n");
					break;
				}
				}
			showMainMenu();	
			mainMenuInput = scan.nextInt();
			continue;		
			}
			case 2:
			{
				showRentalMenu();
				int rentalInput = scan.nextInt();
				List<Car> rentalList = new ArrayList<Car>();
				
				switch(rentalInput)
				{
				case 1:											//case 1 rental
				{
					System.out.println("What type of car do you prefer?\n");
					System.out.println("Please choose the car type from these options:\n" +
										"1. Mini\n" +
										"2. Family\n" +
										"3. Sport\n" +
										"4. No preference\n\n");
					int inputCTMenu = scan.nextInt();
					CarType chosenCarType = null;
					FuelType chosenFuelType = null;
				
					switch(inputCTMenu)
					{
					case 1:
					{
						chosenCarType = CarType.MINI;
						break;
					}
					case 2:
					{
						chosenCarType = CarType.FAMILY;
						break;
					}
					case 3:
					{
						chosenCarType = CarType.SPORT;
						break;
					}
					case 4:
					{
						break;
					}
					default:
					{
						System.out.println("This choice does not exist. Please choose from the given options!\n");
					}
					}
				
					System.out.println("What fuel type do you prefer?\n");
					System.out.println("Please choose the car type from these options:\n" +
										"1. Diesel\n" +
										"2. Benzine\n" +
										"3. Gas\n\n" +
			                       		"4. No preference\n\n");
					int inputFTMenu = scan.nextInt();
				
					switch(inputFTMenu)
					{
					case 1:
					{
						chosenFuelType = FuelType.DIESEL;
						break;
					}
					case 2:
					{
						chosenFuelType = FuelType.BENZINE;
						break;
					}
					case 3:
					{
						chosenFuelType = FuelType.GAS;
						break;
					}
					case 4:
					{
						break;
					}	
					default:
					{
						System.out.println("This choice does not exist. Please choose from the given options!\n");
					}
					}
					rentalList = catalog.searchCarsForRent(chosenCarType, chosenFuelType);
					for (int i = 0; i < rentalList.size(); i++)
					{
						System.out.println("Available cars that match your search:\n");
						System.out.println("Car no. " + (i+1) + ":\n");
						System.out.println("License number: " + rentalList.get(i).getLicenseNum() + "\n");
						System.out.println("Top Speed: " + rentalList.get(i).getTopSpeed() + "\n");
						System.out.println("Number of seats: " + rentalList.get(i).getNumSeats() + "\n");
						System.out.println("Fuel type is: " + rentalList.get(i).getFuelType() + "\n");
						System.out.println("Car Type is: " + rentalList.get(i).getCarType() + "\n");
					}
					mainMenuInput = 2;
					continue;
				}
				case 2:											//case 2 rental
				{
					Order newOrder = new Order();
					System.out.println("Please enter the requested car's license number\n");
					String availSwitcher = scan.next();
					newOrder.setLicenseNumber(availSwitcher);
					System.out.println("Please enter the requested pickup date\n");
					newOrder.setOrderDate(scan.next());
					System.out.println("How many rental days?\n");
					newOrder.setRentalDays(scan.nextInt());
					int tempPrice = catalog.searchByLicenseNumber(availSwitcher).getPricePerDay();
					newOrder.setPricePerDay(tempPrice);
					newOrder.setTotalPrice();
					ordersList.addNewOrder(newOrder);
					catalog.searchByLicenseNumber(availSwitcher).setAvailability(false);     //turn car state to unavailable
					System.out.println("Your order has been added!");
					
					mainMenuInput = 2;
					continue;
				}
				case 3:											//case 3 rental
				{
					System.out.println("Use with caution! Please enter the car's license number");
					String licenseNum = scan.next();
					ordersList.deleteOrder(ordersList.searchOrderByLicenseNumber(licenseNum));
					catalog.searchByLicenseNumber(licenseNum).setAvailability(true);		//turn car state to available
					System.out.println("The order has been deleted.");
					mainMenuInput = 2;
					continue;
				}
				case 4:											//case 4 rental
				{
					ordersList.displayAllOrders();
					mainMenuInput = 2;
					continue;
				}
				case 5:											//case 5 rental
				{
					break;
				}
				default :
				{
					System.out.println("This choice does not exist. Please choose from the given options!\n");
				}
				}
				showMainMenu();	
				mainMenuInput = scan.nextInt();
				continue;
			}
		}	
		}
		scan.close();
	}
	
	public static void showMainMenu()
	{
		System.out.println("\nMain Menu\n" +
				"1. Administration\n" +
				"2. Car Rental\n" +
				"3. Exit\n");
	}
	
	public static void showAdminMenu()
	{
		System.out.println("\nAdministration Menu\n" +
				"1. Add a new car to the catalog\n" +
				"2. Update an existing car data\n" +
				"3. Delete a car from the catalog\n" +
				"4. Display all cars in the catalog\n"+
				"5. Back to main menu\n");
	}
	
	public static void showRentalMenu()
	{
		System.out.println("\nRental Menu\n" +
				"Please choose from the options below\n\n" +
				"1. Find available cars\n" +
				"2. Make an order\n" +
				"3. Delete an order (early return)]\n" +
				"4. Display all existing orders\n" +
				"5. Back to main menu\n");
	}
	
	
}
		
			
			
			

	
	