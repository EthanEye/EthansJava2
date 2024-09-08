package People;

import static java.lang.System.out;

/**
 * Person class, to meet the requirements stated in the Assignment
 Instructions for Assignment.
 * <p>
 * The following UML is given for this class: </p>
 * <p>
 * <strong><u>Person</u> <br>
 * - firstNameField: String <br>
 * - lastNameField: String <br>
 * - ageField: double <br>
 * <br>
 * +&lt;constructor&gt; Person(firstName: String, lastName: String,
 initialAge: double) <br>
 * + setFirst(firstName: String) <br>
 * + setLast(lastName: String) <br>
 * + setAge(): String <br>
 * + getFirst(): String <br>
 * + getLast(): String <br>
 * * + getAge(): String <br>
 * + displayValues() <br>
 * + toString() : String </strong></p>
 *
 */
public class Person
{
/**
 * Default value for invalid names.
 */
private static final String DEFAULT_NAME = null;

/**
 * Default value for invalid salary.
 */
private static final int DEFAULT_AGE = 0;

/**
 * String used to introduce and mark an error message.
 */
private static final String ERROR_MARKER = "Error in setting Person object: ";

/**
 * String used to describe a first name.
 */
private static final String FIRST_KIND = "first";

/**
 * String used to respond to a missing first name.
 */
private static final String FIRST_NAME_REPLACEMENT = "<Invalid " + FIRST_KIND + " name>";

/**
 * String used to describe a last name.
 */
private static final String LAST_KIND = "last";

/**
 * String used to respond to a missing last name.
 */
private static final String LAST_NAME_REPLACEMENT =	"<Invalid " + LAST_KIND + " name>";

/**
 * Number of months in a year.
 */
private static final int MONTHS_IN_YEAR = 12;

/**
 * The Person's first name (assuming Western World naming).
 */
private String firstNameField = DEFAULT_NAME;

/**
 * The Person's last name (assuming Western World naming).
 */
private String lastNameField = DEFAULT_NAME;

/*
* The Persons's age in years
*/
private double ageField = 0;

/**
 * Constructor.
 *
 * @param firstName     Person's first name (assuming Western World naming)
 * @param lastName      Person's last name (assuming Western World naming)
 * @param initialAge	Person's initial age in years
 */
public Person(String firstName, String lastName, double initialAge)
{

	if(firstName == null || firstName.equals("")) {
		this.firstNameField = null;
		
	}else {
		this.firstNameField = firstName;
	}
	if(lastName == null || lastName.equals("")) {
		this.lastNameField = null;
	}else {
		this.lastNameField = lastName;
	}
	if(initialAge < 0) {
		this.ageField = 0;
		
	}else {
		this.ageField = initialAge;
	}
}


/**
 * Print on the standard output the details of this Person.
 */
public void displayValues()
{
  System.out.println(this.firstNameField + " " + this.lastNameField + " " + this.ageField);
}

/**
 * Getter for the Person's first name (assuming Western World naming).
 *
 * @return	Person's first name.


/**
 * String identifying and describing this Person.
 *
 * @return the string
 */


public String getFirst() {
	return firstNameField;
}

public void setFirst(String firstNameField) {
	
	if(firstNameField == null || firstNameField.equals("") || firstNameField.equals(" ")) {
		this.firstNameField = null;
	}else {
		this.firstNameField = firstNameField;	
	}
}

public String getLast() {
	return lastNameField;
}

public void setLast(String lastNameField) {
	if(lastNameField == null || lastNameField.equals("") || lastNameField.equals(" ")) {
		this.lastNameField = null;
	}else {
		this.lastNameField = lastNameField;	
	}
	
}

public double getAge() {
	return ageField;
}

public void setAge(double ageField) {
	if(ageField < 0) {
		this.ageField = 0;
		
	}else {
		this.ageField = ageField;
	}

}

@Override
public String toString() {

	
	return super.toString() + "\u0020" + this.firstNameField +" " + lastNameField;

}

}
