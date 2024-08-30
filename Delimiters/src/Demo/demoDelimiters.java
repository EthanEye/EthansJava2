package Demo;

import java.util.Scanner;


public class demoDelimiters {
	public static void main(String[] args) {
		Scanner inp  = new Scanner(System.in);
//		inp.delimiter();
//		inp.useDelimiter(inp.delimiter().toString() + "|,");
//		System.out.println(inp.delimiter());
		inp.useDelimiter("\\p{javaWhitespace}+" + "|,|\n");
		//\t \n \h X + X* are meta characters
		while(inp.hasNext()) {
			
			
			int num = inp.nextInt();
			System.out.println(num);
			
		}
		
		
		return;
		
		
		
	}

}
