package textExcel;

public class FormulaCell extends RealCell {

	private String formula;
	private Cell[][] spreadsheet;
	
	public FormulaCell(String val, Cell[][] spreadsheet) {
		super(val);
		this.formula = fullCellText().substring(2, fullCellText().length() - 2);
		this.spreadsheet = spreadsheet;
	}
	
	public String abbreviatedCellText() {
		String abbreviated = getDoubleValue() + "";
		String spaces = "";
		if (abbreviated.length() <= 10){
			for (int i = 10; i > abbreviated.length(); i--){
				spaces += " ";
			}
			return abbreviated + spaces;
		}
		else {
			return abbreviated.substring(0, 10);
		}
	}
	
	public double getDoubleValue() {
		String[] operands = formula.split(" ");
		String[] operators = new String[operands.length];
		String[] terms = new String[operands.length];
		Double[] termsValue = new Double[operands.length];
		for (int i = 0; i < operands.length; i++){
			if (i % 2 == 1){
				operators[i] = operands[i];
			}
			else {
				terms[i] = operands[i];
			}
		}
		for (int i = 0; i < terms.length; i++){
			if (terms[i].charAt(0) >= 65){
				SpreadsheetLocation cell = new SpreadsheetLocation(terms[i].toUpperCase());
				terms[i] = spreadsheet[cell.getCol()][cell.getRow()].fullCellText();
				termsValue[i] = Double.parseDouble(terms[i]);
			}
			else {
				termsValue[i] = Double.parseDouble(terms[i]);
			}
		}
		Double returnValue = termsValue[0];
		for (int i = 0; i < termsValue.length; i+=2){
			if (operators[i+1].equals("+")){
				returnValue += termsValue[i];
			}
			else if (operators[i+1].equals("-")){
				returnValue -= termsValue[i];
			}	
			else if (operators[i+1].equals("*")){
				returnValue *= termsValue[i];
			}	
			else if (operators[i+1].equals("/")){
				returnValue /= termsValue[i];
			}	
		}
		return returnValue;
	}
	
	public String fullCellText() {
		return super.fullCellText();
	}
	


}
