public class Java2 {
	
	public static void main(String[] args) {
		new B();
	}
}

class A{
	int i = 7;
	public A() {
		setI(20);
		System.out.println("I is " + i);
	}
	
	public void setI(int i) {
		this.i = 2 * i;
	}
}

class B extends A{
	public B() {
		
		
	}
	
	@Override
	public void setI(int i) {
		this.i = 3 * i;
	}
}

