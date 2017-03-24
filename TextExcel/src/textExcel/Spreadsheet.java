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
		String[] commandParts = command.split(" ", 3);
		if (commandParts.length == 3) {
			SpreadsheetLocation coordinates = new SpreadsheetLocation(commandParts[0]);
			int colNum = coordinates.getCol();
			int rowNum = coordinates.getRow();
			spreadsheet[colNum][rowNum] = new TextCell(commandParts[2]);
			return getGridText();
		}
		else if (commandParts.length == 1) {
			if (command.length() <= 3) {
				SpreadsheetLocation coordinates = new SpreadsheetLocation(commandParts[0]);
				int colNum = coordinates.getCol();
				int rowNum = coordinates.getRow();
				return spreadsheet[colNum][rowNum].fullCellText();
			}
			else {
				Spreadsheet clearSpreadsheet = new Spreadsheet();
				return clearSpreadsheet.getGridText();
			}
		}
		else if (commandParts.length == 2) {
			SpreadsheetLocation coordinates = new SpreadsheetLocation(commandParts[1]);
			int colNum = coordinates.getCol();
			int rowNum = coordinates.getRow();
			spreadsheet[colNum][rowNum] = new EmptyCell();
			return getGridText();
		}
		else {
			return "";
		}
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
		return spreadsheet[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText()
	{
		String grid = "";
		grid += "   ";
		for (char c = 'A'; c <= 'L'; c++){
			grid += "|" + c + "         ";
		}
		grid += "|\n";
		for (int i = 1; i <= 20; i++){
			grid += i;
			if (i < 10){
				grid += "  ";
			}
			else {
				grid += " ";
			}
			for (char a = 'A'; a <= 'L'; a++){
				grid += "|" + spreadsheet[(int)a - 'A'][i-1].abbreviatedCellText();
			}
		grid += "|\n";
		}
		return grid;
	}

}
