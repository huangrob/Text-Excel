package textExcel;

import java.util.Arrays;

// Update this file with your own code.

public class Spreadsheet implements Grid{
	
	private Cell[][] spreadsheet = new Cell[12][20];
	
	public Spreadsheet(){
		for(int i = 0; i < spreadsheet.length; i++){
			for (int j = 0; j < spreadsheet[i].length; j++){
				spreadsheet[i][j] = new EmptyCell();
			}
		}
		
	}

	@Override
	public String processCommand(String command)
	{
		if (command.equals("clear")){
			Spreadsheet clearSpreadsheet = new Spreadsheet();
			return clearSpreadsheet.getGridText();
		}
		String[] commandParts = command.split(" ");
		String coordinates = commandParts[0];
		SpreadsheetLocation cellCoordinates = new SpreadsheetLocation(coordinates);
		int colNum = cellCoordinates.getCol();
		int rowNum = cellCoordinates.getRow();
		if (commandParts[0].equals("clear")){
			spreadsheet[colNum][rowNum] = new EmptyCell();
			return getGridText();
		}
		else if (command.length() <= 3) {
	    	return (spreadsheet[colNum][rowNum].fullCellText());
	    	}
		else if (command.contains("=")){
			spreadsheet[colNum][rowNum] = new TextCell(commandParts[2]);
	    	return getGridText();
		}
		
		return "";
	}

	@Override
	public int getRows()
	{
		return 20;
	}

	@Override
	public int getCols()
	{
		return 12;
	}

	@Override
	public Cell getCell(Location loc)
	{
		return null;
	}

	@Override
	public String getGridText()
	{
		System.out.print("  ");
		for (char c = 'A'; c <= 'L'; c++){
			System.out.print("|" + c + "         ");
		}
		System.out.println("|");
		for (int i = 1; i <= 20; i++){
			System.out.print(i);
			if (i < 10){
				System.out.print(" ");
			}
			for (char a = 'A'; a <= 'L'; a++){
				System.out.print("|" + spreadsheet[(int)a - 'A'][i-1].abbreviatedCellText());
			}
		System.out.println("|");
		}
		return "";
	}

}
