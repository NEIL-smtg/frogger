package p4_group_8_repo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class EnterName {
	private static final int HEIGHT =800;
	private static final int WIDTH = 600;
	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage nameInputStage;
	public static String NewName;
	private TextField nameField;

	EnterName()
	{
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane,WIDTH,HEIGHT);
		nameInputStage = new Stage();
		nameInputStage.setScene(mainScene);
		nameInputStage.setTitle("ENTER YOUR NAME");
		ScreenDesign();
		createBackground();
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
		
		MenuButton enter = new MenuButton("START");
		enter.setLayoutX(240);
		enter.setLayoutY(280);
		enter.setPrefWidth(150);
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
		
		mainPane.getChildren().addAll(back,enter);
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
		mainPane.getChildren().addAll(name,nameField);
	}
	
	private void CheckDuplicateName() {
		int i=0;
		try {
			File namelist = new File("src/viewManager/NameDatabase.txt");
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
				GameView game = new GameView();
				game.createNewGame(nameInputStage);
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
			text.setFont(Font.loadFont("file:src/model/ARCADECLASSIC.TTF", 35));
			text.setFill(Color.RED);
			
		} catch (Exception e) {
			text.setFont(Font.font("Verdana",23));
		}
	}
	
	
	
	private void createBackground() 
	{
		Image backgroundImage = new Image("viewManager/newback.jpg",300,300,false,true);
		BackgroundImage background = new BackgroundImage(backgroundImage,BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,null);
		mainPane.setBackground(new Background(background));
	}

}

