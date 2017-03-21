package textExcel;


public class SpreadsheetLocation implements Location
{
	private String locationValue;
    @Override
    public int getRow()
    {
        int rowNum = (Integer.parseInt(locationValue.substring(1)));			//parsing to find row number from passed string
        return rowNum -1;
    }

    @Override
    public int getCol()
    {
    	int colNum;
    	if (locationValue.charAt(0)>90){							// test to allow for both capital and lower case letters to be perceived for columns
    		colNum = locationValue.charAt(0) - 97;			//converting char to number used in array
    	}else{
            colNum = locationValue.charAt(0) - 65;			//converting char to number used in array
    	}
        return colNum;
    }
    
    public SpreadsheetLocation(String cellName)				//constructor to assign string of location to field value
    {
    		locationValue = cellName;
    }

}