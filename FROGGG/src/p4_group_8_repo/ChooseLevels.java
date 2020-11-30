package p4_group_8_repo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.text.Font;
import javafx.stage.Stage;

//allow player to choose levels scene
public class ChooseLevels {
	private Scene gameScene;
	private Stage gameStage;
	MyStage background;
	private static final int GAME_WIDTH = 600;
	private static final int GAME_HEIGHT = 800;
	ArrayList<Button> levelbud = new ArrayList<Button>();
	private int choosenlvl=0;
	private int pressedCnt=0;
	
	ChooseLevels(){
		background =new MyStage();
		gameScene=new Scene(background,GAME_WIDTH,GAME_HEIGHT);
		gameStage = new Stage();
		gameStage.setScene(gameScene);
		createBackground();
		addbutton();
		levelButtons();
		
	}
	
	private void setButtonFont(Button b) {
		try {
			b.setFont(Font.loadFont(new FileInputStream("file:src/model/ARCADECLASSIC.TTF"),35));
		}catch(FileNotFoundException e) {
			b.setFont(Font.font("Verdana",23));
		}	
	}
	
	private void levelButtons() {
		int moveX=0,moveY=0;
		
		for (int i = 1 ; i <= 10; i++) {
			Button level = new Button("LEVEL"+i);
			setButtonFont(level);
			level.setPrefWidth(150);
			level.setPrefHeight(40);
			level.setStyle("-fx-background-color: #ddd");
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
			background.addbutton(level);
		}
		
		for (int i = 0 ; i < levelbud.size(); i++) {
			int j=i;
			levelbud.get(i).setOnAction(new EventHandler<ActionEvent>() {		
				@Override
				public void handle(ActionEvent event) {
					levelbud.get(j).setStyle("-fx-background-color: #800080");	
					pressedCnt++;
					choosenlvl=j+1;
					if (pressedCnt>1) {
						warning();
						pressedCnt=0;
						choosenlvl=0;
						levelButtons();
					}				
				}
			});
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
		Image backgroundImage = new Image("viewManager/newback.jpg",300,300,false,true);
		BackgroundImage back = new BackgroundImage(backgroundImage,BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,null);
		background.setBackground(new Background(back));
	}
	
	private void addbutton() {
		
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
		background.addbutton(play);
		background.addbutton(back);
	}
	
}
