package viewManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.menuButton;

public class highscore {
	private Text text;
	private int i=0,j,k=i;
	private Scene highscoreScene;
	private Stage highscoreStage;
	private AnchorPane mainPane;
	private static final int WIDTH = 600;
	private static final int HEIGHT = 800;
	
	public highscore() {
		mainPane = new AnchorPane();
		highscoreScene=new Scene(mainPane,WIDTH,HEIGHT);
		highscoreStage = new Stage();
		highscoreStage.setScene(highscoreScene);
		createBackground();
		ScreenDesign();
		addlist();
	}
	
	
	private void ScreenDesign() {
		ImageView highscorelogo = new ImageView("viewManager/highscorelogo2.png");
		highscorelogo.setLayoutX(100);
		highscorelogo.setLayoutY(120);
		
		ImageView rank = new ImageView("viewManager/rsz_1rank.jpg");
		rank.setLayoutX(20);
		rank.setLayoutY(180);
		
		ImageView score = new ImageView("viewManager/rsz_score.jpg");
		score.setLayoutX(400);
		score.setLayoutY(180);
		
		ImageView name = new ImageView("viewManager/rsz_name.jpg");
		name.setLayoutX(200);
		name.setLayoutY(180);
		
		menuButton button = new menuButton("<-BACK");
		button.setLayoutX(20);
		button.setLayoutY(20);
		button.setPrefWidth(150);
		button.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				viewManager.mainStage.show();
				highscoreStage.close();
			}
		});
		
		
		mainPane.getChildren().addAll(highscorelogo,rank,score,name,button);
	}
	
	private void addlist() {
		text = new Text();
		j=1;
		try {
			File scorelist = new File("src/viewManager/HighScoreDatabase.txt");
			Scanner reader = new Scanner(scorelist);
			while (reader.hasNextLine() ) {
				String score = reader.nextLine();
				showlist(j,score);	
				j++;
			}
			File namelist = new File("src/viewManager/NameDatabase.txt");
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
		mainPane.getChildren().addAll(text);
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
		mainPane.getChildren().addAll(text,text2);
	}
	
	private void fontsetup(Text text) {
		try {
			text.setFont(Font.loadFont("file:src/model/ARCADECLASSIC.TTF", 35));
			text.setFill(Color.RED);
			
		} catch (Exception e) {
			text.setFont(Font.font("Verdana",23));
		}
	}

	public void createNewWindow() {
		viewManager.mainStage.hide();
		highscoreStage.show();
		
	}
	
	private void createBackground() {
		Image backgroundImage = new Image("viewManager/newback.jpg",300,300,false,true);
		BackgroundImage background = new BackgroundImage(backgroundImage,BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,null);
		mainPane.setBackground(new Background(background));
	}

	
}
