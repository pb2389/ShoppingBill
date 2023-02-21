
package ProgramOne;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProgramOne {

	public static void main(String[] args) throws IOException {

		ArrayList<ShoppingItem> itemList = new ArrayList<ShoppingItem>(UserInput.getUserInput());
		DisplayList d = new DisplayList();
		d.ShowList(itemList);
	}
}