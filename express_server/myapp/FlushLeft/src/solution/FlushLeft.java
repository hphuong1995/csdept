import java.util.Scanner;

public class FlushLeft {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("Enter the text to justify: ");
		String text = scan.nextLine();

		System.out.print("Enter the output column width in terms of number of characters: ");
		int width = scan.nextInt();

		System.out.println();
		
		while (text.length() > 0) {

			if (text.length() > width) {
				String temp = text.substring(0, width + 1);
				text = text.substring(width + 1);
				
				int lastSpace;
				boolean spaceFound = false;
				
				for (lastSpace = temp.length() - 1; lastSpace >= 0 && !spaceFound; lastSpace--) {
					if (temp.charAt(lastSpace) == ' ') {
						spaceFound = true;
						lastSpace++;
					}
				}

				String toPrint = temp.substring(0, lastSpace);
				text = temp.substring(lastSpace+1) + text;

				System.out.println(toPrint);
			} else { // if we're at the end of the text to print
				System.out.println(text);
				text = "";
			}

		}
		
		scan.close();

	}

}
