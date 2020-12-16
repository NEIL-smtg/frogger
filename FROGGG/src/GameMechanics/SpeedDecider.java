package GameMechanics;

public class SpeedDecider {
	int level;
	int speed;
	
	public SpeedDecider(int level) {
		this.level=level;
		if (level==1) {
			speed=level;
		}
		else {
			speed=(int) (1+level/9);
		}	
	}
	
	public int getspeed() {
		return speed;
	}
}
