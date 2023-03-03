package ProgramOne;

public class SplitUserInput implements UserInputConstants {

	ValidateItem i;

	public SplitUserInput(ShoppingCart c, String s) {

		if (s == END) {
			c.ended = true;
		} else {

			try {
				String[] inputArray1 = s.split(SPACE, IN_TWO_PARTS);
				String[] inputArray2 = inputArray1[1].split(AT, IN_TWO_PARTS);

				i = new ValidateItem(inputArray1[0], inputArray2[0], inputArray2[1]);

			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(INCORRECT_NAME_FORMAT);
			}
		}
	}

	public ValidateItem getItemForValidation() {
		return this.i;
	}
}
