package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location{
	
	private String locationCoordinates = "";
	
	public SpreadsheetLocation(String cellName)
    {
		locationCoordinates = cellName;
    }
	
    @Override
    public int getRow()
    {
    	int rowNum = Integer.parseInt(locationCoordinates.substring(1)) - 1;
        return rowNum;
    }

    @Override
    public int getCol()
    {
    	int colNum = (int) (locationCoordinates.charAt(0) - 65);
    	return colNum;
    }

}
