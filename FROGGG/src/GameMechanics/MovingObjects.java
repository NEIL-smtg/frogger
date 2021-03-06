package GameMechanics;

import GameAnimations.Crocodile;
import GameAnimations.Log;
import GameAnimations.Obstacle;
import GameAnimations.Turtle;
import GameAnimations.WetTurtle;

public class MovingObjects{
	private int gridY = 650;
	private int speed;
	private int y =50; //height per row
	Obstacle[] carlane1 = new Obstacle[3];
	Obstacle[] carlane4 = new Obstacle[2];
	Obstacle[] trucklane2 =  new Obstacle[2];
	Obstacle[] trucklane3 = new Obstacle[2];
	Turtle[] turtlelane6 = new Turtle[2];
	WetTurtle[] turtlelane9 = new WetTurtle[3];
	Log[] loglane7 = new Log[2];
	Log[] loglane8 = new Log[3];
	Log[] loglane10 = new Log[2];
	Crocodile[] lastlane ;
	Crocodile cro;
	
	public MovingObjects(int speed ) {	
		this.speed=speed;
		movingObstacle();
		movingAssits();
		
	}

	private void movingObstacle() {
		
		int gap=0;
		//carlanes
		for (int i = 0; i < carlane1.length; i++) {		
			carlane1[i]= new Obstacle("file:src/MovingObjectResources/car/car1right.png", gap, gridY, (int) (1.5*speed) , 50, 50);
			gap+=330;
		}
				
		for (int i = 0; i < carlane4.length; i++) {
			carlane4[i] = new Obstacle("file:src/MovingObjectResources/car/car1left.png", gap, gridY-3*y, -2*speed, 50, 50);
		}
				
		//trucklanes		
		trucklane2[0]=new Obstacle("file:src/MovingObjectResources/truck/truck2"+"Right.png", 100, gridY-y,  (2*speed), 200, 200);
		trucklane2[1]=new Obstacle("file:src/MovingObjectResources/truck/truck1"+"Right.png", 430, gridY-y,  (2*speed), 120, 120);
				
		trucklane3[0]=new Obstacle("file:src/MovingObjectResources/truck/truck2"+"left.png", 200, gridY-2*y, (int) (-1.22*speed), 200, 200);
		trucklane3[1]=new Obstacle("file:src/MovingObjectResources/truck/truck1"+"left.png", 530 , gridY-2*y, (int) (-1.22*speed), 120, 120);
	}
	
	private void movingAssits() {
		int gap=0;
		
		for (int i = 0; i < 2; i++) {
			turtlelane6[i]= new Turtle(gap, gridY-5*(y+5) , (int) (-1.3*speed), 130, 130);
			loglane10[i]= new Log("file:src/MovingObjectResources/log/logs.png", 276, gap, gridY-9*(y+5),  1.2*speed);
			loglane7[i]= new Log("file:src/MovingObjectResources/log/log2.png", 200, gap-90, gridY-6*(y+5),  1.2*speed);
			gap+=330;
		}
		
		for (int i = 0; i < 3; i++) {		
			loglane8[i]= new Log("file:src/MovingObjectResources/log/log3.png", 166, gap, gridY-7*(y+5), -1.2*speed);
			turtlelane9[i]= new WetTurtle( gap-330 , gridY-8*(y+5) , (int) (1.3*speed), 130, 130);
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
