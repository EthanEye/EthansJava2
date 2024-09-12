package Cars;

public class Cars {

	public static void main(String[] args) {
	 Honda civic = new Honda("Civic", "2020", "LX", "I4");
	 Honda accord = new Honda("Accord", "2000", "EX", "V6");
	 Ford f150 = new Ford("F150", "2015", "Limited", "V8");
	 

	 System.out.println(f150.toString());
	 System.out.println(civic.toString());
	 System.out.println(civic.getEngine());
	 System.out.println(accord.toString());
	 System.out.println(accord.getEngine());
	 
	 System.out.println(civic.getTime());
	
	}
	

}
