package asteroids.collisions;

import asteroids.studentdefined.Asteroid;
import asteroids.studentdefined.Velocity;

public class AsteroidAsteroidCollision implements CollisionType {
	private Asteroid o1;
	private Asteroid o2;
	
	public AsteroidAsteroidCollision(Asteroid o1, Asteroid o2) {
		this.o1 = o1;
		this.o2 = o2;
	}

	@Override
	public void collide() {
		double velocityO1 = Velocity.computeVelocity(o1.getVelocity().getVelocityX(), o1.getVelocity().getVelocityY());
		double velocityO2 = Velocity.computeVelocity(o2.getVelocity().getVelocityX(), o2.getVelocity().getVelocityY());
		double dV = velocityO2 - velocityO1;
		double sigma = o1.getRadius() + o2.getRadius();
		double dR = o2.getRadius() - o1.getRadius();
		double dX = o2.getPosition().getX() - o1.getPosition().getX();
		double dY = o2.getPosition().getY() - o1.getPosition().getY();
		double j = (2 * o1.getMass().getMass()*o2.getMass().getMass()*(dV*dR))/(sigma*(o1.getMass().getMass() + o2.getMass().getMass()));
		double jX = (j*dX)/sigma;
		double jY = (j*dY)/sigma;
		
		double newVelocityO1X = o1.getVelocity().getVelocityX() + (jX / o1.getMass().getMass());
		double newVelocityO1Y = o1.getVelocity().getVelocityY() + (jY / o1.getMass().getMass());
		
		double newVelocityO2X = o2.getVelocity().getVelocityX() - (jX / o2.getMass().getMass());
		double newVelocityO2Y = o2.getVelocity().getVelocityY() - (jY / o2.getMass().getMass());
		
		o1.setVelocity(newVelocityO1X, newVelocityO1Y);
		o2.setVelocity(newVelocityO2X, newVelocityO2Y);
		// o1.setVelocity((-1) * o1.getVelocity().getVelocityX(), (-1) * o1.getVelocity().getVelocityY());
		// o2.setVelocity((-1) * o2.getVelocity().getVelocityX(), (-1) * o2.getVelocity().getVelocityY());
	}

}