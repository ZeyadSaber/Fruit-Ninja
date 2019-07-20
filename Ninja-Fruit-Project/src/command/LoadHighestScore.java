package command;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import interfaces.Command;

public class LoadHighestScore implements Command {
	private String highestScore;
	private Scanner x;
	@Override
	public void execute() {
		
		try {
			x = new Scanner(new File("src/highest score.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(x.hasNext())
			highestScore=x.next();
		x.close();
	}
	public int getHighestScore() {
		return Integer.valueOf(highestScore);
	}
}
