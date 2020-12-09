package Scene;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Background.ScreenDesign;
import GameMechanics.MenuButton;
import GameMechanics.MyStage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class HighScore {
	private int i=0,j,k=i;
	private Scene highscoreScene;
	private Stage highscoreStage;
	MyStage screen;
	private static final int WIDTH = 600;
	private static final int HEIGHT = 800;
	
	public HighScore() {
		screen= new MyStage();
		highscoreScene=new Scene(screen,WIDTH,HEIGHT);
		highscoreStage = new Stage();
		highscoreStage.setScene(highscoreScene);
		
		//create background
		ScreenDesign design = new ScreenDesign();
		screen.setBackground(new Background(design.paint()));
		
		ScreenDesign();
		addlist();
	}
	
	
	private void ScreenDesign() {
		ImageView highscorelogo = new ImageView("file:src/resources/highscorelogo2.png");
		highscorelogo.setLayoutX(100);
		highscorelogo.setLayoutY(120);
		
		ImageView rank = new ImageView("file:src/resources/rank.jpg");
		rank.setLayoutX(20);
		rank.setLayoutY(180);
		
		ImageView score = new ImageView("file:src/resources/score.jpg");
		score.setLayoutX(400);
		score.setLayoutY(180);
		
		ImageView name = new ImageView("file:src/resources/name.jpg");
		name.setLayoutX(200);
		name.setLayoutY(180);
		
		MenuButton button = new MenuButton("<-BACK");
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
	
	private void addlist() {
		new Text();
		j=1;
		try {
			File scorelist = new File("HighScoreDatabase.txt");
			Scanner reader = new Scanner(scorelist);
			while (reader.hasNextLine() ) {
				String score = reader.nextLine();
				showlist(j,score);	
				j++;
			}
			File namelist = new File("NameDatabase.txt");
			reader = new Scanner(namelist);
			while (reader.hasNextLine() ) {
				String name = reader.nextLine();
				shownamelist(name);	
				
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("FILE NOT FOUND.");
			e.printStackTrace();
		}	
		
	}
	
	private void shownamelist(String name) {
		Text text = new Text();
		text.setText(name);
		text.setX(210);
		text.setY(230+k);
		k+=35;
		fontsetup(text);
		screen.getChildren().add(text);
	}


	private void showlist(int j,String score) {
		Text text = new Text();
		text.setText(Integer.toString(j));
		text.setX(40);
		text.setY(230+i);
		
		Text text2 = new Text();
		text2.setText(score);
		text2.setX(400);
		text2.setY(230+i);
		i+=35;
		fontsetup(text);
		fontsetup(text2);
		screen.getChildren().addAll(text,text2);
	}
	
	private void fontsetup(Text text) {
		try {
			text.setFont(Font.loadFont("file:src/resources/ARCADECLASSIC.TTF", 35));
			text.setFill(Color.RED);
			
		} catch (Exception e) {
			text.setFont(Font.font("Verdana",23));
		}
	}

	public void createNewWindow() {
		Menu.mainStage.hide();
		highscoreStage.show();
		
	}

}
