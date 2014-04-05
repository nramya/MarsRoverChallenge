package marsrover;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import objects.Plateau;
import objects.Rover;
import exceptions.InvalidInputException;

/**
 * @author Ramya
 * 
 *         MarsRoverJavaMain class: Class containing the main method. Run this
 *         program by passing input file path as parameter.
 * 
 *         Assumptions:
 * 
 *         1. There can be more than one rover on a grid. This assumption was
 *         made because the question was not clear in how this condition has to
 *         be handled. (If this cannot be the case, we could have a list of
 *         grids which are already occupied and a move forward can be made to go
 *         around the rover to the closest vacant grid. This condition is not
 *         handled by this solution.)
 */

public class MarsRoverJavaMain {

	/**
	 * @param args
	 *            : Absolute path for the input file
	 */

	public static void main(String[] args) {
		try {
			InputStream f = new FileInputStream(args[0]);
			BufferedReader br = new BufferedReader(new InputStreamReader(f));
			String newRover;
			String roverProperties[];
			char commands[];
			// First line in input file has the Plateau's top right grid
			// co-ordinates
			String firstLine = br.readLine();
			String limits[] = firstLine.split(" ");
			boolean flag = false;
			Plateau.limitX = Integer.parseInt(limits[0]);
			Plateau.limitY = Integer.parseInt(limits[1]);
			// To check for the presence of one or more rovers
			newRover = br.readLine();
			if (newRover == null) {
				System.out.println("No Rovers found!");
			}
			while (newRover != null) {
				roverProperties = newRover.split(" ");
				Rover rover = new Rover();
				// Setting rover properties (position and direction)
				rover.setPositionX(Integer.parseInt(roverProperties[0]));
				rover.setPositionY(Integer.parseInt(roverProperties[1]));
				rover.setFacingDirection(roverProperties[2].charAt(0));
				commands = br.readLine().toCharArray();
				if (commands.length > 0) {
					// Commands for the rover to move
					for (int index = 0; index < commands.length; index++) {
						// Act according to the commands, if valid
						if (commands[index] == 'L') {
							rover.turnLeft();
						} else if (commands[index] == 'R') {
							rover.turnRight();
						} else if (commands[index] == 'M') {
							rover.moveAhead();
						} else {
							System.out.println("Encountered invalid command.");
							flag = true;
							break;
						}
					}
					if (flag == false) {
						// To print the final position and direction faced by
						// the rover
						System.out.println(rover.getPositionX() + " "
								+ rover.getPositionY() + " "
								+ rover.getFacingDirection());
					}
				} else {
					System.out
							.println("This rover does not have any commands to move.");
				}
				// Repeat till all rovers have acted on their commands
				newRover = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException fnfEx) {
			System.out.println("File not found!");
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		} catch (InvalidInputException iiEx) {
			System.out
					.println("Invalid Input. Please check the range of co-ordinates in the plateau.");
		} catch (Exception ex) {
			System.out.println("Unknown error:");
			ex.printStackTrace();
		}
	}
}
