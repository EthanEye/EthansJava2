import java.util.Scanner;

/**
 * Class to test class Turtle Program. Drawing turtle graphics based on turtle
 * commands.
 * 
 * @author Deitel 10e chapter 7
 * @version CSC160 CSC 1 2020 Robert Gilanyi, Instructor
 */
public class TurtleGraphics {
	private static final int SIZE = 20; // size of the drawing area
	private static int[][] floor; // array representing the floor

	private static int xPos; // the x Position of the turtle
	private static int yPos; // the y Position of the turtle

	// enters the commands for the turtle graphics
	public static void main(String[] args) {
		new TurtleGraphics().run(); // launch the app
	}

	public void run() {
		final int MAXCOMMANDS = 100; // maximum size of command array
		int[][] commandArray = new int[MAXCOMMANDS][2];
		int count;

		count = enterCommands(commandArray);
		if (!executeCommands(commandArray, count))
			System.err.println("Invalid command detected");
	}

	// enter the turtle commands
	public int enterCommands(int[][] cmnds) {
		int count = 0; // the current number of commands
		Scanner input = new Scanner(System.in);
//		input.useDelimiter("[,\\s]+");
//		while (input.hasNext()) {
//            String token = input.next();
//            System.out.println("Token: " + token);
//        }
//	
		floor = new int[SIZE][SIZE];

		System.out.print("Enter command (9 to end input): ");
		int inputCommand = input.nextInt();

		while (inputCommand != 9 && count < cmnds.length) {
			cmnds[count][0] = inputCommand;

			// prompt for forward spaces
			if (inputCommand == 5)
				cmnds[count][1] = input.nextInt();

			count++;

			System.out.print("Enter command (9 to end input): ");
			inputCommand = input.nextInt();
		}
		return count;
	
	}

	// executes the commands in the command array
	public boolean executeCommands(int[][] cmnds, int count) {
		int commandNumber = 0; // the current position in the array
		int direction = 2; // the direction the turtle is facing // 1 is up right 2 down is 3 and 4 is left
		int distance = 0; // the distance the turtle will travel
		int command; // the current command
		boolean penDown = true; // whether the pen is up or down
		xPos = 0;
		yPos = 0;

		command = cmnds[commandNumber][0];

		// continue executing commands until either reach the end
		// or reach the max commands
		while (commandNumber < count) {
			// System.out.println("Executing...");
			// determine what command was entered
			// and perform desired action
			switch (command) {
			case 1: // pen down
				penDown = true;
				System.out.println("Pen Down");
				break;
			case 2: // pen up
				penDown = false;
				System.out.println("Pen Up");
				break;
			case 3: // turn right
				direction = turnRight(direction);

				break;
			case 4: // turn left
				direction = turnLeft(direction);

				break;
			case 5: // move
				distance = cmnds[commandNumber][1];
			
				if (distance + xPos > 20 || distance + xPos < 0 || distance + yPos > 20 || distance + yPos < 0) { // set
																											// bounds
					System.err.println("Distance Out of bounds");
					break;
				}
				movePen(penDown, floor, direction, distance);
				System.out.println("Move towards Direction: " + direction + " Distance: " + distance);
				break;
			case 6: // display the drawing
				System.out.println("\nThe drawing is:\n");
				printArray(floor);
				break;
			default:
				return false;
			}

			command = cmnds[++commandNumber][0];
		}
		return true;
	}

	// method to turn turtle to the right
	public static int turnRight(int d) {
		String direction = "";
		// To be completed by student.
		d++;
		if (d > 4) {
			d = 1;

		}
		switch (d) {
		case 1:
			direction = "Up";
			break;
		case 2:
			direction = "Right";
			break;
		case 3:
			direction = "Down";
			break;
		case 4:
			direction = "Left";
			break;
		default:
			direction = "";
		}

		System.out.println(direction);

		return d;
	}

	// method to turn turtle to the left
	public static int turnLeft(int d) {

		String direction = "";
		// To be completed by student.
		d--;
		if (d < 1) {
			d = 4;
		}

		switch (d) {
		case 1:
			direction = "Up";
			break;
		case 2:
			direction = "Right";
			break;
		case 3:
			direction = "Down";
			break;
		case 4:
			direction = "Left";
			break;
		default:
			direction = "";
		}

		System.out.println(direction);

		return d;
	}

	// method to move the pen
	public static void movePen(boolean down, int a[][], int dir, int dist) {
		int j; // looping variable

		// determine which way to move pen
		switch (dir) {
		case 1: // move up
			for (j = 1; j <= dist && xPos - j >= 0; ++j)
				if (down)
					a[xPos - j][yPos] = 1;

			xPos -= j - 1;

			break;

		case 2: // move right
			// To be completed by student.
			for (j = 1; j <= dist && xPos + j < SIZE; ++j)
				if (down)
					a[xPos][yPos + j] = 1;

			xPos += j - 1;
			break;

		case 3: // move to down
			// To be completed by student.

			for (j = 1; j <= dist && yPos + j < SIZE; ++j) {
				if (down)
					a[yPos + j][xPos] = 1;
			}

			yPos += j - 1;

			break;

		case 4: // left
			System.err.println("Left");
			for (j = 1; j <= dist && yPos - j >= 0; ++j) {
				if (down) // Check the direction to move left
					a[xPos][yPos - j] = 1; // Move left by decreasing yPos
				System.err.println("Drawing at: (" + xPos + ", " + (yPos - j) + ")");
			}

			// Update yPos to the new position after moving left
			yPos -= j - 1;
			break;

		}
		System.out.println("Updated position " + xPos + " " + yPos);
	}

	// method to print array drawing
	public static void printArray(int[][] a) {

//	   a[10][4] = 1;
		// display array
		for (int i = 0; i < a.length; i++) { // Outer loop for rows
			for (int j = 0; j < a[i].length; j++) { // Inner loop for columns
				System.out.print(a[i][j] + " ");
			}
			System.out.println(); // Move to the next line after printing each row
		}

	}

} // end class TurtleGraphics

/**************************************************************************
 * (C) Copyright 1992-2015 by Deitel & Associates, Inc. and * Pearson Education,
 * Inc. All Rights Reserved. * * DISCLAIMER: The authors and publisher of this
 * book have used their * best efforts in preparing the book. These efforts
 * include the * development, research, and testing of the theories and programs
 * * to determine their effectiveness. The authors and publisher make * no
 * warranty of any kind, expressed or implied, with regard to these * programs
 * or to the documentation contained in these books. The authors * and publisher
 * shall not be liable in any event for incidental or * consequential damages in
 * connection with, or arising out of, the * furnishing, performance, or use of
 * these programs. *
 *************************************************************************/
