package ProgramOne;

public class ShoppingItem {

	int quantity;
	String itemName;
	double price;
	double taxRate;
	double itemTotal;

	static final double EXEMPTED_RATE = 0.0;
	static final double STANDARD_RATE = 10.0;
	static final double IMPORTED_RATE = 5.0;

	double getSalesTaxRate(String itemName) {

		this.itemName = itemName;

		if (itemName.contains("imported")
				&& (itemName.contains("book") || itemName.contains("chocolate") || itemName.contains("pill"))) {
			taxRate = IMPORTED_RATE;
		} else if (itemName.contains("book") || itemName.contains("chocolate") || itemName.contains("pill")) {
			taxRate = EXEMPTED_RATE;
		} else if (itemName.contains("imported")) {
			taxRate = IMPORTED_RATE + STANDARD_RATE;
		} else
			taxRate = STANDARD_RATE;
		return taxRate;
	}

	public ShoppingItem() {
	} // constructor

	public int getQuantity() {
		return this.quantity;
	}

	public String getName() {
		return this.itemName;
	}

	public double getPrice() {
		return this.price;
	}

	public double getTaxRate() {
		return this.taxRate;
	}

	public double getItemTotal() {
		return this.itemTotal;
	}

	public double getRoundedUpTax() {

		// for getting rounded "up" tax value to nearest 0.05

		Double roundedValue = Math.round((getTaxRate() / 100 * getPrice()) * 20) / 20.0;
		Double unRoundedValue = ((getTaxRate() / 100 * getPrice()) * 20) / 20.0;
		if (roundedValue < unRoundedValue) {
			return roundedValue + 0.05;
		} else
			return roundedValue;
	}

}
