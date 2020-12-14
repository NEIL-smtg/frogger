package Scene;

import java.util.ArrayList;
import java.util.List;

import GameMechanics.MenuButton;
import GameMechanics.MyStage;
import ScreenDesign.BackgroundImage;
import ScreenDesign.ScreenDesign;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Menu{
	MyStage screen;
	private Scene mainScene;
	public static Stage mainStage;
	ScreenDesign design = new ScreenDesign();
	List<MenuButton> mButtons;
	MenuButton startButton;
	MenuButton exitButton;
	MenuButton helpButton;
	MenuButton highscoreButton;
	BackgroundImage logo;
	
	public Menu() {
		ScreenSetup();
		mButtons = new ArrayList<>();
		createlogo();
		createButtons();
		ActionListener();
	}
	
	public void ScreenSetup() {
		//screen setup
		screen = new MyStage();
		mainScene=design.FixedScene(screen);
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		mainStage.setTitle("MENU");		
		
		//create background		
		screen.setBackground(new Background(design.paint()));
	}

	public Stage getMainStage() {
		return mainStage;
	}
	
	private void addMenuButton(MenuButton button) {
		//set position of each buttons
		//changed y position of buttons everytime add button into screen
		
		button.setLayoutX(170);
		button.setLayoutY(300 + mButtons.size()*100);
		mButtons.add(button);
		screen.getChildren().add(button);
	}
	
	private void createButtons() {
		//this method is creating buttons in menu
		// then,  add the buttons into the list
		
		startButton = new MenuButton("P L A Y");
		addMenuButton(startButton);
		
		highscoreButton = new MenuButton("HIGH  SCORES");
		addMenuButton(highscoreButton);
		
		helpButton = new MenuButton("H E L P");
		addMenuButton(helpButton);
		
		exitButton = new MenuButton("E X I T");
		addMenuButton(exitButton);
				
	}
	
	private void createlogo() {
		logo = new BackgroundImage("file:src/resources/logo2.png");
		logo.setLayoutX(50);
		logo.setLayoutY(50);
		screen.getChildren().add(logo);
	}
	
	public void ActionListener() {
		//set action listener on each button 
		
		startButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				EnterName name = new EnterName();
				name.newScene();
			}
		});
		
		highscoreButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				HighScore score = new HighScore();
				score.createNewWindow();
			}
			
		});
		
		helpButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Help help = new Help();
				help.helpScene();
			}
			
		});
		
		exitButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				mainStage.close();
			}
			
		});
		
		//set effect when mouse pointing the logo
		logo.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				DropShadow ds = new DropShadow();
				ds.setColor(Color.ANTIQUEWHITE);
				logo.setEffect(ds);
			}
					
		});
				
		//remove effect when mouse not pointing it
		logo.setOnMouseExited(new EventHandler<MouseEvent>() {
	
			@Override
			public void handle(MouseEvent event) {
				logo.setEffect(null);
			}			
		});
	}
}
