package Scene;

import java.util.ArrayList;
import GameMechanics.Database;
import GameMechanics.MenuButton;
import GameMechanics.MyStage;
import ScreenDesign.BackgroundImage;
import ScreenDesign.ScreenDesign;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class HighScore {
	private Scene highscoreScene;
	private Stage highscoreStage;
	private MyStage screen;
	ScreenDesign design = new ScreenDesign();
	Database db = new Database();
	private int gap=0;
	
	public HighScore() {
		ScreenSetup();
		createGraphics();
		getData();
	}
		
	private void ScreenSetup() {
		//screen setup	
		screen = new MyStage();
		highscoreScene=design.FixedScene(screen);
		highscoreStage = new Stage();
		highscoreStage.setScene(highscoreScene);
		highscoreStage.setTitle("HIGH SCORE");
		
		//create background
		screen.setBackground(new Background(design.paint()));
	}
	
	private void createGraphics() {
		BackgroundImage highscorelogo = new BackgroundImage("file:src/resources/highscorelogo2.png");
		highscorelogo.setLayoutX(100);
		highscorelogo.setLayoutY(120);
		
		BackgroundImage rank = new BackgroundImage("file:src/resources/rank.jpg");
		rank.setLayoutX(20);
		rank.setLayoutY(180);
		
		BackgroundImage score = new BackgroundImage("file:src/resources/score.jpg");
		score.setLayoutX(400);
		score.setLayoutY(180);
		
		BackgroundImage name = new BackgroundImage("file:src/resources/name.jpg");
		name.setLayoutX(200);
		name.setLayoutY(180);
		
		MenuButton button = new MenuButton("B A C K");
		button.setLayoutX(20);
		button.setLayoutY(20);
		button.setPrefWidth(150);
		button.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				Menu.mainStage.show();
				highscoreStage.close();
			}
		});	
		screen.getChildren().addAll(highscorelogo,rank,score,name,button);
	}
	
	private void getData() {
		ArrayList<String> namelist = db.getNameDatabase();
		ArrayList<String> scorelist = db.getScoreDatabase();
		
		for (int i = 0; i < namelist.size(); i++) {
			printdata((i+1),namelist.get(i),scorelist.get(i));
		}
		
	}
	
	private void printdata(int j, String dbname, String dbscore) {
		Text index = new Text();
		Text name = new Text();
		Text score = new Text();
		
		index.setText(Integer.toString(j));
		name.setText(dbname);
		score.setText(dbscore.toString());
		
		fontsetup(index, 35, Color.RED);
		fontsetup(name, 35, Color.RED);
		fontsetup(score, 35, Color.RED);
		
		index.setX(40);
		index.setY(230+gap);
		
		name.setX(210);
		name.setY(230+gap);
		
		score.setX(420);
		score.setY(230+gap);
		
		screen.getChildren().addAll(index);
		screen.getChildren().addAll(name);
		screen.getChildren().addAll(score);
	
		gap+=35;
	}
	
	private void fontsetup(Text text, int size , Color c) {
		ScreenDesign s = new ScreenDesign();
		s.fontsetup(text, 35, c);
	}

	public void createNewWindow() {
		Menu.mainStage.hide();
		highscoreStage.show();	
	}

}
