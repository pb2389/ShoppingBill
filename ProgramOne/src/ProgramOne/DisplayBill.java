package ProgramOne;

public interface DisplayBill {

	static final String NO_ITEM = "You have not entered any item. Thanks for visiting us.";

	public static void showBill(ShoppingCart c) {

		if (c.itemList.size() != 0) {
			System.out.println("Your shopping bill is:");

			for (ShoppingItem i : c.itemList) {
				System.out
						.println(i.getQuantity() + " " + i.getName() + ": " + String.format("%.2f", i.getItemTotal()));

				c.billTaxTotal += i.roundedUpTax;
				c.billTotal += i.getItemTotal();
			}

			System.out.println("Sales Taxes: " + String.format("%.2f", c.billTaxTotal));
			System.out.println("Total: " + String.format("%.2f", c.billTotal));
		} else {
			System.out.println(NO_ITEM);
		}
	}
}
