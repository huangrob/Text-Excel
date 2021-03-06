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
		if (command.length() > 0){
			String[] commandParts = command.split(" ", 3);
			if (commandParts.length == 3) {
				SpreadsheetLocation coordinates = new SpreadsheetLocation(commandParts[0].toUpperCase());
				int colNum = coordinates.getCol();
				int rowNum = coordinates.getRow();
			
				if (commandParts[2].contains("%")){
					spreadsheet[colNum][rowNum] = new PercentCell(commandParts[2].substring(0, commandParts[2].length() - 1));
				} 
				else if (commandParts[2].charAt(0) == '(' && commandParts[2].charAt(commandParts[2].length() - 1) == ')'){
					spreadsheet[colNum][rowNum] = new FormulaCell(commandParts[2], spreadsheet);
				} 
				else if (commandParts[2].charAt(0) == '"' && commandParts[2].charAt(commandParts[2].length() - 1) == '"'){
					spreadsheet[colNum][rowNum] = new TextCell(commandParts[2]);
				} 
				else {
					spreadsheet[colNum][rowNum] = new ValueCell(commandParts[2]);
				}
				return getGridText();
			}
		
			else if (commandParts.length == 1) {
				if (command.length() <= 3) {
					SpreadsheetLocation coordinates = new SpreadsheetLocation(commandParts[0].toUpperCase());
					int colNum = coordinates.getCol();
					int rowNum = coordinates.getRow();
					return spreadsheet[colNum][rowNum].fullCellText();
				}
				else {
					for(int i = 0; i < spreadsheet.length; i++){
						for (int j = 0; j < spreadsheet[i].length; j++){
							spreadsheet[i][j] = new EmptyCell();
						}
					}
					return getGridText();
				}
			}
		
			else if (commandParts.length == 2) {
				if (commandParts[0].equalsIgnoreCase("clear")) {
					SpreadsheetLocation coordinates = new SpreadsheetLocation(commandParts[1].toUpperCase());
					int colNum = coordinates.getCol();
					int rowNum = coordinates.getRow();
					spreadsheet[colNum][rowNum] = new EmptyCell();
					return getGridText();
				}
				else {
					return "";
				}
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
		return spreadsheet[loc.getCol()][loc.getRow()];
	}

	@Override
	public String getGridText()
	{
		String grid = "   ";
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
