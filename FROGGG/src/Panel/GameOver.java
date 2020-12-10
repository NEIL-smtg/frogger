package Panel;

import Background.BackgroundImage;
import Background.ScreenDesign;
import Scene.Menu;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class GameOver {
	BackgroundImage ggPanel;
	
	//create black panel when gameover
	public BackgroundImage getpanel(Stage currentStage) {
		ggPanel = new BackgroundImage("file:src/resources/black border.jpg");
		ggPanel.setFitHeight(300);
		ggPanel.setFitWidth(350);
		ggPanel.setX(120);
		ggPanel.setY(150);
		keylistener(currentStage);
		return ggPanel;
	}
	
	//blinking text 
	public Text getblinkingtext() {
		Text t = new Text();
		t.setText("HIT  <SPACE>  TO   CONTINUE");
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.8), t);
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
	
	//label
	public Text gameoverText() {
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
				if (event.getCode()==KeyCode.SPACE) {
					Menu.mainStage.show();
					currentStage.close();
				}
			}
		});
	}
	
}
