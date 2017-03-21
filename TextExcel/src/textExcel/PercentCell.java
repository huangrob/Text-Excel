package textExcel;

public class PercentCell extends RealCell {

	public String abbreviatedCellText() {
		String str = (int)(super.getDouble()) + "%";	
		if (str.length() < 10){				
			while (str.length() < 10){
				str += " ";
			}
			return str;
		} 
		else {
			str = str.substring(0, 10);
			return str;							
		}

	}

	public String fullCellText() {
		return (super.getDouble()/100.0) + "";
	}
	
	public PercentCell(String value){
		super(value);
	}
	
	public double getDoubleValue(){
		return Double.parseDouble(super.fullCellText().substring(0, super.fullCellText().length()-1)); 
	}

	public String getType(){
		return "PercentCell";
	}
}
