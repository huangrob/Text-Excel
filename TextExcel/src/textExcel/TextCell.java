package textExcel;

public class TextCell implements Cell{
	
	private String text;
	
	public TextCell(String contents){
		contents = text;
	}
	
	public String abbreviatedCellText(){
		return "          ";
	}
	
	public String fullCellText(){
		return text;
	}

}
