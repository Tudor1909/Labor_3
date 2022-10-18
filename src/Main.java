import factory.Factory;
import product.Product;

import java.util.Dictionary;

public class Main
{
	public static void main(String[] args)
	{
		Product product = new Product(2019, 200, 100, 2020, 200, 150);
		Product product1 = new Product(2019, 100, 100, 2020, 200, 150);
		Product product2 = new Product(2019, 100, 50, 2020, 100, 60);
		
		System.out.println(product.getDemand());
		System.out.println(product1.getDemand());
		System.out.println(product2.getDemand());
		
		Factory factory = new Factory();
		
		factory.add(product);
		factory.add(product1);
		factory.add(product2);
		
		factory.orderCategory();
		
		factory.sortByDemand();
		
		System.out.println("\n");
		
		for (Product product3 : factory.getProductList())
			System.out.println(product3.toString());
		
		Dictionary<Product, Integer> results = factory.calculateOptimalProduction();
		System.out.println(results.toString());
	}
}