package Scene;

import java.util.ArrayList;

import GameMechanics.ButtonStyle;
import GameMechanics.MyStage;
import ScreenDesign.ScreenDesign;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.stage.Stage;

//allow player to choose levels scene
public class ChooseLevels {
	
	private Scene levelScene;
	private Stage levelStage;
	private MyStage screen;
	ArrayList<Button> levelbud = new ArrayList<Button>();
	private int choosenlvl=0;
	private int pressedCnt=0;
	ScreenDesign design = new ScreenDesign();
	private int[] levelindex = new int[10];
	ButtonStyle play,back;
	
	public ChooseLevels() {
		ScreenSetup();
		createButtons();
		ButtonListener();
	}
	
	private void ScreenSetup() {
		//screen setup
		screen = new MyStage();
		levelScene=design.FixedScene(screen);
		levelStage = new Stage();
		levelStage.setScene(levelScene);
		levelStage.setTitle("CHOOSE LEVELS");
		
		//BACKGROUND IMAGE
		screen.setBackground(new Background(design.paint()));
	}
		
	private void createButtons() {
		int moveX=0,moveY=0;
		
		//using normal button to show level button, removed effect of pressed style and freestyle button
		for (int i = 1 ; i <= 10; i++) {
			Button level = new Button("LEVEL"+i);
			setButtonFont(level);
			level.setPrefWidth(150);
			level.setPrefHeight(40);
			level.setStyle("-fx-background-color: #ddd"); //grey
			level.setLayoutX(100+moveX);
			level.setLayoutY(180+moveY);
			levelbud.add(level);
			
			if ((i+1)%2==0) {
				moveX+=250;
			}
			else {
				moveX=0;
				moveY+=100;
			}
			screen.getChildren().add(level);
		}
		
		
		play = new ButtonStyle("P L A Y");
		play.setLayoutX(400);
		play.setLayoutY(20);
		play.setPrefWidth(150);
		
		
		back = new ButtonStyle("B A C K");
		back.setLayoutX(20);
		back.setLayoutY(20);
		back.setPrefWidth(150);
		
		screen.getChildren().addAll(play,back);
	}
	
	private void ButtonListener() {
		
		//set listener to each level buttons
		for (int i = 0; i < levelbud.size(); i++) {
			int j=i;
			levelbud.get(i).setOnAction(new EventHandler<ActionEvent>() {
			
				@Override
				public void handle(ActionEvent event) {
					levelbud.get(j).setStyle("-fx-background-color: #800080"); //purple
					pressedCnt++;
					levelindex[j]++;
					if (pressedCnt >1) {
						repositionButton();
						warning();
						pressedCnt=0;
					}
					
					choosenlvl=j+1;
					
				}
			});
		}
		
		//listener on play button
		play.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				if (choosenlvl !=0) {
					GameView game = new GameView(choosenlvl);
					game.createNewGame(levelStage);
				}
				else {
					warning();
				}
			}
		});
		
		
		//listener on back button
		back.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				EnterName enter = new EnterName();
				enter.newScene();
				levelStage.close();
			}
		});
			
	}
	
	private void repositionButton() {
		
		for (int i = 0; i < levelindex.length; i++) {
			if (levelindex[i] >=1 ) {
				levelbud.get(i).setStyle("-fx-background-color: #ddd");
				levelindex[i]=0;
				
				choosenlvl=0;
			}
			
		}
	}
		
	private void warning()
	{
		//create warning alert to remind player can only choose 1 level to play
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("WARNING");
		alert.setHeaderText("CHOOSE ONLY ONE LEVEL TO PLAY !");
		alert.setContentText("PLEASE RESELECT THE LEVEL !");
		alert.showAndWait();
	}

	public void NewScene(Stage menuStage) {
		//close previous window and open this window
		menuStage.hide();
		levelStage.show();
	}
		
	private void setButtonFont(Button b) {
		design.buttonfontsetup(b, 28);
	}
	
	
	
}
