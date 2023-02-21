package ProgramOne;

public class ShoppingItem {

	int quantity;
	String itemName;
	double price;
	double taxRate;
	double itemTotal;
	double roundedUpTax;

	static final double EXEMPTED_RATE = 0.0;
	static final double STANDARD_RATE = 10.0;
	static final double IMPORTED_RATE = 5.0;

	static final String IMPORTED = "imported";

	static final String[] EXEMPTED_ITEMS = { "book", "chocolate", "pill" };
	static boolean IS_EXEMPTED;

	public ShoppingItem() {
	}

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

	public void setName(String itemName) {
		this.itemName = itemName;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
