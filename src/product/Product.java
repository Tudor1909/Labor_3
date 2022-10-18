package product;


import java.util.*;

public class Product
{
	private Integer firstYear;
	private Integer secondYear;
	private Integer firstYearQuantity;
	private Integer secondYearQuantity;
	private Integer firstYearQuantitySold;
	private Integer secondYearQuantitySold;
	private String demand;
	private double demandValue;
	private Dictionary<Integer, Double> yearlyDemand = new Hashtable<>();
	
	public Product(Integer firstYear, Integer firstYearQuantity, Integer firstYearQuantitySold, Integer secondYear, Integer secondYearQuantity, Integer secondYearQuantitySold)
	{
		this.firstYear = firstYear;
		this.firstYearQuantity = firstYearQuantity;
		this.firstYearQuantitySold = firstYearQuantitySold;
		this.secondYear = secondYear;
		this.secondYearQuantity = secondYearQuantity;
		this.secondYearQuantitySold = secondYearQuantitySold;
		this.yearlyDemand.put(firstYear, 100 * (double) (firstYearQuantitySold) / firstYearQuantity);
		this.yearlyDemand.put(secondYear, 100 * (double) (secondYearQuantitySold) / secondYearQuantity);
		
		this.demandValue = yearlyDemand.get(secondYear) - yearlyDemand.get(firstYear);
		if (demandValue > 0 && demandValue <= 10) this.demand = "Stagnant";
		else if (demandValue < 0) {
			this.demand = "Falling";
		} else this.demand = "Rising";
	}
	
	public Integer getFirstYear()
	{
		return firstYear;
	}
	
	public void setFirstYear(Integer firstYear)
	{
		this.firstYear = firstYear;
	}
	
	public Integer getSecondYear()
	{
		return secondYear;
	}
	
	public void setSecondYear(Integer secondYear)
	{
		this.secondYear = secondYear;
	}
	
	public Integer getFirstYearQuantity()
	{
		return firstYearQuantity;
	}
	
	public void setFirstYearQuantity(Integer firstYearQuantity)
	{
		this.firstYearQuantity = firstYearQuantity;
	}
	
	public Integer getSecondYearQuantity()
	{
		return secondYearQuantity;
	}
	
	public void setSecondYearQuantity(Integer secondYearQuantity)
	{
		this.secondYearQuantity = secondYearQuantity;
	}
	
	public Integer getFirstYearQuantitySold()
	{
		return firstYearQuantitySold;
	}
	
	public void setFirstYearQuantitySold(Integer firstYearQuantitySold)
	{
		this.firstYearQuantitySold = firstYearQuantitySold;
	}
	
	public Integer getSecondYearQuantitySold()
	{
		return secondYearQuantitySold;
	}
	
	public void setSecondYearQuantitySold(Integer secondYearQuantitySold)
	{
		this.secondYearQuantitySold = secondYearQuantitySold;
	}
	
	public Dictionary<Integer, Double> getYearlyDemand()
	{
		return yearlyDemand;
	}
	
	
	public void setYearlyDemand(Dictionary<Integer, Double> yearlyDemand)
	{
		this.yearlyDemand = yearlyDemand;
	}
	
	public Double getYearlyDemandForSpecifiedYear(Integer year)
	{
		try {
			return this.yearlyDemand.get(year);
		}
		catch (Exception e) {
			System.out.println("Invalid Year Specification!");
			return (double) -1;
		}
	}
	
	public String getDemand()
	{
		return demand;
	}
	
	public double getDemandValue()
	{
		return demandValue;
	}
	
	@Override
	public String toString()
	{
		return "Product:\nFirst Year Statistic: " + firstYear + " " + firstYearQuantity + " " + firstYearQuantitySold + "\nSecond Year Statistic: " + secondYear + " " + secondYearQuantity + " " + secondYearQuantitySold + "\nDemand Value: " + demandValue + "\nDemand Label: " + demand + "\n";
	}
}
