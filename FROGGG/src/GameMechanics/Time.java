package GameMechanics;

import Background.*;

public class Time {
	BackgroundImage[] time;
	
	public Time() {
		time= new BackgroundImage[15];
		int gap=0;
		
		for (int i = 0; i < time.length; i++) {
			time[i] = new BackgroundImage("file:src/resources/green.jpg");
			time[i].setFitWidth(10);
			time[i].setFitHeight(30);
			time[i].setLayoutX(430+gap);
			time[i].setLayoutY(750);
			gap+=10;
		}
		
	}
	
	public BackgroundImage[] getTimer() {
		return time;
	}
}
 