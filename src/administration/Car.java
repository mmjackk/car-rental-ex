package administration;

import enums.*;


public class Car 
{
	private String _licenseNum;
	private int _topSpeed;
	private int _numSeats;
	private FuelType _fuelType;
	private CarType _carType;
	private int _pricePerDay;
	private boolean _availability = true;
	

	public Car() 
	{
		
	}
	
	
	public String getLicenseNum() 
	{
		return _licenseNum;
	}
	public void setLicenseNum(String licenseNum) 
	{
		this._licenseNum = licenseNum;
	}
	
	public int getTopSpeed() 
	{
		return _topSpeed;
	}
	public void setTopSpeed(int topSpeed) 
	{
		this._topSpeed = topSpeed;
	}
	
	public int getNumSeats() 
	{
		return _numSeats;
	}
	public void setNumSeats(int numSeats) 
	{
		this._numSeats = numSeats;
	}
	
	public FuelType getFuelType() 
	{
		return _fuelType;
	}
	public void setFuelType(FuelType fuelType) 
	{
		this._fuelType = fuelType;
	}
	
	public CarType getCarType() 
	{
		return _carType;
	}
	public void setCarType(CarType carType) 
	{
		this._carType = carType;
	}
	public int getPricePerDay() 
	{
		return _pricePerDay;
	}
	public void setPricePerDay(int pricePerDay) 
	{
		this._pricePerDay = pricePerDay;
	}
	public boolean isAvailable() 
	{
		return _availability;
	}
	public void setAvailability(boolean availability) 
	{
		this._availability = availability;
	}
	
	
}

