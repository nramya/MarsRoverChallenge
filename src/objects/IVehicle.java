package objects;

import exceptions.InvalidInputException;

public interface IVehicle {

	// IVehicle Interface: Contains methods that can be implemented by any
	// controllable vehicle

	public boolean canMove();

	public void moveAhead() throws InvalidInputException;

	public void turnLeft() throws InvalidInputException;

	public void turnRight() throws InvalidInputException;
}
