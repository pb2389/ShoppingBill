package ProgramOne;

public interface TaxBrackets {

	static final double EXEMPTED_RATE = 0.0;
	static final double STANDARD_RATE = 10.0;
	static final double IMPORTED_RATE = 5.0;
	static final String[] EXEMPTED_ITEMS = { "book", "chocolate", "pill" };
	static final String IMPORTED = "imported";

	public static double setSalesTaxRate(String name) {

		double rate;
		boolean isTaxExempt = false;

		for (String i : EXEMPTED_ITEMS) {
			if (name.contains(i)) {
				isTaxExempt = true;
			}
		}

		if (name.contains(IMPORTED) && (isTaxExempt)) {
			rate = IMPORTED_RATE;
		} else if (isTaxExempt) {
			rate = EXEMPTED_RATE;
		} else if (name.contains(IMPORTED)) {
			rate = IMPORTED_RATE + STANDARD_RATE;
		} else
			rate = STANDARD_RATE;

		return rate;
	}

}