package asteroids.studentdefined;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.Set;

import asteroids.CollisionListener;
import asteroids.IFacade;
import asteroids.model.programs.parsing.ProgramParser;
import asteroids.program.ProgramConstructor;
import asteroids.program.expressions.Expression;
import asteroids.program.statements.Statement;
import asteroids.program.types.Type;

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
		return (Set) ((World)world).getAllShips();
	}

	@Override
	public Set getAsteroids(Object world) {
		return (Set) ((World)world).getAllAsteroids();
	}

	@Override
	public Set getBullets(Object world) {
		return (Set) ((World)world).getAllBullets();
	}

	public Set getPowerUps(Object world){
		return (Set) ((World)world).getAllPowerUps();
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
		return ((Ship)ship).getMass().getValue();
	}

	@Override
	public Object getShipWorld(Object ship) {
		return ((Ship)ship).getWorld();
	}

	@Override
	public boolean isShipThrusterActive(Object ship) {
		return ((Ship)ship).getThruster().isEnabled();
	}

	@Override
	public boolean getisShieldActive(Object ship) {
		return ((Ship)ship).getShield() > 0;
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
	public boolean canFireBullet(Object ship){
		if (((Ship)ship).canFireBullet())	
			return true;
		return false;
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
		return ((Asteroid)asteroid).getMass().getValue();

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
		return ((Bullet)bullet).getMass().getValue();

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
		return ((PowerUp)powerup).getMass().getValue();
	}

	@Override
	public Object getPowerUpWorld(Object powerup) {
		return ((PowerUp)powerup).getWorld();
	}
	@Override
	public int getPowerUpType(Object powerup){
		return ((PowerUp)powerup).getType();
	}

	@Override
	public boolean isWall(Object o) {
		return o instanceof Wall;
	}


	@Override
	public boolean isPowerUp(Object o) {
		return o instanceof PowerUp;
	}

	/**
	 * 
	 */
	@Override
	public ParseOutcome<Program> parseProgram(String text) {
		ProgramConstructor factory = new ProgramConstructor();
		ProgramParser<Expression, Statement, Type> parser = new ProgramParser<>(factory);
		parser.parse(text);
		List<String> errors = parser.getErrors();
		if(! errors.isEmpty()) {
			return ParseOutcome.failure(errors.get(0));
		} else {
			return ParseOutcome.success(new Program(parser.getGlobals(), parser.getStatement()));
		} 
	}

	/**
	 * 
	 */
	@Override
	public ParseOutcome loadProgramFromStream(InputStream stream)
			throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 */
	@Override
	public ParseOutcome<Program> loadProgramFromUrl(URL url) throws IOException {
		ProgramConstructor factory = new ProgramConstructor();
		ProgramParser<Expression, Statement, Type> parser = new ProgramParser<>(factory);
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

		String text;
		String program = "";
		while ((text = in.readLine()) != null) {
			// Keep in mind that readLine() strips the newline characters
			program += (text + "\n");
		}
		parser.parse(program);
		List<String> errors = parser.getErrors();
		if(! errors.isEmpty()) {
			return ParseOutcome.failure(errors.get(0));
		} else {
			return ParseOutcome.success(new Program(parser.getGlobals(), parser.getStatement()));
		} 



	}

	/**
	 * 
	 */
	@Override
	public boolean isTypeCheckingSupported() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 
	 */
	@Override
	public TypeCheckOutcome typeCheckProgram(Object program) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 */
	@Override
	public void setShipProgram(Object ship, Object program) {
		((Ship) ship).setProgram((Program) program);
	}

}

