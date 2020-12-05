package p4_group_8_repo;

import javafx.scene.image.Image;

public class BackgroundImage extends Actor{

	@Override
	public void act(long now) {
		
		
	}
	
	public BackgroundImage(String imageLink) {
		//setImage(new Image(imageLink, 600, 800, false, true));
		setImage(new Image(imageLink));
	}
	/*public BackgroundImage() {
		
		
	}
	
	public void BackgroundImage2(String imageLink) {
		setImage(new Image(imageLink));
	}*/

}
