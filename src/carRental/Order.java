package carRental;

public class Order 
{
	private String _licenseNumber;
	private String _orderDate;
	private int _rentalDays;
	private int _pricePerDay;
	private int _totalPrice =0;
	
	public Order(String licenseNumber, String orderDate, int rentalDays, int pricePerDay)
	{
		this._licenseNumber = licenseNumber;
		this._orderDate = orderDate;
		this._rentalDays = rentalDays;
		this._pricePerDay = pricePerDay;
		this._totalPrice = rentalDays * pricePerDay;
	}
	public Order()   //needed or not?
	{
		
	}
	
	
	public String getLicenseNumber() 
	{
		return _licenseNumber;
	}
	public void setLicenseNumber(String _licenseNumber) 
	{
		this._licenseNumber = _licenseNumber;
	}
	
	public String getOrderDate() 
	{
		return _orderDate;
	}
	
	public void setOrderDate(String _orderDate) 
	{
		this._orderDate = _orderDate;
	}
	
	public int getRentalDays() 
	{
		return _rentalDays;
	}
	public void setRentalDays(int _rentalDays) 
	{
		this._rentalDays = _rentalDays;
	}
	
	public int getPricePerDay() 
	{
		return _pricePerDay;
	}
	public void setPricePerDay(int pricePerDay) 
	{
		this._pricePerDay = pricePerDay;
	}
	
	public int getTotalPrice() 
	{
		return _totalPrice;
	}
	public void setTotalPrice()
	{
		this._totalPrice = _pricePerDay * _rentalDays;
	}
	public int calculatePrice() 
	{
		int calcPrice;
		calcPrice = _pricePerDay * _rentalDays;
		return calcPrice;
	}
	
	
}
