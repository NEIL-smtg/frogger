package GameMechanics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import Scene.EnterName;

public class Database
{
	ArrayList<String> namelist = new ArrayList<String>();
	ArrayList<String> scorelist = new ArrayList<String>();
	
	public Database(){
		try {
			
			File namedb = new File("NameDatabase.txt");
			Scanner reader = new Scanner(namedb);
			while (reader.hasNextLine() ) {
				String score = reader.nextLine();
				namelist.add(score);
				
			}
			reader.close();
			
		}catch (FileNotFoundException e) {
			System.out.println("FILE NOT FOUND.");
			e.printStackTrace();
		}	
		
		try {
			
			File scoredb = new File("HighScoreDatabase.txt");
			Scanner reader = new Scanner(scoredb);
			while (reader.hasNextLine() ) {
				String score = reader.nextLine();
				scorelist.add(score);
				
			}
			reader.close();
		}catch (FileNotFoundException e) {
			System.out.println("FILE NOT FOUND.");
			e.printStackTrace();
		}	
		
		sorting();
	}
	
	//store new score & new name into database
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
	
	private void sorting() {
		//sort namelist, scorelist from highest to lowest
		String tmpS,tmpB;
		
		for (int i = 0; i < scorelist.size(); i++) {
			for (int j = scorelist.size()-1; j >=i; j--) {
				if (Integer.parseInt(scorelist.get(j))  > Integer.parseInt(scorelist.get(i)) ) {
					tmpB = scorelist.get(j);
					tmpS = scorelist.get(i);
				
					scorelist.set(j, tmpS);
					scorelist.set(i, tmpB);
					
					tmpB = namelist.get(j);
					tmpS = namelist.get(i);
					namelist.set(j, tmpS);
					namelist.set(i, tmpB);
				}
			}
		}
	}
	
	//return data in name database
	public ArrayList<String> getNameDatabase() {
		
		return namelist;
	}
	
	//return data in score database
	public ArrayList<String> getScoreDatabase() {

		return scorelist;
	}
}
	
