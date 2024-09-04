package Classes;

public class Circle {
	private double radius;
	
	

	public Circle(double radius) {
		this.radius = radius;
	}
	
	public Circle() {
		this.radius = 1.0;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "Circle radius = " + radius;
	}
	
	

}
