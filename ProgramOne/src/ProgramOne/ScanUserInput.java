package ProgramOne;

import java.util.Scanner;

public abstract class ScanUserInput implements UserInputConstants {

	static Scanner scan = new Scanner(System.in);

	static public String scanInput() {
		String userInput = scan.nextLine();
		if (userInput.equals(END) || userInput.equals(RETURN)) {
			return END;
		} else {
			return (userInput);
		}
	}
}