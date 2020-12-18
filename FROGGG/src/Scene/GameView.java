package Scene;

import java.util.Optional;

import Database.Database;
import GameAnimations.Crocodile;
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
import GameMechanics.SoundEffect;
import GameMechanics.SpeedDecider;
import GameMechanics.Time;
import Panel.EndGame;
import ScreenDesign.*;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameView{
	private Scene gameScene;
	private Stage gameStage;
	private MyStage screen;
	private AnimationTimer timer;
	private Animal frog;
	private static final int GAME_WIDTH = 600;
	private static final int GAME_HEIGHT = 800;
	private Stage menuStage;
	private int level;
	private int speed;
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
	Database db = new Database();
	SoundEffect effect = new SoundEffect();
	
	public GameView(int level) {
		this.level=level;	
		SpeedDecider(level);
		screen = new MyStage();
		ScreenSetup();
		game();
		showLifes();
		showTime();
		exitGame();
	}
	
	private void SpeedDecider(int level) {
		
		SpeedDecider sd = new SpeedDecider(level);
		speed=sd.getspeed();
	}
		
	private void ScreenSetup() {
		gameScene=new Scene(screen,GAME_WIDTH,GAME_HEIGHT);
		gameStage = new Stage();
		gameStage.setScene(gameScene);
		
		BackgroundImage[] purplesafezone = new BackgroundImage[3];
		BackgroundImage blackborder = new BackgroundImage("resources/black border.jpg");
		BackgroundImage darkblue = new BackgroundImage("resources/deepblue.jpg");
		
		darkblue.setLayoutX(0);
		darkblue.setLayoutY(0);
		
		purplesafezone[0]=new BackgroundImage("resources/purple border.jpg");
		purplesafezone[1]=new BackgroundImage("resources/purple border.jpg");
		purplesafezone[2]=new BackgroundImage("resources/purple border.jpg");
		purplesafezone[0].setLayoutX(0);
		purplesafezone[0].setLayoutY(435);
		purplesafezone[1].setLayoutX(0);
		purplesafezone[1].setLayoutY(700);
		purplesafezone[2].setLayoutX(0);
		purplesafezone[2].setLayoutY(80);
		purplesafezone[2].setFitHeight(65);;
		
		blackborder.setLayoutX(0);
		blackborder.setLayoutY(470);
		
		Text lvl = new Text();
		lvl.setText("LEVEL "+level);
		lvl.setX(20);
		lvl.setY(50);
		fontsetup(lvl,35,Color.YELLOW);
		
		Text timetext = new Text();
		timetext.setText("TIME ");
		timetext.setX(180);
		timetext.setY(775);
		fontsetup(timetext,18,Color.GREENYELLOW);
		
		Text highscore = new Text();
		highscore.setText("HI SCORE");
		highscore.setX(220);
		highscore.setY(35);
		fontsetup(highscore , 20 , Color.MEDIUMVIOLETRED);
		
		screen.getChildren().addAll(darkblue,blackborder);
		screen.getChildren().addAll(purplesafezone);
		screen.getChildren().addAll(lvl,timetext,highscore);	
		

	}
	
	private void game(){
		
		MovingObjects o = new MovingObjects(speed );
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
		
		screen.add(new Digit(0, 30, 250+50, 33));
		
		if (level<=3) {
			screen.add(new End(141,86));
			screen.add(new End(398,86));
		}
		else if (level >=4 && level<=6) {
			screen.add(new End(111,86));
			screen.add(new End(269,86));
			screen.add(new End(420,86));
		}
		else if (level==7 || level==8) {
			screen.add(new End(90,86));
			screen.add(new End(218,86));
			screen.add(new End(346,86));
			screen.add(new End(475,86));
		}
		else {
			screen.add(new End(13,86));
			screen.add(new End(141,86));
			screen.add(new End(269,86));
			screen.add(new End(398,86));
			screen.add(new End(525,86));
		}
			
	
		screen.getChildren().addAll(carlane1);
		screen.getChildren().addAll(trucklane2);
		screen.getChildren().addAll(trucklane3);
		screen.getChildren().addAll(carlane4);
		screen.getChildren().addAll(turtlelane6);
		screen.getChildren().addAll(loglane7);
		screen.getChildren().addAll(loglane8);
		screen.getChildren().addAll(turtlelane9);	
		screen.getChildren().addAll(loglane10);
			
		frog = new Animal("file:src/MovingObjectResources/frog/froggerUp.png",speed,level);
		screen.add(frog);
				
		if (level >=4) {
			screen.add(new Crocodile(level));
		}
		
		screen.start();
		start();
	}
	

	private void showLifes() {
		//show frog lifes on screen
		for ( i = 0; i < frog.lifes; i++) {
			froglives[i] =new BackgroundImage("file:src/MovingObjectResources/frog/froggerUp.png");
			froglives[i].setX(0+next);
			froglives[i].setY(750);
			screen.add(froglives[i]);
			next+=40;
		}
	}
	
	private void showTime() {
		//show time animation
		Time t = new Time();
		time = t.getTimer();
		screen.getChildren().addAll(time);
		timetracking();
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "static-access" })
	private void timetracking() {
		
	//timer animation, time image reduce 1 by 1 as time goes by
		timeSeconds=30;
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
										screen.remove(time[timeSeconds]);
										if (timeSeconds==8) {
											effect.TimeRunsOut();
										}
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
									screen.getChildren().removeAll(time);
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
		screen.getChildren().addAll(b,timesout);
		
		Timeline t = new Timeline();
 		t.setCycleCount(sec);
 		
 		t.getKeyFrames().add(
 				new KeyFrame(Duration.seconds(1), new EventHandler() {

					@Override
					public void handle(Event event) {
						sec--;
						if(sec<=0) {
							screen.getChildren().removeAll(b,timesout);
							t.stop();
						}
					}
				}));
 		t.playFromStart();
	
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
						screen.stop();
						screen.stopMusic();
						Menu.mainStage.show();
						gameStage.close();
					
					}
			}
			
		});
		
		screen.getChildren().add(exit);
	}

	public void createNewGame(Stage menuStage) {
		this.menuStage=menuStage;
		this.menuStage.hide();
		gameStage.show();
		
	}
	
	private void GameOver() {
		boolean duplicate;
		duplicate = db.checkDuplicateName();
		EndGame gg = new EndGame(frog);
		screen.getChildren().addAll(gg.getpanel(gameStage) ,   gg.gameoverText() ,gg.gameOverblinkingtext());
		
		if (duplicate==false) {
			db.StoretoDatabase(frog.getPoints());
		}
		else {
			db.changeData(frog.getPoints());
			
		}
		
		
	}
	
	public void createTimer() {
		timer = new AnimationTimer() {
			
		    @Override 
		    public void handle(long now) {
		    	if (frog.lifes==0) {
		    		timeline.stop();
		    		screen.getChildren().removeAll(time);
					stop();
					screen.stop();
					screen.stopMusic();
					GameOver();
				}
		    	
		    	if (frog.lifes<updateLifes ) {
		    		updateLifes=frog.lifes;
		    		screen.remove(froglives[i-1]);
		    		i--;
		    		timeline.stop();
		    		screen.getChildren().removeAll(time);
		    		showTime();
				}
		    	
		    	
		    	if (frog.changeScore()) {
		    		setNumber(frog.getPoints());
		    	}
		    	if (frog.getStop()) {
		    		System.out.print("STOPP:");
		    		screen.stopMusic();
		    		stop();
		    		screen.stop();
		    		timeline.stop();
		    		GameWon();
		    	}
		    }
		};	
	}
	
	private void GameWon() {
		boolean duplicate;
		duplicate = db.checkDuplicateName();
		
		if (duplicate==false) {
			db.StoretoDatabase(frog.getPoints());
		}
		else {
			db.changeData(frog.getPoints());
		}
		
		//display the panel when player wins the level
		EndGame won = new EndGame(frog);
		BackgroundImage panel = won.getpanel(gameStage);
		
		screen.getChildren().add(panel);
		screen.getChildren().add(won.gameWonblinkingtext());
		screen.getChildren().add(won.escText());
		screen.getChildren().add(won.gameWonText(frog));
		
		panel.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if (event.getCode()==KeyCode.ESCAPE) {
					Menu.mainStage.show();
					gameStage.close();
				}
				else if (event.getCode()==KeyCode.G) {
					level++;
					GameView newgame = new GameView(level);
					newgame.createNewGame(gameStage);
				}
			}

		});

	}
	
	public void start() {
		screen.playMusic();
		createTimer();
		timer.start();
	}
	
	public void stop() {
		timer.stop();
	}
	
	public void setNumber(int n) {  
		int shift = 25;	

		int d =n ;
		if (n> 0) {
			int k;
			
			if (d >= 100) {
				k = d/100;
				screen.add(new Digit(k, 30, 250 , 33));
				d -= k*100;
			}
			else {
				screen.add(new Digit(0, 30, 250 , 33));
			}
			
			if(d < 100) {
				k= d/10;
				screen.add(new Digit(k, 30, 250 +shift, 33));
				d -= k*10;	
				screen.add(new Digit(d, 30, 250 +2*shift, 33));
			}
			
		}		
	}		
}
	


