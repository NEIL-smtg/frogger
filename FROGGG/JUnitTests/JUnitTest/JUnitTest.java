package JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Database.Database;
import GameMechanics.ScoreGenerator;
import GameMechanics.SpeedDecider;
import Scene.EnterName;


public class JUnitTest {

	@Test
	public void test() {
		
		// ScoreGenerator class bonusScore() Test 
		int a=3 , b=5 , c=7 , d= 10;
		ScoreGenerator test1 = new ScoreGenerator();
		int result = test1.bonusScore(a);
		assertEquals(a*4 , result );
		
		result = test1.bonusScore(b);
		assertEquals(b*6 , result );
		
		result = test1.bonusScore(c);
		assertEquals(c*7 , result );
		
		result = test1.bonusScore(d);
		assertEquals(d*8 , result );
		
		//SpeedDecider class getspeed() test
		a=1; b=6;
		SpeedDecider test2 = new SpeedDecider(a);
		result = test2.getspeed();
		assertEquals(a, a);
		
		test2 = new SpeedDecider(b);
		result = test2.getspeed();
		assertEquals( 1+b/3 , result);
		
		// database class checkduplicatename() test
		Database test3 = new Database();
		test3.getNameDatabase().add("ray");
		EnterName.NewName="ray";
		assertEquals(true, test3.checkDuplicateName());
		
		EnterName.NewName="tay";
		assertEquals(false, test3.checkDuplicateName());
		
		
		// database class chcek getindex() test
		Database test4 = new Database();
		result = test4.getindex();
		//since the database is empty now , we will be expecting result=0
		assertEquals(0, result);
	}

}
