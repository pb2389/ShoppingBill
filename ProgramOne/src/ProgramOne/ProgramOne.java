
package ProgramOne;

import java.io.IOException;

public class ProgramOne implements ConsoleConstants, TaxBrackets, RoundUpTaxes {

	public static void main(String[] args) throws IOException {

		ShoppingCart cart = new ShoppingCart();

		do {
			try {
				SplitUserInput input = new SplitUserInput(cart, ScanUserInput.scanInput());
				ValidateItem givenInput = input.getItemForValidation();
				ShoppingItem item = givenInput.validate();

				item.setTaxRate();
				item.setItemTotal();

				cart.addItem(item);

			} catch (NullPointerException n) {
				continue;
			}
		} while (cart.ended == false);

		DisplayBill.showBill(cart);
	}
}