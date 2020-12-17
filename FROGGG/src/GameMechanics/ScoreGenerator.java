package GameMechanics;

public class ScoreGenerator {
	//score increment is different in every level
	private int score;
	
	public int bonusScore(int level) {
		if (level <=3 ) {
			score = level*4;
			return score;
		}
		else if (level >=4 && level <=6) {
			score = level*6;
			return score;
		}
		else if (level==7 || level ==8) {
			score = level*7;
			return score;
		}
		else {
			score = level*8;
			return score;
		}
	}
	
}
