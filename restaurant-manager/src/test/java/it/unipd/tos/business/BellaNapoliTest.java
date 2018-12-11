////////////////////////////////////////////////////////////////////
// [Luca] [Stocco] [1125280]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import static org.junit.Assert.*;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.typeItem;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BellaNapoliTest {
	
	private RestaurantBill restaurant;
	
	@Before
	public void initialized() {
		restaurant = new BellaNapoli();
	}
	
	/*
	 * Insieme che supera i 20 ordini. Gli ordini sono 23
	 */
	public List<MenuItem> orderWithError() {
		return Arrays.asList(new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5)
				);
	}
	
	/*
	 * Ordine per contare il numero di pizze.
	 * Inoltre serve per rimuovere la pizza meno costosa.
	 * Le pizze sono 11 e gli ordini totali 16
	 */
	public static List<MenuItem> orderToCountPizzas() {
		return Arrays.asList(new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PRIMI, "Spaghetti", 7.5),
				new MenuItem(typeItem.PRIMI, "Spaghetti", 7.5),
				new MenuItem(typeItem.PRIMI, "Spaghetti", 7.5),
				new MenuItem(typeItem.PRIMI, "Spaghetti", 7.5),
				new MenuItem(typeItem.PRIMI, "Spaghetti", 7.5)
				);
	}
	
	/*
	 * Ordine che supera i 100 euro per ottenere il 5% di sconto
	 */
	public static List<MenuItem> orderToHaveDiscount() {
		return Arrays.asList(new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PRIMI, "Spaghetti", 10.5),
				new MenuItem(typeItem.PRIMI, "Spaghetti", 10.5),
				new MenuItem(typeItem.PRIMI, "Spaghetti", 10.5),
				new MenuItem(typeItem.PRIMI, "Spaghetti", 10.5),
				new MenuItem(typeItem.PRIMI, "Spaghetti", 10.5),
				new MenuItem(typeItem.PRIMI, "Spaghetti", 10.5)
				);
	}
	
	/*
	 * Ordine per superare i 100 euro e superare le 10 pizze
	 */
	public static List<MenuItem> orderToRemovePizzaAndDiscount() {
		return Arrays.asList(new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PRIMI, "Spaghetti", 10.5),
				new MenuItem(typeItem.PRIMI, "Spaghetti", 10.5),
				new MenuItem(typeItem.PRIMI, "Spaghetti", 10.5),
				new MenuItem(typeItem.PRIMI, "Spaghetti", 10.5),
				new MenuItem(typeItem.PRIMI, "Spaghetti", 10.5)
				);
	}
	
	@Test(expected = RestaurantBillException.class)
	public void exeptionTest() throws RestaurantBillException {
		restaurant.getOrderPrice(orderWithError());
	}
	
	@Test
	public void getNumPizzaTest() {
		BellaNapoli test = new BellaNapoli();
		assertEquals(11, test.getNumPizza(orderToCountPizzas()));
	}
	
	@Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] {{orderToCountPizzas(), 92.5},
				{orderToHaveDiscount(), 96.425},
				{orderToRemovePizzaAndDiscount(), 102.125}
				});
	}
	
	
	private List<MenuItem> input;
	private double expectedOutput;
	
	public BellaNapoliTest(List<MenuItem> input, double expectedOutput) {
		this.input = input;
		this.expectedOutput = expectedOutput;
	}
	
	@Test
	public void getOrderPriceTest() throws RestaurantBillException {
		assertEquals(expectedOutput, restaurant.getOrderPrice(input), 0);
	}
}
