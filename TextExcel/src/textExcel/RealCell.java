package textExcel;

public class RealCell implements Cell{
	
	private String value;
	
	public String abbreviatedCellText(){
		if (value.length() <= 10){
			for (int i = 10; i > value.length(); i--){
				value += " ";
			}
			return value;
		}
		else {
			String abbreviatedValue = "";
			for (int j = 0; j < 10; j++){
				abbreviatedValue += value.charAt(j);
			}
			return abbreviatedValue;
		}
	}
	
	public String fullCellText(){
		return value;
	}
	
	public RealCell (String val){
		value = val;
	}
	
	public double getDouble(){
		return Double.parseDouble(value);
	}
	
	public String getType(){
		return "RealCell";
	}
}
