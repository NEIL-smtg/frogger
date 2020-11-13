package viewManager;


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
import model.menuButton;

public class viewManager {
	
	private static final int HEIGHT =800;
	private static final int WIDTH = 600;
	private AnchorPane mainPane;
	private Scene mainScene;
	public static Stage mainStage;
	
	List<menuButton> mButtons;
	
	public viewManager() {
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
	
	private void addMenuButton(menuButton button) {
		
		button.setLayoutX(170);
		button.setLayoutY(300 + mButtons.size()*100);
		mButtons.add(button);
		mainPane.getChildren().add(button);
	}
	
	
	
	private void createStartButton() {
		menuButton startButton = new menuButton("PLAY");
		addMenuButton(startButton);
		
		startButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				GameView game = new GameView();
				game.createNewGame(mainStage);
			}
			
		});
		
	}
	
	private void createScoreButton() {
		menuButton scoreButton = new menuButton("HIGH SCORES");
		addMenuButton(scoreButton);
		
		scoreButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				highscore score = new highscore();
				score.createNewWindow();
			}
			
		});
	}
	
	private void createHelpButton() {
		menuButton helpButton = new menuButton("HELP");
		addMenuButton(helpButton);
	}
	
	private void createExitButton() {
		menuButton exit = new menuButton("EXIT");
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
