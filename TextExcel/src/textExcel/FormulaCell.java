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
		if (!(operands.length == 2)) {
			for (int i = 0; i < operands.length; i++){
				if (i % 2 == 1){
					operators[i] = operands[i];
				}
				else {
					terms[i] = operands[i];
				}
			}
			for (int i = 0; i < terms.length; i+=2){
				if ((terms[i].charAt(0) >= 'a' && terms[i].charAt(0) <= 'z') || (terms[i].charAt(0) >= 'A' && terms[i].charAt(0) <= 'Z')){
					SpreadsheetLocation loc = new SpreadsheetLocation(terms[i].toUpperCase());
					String cellFormula = spreadsheet[loc.getCol()][loc.getRow()].fullCellText();
					FormulaCell cell = new FormulaCell(cellFormula, spreadsheet);
					termsValue[i] = cell.getDoubleValue();
				}
				else {
					termsValue[i] = Double.parseDouble(terms[i]);
				}
			}
			Double returnValue = termsValue[0];
			if (operands.length == 1){
				return returnValue;
			}
			else {
				for (int i = 0; i < termsValue.length - 2; i+=2){
					if (operators[i+1].equals("+")){
						returnValue += termsValue[i+2];
					}
					else if (operators[i+1].equals("-")){
						returnValue -= termsValue[i+2];
					}	
					else if (operators[i+1].equals("*")){
						returnValue *= termsValue[i+2];
					}	
					else if (operators[i+1].equals("/")){
						returnValue /= termsValue[i+2];
					}
				}
				return returnValue;
			}
		}
		else if (operands.length == 2) {
			String[] cellRange = operands[0].split("-");
			Double[]
			for (char c = 'A'; c <= 'L'; c++){
				for (int i = 0; i < 20; i++){
					
				}
			}
			if (operands[0].equals("AVG")){
				
			}
			else if (operands[0].equals("SUM")){
				
			}
		}
	}
	
	public String fullCellText() {
		return super.fullCellText();
	}
	


}
