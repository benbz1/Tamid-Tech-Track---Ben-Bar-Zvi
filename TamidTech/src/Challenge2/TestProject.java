package Challenge2;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestProject {

	@Test
	void tesCustomer() {
		Customer ben = new Customer("BEN", 19, 300);

		assertEquals(ben.purchase(20), true);
		assertEquals(ben.getMoney() == 280, true);
		assertEquals(ben.purchase(2000), false);
		assertEquals(ben.getAge(), 19);
		assertEquals(ben.getName(), "BEN");

	}

	@Test
	void tesDriver() {
		Driver ben = new Driver("BEN", 19, "Employed", 20, true);
		assertEquals(ben.getName(), "BEN");
	}

	@Test
	void testIceCream() {
		IceCream vanilla = new IceCream("Vanilla", 3, 30, 3);
		assertEquals(vanilla.getName(), "Vanilla");

		assertEquals(vanilla.sellScoop(), true);
		assertEquals(vanilla.getScoops(), 2);
		assertEquals(vanilla.sellScoop(), true);
		assertEquals(vanilla.getScoops(), 1);
		assertEquals(vanilla.sellScoop(), true);
		assertEquals(vanilla.getScoops(), 0);
		assertEquals(vanilla.sellScoop(), false);

		vanilla.addStock(new IceCream("Vanilla", 3, 30, 3));
		assertEquals(vanilla.getScoops(), 3);
		assertEquals(vanilla.getCost() == 60, true);

	}

	@Test
	void testTruckWorker() {
		TruckWorker worker = new TruckWorker("BEN", 19, "Employed",20, true);
		assertEquals(worker.getName(),"BEN");
	}
}
