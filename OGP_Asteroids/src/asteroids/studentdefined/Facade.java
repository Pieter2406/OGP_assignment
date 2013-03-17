package asteroids.studentdefined;

import asteroids.IFacade;
import asteroids.IShip;

public class Facade implements IFacade {

	@Override
	public IShip createShip() {
		return new Ship(0,0,0,0);
	}

	@Override
	public IShip createShip(double x, double y, double xVelocity,
			double yVelocity, double radius, double angle) {
		return new Ship(x,y,xVelocity, yVelocity,radius,angle);
	}

	@Override
	public double getX(IShip ship) {
		return ((Ship) ship).getPosition().getX();
	}

	@Override
	public double getY(IShip ship) {
		return ((Ship) ship).getPosition().getY();
	}

	@Override
	public double getXVelocity(IShip ship) {
		return ((Ship) ship).getVelocity().getVelocityX();
	}

	@Override
	public double getYVelocity(IShip ship) {
		return ((Ship) ship).getVelocity().getVelocityY();
	}

	@Override
	public double getRadius(IShip ship) {
		return ((Ship) ship).getRadius();
	}

	@Override
	public double getDirection(IShip ship) {
		return ((Ship) ship).getAngle();
	}

	@Override
	public void move(IShip ship, double dt) {
		((Ship) ship).move(dt);
	}

	@Override
	public void thrust(IShip ship, double amount) {
		((Ship) ship).thrust(amount);
	}

	@Override
	public void turn(IShip ship, double angle) {
		((Ship) ship).turn(angle);
	}

	@Override
	public double getDistanceBetween(IShip ship1, IShip ship2) {
		return ((Ship) ship1).getDistanceBetween((Ship) ship2);
	}

	@Override
	public boolean overlap(IShip ship1, IShip ship2) {
		return ((Ship)ship1).overlap((Ship)ship2);
	}

	@Override
	public double getTimeToCollision(IShip ship1, IShip ship2) {
		return ((Ship)ship1).getTimeToCollision((Ship)ship2);
	}

	@Override
	public double[] getCollisionPosition(IShip ship1, IShip ship2) {
		double[] coordinates = new double[2];
		Coordinate coordinate = new Coordinate();
		coordinate = ((Ship)ship1).getCollisionPosition((Ship)ship2);
		if (coordinate == null){
		}else{
			coordinates[0] = coordinate.getX();
			coordinates[1] = coordinate.getY();
			return coordinates;
		}
		return null;
	}

}


