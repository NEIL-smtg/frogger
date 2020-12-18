package Main;

import Scene.Menu;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	
		Menu menu = new Menu();
		primaryStage = menu.getMainStage();
		primaryStage.show();
	
	}
}

