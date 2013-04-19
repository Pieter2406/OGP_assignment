OGP Project
	Participating members:
	+ yotabytes (Wouter)
	+ Pieter2406 (Pieter)
	+ fantasm0 (Kristof)

List of Issues:


* Ship.fireBullet(): Handle immediate collision situations and situations where the 
	new bullet is partly off the screen.
* The revalidate() method in Asteroids.java is not recognized.
	Fix: This method is introduced in java 7. While windows 7 and 8 versions are usually updated to java 7,
	Mac OS versions before 10.7 have java 6 instead of java 7 installed. More importantly, versions prior to
	10.7(Lion) cannot upgrade java to version 7.
	Solution: replace "revalidate();" by "invalidate(); validate();"
* Finish test cases for World
* Review World.java invariants and Data Structures
	using methods for manipulating associated SpaceObjects in collision 
	calculations, rather than manipulating the data structures directly.
* Collisions with walls while thruster is enabled are not working correctly.
* getTimeToCollision test cases do not pass.
* Introduce timers for every powerup.

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
