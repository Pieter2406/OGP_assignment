OGP Project
	Participating members:
	+ yotabytes (Wouter)
	+ Pieter2406 (Pieter)
	+ fantasm0 (Kristof)

List of Issues:

* Finish test cases for World FIXED
* Review World.java invariants and Data Structures
	using methods for manipulating associated SpaceObjects in collision 
	calculations, rather than manipulating the data structures directly.
* Collisions with walls while thruster is enabled are not working correctly. FIXED
* getTimeToCollision test cases do not pass. FIXED
* Introduce timers for every powerup. FIXED (powerups now dissapear after 10 seconds)
* firing bullet close to wall creates a bullet behind the wall, revision of wall collision necessary.

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
