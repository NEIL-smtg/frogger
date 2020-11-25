package p4_group_8_repo;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.stage.Stage;

public class GameView  {
	private Scene gameScene;
	private Stage gameStage;
	AnimationTimer timer;
	MyStage background;
	Animal animal;
	
	private static final int GAME_WIDTH = 600;
	private static final int GAME_HEIGHT = 800;
	
	private Stage menuStage;
	
	public GameView() {
		background = new MyStage();
		game();
		exitGame();
	}

	private void exitGame() {
		MenuButton exit = new MenuButton("EXIT");
		exit.setLayoutX(10);
		exit.setLayoutY(10);
		exit.setPrefHeight(50);
		exit.setPrefWidth(120);
		exit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				background.stop();
				background.stopMusic();
				Menu.mainStage.show();
				gameStage.close();
			}
			
		});
		
		background.getChildren().add(exit);
	}
	

	public void createNewGame(Stage menuStage) {
		this.menuStage=menuStage;
		this.menuStage.hide();
		gameStage.show();
		
	}
	
	private void game() {
		
		gameScene=new Scene(background,GAME_WIDTH,GAME_HEIGHT);
		gameStage = new Stage();
		gameStage.setScene(gameScene);
		//Obstacle obstacle = new Obstacle("file:src/p4_group_8_repo/truck1Right.png", 25, 25, 3);
		//Obstacle obstacle1 = new Obstacle("file:src/p4_group_8_repo/truck2Right.png", 100, 100,2 );
		//Obstacle obstacle2 = new Obstacle("file:src/p4_group_8_repo/truck1Right.png",0,  150, 1);
		
		BackgroundImage froggerback = new BackgroundImage("file:src/p4_group_8_repo/Screen Shot 2017-05-29 at 10.02.14 PM.png");
		background.add(froggerback);
		BackgroundImage back = new BackgroundImage("p4_group_8_repo/darkpurple.jpg");
		background.add(back);
		
		background.add(new Log("file:src/p4_group_8_repo/log/log3.png", 150, 0, 166, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/log/log3.png", 150, 220, 166, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/log/log3.png", 150, 440, 166, 0.75));
		//background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 0, 166, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/log/logs.png", 300, 0, 276, -2));
		background.add(new Log("file:src/p4_group_8_repo/log/logs.png", 300, 400, 276, -2));
		//background.add(new Log("file:src/p4_group_8_repo/logs.png", 300, 800, 276, -2));
		background.add(new Log("file:src/p4_group_8_repo//log/log3.png", 150, 50, 329, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/log/log3.png", 150, 270, 329, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/log/log3.png", 150, 490, 329, 0.75));
		//background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 570, 329, 0.75));

		background.add(new Turtle(500, 376, -1, 130, 130));
		background.add(new Turtle(300, 376, -1, 130, 130));
		background.add(new WetTurtle(700, 376, -1, 130, 130));
		background.add(new WetTurtle(600, 217, -1, 130, 130));
		background.add(new WetTurtle(400, 217, -1, 130, 130));
		background.add(new WetTurtle(200, 217, -1, 130, 130));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 100, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 0, 100, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 120, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 120, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 140, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 140, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 160, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 300, 160, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 180, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 180, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 200, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 200, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 220, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 220, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 400, 220, 1));
		//End end2 = new End();
		//End end3 = new End();
		//End end4 = new End();
		//End end5 = new End();
		background.add(new End(13,96));
		background.add(new End(141,96));
		background.add(new End(141 + 141-13,96));
		background.add(new End(141 + 141-13+141-13+1,96));
		background.add(new End(141 + 141-13+141-13+141-13+3,96));
		animal = new Animal("file:src/p4_group_8_repo/frog/froggerUp.png");
		background.add(animal);
		background.add(new Obstacle("file:src/p4_group_8_repo/truck/truck1"+"Right.png", 0, 649, 1, 120, 120));
		background.add(new Obstacle("file:src/p4_group_8_repo/truck/truck1"+"Right.png", 300, 649, 1, 120, 120));
		background.add(new Obstacle("file:src/p4_group_8_repo/truck/truck1"+"Right.png", 600, 649, 1, 120, 120));
		//background.add(new Obstacle("file:src/p4_group_8_repo/truck1"+"Right.png", 720, 649, 1, 120, 120));
		background.add(new Obstacle("file:src/p4_group_8_repo/car/car1Left.png", 100, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/p4_group_8_repo/car/car1Left.png", 250, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/p4_group_8_repo/car/car1Left.png", 400, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/p4_group_8_repo/car/car1Left.png", 550, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/p4_group_8_repo/truck/truck2Right.png", 0, 540, 1, 200, 200));
		background.add(new Obstacle("file:src/p4_group_8_repo/truck/truck2Right.png", 500, 540, 1, 200, 200));
		background.add(new Obstacle("file:src/p4_group_8_repo/car/car1Left.png", 500, 490, -5, 50, 50));
		background.add(new Digit(0, 30, 280, 25));
		//background.add(obstacle);
		//background.add(obstacle1);
		//background.add(obstacle2);
		background.start();
		//primaryStage.setScene(scene);
		//primaryStage.show();
		start();  
	}


	

	public void createTimer() {
	timer = new AnimationTimer() {
	    @Override
	    public void handle(long now) {
	    	if (animal.changeScore()) {
	    		setNumber(animal.getPoints());
	    	}
	    	if (animal.getStop()) {
	    		System.out.print("STOPP:");
	    		background.stopMusic();
	    		stop();
	    		background.stop();
	    		Alert alert = new Alert(AlertType.INFORMATION);
	    		alert.setTitle("You Have Won The Game!");
	    		alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
	    		alert.setContentText("Highest Possible Score: 800");
	    		alert.show();
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
			  shift+=30;
		}
	}
}

