package textExcel;

public class ValueCell extends RealCell {
	private double value;

	public String abbreviatedCellText() {
		return super.abbreviatedCellText();
	}

	public String fullCellText() {
		return super.fullCellText();
	}
	
	public ValueCell (String val){
		super(val);
		value = Double.parseDouble(super.fullCellText());		
	}
	
	public double getDoubleValue(){
		return value;
	}
	
	public String getType(){
		return "ValueCell";
	}

}
