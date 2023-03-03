package ProgramOne;

public class ShoppingItem implements TaxBrackets, RoundUpTaxes {

	public String itemName;
	public int quantity;
	public double price;
	public double taxRate;
	public double itemTotal;
	public double roundedUpTax;

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

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setName(String itemName) {
		this.itemName = itemName;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setTaxRate() {
		this.taxRate = TaxBrackets.setSalesTaxRate(this.itemName);
		this.roundedUpTax = RoundUpTaxes.setRoundedUpTax(this);
	}

	public void setItemTotal() {
		this.itemTotal = (this.getQuantity()) * (this.getPrice()) + this.roundedUpTax;
	}
}
