package ProgramOne;

public class ShoppingItem {

	int quantity;
	String itemName;
	double price;
	double taxRate;
	double itemTotal;
	double roundedUpTax;

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
