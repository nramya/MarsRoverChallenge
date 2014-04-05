import static org.junit.Assert.assertEquals;
import objects.Plateau;
import objects.Rover;

import org.junit.Test;

import enumerations.FacingDirection;
import exceptions.InvalidInputException;

/**
 * @author Ramya
 * 
 *         Test suite containing different scenarios to test the Mars Rover
 *         program
 * 
 */
public class MarsRoverJavaTest {

	// To check whether an InvalidInputException is thrown when the rover is
	// placed out of the plateau boundaries

	@Test(expected = InvalidInputException.class)
	public void throwInvalidInputExceptionTest() throws InvalidInputException {
		Rover testRover = new Rover();
		Plateau.limitX = 5;
		Plateau.limitY = 5;
		testRover.setPositionX(1);
		testRover.setPositionY(7);
		testRover.setFacingDirection('N');
		testRover.moveAhead();
	}

	// To test whether movement of rover is restricted within plateau boundaries
	@Test
	public void throwInvalidInputExceptionTest2() throws InvalidInputException {
		Rover testRover = new Rover();
		Plateau.limitX = 5;
		Plateau.limitY = 5;
		testRover.setPositionX(0);
		testRover.setPositionY(3);
		testRover.setFacingDirection('W');
		assertEquals(false, testRover.canMove());
	}

	// To test whether the rover can turn left when instructed to do so
	@Test
	public void testTurnLeft() throws InvalidInputException {
		Rover testRover = new Rover();
		Plateau.limitX = 5;
		Plateau.limitY = 5;
		testRover.setPositionX(1);
		testRover.setPositionY(1);
		testRover.setFacingDirection('N');
		testRover.turnLeft();
		assertEquals(FacingDirection.W, testRover.getFacingDirection());
	}

	// To test whether the rover can turn right when instructed to do so
	@Test
	public void testTurnRight() throws InvalidInputException {
		Rover testRover = new Rover();
		Plateau.limitX = 5;
		Plateau.limitY = 5;
		testRover.setPositionX(1);
		testRover.setPositionY(1);
		testRover.setFacingDirection('N');
		testRover.turnRight();
		assertEquals(FacingDirection.E, testRover.getFacingDirection());
	}

	// To test whether the rover can move one step ahead when instructed to do
	// so
	@Test
	public void testmoveAhead() throws InvalidInputException {
		Rover testRover = new Rover();
		Plateau.limitX = 5;
		Plateau.limitY = 5;
		testRover.setPositionX(1);
		testRover.setPositionY(1);
		testRover.setFacingDirection('N');
		testRover.moveAhead();
		assertEquals(2, testRover.getPositionY());
	}

}
