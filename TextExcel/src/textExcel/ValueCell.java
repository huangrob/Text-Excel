package textExcel;

public class ValueCell extends RealCell {
	
	private double doubleVal;
	
	public String abbreviatedCellText() {
		return super.abbreviatedCellText();
	}

	public String fullCellText() {
		return super.fullCellText();
	}
	
	public ValueCell (String val){
		super(val);
		doubleVal = Double.parseDouble(super.fullCellText());
	}
	
	public double getDoubleValue(){
		return doubleVal;
	}

}
