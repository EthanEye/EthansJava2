package Cars;

import java.time.LocalDateTime;

public class Car {
	private String make;
	private String model;
	private String year;
	private String subModel;
	private String engine;
	private LocalDateTime time;
	
	
	public Car(String make, String model, String year, String subModel, String engine) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.subModel = subModel;
		this.engine = engine;
		this.time = LocalDateTime.now();
	}
	
	
	
	public LocalDateTime getTime() {
		return time;
	}




	public void setTime(LocalDateTime time) {
		this.time = time;
	}




	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public String getSubModel() {
		return subModel;
	}


	public void setSubModel(String subModel) {
		this.subModel = subModel;
	}


	public String getEngine() {
		return engine;
	}


	public void setEngine(String engine) {
		this.engine = engine;
	}


	@Override
	public String toString() {
		return "Car [make=" + make + ", model=" + model + ", year=" + year + ", subModel=" + subModel + ", engine="
				+ engine + "]";
	}
	
	
	
	

}
