package textExcel;
import java.util.*;
import java.io.*;

public class Spreadsheet implements Grid
{
	private Cell[][] spreadsheetArr = new Cell[20][12];		//field of Array of type cell
	
	public Spreadsheet(){									//constructor to assign each index to being an EmptyCell
		for( int i = 0; i < spreadsheetArr.length; i++){
			for (int j = 0; j<spreadsheetArr[i].length; j++){
				spreadsheetArr[i][j] = new EmptyCell();
			}
		}
	}

	@Override
	public String processCommand(String command){
		if(command.equalsIgnoreCase("")){				//test to check if valid input
			return "";
		}
		if (command.indexOf(" ") > 0){					//check to see if there are spaces to cut command options down and can safely split
			String[] commandBreakdown = command.split(" ", 3);		//string array made with length of three
			if (commandBreakdown.length > 1){
				if (commandBreakdown[1].equals("=")){				//test to see if its an assignment call
					String location = commandBreakdown[0];
					SpreadsheetLocation cellLocation = new SpreadsheetLocation(location);		//create Spreadsheetlocation instance for the entered cell
					int rowNum = cellLocation.getRow();
					int columnNum = cellLocation.getCol();
					if (commandBreakdown[2].substring(commandBreakdown[2].length()-1).equals("%")){		//test to see if assignment for percent cell
						spreadsheetArr[rowNum][columnNum] = new PercentCell(commandBreakdown[2]);
					} else if(commandBreakdown[2].charAt(0) == '"' && commandBreakdown[2].charAt(commandBreakdown[2].length()-1) == '"'){		//test to see if assignment for textcell
						spreadsheetArr[rowNum][columnNum] = new TextCell(commandBreakdown[2].substring(1, commandBreakdown[2].length()-1));
					}else if (commandBreakdown[2].charAt(0) == '(' && commandBreakdown[2].charAt(commandBreakdown[2].length()-1) == ')'){		//test to see if assignment for formula cell
						spreadsheetArr[rowNum][columnNum] = new FormulaCell(commandBreakdown[2]);
					}else {
						spreadsheetArr[rowNum][columnNum] = new ValueCell(commandBreakdown[2]);		//last option if failed all others leads to value cell
					}
					return (getGridText());				//returns grid after assignment, as per instructions
				} else if (commandBreakdown[0].equalsIgnoreCase("clear")){					// test to see if clear is the first word of the command and it has more than one word, as given there is a space in the entered call if it reaches this test, meaning test to see if this is a call to clear a certain value
					SpreadsheetLocation cellLocation = new SpreadsheetLocation(commandBreakdown[1]);		//location object to easily get rows and columns of cell to be cleared
					spreadsheetArr[cellLocation.getRow()][cellLocation.getCol()] = new EmptyCell();
					return (getGridText());				//returns grid after assignment, as per instructions
			}
		}else if (command.equalsIgnoreCase("clear")){						// if sole call is "clear" reassign each index to be empty cells
			for( int i = 0; i < spreadsheetArr.length; i++){
				for (int j = 0; j<spreadsheetArr[i].length; j++){
					spreadsheetArr[i][j] = new EmptyCell();
				}
			}
			return (getGridText());
		} else if(command.length() < 5){							//known that length of call of a row and column is less than 5, and safer than else statement
			SpreadsheetLocation cellLocation = new SpreadsheetLocation(command);
			return (getCell(cellLocation).fullCellText());
			}
		}
		return "";
	}


	@Override
	public int getRows()			//returns set row numbers
	{
		return 20;
	}

	@Override
	public int getCols()			//returns set column numbers
	{
		return 12;
	}

	@Override
	public Cell getCell(Location loc)				//finds row and column values from a location object for cell
	{
		return spreadsheetArr[loc.getRow()][loc.getCol()];
	}

	
	
	
	
	
	@Override
	public String getGridText()			//returns string with physical representation of grid
	{
		String grid = "";
		grid += "   |";
		char columnLet = 'A';
		for(int i = 0; i < 12; i++){			// printing first header line, with ascending alphabet letters
			grid += ((char)(columnLet)) + "         |";
			columnLet += 1;
		}
		grid += "\n";
		
		for (int i = 0; i < 20; i++){	//main loop to print formatting and values for cells
			if(i<9){
				grid += (i+1) + "  |";
			} else {
				grid += (i+1) + " |";
			}
			for(int j = 0; j<12 ; j++){
				grid += spreadsheetArr[i][j].abbreviatedCellText() + "|";		//uses abbreviated cell text to get ten char long string for each cell
			}
			grid += "\n";
		}
		
		return grid;
	}

}