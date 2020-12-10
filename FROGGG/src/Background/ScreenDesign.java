package Background;

import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ScreenDesign {
	
	public BackgroundImage paint() {
		Image backgroundImage = new Image("file:src/resources/mainbackground.jpg",300,300,false,true);
		BackgroundImage b = new BackgroundImage(backgroundImage,BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,null);
		return b;
	}
	
	public void fontsetup(Text t, int size , Color c) {
		
		try {
			t.setFont(Font.loadFont("file:src/resources/ARCADECLASSIC.TTF", size));
			t.setFill(c);
			
		} catch (Exception e) {
			t.setFont(Font.font("Verdana",size));
		}
	
	}
}
