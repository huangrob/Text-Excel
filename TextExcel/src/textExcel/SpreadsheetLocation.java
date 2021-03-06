package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location{
	
	private String coordinates;
	
	public SpreadsheetLocation(String cellName)
    {
		coordinates = cellName;
    }
	
    @Override
    public int getRow()
    {
    	int rowNum = Integer.parseInt(coordinates.substring(1));
        return rowNum - 1;
    }

    @Override
    public int getCol()
    {
    	int colNum = (int) (coordinates.charAt(0) - 'A');
    	return colNum;
    }

}
