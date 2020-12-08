package p4_group_8_repo;

import java.util.Optional;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameView{
	private Scene gameScene;
	private Stage gameStage;
	MyStage background;
	AnimationTimer timer;
	Animal animal;
	Animal frog;
	private static final int GAME_WIDTH = 600;
	private static final int GAME_HEIGHT = 800;
	private Stage menuStage;
	private int level;
	private int orilevel;
	int next=0;
	int updateLifes=4;
	int i;
	BackgroundImage[] froglives = new BackgroundImage[4] ;
	
	public GameView(int level) {
		SpeedDecider(level);
		background = new MyStage();
		game();
		showLives();
		showLevelText(level);
		exitGame();
	}

	private void showLives() {
		for ( i = 0; i < frog.lifes; i++) {
			froglives[i] =new BackgroundImage("file:src/p4_group_8_repo/frog/froggerUp.png");
			froglives[i].setX(0+next);
			froglives[i].setY(750);
			background.add(froglives[i]);
			next+=40;
			
		}
	}

	private void showLevelText(int level) {
		Text text = new Text();
		text.setText("LEVEL "+level);
		text.setX(30);
		text.setY(60);
		fontsetup(text);
		background.addText(text);
	}
	
	private void fontsetup(Text text) {
		try {
			text.setFont(Font.loadFont("file:src/model/ARCADECLASSIC.TTF", 35));
			text.setFill(Color.RED);
			
		} catch (Exception e) {
			text.setFont(Font.font("Verdana",23));
		}
	}

	private void exitGame() { 
		MenuButton exit = new MenuButton("EXIT");
		exit.setLayoutX(450);
		exit.setLayoutY(10);
		exit.setPrefHeight(50);
		exit.setPrefWidth(120);
		
		exit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {	
				if (frog.lifes !=0) {
					setAlert();
				}
				else {
					StoreData s = new StoreData(frog);
					Menu.mainStage.show();
					gameStage.close();
				}
			}

			private void setAlert() {
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("CONFIRMATION");
					alert.setHeaderText("EXIT GAME");
					alert.setContentText("ARE YOU SURE? ALL PROGRESS WILL BE NOT BE SAVED.");
					Optional<ButtonType> option = alert.showAndWait();
					
					if (option.get()==ButtonType.OK) {
						background.stop();
						background.stopMusic();
						Menu.mainStage.show();
						gameStage.close();
					
					}
			}
			
		});
		
		background.getChildren().add(exit);
	}

	private void SpeedDecider(int level) {
		orilevel=level;
		if (level==1) {
			this.level=level;
		}
		else {
			this.level=(int) (1+level/3.5);
		}
		
	}

	public void createNewGame(Stage menuStage) {
		this.menuStage=menuStage;
		this.menuStage.hide();
		gameStage.show();
		
	}
	
	private void backgroundsetup() {
		BackgroundImage purpleborder1 = new BackgroundImage("p4_group_8_repo/purple border.jpg");
		BackgroundImage purpleborder2 = new BackgroundImage("p4_group_8_repo/purple border.jpg");
		BackgroundImage blackborder = new BackgroundImage("p4_group_8_repo/black border.jpg");
		BackgroundImage darkblue = new BackgroundImage("p4_group_8_repo/deepblue.jpg");
		darkblue.setLayoutX(0);
		darkblue.setLayoutY(0);
		purpleborder1.setLayoutX(0);
		purpleborder1.setLayoutY(435);
		purpleborder2.setLayoutX(0);
		purpleborder2.setLayoutY(700);
		blackborder.setLayoutX(0);
		blackborder.setLayoutY(470);
		
		background.add(darkblue);
		background.add(blackborder);
		background.add(purpleborder1);
		background.add(purpleborder2);
	}

	private void game(){
		gameScene=new Scene(background,GAME_WIDTH,GAME_HEIGHT);
		gameStage = new Stage();
		gameStage.setScene(gameScene);
		backgroundsetup();
		
		
		MovingObjects o = new MovingObjects(level);
		Obstacle[] carlane1=o.getlane1();
		Obstacle[] carlane4=o.getlane4();
		Obstacle[] trucklane2= o.getlane2();
		Obstacle[] trucklane3= o.getlane3();
		Turtle[] turtlelane6 = o.getlane6();
		WetTurtle[] turtlelane9 = o.getlane9();
		Log[] loglane7 = o.getlane7();
		Log[] loglane8 = o.getlane8();
		Log[] loglane10 = o.getlane10();
		
		BackgroundImage froggerback = new BackgroundImage("file:src/p4_group_8_repo/Screen Shot 2017-05-29 at 10.02.14 PM.png");
		background.add(froggerback);
		background.add(new Digit(0, 30, 280, 25));
		if (orilevel<=3) {
			background.add(new End(141,86));
			background.add(new End(398,86));
		}
		else if (orilevel >=4 && orilevel<=6) {
			background.add(new End(111,86));
			background.add(new End(269,86));
			background.add(new End(420,86));
		}
		else if (orilevel>=7 && orilevel<=8) {
			background.add(new End(90,86));
			background.add(new End(218,86));
			background.add(new End(346,86));
			background.add(new End(475,86));
		}
		else {
			background.add(new End(13,86));
			background.add(new End(141,86));
			background.add(new End(269,86));
			background.add(new End(398,86));
			background.add(new End(525,86));
		}
			
		
		//loop by 3
		for (int i = 0; i < 3 ; i++) {
			background.add(carlane1[i]);		
			background.add(loglane8[i]);
			background.add(turtlelane9[i]);
		}
		
		//loop by 2
		for (int i = 0; i < 2; i++) {
			background.add(carlane4[i]);
			background.add(trucklane2[i]);
			background.add(trucklane3[i]);
			background.add(turtlelane6[i]);
			background.add(loglane7[i]);
			background.add(loglane10[i]);
		}
		
		frog = new Animal("file:src/p4_group_8_repo/frog/froggerUp.png");
		background.add(frog);
		
		
		
		background.start();
		start();
	}
	
	private void GameOver() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("GAME OVER...");
		alert.setHeaderText("YOU HAVE LOST THE GAME...");
		alert.setContentText("PLEASE EXIT TO MAIN MENU....");
		alert.show();
	
	}
	
	public void createTimer() {
	timer = new AnimationTimer() {
	    @Override 
	    public void handle(long now) {
	    	if (frog.lifes==0) {
				stop();
				background.stop();
				background.stopMusic();
				GameOver();
			}
	    	
	    	if (frog.lifes<updateLifes) {
	    		updateLifes=frog.lifes;
	    		background.getChildren().remove(froglives[i-1]);
	    		i--;
	    		next=0;
			}
	    	
	    	if (frog.changeScore()) {
	    		setNumber(frog.getPoints());
	    	}
	    	if (frog.getStop()) {
	    		System.out.print("STOPP:");
	    		
	    		background.stopMusic();
	    		stop();
	    		background.stop();
	    		Alert alert = new Alert(AlertType.INFORMATION);
	    		alert.setTitle("You Have Won The Game!");
	    		alert.setHeaderText("Your High Score: "+frog.getPoints()+"!");
	    		alert.setContentText("Highest Possible Score: 800");
	    		alert.show();
	    		
	    		alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("CONTINUE");
				alert.setHeaderText("CONGRATULATIONS !");
				alert.setContentText("DO YOU WANT TO TRY NEXT LEVEL ?");
				Optional<ButtonType> option = alert.showAndWait();
				
				if (option.get()==ButtonType.OK) {
					level++;
					game();
				}
				else {
					StoreData S = new StoreData(frog);
				}
	    		
	    	}
	    }
	};
	}
	
	public void start() {
		background.playMusic();
		createTimer();
		timer.start();
	}
	
	public void stop() {
		timer.stop();
	}
	
	public void setNumber(int n) {
		int shift = 0;
		while (n > 0) {
			  int d = n / 10;
			  int k = n - d * 10;
			  n = d;
			  background.add(new Digit(k, 30, 280 - shift, 25));
			  shift+=20;
		}
	}
}

