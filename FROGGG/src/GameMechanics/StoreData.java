package GameMechanics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Scene.EnterName;

public class StoreData
{
	public void StoretoDatabase(Animal frog) {
		try(FileWriter fw = new FileWriter("HighScoreDatabase.txt", true);
	     BufferedWriter bw = new BufferedWriter(fw);
	     PrintWriter out = new PrintWriter(bw))
		{
			out.print(frog.getPoints()+"\n");
		} catch (IOException e) {}
		
		try(FileWriter fw = new FileWriter("NameDatabase.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw))
				{
				    out.print(EnterName.NewName+"\n");
				} catch (IOException e) {}
	}
}
