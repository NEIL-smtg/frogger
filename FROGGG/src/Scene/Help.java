package Scene;

import GameMechanics.MenuButton;
import GameMechanics.MyStage;
import ScreenDesign.ScreenDesign;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Help {
	MyStage screen;
	private Scene HelpScene;
	private Stage HelpStage;
	ScreenDesign design = new ScreenDesign();

	public Help()
	{
		ScreenSetup();
		createbutton();
		gameInfo();
	}
	
	private void ScreenSetup() {
		//screen setup
		screen = new MyStage();
		HelpScene=design.FixedScene(screen);
		HelpStage = new Stage();
		HelpStage.setScene(HelpScene);
		HelpStage.setTitle("INFO/HELP");
		
		//create background
		screen.setBackground(new Background(design.paint()));		
	}
	
	private void createbutton() {
		MenuButton back = new MenuButton("B  A  C  K");
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
				+ "Here   are   the   things   you   need\nto   look   out !\nFrogger   has   only   4   lives !\nyou   have   to\n"
				+ "avoids   car   on   the   freeway\nyou   can   jump   on   log\nor   turtles   in   river   to\nreach   the   top !\n"
				+ "Speed   will   increases   as   the\nlevel   increases");
		info.setX(60);
		info.setY(150);
		fontsetup(info,35,Color.YELLOW);
		screen.getChildren().add(info);
	}
	
	private void fontsetup(Text text, int size , Color c) {
		ScreenDesign s = new ScreenDesign();
		s.fontsetup(text, 35, c);
	}
	
	public void helpScene() {
		HelpStage.show();
		Menu.mainStage.close();
	}
}

