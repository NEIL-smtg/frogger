package GameMechanics;

import java.util.ArrayList;

import GameAnimations.End;
import GameAnimations.Log;
import GameAnimations.Obstacle;
import GameAnimations.Turtle;
import GameAnimations.WetTurtle;
import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Animal extends Actor {
	private Image imgW1, imgA1, imgS1, imgD1, imgW2, imgA2, imgS2, imgD2;
	private int points = 0, end=0;
	private boolean second = false;
	private boolean noMove = false;
	private double movement = 13.3333333*2;
	private double movementX = 10.666666*2;
	private int imgSize = 40;
	private boolean carDeath = false;
	private boolean waterDeath = false;
	private boolean stop = false;
	private boolean changeScore = false;
	private int carD = 0;
	private double w = 800;
	private int gethit;
	public int lifes=4;
	int level;
	ArrayList<End> inter = new ArrayList<End>();
	ProceedtoNextLevel ptnl = new ProceedtoNextLevel();

	public Animal(String imageLink , int level) {
		this.level=level;
		points=ptnl.getPoints();
		
		setImage(new Image(imageLink, imgSize, imgSize, true, true));
		setX(300);
		setY(679.8+movement);
		imgW1 = new Image("file:src/MovingObjectResources/frog/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("file:src/MovingObjectResources/frog/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image("file:src/MovingObjectResources/frog/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("file:src/MovingObjectResources/frog/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:src/MovingObjectResources/frog/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image("file:src/MovingObjectResources/frog/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image("file:src/MovingObjectResources/frog/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image("file:src/MovingObjectResources/frog/froggerRightJump.png", imgSize, imgSize, true, true);
		
		
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				if (noMove) {}
				else {
				if (second) {			
					if (event.getCode() == KeyCode.W || event.getCode()==KeyCode.UP) {	  
		                move(0, -movement);
		                changeScore = false;
		                setImage(imgW1);
		                second = false;
		            }
		            else if (event.getCode() == KeyCode.A || event.getCode()==KeyCode.LEFT) {	            	
		            	 move(-movementX, 0);
		            	 setImage(imgA1);
		            	 second = false;
		            }
		            else if (event.getCode() == KeyCode.S || event.getCode()==KeyCode.DOWN) {	            	
		            	 move(0, movement);
		            	 setImage(imgS1);
		            	 second = false;
		            }
		            else if (event.getCode() == KeyCode.D || event.getCode()==KeyCode.RIGHT) {	            	
		            	 move(movementX, 0);
		            	 setImage(imgD1);
		            	 second = false;
		            }
				}
				else if (event.getCode() == KeyCode.W || event.getCode()==KeyCode.UP) {	            	
	                move(0, -movement);
	                setImage(imgW2);
	                second = true;
	            }
	            else if (event.getCode() == KeyCode.A || event.getCode()==KeyCode.LEFT) {	            	
	            	 move(-movementX, 0);
	            	 setImage(imgA2);
	            	 second = true;
	            }
	            else if (event.getCode() == KeyCode.S || event.getCode()==KeyCode.DOWN) {	            	
	            	 move(0, movement);
	            	 setImage(imgS2);
	            	 second = true;
	            }
	            else if (event.getCode() == KeyCode.D || event.getCode()==KeyCode.RIGHT) {	            	
	            	 move(movementX, 0);
	            	 setImage(imgD2);
	            	 second = true;
	            }
	        }
			}
		});	
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (noMove) {}
				else {
				if (event.getCode() == KeyCode.W || event.getCode()==KeyCode.UP) {	  
					if (getY() < w) {
						changeScore = true;
						w = getY();
						points+=10;
					}
	                move(0, -movement);
	                setImage(imgW1);
	                second = false;
	            }
	            else if (event.getCode() == KeyCode.A || event.getCode()==KeyCode.LEFT) {	            	
	            	 move(-movementX, 0);
	            	 setImage(imgA1);
	            	 second = false;
	            }
	            else if (event.getCode() == KeyCode.S || event.getCode()==KeyCode.DOWN) {	            	
	            	 move(0, movement);
	            	 setImage(imgS1);
	            	 second = false;
	            }
	            else if (event.getCode() == KeyCode.D || event.getCode()==KeyCode.RIGHT) {	            	
	            	 move(movementX, 0);
	            	 setImage(imgD1);
	            	 second = false;
	            }
	        }
			}
			
		});
	}
	
	public void death(int dcount, String death ) {
		if (gethit==0) {
			gethit=1;
		}
		for(int i=1; i<=5 ;i++) 
		{
			if(death.equals("carDeath") && i==dcount && i<4)
			{
				setImage(new Image("file:src/MovingObjectResources/car/cardeath"+i+".png", imgSize, imgSize, true, true));
				break;				
			}
			else if(death.equals("waterDeath") && i==dcount && i<5)
			{
				setImage(new Image("file:src/MovingObjectResources/waterdeath/waterdeath"+i+".png", imgSize, imgSize, true, true));
				break;
			}				
		}
	}
			
	public void carDmax() {
		setX(300);
		setY(679.8+movement);
		if (gethit==1) {
			lifes--;
			gethit=0;
		}
		carDeath = false;
		waterDeath=false;  //if error change to if cardeath , cardeath =false , same as waterdeath
		carD = 0;
		setImage(new Image("file:src/MovingObjectResources/frog/froggerUp.png", imgSize, imgSize, true, true));
		noMove = false;
		if (points>50) {
			points-=50;
			changeScore = true;
		}
	}
	
	@Override
	public void act(long now) {	
		int bounds = 0;
		if (getY()<0 || getY()>734) {
			setX(300);
			setY(679.8+movement);
			if (gethit==1) {
				lifes--;
				gethit=0;
			}
		}
		if (getX()<0) {
			move(movement*2, 0);
		}
		if (carDeath) {
			noMove = true;
			if ((now)% 11 ==0) {
				carD++;
			}
			death(carD,"carDeath");	
			if(carD==4) {
				carDmax();
			}
		}
		if (waterDeath) {
			noMove = true;
			if ((now)% 11 ==0) {
				carD++;
			}
			death(carD,"waterDeath");
			if(carD==5) {
				carDmax();
			}
		}
		
		if (getX()>600) {
			move(-movement*2, 0);
		}
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
			if (gethit==0) {
				gethit=1;
			}
		}
		if (getX() == 240 && getY() == 82) {
			stop = true;
			if (gethit==0) {
				gethit=1;
			}
		}
		
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			if(getIntersectingObjects(Log.class).get(0).getLeft())
			{	
				move(-1.2*level,0);	
			}
			else {
				
				move (1.2*level,0);
			}
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
			move(-1*level,0);
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
				if (gethit==0) {
					gethit=1;
				}
				 
			} else {
				move(1*level,0);
			}
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			inter = (ArrayList<End>) getIntersectingObjects(End.class);
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				end--;
				points-=50;
				if (gethit==0) {
					gethit=1;
				}
			}
			points+=50;
			changeScore = true;
			w=800;
			getIntersectingObjects(End.class).get(0).setEnd();
			end++;
			setX(300);
			setY(679.8+movement);
			
		}
		else if (getY()<413){
			waterDeath = true;
			if (gethit==0) {
				gethit=1;
			}
			//setX(300);
			//setY(679.8+movement);
		}
	}


	public boolean getStop() {
		return end==5; // frog in hole==5 ,end of a level
	}
	
	public int getPoints() {
		return points;
	}
	
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
		
	}

}
