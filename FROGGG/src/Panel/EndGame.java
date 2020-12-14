package Panel;

import GameMechanics.Animal;
import GameMechanics.Database;
import Scene.Menu;
import ScreenDesign.BackgroundImage;
import ScreenDesign.ScreenDesign;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class EndGame {
	BackgroundImage ggPanel;
	boolean won;
	Database db= new Database();
	
	public EndGame(boolean won){
		this.won=won;
	}
	
	//create black panel when game end
	public BackgroundImage getpanel(Stage currentStage) {
		ggPanel = new BackgroundImage("file:src/resources/black border.jpg");
		ggPanel.setFitHeight(300);
		ggPanel.setFitWidth(350);
		ggPanel.setX(120);
		ggPanel.setY(150);
		keylistener(currentStage);
		return ggPanel;
	}
	
	public Text gameWonblinkingtext() {
		Text t = new Text();
		t.setText("HIT  ! G !  TO   TRY  NEXT LEVEL");
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), t);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        fadeTransition.setCycleCount(Animation.INDEFINITE);
        fadeTransition.play();
		t.setLayoutX(160);
		t.setLayoutY(320);
		
		ScreenDesign s = new ScreenDesign();
		s.fontsetup(t, 20, Color.WHITE);
		
		return t;
	}
	
	public Text gameWonText(Animal frog) {
		//label
		Text t = new Text() ;
		t.setText("GAME  WON !\nYOUR   HIGH   SCORE   IS  "+frog.getPoints()+"\nHIGHEST   POSSIBLE  SCORE   IS "+ db.getScoreDatabase().get(0));
		t.setLayoutX(140);
		t.setLayoutY(230);
		t.getTextAlignment();
		ScreenDesign s = new ScreenDesign();
		s.fontsetup(t, 20, Color.YELLOW);
	
		return t;
	}
	
	public Text escText() {
		Text esc = new Text();
		esc.setText("HIT   ESC   RETURN   TO   MAIN  MENU");
		esc.setLayoutX(160);
		esc.setLayoutY(350);
		ScreenDesign s = new ScreenDesign();
		s.fontsetup(esc, 20, Color.BLUE);

		return esc;
	}
	
	//blinking text 
	public Text gameOverblinkingtext() {
		Text t = new Text();
		t.setText("HIT  <SPACE>  TO   CONTINUE");
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), t);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        fadeTransition.setCycleCount(Animation.INDEFINITE);
        fadeTransition.play();
		t.setLayoutX(180);
		t.setLayoutY(350);
		
		ScreenDesign s = new ScreenDesign();
		s.fontsetup(t, 20, Color.WHITE);
		
		return t;
	}
	
	
	public Text gameoverText() {
		//label
		Text t = new Text() ;
		t.setText("GAME  OVER");
		t.setLayoutX(220);
		t.setLayoutY(270);
		
		ScreenDesign s = new ScreenDesign();
		s.fontsetup(t, 35, Color.YELLOW);
		
		return t;
	}
	
	//when space is pressed
	private void keylistener(Stage currentStage) {
		ggPanel.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if (won==false) {
					if (event.getCode()==KeyCode.SPACE) {
						Menu.mainStage.show();
						currentStage.close();
					}
				}
				
				//game won key listener is implemented in GameView class
				
			}
		});
	}
	
}