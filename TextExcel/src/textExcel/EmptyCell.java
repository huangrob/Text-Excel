package textExcel;

public class EmptyCell implements Cell{
	
	public String abbreviatedCellText(){
		return "          ";
	}
	
	public String fullCellText(){
		return null;
	}
	
	public String getType(){
		return "EmptyCell";
	}
}
