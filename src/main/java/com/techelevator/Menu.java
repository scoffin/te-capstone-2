package com.techelevator;

	import java.io.InputStream;
	import java.io.OutputStream;
	import java.io.PrintWriter;
	import java.util.Scanner;

	public class Menu {

		private PrintWriter out;
		private Scanner in;

		public Menu(InputStream input, OutputStream output) {
			this.out = new PrintWriter(output);
			this.in = new Scanner(input);
		}
		
		public Menu() {
			
		}

		public Object getChoiceFromOptions(Object[] options) {
			Object choice = null;
			while(choice == null) {
				displayMenuOptions(options);
				choice = getChoiceFromUserInput(options);
			}
			return choice;
		}

		private Object getChoiceFromUserInput(Object[] options) {
			Object choice = null;
			String userInput = in.nextLine();
			try {
				int selectedOption = Integer.valueOf(userInput);
				if(selectedOption <= options.length) {
					choice = options[selectedOption - 1];
				}
			} catch(NumberFormatException e) {
				// eat the exception, an error message will be displayed below since choice will be null
			}
			if(choice == null) {
				out.println("\n*** Your request search, " + userInput + ", is not a valid option. Please try again. ***\n");
			}
			return choice;
		}

		private void displayMenuOptions(Object[] options) {
			out.println();
			for(int i = 0; i < options.length; i++) {
				int optionNum = i+1;
				out.println("➩ " + optionNum + ") "+options[i]);
			}
			out.print("\nSELECT a menu option: ");
			out.flush();
		}

	

	
	

}

