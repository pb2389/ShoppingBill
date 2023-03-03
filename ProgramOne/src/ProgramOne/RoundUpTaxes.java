package ProgramOne;

public interface RoundUpTaxes {

	static final double HUNDRED = 100.0;
	static final double TWENTY = 20.0;
	static final double ROUND_UP_FACTOR = 0.05;

	static double setRoundedUpTax(ShoppingItem s) {

		// for getting rounded "up" tax value to nearest 0.05
		Double roundedValue = Math.round((s.getTaxRate() / HUNDRED * s.getPrice() * s.getQuantity()) * TWENTY) / TWENTY;
		Double unRoundedValue = ((s.getTaxRate() / HUNDRED * s.getPrice() * s.getQuantity()) * TWENTY) / TWENTY;

		// rounding up by 0.05 if Math.round returns lower bound.
		if (roundedValue < unRoundedValue) {
			return s.roundedUpTax = roundedValue + ROUND_UP_FACTOR;
		} else {
			return s.roundedUpTax = roundedValue;
		}
	}
}
