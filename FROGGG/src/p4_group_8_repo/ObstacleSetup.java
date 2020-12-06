package p4_group_8_repo;

public class ObstacleSetup{
	int gridY = 650;
	Obstacle[] obstacles = new Obstacle[3];
	
	ObstacleSetup(int level) {	
			int gap=0;
		
			for (int j = 0; j < obstacles.length; j++) {		
				obstacles[j]= new Obstacle("file:src/p4_group_8_repo/car/car1right.png", 0+gap, gridY,-1*level , 50, 50);
				gap+=200;	
			}
		}
	
	public Obstacle[] getarr() {
		return obstacles;
	}

}
