package edu.frontrange.csc1061.a5;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

/**
 *
 * @author bobgils
 */
public class StringConverterTest {
    public static void main(String[] args)throws Exception{
        
        File numFile = new File("NumberStrings.txt");
        Scanner inp = new Scanner(numFile);
        PrintWriter outp = new PrintWriter("NumberStringsConverted.txt");
        int ival;
        
        String numString;
        while (inp.hasNext()){
            numString = inp.next();
            try{
            
                ival = StringConverter.convert(numString);
                outp.printf("Value of \"%s\" is %d %n", numString, ival);
            }
            catch (RuntimeException ex){
                outp.println(ex.getMessage());
            }            
        }
        
        outp.print("test");
        outp.close();
      
    }
     
    public class StringConverter{
    	
    	   public static int convert(String numString) {
    	      
    	        if (numString.length() == 0) return 0;
    	        
    	        
    	        int firstDigit = numString.charAt(0) - '0';
    	        
    	        System.out.println(firstDigit * (int) Math.pow(10, numString.length() - 1));
    	        // We multiply the first digit by 10^(length - 1) to place it correctly
    	        return firstDigit * (int) Math.pow(10, numString.length() - 1) 
    	                + convert(numString.substring(1));
    	    }

	    }
	
	    
}


