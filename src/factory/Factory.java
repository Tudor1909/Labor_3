package factory;

import product.Product;

import java.util.*;

public class Factory
{
	private List<Product> productList = new ArrayList<>();
	private List<Product> stagnation = new ArrayList<>();
	private List<Product> rise = new ArrayList<>();
	private List<Product> fall = new ArrayList<>();
	
	public List<Product> getProductList()
	{
		return productList;
	}
	
	public List<Product> getStagnation()
	{
		return stagnation;
	}
	
	public List<Product> getRise()
	{
		return rise;
	}
	
	public List<Product> getFall()
	{
		return fall;
	}
	
	public void sortByDemand()
	{
		productList.sort(Comparator.comparing(Product::getDemandValue));
	}
	
	public void orderCategory()
	{
		for (Product product : productList)
			switch (product.getDemand()) {
				case "Rising" -> rise.add(product);
				case "Falling" -> fall.add(product);
				default -> stagnation.add(product);
			}
	}
	
	public Dictionary<Product, Integer> calculateOptimalProduction()
	{
		Dictionary<Product, Integer> recalculated = new Hashtable<>();
		for (Product product : rise)
			recalculated.put(product, (int) Math.ceil(1.5 * (double) product.getSecondYearQuantity()));
		for (Product product : fall)
			recalculated.put(product, (int) Math.ceil(0.9 * (double) product.getSecondYearQuantity()));
		for (Product product : stagnation)
			recalculated.put(product, (int) Math.ceil(1.1 * (double) product.getSecondYearQuantity()));
		return recalculated;
	}
	
	public void add(Product product)
	{
		productList.add(product);
	}
}
