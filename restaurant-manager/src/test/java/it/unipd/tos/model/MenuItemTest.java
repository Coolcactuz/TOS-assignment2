////////////////////////////////////////////////////////////////////
// [Luca] [Stocco] [1125280]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class MenuItemTest {

	@Test
	public void getPriceTest() {
		MenuItem example = new MenuItem(typeItem.PIZZA, "Margherita", 5.50);
		assertEquals(5.50, example.getPrice(), 0);
	}
	
	@Test
	public void getItemTypeExample() {
		MenuItem example = new MenuItem(typeItem.PIZZA, "Margherita", 5.50);
		assertEquals(typeItem.PIZZA, example.getItemType());
	}

}
