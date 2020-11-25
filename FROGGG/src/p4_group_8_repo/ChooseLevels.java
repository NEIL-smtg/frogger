package p4_group_8_repo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

//allow player to choose levels scene
public class ChooseLevels {
	private Scene gameScene;
	private Stage gameStage;
	MyStage background;
	private static final int GAME_WIDTH = 600;
	private static final int GAME_HEIGHT = 800;
	
	
	ChooseLevels(){
		background =new MyStage();
		gameScene=new Scene(background,GAME_WIDTH,GAME_HEIGHT);
		gameStage = new Stage();
		gameStage.setScene(gameScene);
		BackgroundImage back = new BackgroundImage("viewManager/newback.jpg");
		back.resize(200, 200);
		background.add(back);
		addbutton();
	}
	
	public void NewScene(Stage menuStage) {
		menuStage.hide();
		gameStage.show();
		
	}
	
	private void addbutton() {
		
		MenuButton play = new MenuButton("PLAY");
		play.setLayoutX(240);
		play.setLayoutY(280);
		play.setPrefWidth(150);
		play.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				GameView game = new GameView();
				game.createNewGame(gameStage);
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
