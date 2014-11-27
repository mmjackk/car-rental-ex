package carRental;

import java.util.ArrayList;
import java.util.List;

public class Orders 
{
	List<Order> allOrders = new ArrayList<Order>();
	
	public Orders()
	{
		
	}
	
	public void addNewOrder(Order order)
	{
		allOrders.add(order);
	}
	
	public void deleteOrder(Order order)
	{
		allOrders.remove(order);      
	}
	
	public Order searchOrderByLicenseNumber(String licenseNum)
	{
		int i;
		for ( i = 0; i < allOrders.size(); i++)
		{
			if (allOrders.get(i).getLicenseNumber().equals(licenseNum))
			{
				
				break;
			}
			
		}
		return allOrders.get(i);
		
	}
	
	public void displayAllOrders()
	{
		System.out.println("\nAll orders :\n\n");
		for (int i = 0; i < allOrders.size(); i++)
		{
			System.out.println("Order no. " + (i+1) + ":\n");
			System.out.println("Car license number: " + allOrders.get(i).getLicenseNumber() + "\n");
			System.out.println("Order date: " + allOrders.get(i).getOrderDate() + "\n");
			System.out.println("Number of rental days: " + allOrders.get(i).getRentalDays() + "\n");
			System.out.println("The price per day is: " + allOrders.get(i).getPricePerDay() + "\n");
			System.out.println("The total price is: " + allOrders.get(i).getTotalPrice() + "\n\n");
		}
	}
	
	public void saveOrdersToFile()
	{
		
	}
	
	public void loadOrdersFromFile()
	{
		
	}
}
