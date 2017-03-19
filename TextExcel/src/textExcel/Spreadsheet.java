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
		if (command.equals("")) {
			return "";
		}
		if (command.equals("clear")){
			Spreadsheet clearSpreadsheet = new Spreadsheet();
			return clearSpreadsheet.getGridText();
		}
		else {
			String[] commandParts = command.split(" ");
			SpreadsheetLocation coordinates = new SpreadsheetLocation(commandParts[0]);
			int colNum = coordinates.getCol();
			int rowNum = coordinates.getRow();
			if (commandParts[0].equals("clear")){
				spreadsheet[colNum][rowNum] = new EmptyCell();
				return getGridText();
			}		
			else if (command.length() <= 3) {
				return (spreadsheet[colNum][rowNum].fullCellText());
	    		}
			else if (commandParts[1].equals("=")){
				spreadsheet[colNum][rowNum] = new TextCell(commandParts[2]);
				return getGridText();
			}
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
		return spreadsheet[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText()
	{
		String grid = "  ";
		for (char c = 'A'; c <= 'L'; c++){
			grid += "|" + c + "         ";
		}
		grid += "|\n";
		for (int i = 1; i <= 20; i++){
			grid += i;
			if (i < 10){
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
