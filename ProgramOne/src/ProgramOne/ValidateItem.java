package ProgramOne;

public class ValidateItem implements ValidationConstants {

	String givenQuantity;
	String givenName;
	String givenPrice;

	public ValidateItem(String q, String n, String p) {
		this.givenQuantity = q;
		this.givenName = n;
		this.givenPrice = p;
	}

	public ShoppingItem validate() {

		ShoppingItem s = new ShoppingItem();
		try {
			s.setQuantity(Integer.parseInt(givenQuantity));
			if (s.getQuantity() < MINIMUM_QUANTITY) {
				System.out.println(INCORRECT_QUANTITY);
			}

			s.setPrice(Float.parseFloat(givenPrice));
			if (s.getPrice() <= MINIMUM_PRICE) {
				System.out.println(INCORRECT_PRICE);
			}

		} catch (NumberFormatException n) {
			System.out.println(INCORRECT_NUMBER_FORMAT);
		}
		s.setName(givenName);
		return s;
	}
}