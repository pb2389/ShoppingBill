
package ProgramOne;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProgramOne {

	public static void main(String[] args) throws IOException {
		
		boolean isRunning = true;
		double billTax=0.0, billTotal = 0.0;
		ArrayList<ShoppingItem> itemList = new ArrayList<ShoppingItem>();

		Scanner sc = new Scanner(System.in);

		System.out.println(
				"Please enter shopping items in \"Quantity Name at Price\" format. "
				+ "For example, type \"1 Book at 12.49\" if you want to purchase 1 book"
				+ " at the price of 12.49 per book.\r"
				+ "Press ENTER after each item entry to add the next item. "
				+ "Type END or press Enter again when finished.\n");

		while (isRunning) {
			String userInput = sc.nextLine();

			if (userInput.equals("END") || userInput.equals("")) {
				break;
			}
			
			// splitting the user input string to extract quantity, name and price of the shopping item.
			String[] inputArray1 = userInput.split(" ", 2);
			String[] inputArray2 = inputArray1[1].split("at ", 2);
			
			ShoppingItem item = new ShoppingItem();
			
			try {
				
				try {
					item.quantity = Integer.parseInt(inputArray1[0]);
					if(item.quantity<1) {
						System.out.println("Incorrect Quantity or Price input format, please enter the item again.");
						continue;
						}
					
					item.price = Float.parseFloat(inputArray2[1]);
					if(item.price<0) {
						System.out.println("Incorrect Quantity or Price input format, please enter the item again.");
						continue;
						}
					
				} catch (NumberFormatException n) {
					System.out.println("Incorrect Quantity or Price input format, please enter the item again.");
					continue;
				}
				
				item.itemName = (inputArray2[0]);
				item.taxRate = item.getSalesTaxRate(item.itemName);
				
				double roundedUpTax  = item.getRoundedUpTax();	
				item.itemTotal = (item.quantity)*(item.price)+ roundedUpTax;
				
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Incorrect Name or text input format, please enter the item again.");
				continue;
			}
			
			itemList.add(item);
			
			// We may add the below mentioned comment if needed for affirmation of correct entry.
			// System.out.println("Item added correctly, please enter the next one.");
		}

		sc.close();

		if (itemList.size()!=0) {
			System.out.println("Your shopping bill is:");
		}
		
		for (ShoppingItem i : itemList) {
			System.out.println(i.getQuantity() + " " + i.getName() +
					": " +  String.format("%.2f",i.getItemTotal()));
			
			billTax += i.getRoundedUpTax(); 
			billTotal += i.getItemTotal();	
		}
		
		if (itemList.size()!=0) {
		System.out.println("Sales Taxes: " + String.format("%.2f",billTax));
		System.out.println("Total: " + String.format("%.2f",billTotal));
		}
		
		if (itemList.size()==0) {
			System.out.println("You have not entered any item. Thanks for visiting us!");
		}
	}
}