package textExcel;

public class RealCell implements Cell{
	
	private String value;
	
	public RealCell (String val){
		value = val;
	}
	
	public String abbreviatedCellText(){
		String doubleVal = getDoubleValue() + "";
		String spaces = "";
		if (doubleVal.length() <= 10){
			for (int i = 10; i > doubleVal.length(); i--){
				spaces += " ";
			}
			return doubleVal + spaces;
		}
		else {
			return value.substring(0, 10);
		}
	}
	
	public String fullCellText(){
		return value;
	}
	
	public double getDoubleValue(){
		return Double.parseDouble(value);
	}

}
