/**
 * This program will take in text and a column width measured in characters, then ﬂush text to
 * the left and leave the right side of the text ragged (i.e., uneven) according to the column
 * width. Note that there will never be a leading space (i.e., a line will never start with a
 * space).
 */
import java.util.Scanner;
public class FlushLeft {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String text;
		int column;
		int userInput;
		int i=0;
		
		System.out.print("Enter the text to justify: ");
		text = scan.nextLine();
		System.out.print("Enter the output column width in terms of number of characters: ");
		userInput = scan.nextInt();
		System.out.println("");
		
		String text1;
		
		
		while(i <= text.length()) {
			for(int col =0; col <= userInput; col++) {
				if(col==userInput) {
					  System.out.println(text.charAt(col));
				}else {
					System.out.print(text.charAt(col));
				}
				

			}
			text = text.substring(text.indexOf(' ')+1, text.length());
			i++;
		}

	}
}