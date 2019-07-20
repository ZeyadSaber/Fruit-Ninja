package command;

import java.io.FileWriter;
import java.io.IOException;
import interfaces.Command;

public class SaveHighestScore implements Command{

	private FileWriter x;
	private String highestScore;
	public  SaveHighestScore(int highestScore) {
		this.highestScore=String.valueOf(highestScore);
	}
	@Override
	public void execute() {
		 try {
			x = new FileWriter("src/highest score.txt",false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			x.write(highestScore);
			x.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
