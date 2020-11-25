package p4_group_8_repo;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Menu {
	private static final int HEIGHT =800;
	private static final int WIDTH = 600;
	private AnchorPane mainPane;
	private Scene mainScene;
	public static Stage mainStage;
	
	List<MenuButton> mButtons;
	
	public Menu() {
		mButtons = new ArrayList<>();
		mainPane= new AnchorPane();
		mainScene = new Scene(mainPane,WIDTH,HEIGHT);
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		createlogo();
		createBackground();
		createButtons();
	
	}

	public Stage getMainStage() {
		return mainStage;
	}
	
	private void createButtons() {
		createStartButton();
		createScoreButton();
		createHelpButton();
		createExitButton();
	}
	
	private void addMenuButton(MenuButton button) {
		
		button.setLayoutX(170);
		button.setLayoutY(300 + mButtons.size()*100);
		mButtons.add(button);
		mainPane.getChildren().add(button);
	}
	
	
	
	private void createStartButton() {
		MenuButton startButton = new MenuButton("PLAY");
		addMenuButton(startButton);
		
		startButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				EnterName input = new EnterName();
				input.inputScene();
			}
			
		});
		
	}
	
	private void createScoreButton() {
		MenuButton scoreButton = new MenuButton("HIGH SCORES");
		addMenuButton(scoreButton);
		
		scoreButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				HighScore score = new HighScore();
				score.createNewWindow();
			}
			
		});
	}
	
	private void createHelpButton() {
		MenuButton helpButton = new MenuButton("HELP");
		addMenuButton(helpButton);
	}
	
	private void createExitButton() {
		MenuButton exit = new MenuButton("EXIT");
		addMenuButton(exit);
		
		exit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				mainStage.close();
			}
			
		});
	}
	
	private void createlogo() {
		ImageView logo = new ImageView("viewManager/logo2.png");
		logo.setLayoutX(50);
		logo.setLayoutY(50);
		
		logo.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				DropShadow ds = new DropShadow();
				ds.setColor(Color.ANTIQUEWHITE);
				logo.setEffect(ds);
			}
			
		});
		
		logo.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				logo.setEffect(null);
			}
			
		});
		
		mainPane.getChildren().add(logo);
	}
	
	private void createBackground() {
		Image backgroundImage = new Image("viewManager/newback.jpg",300,300,false,true);
		BackgroundImage background = new BackgroundImage(backgroundImage,BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,null);
		mainPane.setBackground(new Background(background));
	}
}
