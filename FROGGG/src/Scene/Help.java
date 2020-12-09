package Scene;

import Background.ScreenDesign;
import GameMechanics.MenuButton;
import GameMechanics.MyStage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Help {
	private static final int HEIGHT =800;
	private static final int WIDTH = 600;
	MyStage screen;
	private Scene HelpScene;
	private Stage HelpStage;
	

	Help()
	{
		screen =new MyStage();
		HelpScene=new Scene(screen,WIDTH,HEIGHT);
		HelpStage = new Stage();
		HelpStage.setScene(HelpScene);
		
		//create background
		ScreenDesign design = new ScreenDesign();
		screen.setBackground(new Background(design.paint()));
		
		addbutton();
		gameInfo();
	}
	
	private void addbutton() {
		MenuButton back = new MenuButton("<-BACK");
		back.setLayoutX(20);
		back.setLayoutY(20);
		back.setPrefWidth(150);
		back.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				Menu.mainStage.show();
				HelpStage.close();
			}
		});
		screen.getChildren().add(back);
	}
	
	
	private void gameInfo() {
		Text info = new Text();
		info.setText("Please   help   a   frog   name\nFrogger   reach   safety\nhome   on   the   top   of   the   screen\n"
				+ "You   may   use   arrow   keys   or\nWASD   key   to   move   Frogger !\n\n"
				+ "Here   are   the   things   you   need\nto   look   out !\nFrogger   have   only   4   lives !\nyou   have   to\n"
				+ "avoids   car   on   the   freeway\nyou   can   jump   on   log\nor   turtles   in   river   to\nreach   the   top !\n"
				+ "Speed   will   increases   as   the\nlevel   increases");
		info.setX(60);
		info.setY(150);
		fontsetup(info);
		screen.getChildren().add(info);
	}
	
	private void fontsetup(Text text) {
		try {
			text.setFont(Font.loadFont("file:src/resources/ARCADECLASSIC.TTF", 35));
			text.setFill(Color.BEIGE);
			
		} catch (Exception e) {
			text.setFont(Font.font("Verdana",23));
		}
	}
	
	public void helpScene() {
		HelpStage.show();
		Menu.mainStage.close();
	}
}

