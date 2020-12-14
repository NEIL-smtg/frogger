package GameMechanics;

import ScreenDesign.*;

public class Time {
	BackgroundImage[] time;
	
	public Time() {
		time= new BackgroundImage[30];
		int gap=0;
		
		for (int i = 0; i < time.length; i++) {
			time[i] = new BackgroundImage("file:src/resources/green.jpg");
			time[i].setFitWidth(10);
			time[i].setFitHeight(30);
			time[i].setLayoutX(280+gap);
			time[i].setLayoutY(750);
			gap+=10;
		}
		
	}
	
	public BackgroundImage[] getTimer() {
		return time;
	}
}
 