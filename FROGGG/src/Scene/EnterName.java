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
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class EnterName {
	private static final int HEIGHT =800;
	private static final int WIDTH = 600;
	MyStage screen;
	private Scene mainScene;
	private Stage nameInputStage;
	public static String NewName;
	private TextField nameField;

	EnterName()
	{
		screen = new MyStage();
		mainScene = new Scene(screen,WIDTH,HEIGHT);
		nameInputStage = new Stage();
		nameInputStage.setScene(mainScene);
		nameInputStage.setTitle("ENTER YOUR NAME");
		
		//create background
		ScreenDesign design = new ScreenDesign();
		screen.setBackground(new Background(design.paint()));
				
		ScreenDesign();
		textfield();
		
	}
	
	private void ScreenDesign() {
		MenuButton back = new MenuButton("<-BACK");
		back.setLayoutX(20);
		back.setLayoutY(20);
		back.setPrefWidth(150);
		back.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				Menu.mainStage.show();
				nameInputStage.close();
			}
		});
		
		MenuButton enter = new MenuButton("CHOOSE LEVELS");
		enter.setLayoutX(200);
		enter.setLayoutY(280);
		enter.setPrefWidth(250);
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
		
		screen.getChildren().addAll(back,enter);
	}
	
	public void inputScene() 
	{
		Menu.mainStage.hide();
		nameInputStage.show();
		
	}
	

	private void textfield()
	{
		Text name = new Text();
		name.setText("NAME ");
		name.setX(140);
		name.setY(225);
		fontsetup(name);
		
		nameField = new TextField();
		nameField.setLayoutX(250);
		nameField.setLayoutY(200);
		screen.getChildren().addAll(name,nameField);
	}
	
	private void CheckDuplicateName() {
		int i=0;
		try {
			File namelist = new File("NameDatabase.txt");
			Scanner reader = new Scanner(namelist);
			while (reader.hasNextLine() ) 
			{
				String oldname = reader.nextLine();
				if(NewName.equalsIgnoreCase(oldname))
				{
					setAlert(oldname);
					i=1;
					break;
				}
			}	
			if(i==0) 
			{
				ChooseLevels choose = new ChooseLevels();
				choose.NewScene(nameInputStage);
			}
		} catch (FileNotFoundException e) 
		{
			System.out.println("FILE NOT FOUND.");
			e.printStackTrace();
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
	
	
	
	private void fontsetup(Text text) {
		try {
			text.setFont(Font.loadFont("file:src/resources/ARCADECLASSIC.TTF", 35));
			text.setFill(Color.RED);
			
		} catch (Exception e) {
			text.setFont(Font.font("Verdana",23));
		}
	}
	

}
