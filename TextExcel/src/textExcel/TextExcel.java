package textExcel;

import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
		Spreadsheet spreadsheet = new Spreadsheet();
	    Scanner scannerInput = new Scanner(System.in);
	    String command = scannerInput.nextLine();
	    while(!(command.equals("quit"))){
	    	System.out.println(spreadsheet.processCommand(command));
	    	command = scannerInput.nextLine();
	    }
	}
}
