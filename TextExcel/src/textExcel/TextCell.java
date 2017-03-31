package textExcel;

public class TextCell implements Cell{
	
	private String text;
	
	public TextCell(String contents){
		text = contents.substring(1, contents.length() - 1);
	}
	
	public String abbreviatedCellText(){
		String spaces = "";
		if (text.length() <= 10){
			for (int i = 10; i > text.length(); i--){
				spaces += " ";
			}
			return text + spaces;
		}
		else {
			return text.substring(0, 10);
		}
	}
	
	public String fullCellText(){
		return "\"" + text + "\"";
	}

}
