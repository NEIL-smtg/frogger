package Scene;

import java.util.Optional;

import GameAnimations.Digit;
import GameAnimations.End;
import GameAnimations.Log;
import GameAnimations.Obstacle;
import GameAnimations.Turtle;
import GameAnimations.WetTurtle;
import GameMechanics.Animal;
import GameMechanics.MenuButton;
import GameMechanics.MovingObjects;
import GameMechanics.MyStage;
import GameMechanics.ProceedtoNextLevel;
import GameMechanics.StoreData;
import GameMechanics.Time;
import Panel.GameOver;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import Background.*;

public class GameView{
	private Scene gameScene;
	private Stage gameStage;
	private MyStage background;
	private AnimationTimer timer;
	private Animal frog;
	private static final int GAME_WIDTH = 600;
	private static final int GAME_HEIGHT = 800;
	private Stage menuStage;
	private int level;
	private int orilevel;
	private int next=0;
	private int updateLifes=4;
	private int i;
	private BackgroundImage[] froglives = new BackgroundImage[4] ;
	private BackgroundImage[] time;
	private int timeSeconds;
	private int sec;
	private Timeline timeline;
	private BackgroundImage b;
	private Text timesout;
	
	public GameView(int level) {
		SpeedDecider(level);
		background = new MyStage();
		game();
		showLifes();
		showTime();
		showText(level);
		exitGame();
	}
	
	private void showLifes() {
		for ( i = 0; i < frog.lifes; i++) {
			froglives[i] =new BackgroundImage("file:src/MovingObjectResources/frog/froggerUp.png");
			froglives[i].setX(0+next);
			froglives[i].setY(750);
			background.add(froglives[i]);
			next+=40;
		}
	}
	
	//show time animation
	private void showTime() {
		Time t = new Time();
		time = t.getTimer();
		background.getChildren().addAll(time);
		timetracking();
	}

	//timer animation, time image reduce 1 by 1 as time goes by
	@SuppressWarnings({ "unchecked", "rawtypes", "static-access" })
	private void timetracking() {
		timeSeconds=15;
		timeline = new Timeline();
		timeline.setCycleCount(timeline.INDEFINITE);
		
		
		timeline.getKeyFrames().add(
				new KeyFrame(Duration.seconds(1),
						new EventHandler() {
							@Override
							public void handle(Event event) {
								//when time runs out 
								if(frog.lifes >0) {
									if (timeSeconds >0) {
										timeSeconds--;
										background.remove(time[timeSeconds]);
									}
									else {
										frog.lifes--;
										frog.setX(300);
										frog.setY(679.8+13.3333333*2); //get from animal class
										TimesOut();
										timeline.stop();
									}
								}
								else {
									background.getChildren().removeAll(time);
									timeline.stop();
								}
							}
						}));
		timeline.play();		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void TimesOut() {
		b = new BackgroundImage("file:src/resources/black border.jpg");
		b.setFitHeight(35);
		b.setFitWidth(180);
		b.setX(220);
		b.setY(440);
		
		timesout = new Text();
		timesout.setText("TIMES  OUT");
		timesout.setX(230);
		timesout.setY(470);
		fontsetup(timesout,35,Color.RED);
		
		sec=2;
		background.getChildren().addAll(b,timesout);
		
		Timeline t = new Timeline();
 		t.setCycleCount(sec);
 		
 		t.getKeyFrames().add(
 				new KeyFrame(Duration.seconds(1), new EventHandler() {

					@Override
					public void handle(Event event) {
						sec--;
						if(sec<=0) {
							background.getChildren().removeAll(b,timesout);
							t.stop();
						}
					}
				}));
 		t.playFromStart();
	
	}
	
	private void showText(int level) {
		Text lvl = new Text();
		lvl.setText("LEVEL "+level);
		lvl.setX(30);
		lvl.setY(50);
		fontsetup(lvl,35,Color.GREENYELLOW);
		
		Text timetext = new Text();
		timetext.setText("TIME ");
		timetext.setX(330);
		timetext.setY(775);
		fontsetup(timetext,35,Color.GREENYELLOW);
		
		background.getChildren().addAll(lvl,timetext);
	}
	
	private void fontsetup(Text text, int size , Color c) {
		ScreenDesign s = new ScreenDesign();
		s.fontsetup(text, 35, c);
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
					StoreData s = new StoreData();
					s.StoretoDatabase(frog);
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
						//background.stopMusic();
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
			this.level=(int) (1+level/2);
		}
		
	}

	public void createNewGame(Stage menuStage) {
		this.menuStage=menuStage;
		this.menuStage.hide();
		gameStage.show();
		
	}
	
	private void backgroundsetup() {
		BackgroundImage[] purplesafezone = new BackgroundImage[2];
		BackgroundImage blackborder = new BackgroundImage("resources/black border.jpg");
		BackgroundImage darkblue = new BackgroundImage("resources/deepblue.jpg");
		
		darkblue.setLayoutX(0);
		darkblue.setLayoutY(0);
		
		purplesafezone[0]=new BackgroundImage("resources/purple border.jpg");
		purplesafezone[1]=new BackgroundImage("resources/purple border.jpg");
		purplesafezone[0].setLayoutX(0);
		purplesafezone[0].setLayoutY(435);
		purplesafezone[1].setLayoutX(0);
		purplesafezone[1].setLayoutY(700);
		
		blackborder.setLayoutX(0);
		blackborder.setLayoutY(470);
		
		background.getChildren().addAll(darkblue,blackborder);
		background.getChildren().addAll(purplesafezone);

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
		
		//BackgroundImage froggerback = new BackgroundImage("file:src/p4_group_8_repo/Screen Shot 2017-05-29 at 10.02.14 PM.png");
		//background.add(froggerback);
		
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
			
	
		background.getChildren().addAll(carlane1);
		background.getChildren().addAll(loglane8);
		background.getChildren().addAll(turtlelane9);
		background.getChildren().addAll(carlane4);
		background.getChildren().addAll(trucklane2);
		background.getChildren().addAll(trucklane3);
		background.getChildren().addAll(loglane10);
		background.getChildren().addAll(loglane7);
		background.getChildren().addAll(turtlelane6);
		
		frog = new Animal("file:src/MovingObjectResources/frog/froggerUp.png",orilevel);
		background.add(frog);
				
		background.start();
		start();
	}
	
	private void GameOver() {
		GameOver gg = new GameOver();
		background.getChildren().addAll(gg.getpanel(gameStage) ,   gg.gameoverText() ,gg.getblinkingtext() );
	
	}
	
	public void createTimer() {
		
	timer = new AnimationTimer() {
		
	    @Override 
	    public void handle(long now) {
	    	if (frog.lifes==0) {
	    		timeline.stop();
	    		background.getChildren().removeAll(time);
				stop();
				background.stop();
				//background.stopMusic();
				GameOver();
			}
	    	
	    	if (frog.lifes<updateLifes ) {
	    		updateLifes=frog.lifes;
	    		background.remove(froglives[i-1]);
	    		i--;
	    		timeline.stop();
	    		background.getChildren().removeAll(time);
	    		showTime();
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
					orilevel++;
					
					ProceedtoNextLevel ptnl = new ProceedtoNextLevel();
					ptnl.setpoint(frog.getPoints());
					
					GameView newgame = new GameView(orilevel);
					newgame.createNewGame(gameStage);
				}
				else {
					StoreData S = new StoreData();
					S.StoretoDatabase(frog);
				}
	    		
	    	}
	    }
	};	
	}
	
	public void start() {
		//background.playMusic();
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

