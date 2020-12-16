package GameMechanics;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Scene.EnterName;

public class Database
{
	ArrayList<String> namelist = new ArrayList<String>();
	ArrayList<String> scorelist = new ArrayList<String>();
	private int newscore;
	private int index;
	
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
		
	}
	
	public void StoretoDatabase(int points) {
		//store new score & new player into database
		
		namelist.add(EnterName.NewName);
		scorelist.add(Integer.toString(points));
		sorting();
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
		
		updateDatabase();
	}
	
	private void updateDatabase() {
		//update the database after sorting
		 try {
		      FileWriter namedbWriter = new FileWriter("NameDatabase.txt");
		      FileWriter scoredbWriter = new FileWriter("HighScoreDatabase.txt");
		      
		      for (int i = 0; i < namelist.size(); i++) {
		    	  namedbWriter.write(namelist.get(i)+"\n");
		    	  scoredbWriter.write(scorelist.get(i)+"\n");
		      }
		      namedbWriter.close();
		      scoredbWriter.close();
		      System.out.println("Successfully wrote to the file.");
		      
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}

	public boolean checkDuplicateName() {
		for (int i = 0; i < namelist.size(); i++) {
			if (namelist.get(i).equals(EnterName.NewName)) {
				index=i;
				return true;
			}
		}
		return false;
	}
	
	public void changeData(int score) {
		newscore=score;
		
		if (checkDuplicateName()==true) {
			newscore += Integer.parseInt(scorelist.get(index));
			System.out.println("\n"+newscore);
			scorelist.set(index, Integer.toString(newscore));
			sorting();
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
	