package Scene;

import java.util.ArrayList;

import Database.Database;
import GameMechanics.MenuButton;
import GameMechanics.MyStage;
import ScreenDesign.ScreenDesign;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class EnterName {
	MyStage screen;
	private Scene mainScene;
	private Stage nameInputStage;
	public static String NewName;
	private TextField nameField;
	ScreenDesign design = new ScreenDesign();
	MenuButton back,enter;
	Database db = new Database();
	
	EnterName()
	{
		ScreenSetup();
		createButton();
		ButtonListener();
		createtextfield();
	}
	
	private void ScreenSetup() {
		//screen setup
		screen = new MyStage();
		mainScene=design.FixedScene(screen);
		nameInputStage = new Stage();
		nameInputStage.setScene(mainScene);
		
		//description of window
		nameInputStage.setTitle("ENTER YOUR NAME");
		
		//create background
		screen.setBackground(new Background(design.paint()));
	}
	
	private void createButton() {
		back = new MenuButton("B A C K ");
		back.setLayoutX(20);
		back.setLayoutY(20);
		back.setPrefWidth(150);
		
		
		enter = new MenuButton("C H O O S E     LEVELS");
		enter.setLayoutX(140);
		enter.setLayoutY(280);
		enter.setPrefWidth(300);
		
		
		screen.getChildren().addAll(back,enter);
	}
	
	private void ButtonListener() {
		//back button listener
		back.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				//back to menu
				Menu.mainStage.show();
				nameInputStage.close();
			}
		});
		
		//choose level button listener
		enter.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				NewName=nameField.getText();
				if(NewName.trim().equals("")) 
				{			
					setAlert(NewName);
				}
				else
				{
					CheckDuplicateName();
				}
			}
		});
	}
	
	private void createtextfield()
	{
		Text name = new Text();
		name.setText("NAME ");
		name.setX(140);
		name.setY(225);
		fontsetup(name,35,Color.RED);
		
		nameField = new TextField();
		nameField.setLayoutX(250);
		nameField.setLayoutY(200);
		
		screen.getChildren().addAll(name,nameField);
	}
	
	public void newScene() 
	{
		//show this window only , close menu
		Menu.mainStage.hide();
		nameInputStage.show();	
	}
	
	private void CheckDuplicateName() {
		
		boolean duplicate=false;
		ArrayList<String> namelist = db.getNameDatabase();
		
		//check if input name is duplicated with name in high score list
		for (int i = 0; i < namelist.size(); i++) {
			
			if (NewName.equalsIgnoreCase(namelist.get(i))) {
				setAlert(namelist.get(i));
				duplicate=true;
				break;
			}
			
		}
		if (duplicate==false) {
			ChooseLevels choose = new ChooseLevels();
			choose.NewScene(nameInputStage);
		}
	}
	
	private void setAlert(String inputName) {
		
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		if(inputName.trim().equals(""))
		{
			alert.setHeaderText("Empty name !! ");
			alert.setContentText("Name cannot be empty !");
			alert.showAndWait();
		}
		else 
		{			
			alert.setHeaderText("Duplicated name !! "+inputName+" has been registered !");
			alert.setContentText("Please enter another name !");
			alert.showAndWait();
		}
	}
	
	private void fontsetup(Text text, int size , Color c) {
		design.fontsetup(text, 35, c);
	}
	
}

