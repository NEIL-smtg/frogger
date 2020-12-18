package Scene;

import GameMechanics.ButtonStyle;
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
		ButtonStyle back = new ButtonStyle("B  A  C  K");
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
		info.setText("The     only     player     control\n"
				+ "is     the     arrow     keys    on    your\n"
				+ "keyboard   or    W  A  S  D  \n"
				+ "to   navigate  the   frog\n"
				+ "each   push   in   a   direction\n"
				+ "causes  the   frog   to   hop\n"
				+ "\nonce  in   that   direction !\n"
				+ "On    the    bottom    half\n"
				+ "of  the  screen\n"
				+ "the  player  must  successfully"
				+ "\nguide   the   frog   between\n"
				+ " opposing   lanes   of    cars\n"
				+ "and   other  vehicles"
				+ "\nto  avoid   becoming  roadkil\n"
				+ "\nthe  way  to  win   is  simply\n"
				+ "navigate   all  of  the   \n"
				+ "frogs   home");
		info.setX(60);
		info.setY(120);
		fontsetup(info,25,Color.LIGHTGOLDENRODYELLOW);
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

