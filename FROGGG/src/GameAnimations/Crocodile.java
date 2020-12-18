package GameAnimations;

import java.util.ArrayList;
import java.util.Random;

import GameMechanics.Actor;
import javafx.scene.image.Image;

public class Crocodile extends Actor {
	Image crocodile;
	int xpos;
	int level;
	Random rand = new Random();
	ArrayList<Integer> randompos = new ArrayList<Integer>(); ;
	
	@Override
	public void act(long now) {
		
		if (now/900000000  % 3 ==0) {
			xpos =Randomiser();
		}
		else if (now/900000000 % 3 == 1) {
			setImage(crocodile);				
			setX(xpos);
		}
		else if (now/900000000 %3 == 2) {
			setImage(crocodile);
		}
	}
	
	public Crocodile(int level ){
		this.level=level;
		crocodile = new Image("file:src/resources/crocodile.jpg", 40,50, true, true);
		xpos= Randomiser();
		setX(xpos);
		setY(95);
	}
	
	
	private int Randomiser() {
		
		if (level <=6) {
			randompos.add(121);
			randompos.add(279);
			randompos.add(430);
			
			int r = rand.nextInt(3);
			return randompos.get(r);
		}
		else if (level==7 || level ==8) {
			randompos.add(95);
			randompos.add(223);
			randompos.add(351);
			randompos.add(480);
			
			int r = rand.nextInt(4);
			return randompos.get(r);
		}
		else {
			randompos.add(18);
			randompos.add(146);
			randompos.add(275);
			randompos.add(403); 
			randompos.add(530);
			
			int r = rand.nextInt(5);
			return randompos.get(r);
		}
		
	}

}
