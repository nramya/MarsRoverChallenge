package objects;

import enumerations.FacingDirection;
import exceptions.InvalidInputException;

/**
 * 
 */

/**
 * @author Ramya
 * 
 *         Rover Class: Describes the rover's properties and possible actions
 */

public class Rover implements IVehicle {
	// x and y co-ordinate of the rover's position in the plateau
	public int positionX;
	public int positionY;
	// Direction faced by the rover
	public FacingDirection facingDirection;

	// Getters and setters
	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) throws InvalidInputException {
		if (positionX >= 0 && positionX <= Plateau.limitX) {
			this.positionX = positionX;
		} else {
			throw new InvalidInputException();
		}
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) throws InvalidInputException {
		if (positionY >= 0 && positionY <= Plateau.limitY) {
			this.positionY = positionY;
		} else {
			throw new InvalidInputException();
		}
	}

	public FacingDirection getFacingDirection() {
		return facingDirection;
	}

	public void setFacingDirection(char direction) throws InvalidInputException {
		if (direction == 'N')
			this.facingDirection = FacingDirection.N;
		else if (direction == 'E')
			this.facingDirection = FacingDirection.E;
		else if (direction == 'W')
			this.facingDirection = FacingDirection.W;
		else if (direction == 'S')
			this.facingDirection = FacingDirection.S;
		else {
			throw new InvalidInputException();
		}
	}

	// Method to check whether a move is possible from the current position and
	// facing direction of the rover
	public boolean canMove() {
		if ((this.getFacingDirection() == FacingDirection.N
				&& this.getPositionY() + 1 >= 0
				&& this.getPositionY() + 1 <= Plateau.limitY
				&& this.getPositionX() >= 0 && this.getPositionX() <= Plateau.limitX)
				|| (this.getFacingDirection() == FacingDirection.S
						&& this.getPositionY() - 1 >= 0
						&& this.getPositionY() - 1 <= Plateau.limitY
						&& this.getPositionX() >= 0 && this.getPositionX() <= Plateau.limitX)
				|| (this.getFacingDirection() == FacingDirection.E
						&& this.getPositionX() + 1 >= 0
						&& this.getPositionX() + 1 <= Plateau.limitX
						&& this.getPositionY() >= 0 && this.getPositionY() <= Plateau.limitY)
				|| (this.getFacingDirection() == FacingDirection.W
						&& this.getPositionX() - 1 >= 0
						&& this.getPositionX() - 1 <= Plateau.limitX
						&& this.getPositionY() >= 0 && this.getPositionY() <= Plateau.limitY)) {
			return true;
		} else
			return false;
	}

	// Method to make the rover move one step ahead in the direction it is
	// facing
	public void moveAhead() throws InvalidInputException {
		if (this.getFacingDirection() == FacingDirection.N && this.canMove()) {
			this.setPositionY(getPositionY() + 1);
		} else if (this.getFacingDirection() == FacingDirection.S
				&& this.canMove()) {
			this.setPositionY(getPositionY() - 1);
		} else if (this.getFacingDirection() == FacingDirection.E
				&& this.canMove()) {
			this.setPositionX(getPositionX() + 1);
		} else if (this.getFacingDirection() == FacingDirection.W
				&& this.canMove()) {
			this.setPositionX(getPositionX() - 1);
		} else {
			throw new InvalidInputException();
		}
	}

	// To turn the rover to its left
	public void turnLeft() throws InvalidInputException {
		if (this.getFacingDirection() == FacingDirection.N) {
			this.setFacingDirection('W');
		} else if (this.getFacingDirection() == FacingDirection.E) {
			this.setFacingDirection('N');
		} else if (this.getFacingDirection() == FacingDirection.S) {
			this.setFacingDirection('E');
		} else if (this.getFacingDirection() == FacingDirection.W) {
			this.setFacingDirection('S');
		} else {
			throw new InvalidInputException();
		}
	}

	// To turn the rover to its right
	public void turnRight() throws InvalidInputException {
		if (this.getFacingDirection() == FacingDirection.N) {
			this.setFacingDirection('E');
		} else if (this.getFacingDirection() == FacingDirection.E) {
			this.setFacingDirection('S');
		} else if (this.getFacingDirection() == FacingDirection.S) {
			this.setFacingDirection('W');
		} else if (this.getFacingDirection() == FacingDirection.W) {
			this.setFacingDirection('N');
		} else {
			throw new InvalidInputException();
		}
	}
}
