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
	
	//return data in name database
	public ArrayList<String> getNameDatabase() {
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
		
		return namelist;
	}
	
	//return data in score database
	public ArrayList<String> getScoreDatabase() {
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
		
		return scorelist;
	}
}
	
