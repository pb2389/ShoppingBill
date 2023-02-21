package ProgramOne;

import java.util.ArrayList;

public class DisplayList {

	double billTax = 0.0, billTotal = 0.0;

	public DisplayList() {
	}

	public void ShowList(ArrayList<ShoppingItem> itemList) {
		if (itemList.size() != 0) {
			System.out.println("Your shopping bill is:");

			for (ShoppingItem i : itemList) {
				System.out
						.println(i.getQuantity() + " " + i.getName() + ": " + String.format("%.2f", i.getItemTotal()));

				billTax += i.roundedUpTax;
				billTotal += i.getItemTotal();
			}

			System.out.println("Sales Taxes: " + String.format("%.2f", billTax));
			System.out.println("Total: " + String.format("%.2f", billTotal));
		} else {
			System.out.println("You have not entered any item. Thanks for visiting us!");
		}

	}
}
