OGP Project
	Participating members:
	+ yotabytes (Wouter)
	+ Pieter2406 (Pieter)
	+ fantasm0 (Kristof)

List of Issues:

* Running the game gives a NullPointerException for FileSoundLoader
* Long and redundant method calls SpaceObject.getMass().getMass()
	-> Make Mass methods static and make it return a double after calculating
	A mass is just a double value, all calculations can be static!
  and SpaceObject.getCoordinate().getX()
  and SpaceObject.getVelocity().getVelocityX() | Use 2D vector math
  	or shorten method calls.
* Ship.fireBullet(): Handle immediate collision situations and situations where the 
	new bullet is partly off the screen.
* The revalidate() method in Asteroids.java is not recognized.
* Test methods using black- and white-box testing JUnit suites
* Review World.java invariants and Data Structures
	using methods for manipulating associated SpaceObjects in collision 
	calculations, rather than manipulating the data structures directly.
* Collision not working.

Changes:

	*** Pieter ***
* Updated TODO list;
* Made templates for future testcases
* Added tests in SpaceObjectTest and VelocityTest
* CHANGED EVOLVE METHOD, MAYBE WORSE THAN BEFORE OR BETTER
* Changed Bullet:
	* initialized with pendingVelocityChange = true;
	* handleCollisions(): added method updateCollisions()
* Added template methods for WorldTest
____________________________________________________
