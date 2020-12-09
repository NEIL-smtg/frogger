package Background;

import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;

public class ScreenDesign {
	
	public BackgroundImage paint() {
		Image backgroundImage = new Image("file:src/resources/mainbackground.jpg",300,300,false,true);
		BackgroundImage b = new BackgroundImage(backgroundImage,BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,null);
		return b;
	}
}
