package ProgramOne;

import java.util.Scanner;
import java.util.ArrayList;

public class UserInput {

	static ArrayList<ShoppingItem> itemList = new ArrayList<ShoppingItem>();

	static Scanner scan = new Scanner(System.in);
	static boolean isRunning = true;
	static final int MINIMUM_QUANTITY = 1;
	static final int MINIMUM_PRICE = 0;
	static final int IN_TWO_PARTS = 2;
	static final String END = "END";
	static final String RETURN = "";
	static final String AT = "at ";
	static final String SPACE = " ";
	static final String INCORRECT_QUANTITY = "Item quantity cannot be less than 1. Please enter the item again.";
	static final String INCORRECT_PRICE = "Item price cannot be less than 0. Please enter the item again.";
	static final String INCORRECT_NUMBER_FORMAT = "Incorrect Quantity or Price input format, please enter the item again.";

	static final String PROMPT_USER = "Please enter shopping items in \"Quantity Name at Price\" format. "
			+ "For example, type \"1 Book at 12.49\" if you want to purchase 1 book"
			+ " at the price of 12.49 per book.\r" + "Press ENTER after each item entry to add the next item. "
			+ "Type END or press Enter again when finished.\n";

	public static ArrayList<ShoppingItem> getUserInput() {

		System.out.println(UserInput.PROMPT_USER);

		while (isRunning) {
			ShoppingItem item = new ShoppingItem();
			String userInput = scan.nextLine();

			if (userInput.equals(END) || userInput.equals(RETURN)) {
				break;
			}

			String[] inputArray1 = userInput.split(SPACE, IN_TWO_PARTS);
			String[] inputArray2 = inputArray1[1].split(AT, IN_TWO_PARTS);

			try {

				try {
					item.setQuantity(Integer.parseInt(inputArray1[0]));
					if (item.quantity < MINIMUM_QUANTITY) {
						System.out.println(INCORRECT_QUANTITY);
						continue;
					}

					item.setPrice(Float.parseFloat(inputArray2[1]));
					if (item.price < MINIMUM_PRICE) {
						System.out.println(INCORRECT_PRICE);
						continue;
					}

				} catch (NumberFormatException n) {
					System.out.println(INCORRECT_NUMBER_FORMAT);
					continue;
				}

				item.setName(inputArray2[0]);
				SalesTax s = new SalesTax(item);
				item.taxRate = s.setSalesTaxRate(item.itemName);
				s.setRoundedUpTax(item);
				item.itemTotal = (item.quantity) * (item.price) + item.roundedUpTax;

			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Incorrect Name or text input format, please enter the item again.");
				continue;
			}

			itemList.add(item);
		}

		scan.close();

		return itemList;
	}

}