package ProgramOne;

public class SalesTax {

	static final double EXEMPTED_RATE = 0.0;
	static final double STANDARD_RATE = 10.0;
	static final double IMPORTED_RATE = 5.0;
	static final double HUNDRED = 100.0;
	static final double TWENTY = 20.0;
	static final double ROUND_UP_FACTOR = 0.05;

	static final String IMPORTED = "imported";

	static final String[] EXEMPTED_ITEMS = { "book", "chocolate", "pill" };
	boolean IS_EXEMPTED = false;

	public SalesTax(ShoppingItem s) {
	}

	public void setRoundedUpTax(ShoppingItem s) {

		// for getting rounded "up" tax value to nearest 0.05
		Double roundedValue = Math.round((s.getTaxRate() / HUNDRED * s.getPrice()) * TWENTY) / TWENTY;
		Double unRoundedValue = ((s.getTaxRate() / HUNDRED * s.getPrice()) * TWENTY) / TWENTY;

		// rounding up by 0.05 if Math.round returns lower bound.
		if (roundedValue < unRoundedValue) {
			s.roundedUpTax = roundedValue + ROUND_UP_FACTOR;
		} else {
			s.roundedUpTax = roundedValue;
		}
	}

	public double setSalesTaxRate(String name) {

		double rate;

		for (String i : EXEMPTED_ITEMS) {
			if (name.contains(i)) {
				IS_EXEMPTED = true;
			}
		}

		if (name.contains(IMPORTED) && (IS_EXEMPTED)) {
			rate = IMPORTED_RATE;
		} else if (IS_EXEMPTED) {
			rate = EXEMPTED_RATE;
		} else if (name.contains(IMPORTED)) {
			rate = IMPORTED_RATE + STANDARD_RATE;
		} else
			rate = STANDARD_RATE;

		return rate;
	}

}
