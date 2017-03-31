package textExcel;

public class PercentCell extends RealCell {
	
	public String abbreviatedCellText() {
		String str = (int) (super.getDouble()) + "%";	
		String spaces = "";
		if (str.length() <= 10){
			for (int i = 10; i > str.length(); i--){
				spaces += " ";
			}
			return str + spaces;
		}
		else {
			return str.substring(0, 10);
		}
	}

	public String fullCellText() {
		return super.getDouble()/100.0 + "";
	}
	
	public PercentCell(String value) {
		super(value);
	}
	
}
