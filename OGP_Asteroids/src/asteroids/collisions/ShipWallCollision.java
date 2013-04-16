package asteroids.collisions;

import asteroids.studentdefined.Ship;
import asteroids.studentdefined.Wall;

public class ShipWallCollision implements CollisionType{
		private Ship o1;
		private Wall o2;
		
		public ShipWallCollision(Ship o1, Wall o2) {
			this.o1 = o1;
			this.o2 = o2;
		}

		@Override
		public void collide() {
			if (o2.getOrientation().equals("horizontal"))
				o1.setVelocity(o1.getVelocity().getVelocityX(), -o1.getVelocity().getVelocityY());
			else
				o1.setVelocity(-o1.getVelocity().getVelocityX(), o1.getVelocity().getVelocityY());
		}
}
