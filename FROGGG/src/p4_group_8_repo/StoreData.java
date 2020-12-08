package p4_group_8_repo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class StoreData
{
	StoreData(Animal frog) {
		try(FileWriter fw = new FileWriter("src/viewManager/HighScoreDatabase.txt", true);
	     BufferedWriter bw = new BufferedWriter(fw);
	     PrintWriter out = new PrintWriter(bw))
		{
			out.print(frog.getPoints()+"\n");
		} catch (IOException e) {}
		
		try(FileWriter fw = new FileWriter("src/viewManager/NameDatabase.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw))
				{
				    out.print(EnterName.NewName+"\n");
				} catch (IOException e) {}
	}
}
