package GameMechanics;

public class ScoreGenerator {
	//score increment is different in every level
	private int score;
	private int level;
	
	public ScoreGenerator(int level ) {
		this.level=level;	
		bonusScore();
	}
	
	private void bonusScore() {
		if (level <=3 ) {
			score = level*4;
		}
		else if (level >=4 && level <=6) {
			score = level*6;
		}
		else if (level==7 || level ==8) {
			score = level*7;
		}
		else {
			score = level*8;
		}
	}
	
	public int getscore() {
		return score;
	}

}
