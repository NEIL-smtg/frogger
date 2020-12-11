package Scene;

import java.util.ArrayList;

import Background.ScreenDesign;
import GameMechanics.MenuButton;
import GameMechanics.MyStage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.stage.Stage;

//allow player to choose levels scene
public class ChooseLevels {
	
	private Scene gameScene;
	private Stage gameStage;
	MyStage screen;
	private static final int GAME_WIDTH = 600;
	private static final int GAME_HEIGHT = 800;
	ArrayList<Button> levelbud = new ArrayList<Button>();
	int choosenlvl=0;
	int pressedCnt=0;
	ScreenDesign s = new ScreenDesign();
	int[] levelindex = new int[10];
	
	ChooseLevels(){
		screen =new MyStage();
		gameScene=new Scene(screen,GAME_WIDTH,GAME_HEIGHT);
		gameStage = new Stage();
		gameStage.setScene(gameScene);
		
		createBackground();
		otherbutton();
		levelButtons();	
	}
		
	private void levelButtons() {
		int moveX=0,moveY=0;
		
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
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("WARNING");
		alert.setHeaderText("CHOOSE ONLY ONE LEVEL TO PLAY !");
		alert.setContentText("PLEASE RESELECT THE LEVEL !");
		alert.showAndWait();
	}

	public void NewScene(Stage menuStage) {
		menuStage.hide();
		gameStage.show();
	}
	
	private void createBackground() {
		BackgroundImage b = s.paint();
		screen.setBackground(new Background(b));
	}
	
	private void setButtonFont(Button b) {
		s.buttonfontsetup(b, 28);
	}
	
	private void otherbutton() {
		
		MenuButton play = new MenuButton("PLAY ->");
		play.setLayoutX(400);
		play.setLayoutY(20);
		play.setPrefWidth(150);
		play.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				if (choosenlvl !=0) {
					GameView game = new GameView(choosenlvl);
					game.createNewGame(gameStage);
				}
				else {
					warning();
				}
			}
		});
		
		MenuButton back = new MenuButton("<-BACK");
		back.setLayoutX(20);
		back.setLayoutY(20);
		back.setPrefWidth(150);
		back.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				EnterName enter = new EnterName();
				enter.inputScene();
				gameStage.close();
			}
		});
		
		screen.getChildren().addAll(play,back);
	}
	
}
