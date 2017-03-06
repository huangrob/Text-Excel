package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
	    Spreadsheet spreadsheet = new Spreadsheet();
	    Scanner input = new Scanner(System.in);
	    String command = input.next();
	    while(!(command.equals("quit"))){
	    	System.out.println(spreadsheet.processCommand(command));
	    	command = input.next();
	    }
	}
}
