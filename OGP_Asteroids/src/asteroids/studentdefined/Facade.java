package asteroids.studentdefined;

import java.util.Random;
import java.util.Set;

import asteroids.CollisionListener;
import asteroids.IFacade;
import asteroids.IShip;

public class Facade implements IFacade {

	@Override
	public Object createWorld(double width, double height) {
		return new World(width, height);
	}

	@Override
	public double getWorldWidth(Object world) {
		return ((World)world).getWidth();
	}

	@Override
	public double getWorldHeight(Object world) {
		return ((World)world).getHeight();
	}

	@Override
	public Set getShips(Object world) {
		return (Set) ((World)world).getShips();
	}

	@Override
	public Set getAsteroids(Object world) {
		return (Set) ((World)world).getAsteroids();
	}

	@Override
	public Set getBullets(Object world) {
		return (Set) ((World)world).getBullets();
	}
	
	public Set getPowerUps(Object world){
		return (Set) ((World)world).getPowerUps();
	}

	@Override
	public void addShip(Object world, Object ship) {
		((World)world).addShip((Ship)ship);
		
	}

	@Override
	public void addAsteroid(Object world, Object asteroid) {
		((World)world).addAsteroid((Asteroid)asteroid);
	}

	@Override
	public void removeShip(Object world, Object ship) {
		((World)world).removeSpaceObject((SpaceObject)ship);
		
	}

	@Override
	public void removeAsteroid(Object world, Object asteroid) {
		((World)world).removeSpaceObject((SpaceObject)asteroid);
		
	}

	@Override
	public void evolve(Object world, double dt,CollisionListener collisionListener) {
		((World)world).evolve(dt,collisionListener);
		
	}

	@Override
	public Object createShip(double x, double y, double xVelocity,
			double yVelocity, double radius, double direction, double mass) {
		return new Ship(x, y, xVelocity, yVelocity,  radius,  direction,  mass, null);
	}

	@Override
	public boolean isShip(Object o) {
		return (o instanceof Ship);
	}

	@Override
	public double getShipX(Object ship) {
		return ((Ship)ship).getPosition().getX();
	}

	@Override
	public double getShipY(Object ship) {
		return ((Ship) ship).getPosition().getY();
		
	}

	@Override
	public double getShipXVelocity(Object ship) {
		return ((Ship) ship).getVelocity().getVelocityX();
	}

	@Override
	public double getShipYVelocity(Object ship) {
		return ((Ship) ship).getVelocity().getVelocityY();
	}

	@Override
	public double getShipRadius(Object ship) {
		return ((Ship)ship).getRadius();
	}

	@Override
	public double getShipDirection(Object ship) {
		return ((Ship)ship).getAngle();
	}

	@Override
	public double getShipMass(Object ship) {
		return ((Ship)ship).getMass().getMass();
	}

	@Override
	public Object getShipWorld(Object ship) {
		return ((Ship)ship).getWorld();
	}

	@Override
	public boolean isShipThrusterActive(Object ship) {
		return ((Ship)ship).isThrusterActive();
	}

	@Override
	public void setThrusterActive(Object ship, boolean active) {
		if (active)
			((Ship)ship).enableThruster();
		else
			((Ship)ship).disableThruster();
		
	}

	@Override
	public void turn(Object ship, double angle) {
		((Ship)ship).turn(angle);
		
	}

	@Override
	public void fireBullet(Object ship) {
		((Ship)ship).fireBullet();
		
	}

	@Override
	public Object createAsteroid(double x, double y, double xVelocity,
			double yVelocity, double radius) {
		return new Asteroid(x, y, xVelocity, yVelocity, radius, null);
	}

	@Override
	public Object createAsteroid(double x, double y, double xVelocity,
			double yVelocity, double radius, Random random) {
		return new Asteroid(x, y, xVelocity, yVelocity, radius, null);
	}

	@Override
	public boolean isAsteroid(Object o) {
		return o instanceof Asteroid;
	}

	@Override
	public double getAsteroidX(Object asteroid) {
		return ((Asteroid)asteroid).getPosition().getX();
	}

	@Override
	public double getAsteroidY(Object asteroid) {
		return ((Asteroid)asteroid).getPosition().getY();
	}

	@Override
	public double getAsteroidXVelocity(Object asteroid) {
		return ((Asteroid)asteroid).getVelocity().getVelocityX();
	}

	@Override
	public double getAsteroidYVelocity(Object asteroid) {
		return ((Asteroid)asteroid).getVelocity().getVelocityY();

	}

	@Override
	public double getAsteroidRadius(Object asteroid) {
		return ((Asteroid)asteroid).getRadius();
	}

	@Override
	public double getAsteroidMass(Object asteroid) {
		return ((Asteroid)asteroid).getMass().getMass();

	}

	@Override
	public Object getAsteroidWorld(Object asteroid) {
		return ((Asteroid)asteroid).getWorld();

	}

	@Override
	public boolean isBullets(Object o) {
		return o instanceof Bullet;
	}

	@Override
	public double getBulletX(Object bullet) {
		return ((Bullet)bullet).getPosition().getX();
	}

	@Override
	public double getBulletY(Object bullet) {
		return ((Bullet)bullet).getPosition().getY();

	}

	@Override
	public double getBulletXVelocity(Object bullet) {
		return ((Bullet)bullet).getVelocity().getVelocityX();

	}

	@Override
	public double getBulletYVelocity(Object bullet) {
		return ((Bullet)bullet).getVelocity().getVelocityY();

	}

	@Override
	public double getBulletRadius(Object bullet) {
		return ((Bullet)bullet).getRadius();
	}

	@Override
	public double getBulletMass(Object bullet) {
		return ((Bullet)bullet).getMass().getMass();

	}

	@Override
	public Object getBulletWorld(Object bullet) {
		return ((Bullet)bullet).getWorld();

	}

	@Override
	public Object getBulletSource(Object bullet) {
		return ((Bullet)bullet).getSource();
	}

	@Override
	public double getPowerUpX(Object powerup) {
		return ((PowerUp)powerup).getPosition().getX();
	}

	@Override
	public double getPowerUpY(Object powerup) {
		return ((PowerUp)powerup).getPosition().getY();
	}

	@Override
	public double getPowerUpXVelocity(Object powerup) {
		return ((PowerUp)powerup).getVelocity().getVelocityX();
	}

	@Override
	public double getPowerUpYVelocity(Object powerup) {
		return ((PowerUp)powerup).getVelocity().getVelocityY();
	}
	
	@Override
	public double getPowerUpRadius(Object powerup) {
		return ((PowerUp)powerup).getRadius();
	}

	@Override
	public double getPowerUpMass(Object powerup) {
		return ((PowerUp)powerup).getMass().getMass();
	}

	@Override
	public Object getPowerUpWorld(Object powerup) {
		return ((PowerUp)powerup).getWorld();
	}
	@Override
	public int getPowerUpType(Object powerup){
		return ((PowerUp)powerup).getType();
	}

}

