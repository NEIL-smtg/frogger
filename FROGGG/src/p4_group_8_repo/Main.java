package p4_group_8_repo;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//viewManager manager = new viewManager();
		Menu menu = new Menu();
		primaryStage = menu.getMainStage();
		//primaryStage = manager.getMainStage();
		primaryStage.show();
		
				
	}
}

