package GameMechanics;

import ScreenDesign.ScreenDesign;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class ButtonStyle extends Button{
	private final String FONT_PATH="file:src/resources/ARCADECLASSIC.TTF";
	private final String BUTTON_FREE_STYLE="-fx-background-color: #ddd";
	//"-fx-background-color: transparent; -fx-background-image: url('/model/orange.png')";
	ScreenDesign s = new ScreenDesign();
	
	public ButtonStyle(String text) {
		setText(text);
		setButtonFont();
		setPrefWidth(250);
		setPrefHeight(49);
		setButtonFreeStyle();
		initializeButtonListeners();
	}
	

	private void setButtonFont() {
		try {
			setFont(Font.loadFont(FONT_PATH, 32));
			
		} catch (Exception e) {
			setFont(Font.font("Verdana",35));
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
