package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location{
	
	private int rowNum;
	private int colNum;
	
	public SpreadsheetLocation(String cellName)
    {
    	String row = cellName.substring(1);
    	char column = cellName.charAt(0);
    	int rowNum = Integer.parseInt(row);
    	int colNum = (int)column - 64;
    }
	
    @Override
    public int getRow()
    {
        return this.rowNum;
    }

    @Override
    public int getCol()
    {
        return this.colNum;
    }

}
