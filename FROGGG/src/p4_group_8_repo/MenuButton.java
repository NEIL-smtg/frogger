package p4_group_8_repo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class MenuButton extends Button{
	private final String FONT_PATH="file:src/model/ARCADECLASSIC.TTF";
	private final String BUTTON_FREE_STYLE="-fx-background-color: #ddd";
	//"-fx-background-color: transparent; -fx-background-image: url('/model/orange.png')";
	
	
	public MenuButton(String text) {
		setText(text);
		setButtonFont();
		setPrefWidth(250);
		setPrefHeight(49);
		setButtonFreeStyle();
		initializeButtonListeners();
	}
	

	private void setButtonFont() {
		try {
			setFont(Font.loadFont(new FileInputStream(FONT_PATH),35));
		}catch(FileNotFoundException e) {
			setFont(Font.font("Verdana",23));
		}	
	}
	
	private void setButtonFreeStyle() {
		setStyle(BUTTON_FREE_STYLE);
		setPrefHeight(49);
		setLayoutY(getLayoutY()-4);
	}
	
	private void setButtonPressedStyle() {
		setPrefHeight(45);
		setLayoutY(getLayoutY()+4);
	}
	
	
	private void initializeButtonListeners() {
		
		setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					setButtonPressedStyle();
				}
			}
		});
		
		setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					setButtonFreeStyle();
				}
				
			}
			
		});
		
		setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					setEffect(null);
				}
				
			}
			
		});
	}
}
