package p4_group_8_repo;

public class MovingObjects{
	int gridY = 650;
	int speed;
	int level;
	int y =50; //size per row
	Obstacle[] carlane1 = new Obstacle[3];
	Obstacle[] carlane4 = new Obstacle[2];
	Obstacle[] trucklane2 =  new Obstacle[2];
	Obstacle[] trucklane3 = new Obstacle[2];
	Turtle[] turtlelane6 = new Turtle[2];
	WetTurtle[] turtlelane9 = new WetTurtle[3];
	Log[] loglane7 = new Log[2];
	Log[] loglane8 = new Log[3];
	Log[] loglane10 = new Log[2];
	
	MovingObjects(int level) 
	{	
		this.level=level;
		movingObstacle();
		movingHelp();
	}

	private void movingObstacle() {
		
		int gap=0;
		//carlanes
		for (int i = 0; i < carlane1.length; i++) {		
			carlane1[i]= new Obstacle("file:src/p4_group_8_repo/car/car1right.png", gap, gridY, (int) (1.5*level) , 50, 50);
			gap+=330;
		}
				
		for (int i = 0; i < carlane4.length; i++) {
			carlane4[i] = new Obstacle("file:src/p4_group_8_repo/car/car1left.png", gap, gridY-3*y, -2*level, 50, 50);
		}
				
		//trucklanes		
		trucklane2[0]=new Obstacle("file:src/p4_group_8_repo/truck/truck2"+"Right.png", 100, gridY-y, (int) (1.11*level), 200, 200);
		trucklane2[1]=new Obstacle("file:src/p4_group_8_repo/truck/truck1"+"Right.png", 430, gridY-y, (int) (1.11*level), 120, 120);
				
		trucklane3[0]=new Obstacle("file:src/p4_group_8_repo/truck/truck2"+"left.png", 200, gridY-2*y, (int) (-1.22*level), 200, 200);
		trucklane3[1]=new Obstacle("file:src/p4_group_8_repo/truck/truck1"+"left.png", 530 , gridY-2*y, (int) (-1.22*level), 120, 120);
	}
	
	private void movingHelp() {
		int gap=0;
		
		for (int i = 0; i < 2; i++) {
			turtlelane6[i]= new Turtle(gap, gridY-5*(y+5) , (int) (-1.3*level), 130, 130);
			loglane10[i]= new Log("file:src/p4_group_8_repo/log/logs.png", 276, gap, gridY-9*(y+5),  1.2*level);
			loglane7[i]= new Log("file:src/p4_group_8_repo/log/log2.png", 200, gap-90, gridY-6*(y+5),  1.2*level);
			gap+=330;
		}
		
		for (int i = 0; i < 3; i++) {		
			loglane8[i]= new Log("file:src/p4_group_8_repo/log/log3.png", 166, gap, gridY-7*(y+5), -1.2*level);
			turtlelane9[i]= new WetTurtle( gap-330 , gridY-8*(y+5) , (int) (1.3*level), 130, 130);
			gap+=330;
			
		}
	}

	
	public Obstacle[] getlane1() {
		return carlane1;
	}
	
	public Obstacle[] getlane4() {
		return carlane4;
	}
	
	public Obstacle[] getlane2() {
		return trucklane2;
	}
	
	public Obstacle[] getlane3() {
		return trucklane3;
	}
	
	public Turtle[] getlane6() {
		return turtlelane6;
	}
	
	public WetTurtle[] getlane9() {
		return turtlelane9;
	}
	
	public Log[] getlane7() {
		return loglane7;
	}
	
	public Log[] getlane8() {
		return loglane8;
	}
	
	public Log[] getlane10() {
		return loglane10;
	}
	
	
}
