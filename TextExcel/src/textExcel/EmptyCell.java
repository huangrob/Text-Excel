package textExcel;

public class EmptyCell implements Cell{
	
	public String abbreviatedCellText(){
		return "          ";
	}
	
	public String fullCellText(){
		return "";
	}
	
	public String getType(){
		return "EmptyCell";
	}
	
	public double getDoubleValue(){
		return 0.0;
	}
}
