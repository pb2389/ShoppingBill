package ProgramOne;

import java.util.ArrayList;

public class ShoppingCart implements ConsoleConstants, DisplayBill {

	ArrayList<ShoppingItem> itemList;
	double billTaxTotal, billTotal;
	boolean ended = false;

	public ShoppingCart() {
		System.out.println(PROMPT_USER);
		itemList = new ArrayList<ShoppingItem>();
	}

	public void addItem(ShoppingItem i) {
		if (i.getQuantity() > ZERO && i.getPrice() > ZERO) {
			this.itemList.add(i);
		}
	}

//	public void displayBill() {
//		if (this.itemList.size() != 0) {
//			System.out.println("Your shopping bill is:");
//
//			for (ShoppingItem i : itemList) {
//				System.out.println(i.getQuantity() + " " + i.getName() + ": " + String.format("%.2f", i.getItemTotal()));
//
//				billTaxTotal += i.roundedUpTax;
//				billTotal += i.getItemTotal();
//			}
//
//			System.out.println("Sales Taxes: " + String.format("%.2f", billTaxTotal));
//			System.out.println("Total: " + String.format("%.2f", billTotal));
//		} else {
//			System.out.println(NO_ITEM);
//		}
//	}
}