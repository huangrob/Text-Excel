package textExcel;

public class TextCell implements Cell{
	
	private String text;
	
	public TextCell(String contents){
		text = contents;
	}
	
	public String abbreviatedCellText(){
		if (text.length() <= 10){
			for (int i = 10; i > text.length(); i--){
				text += " ";
			}
			return text;
		}
		else {
			String abbreviatedText = "";
			for (int j = 0; j < 10; j++){
				abbreviatedText += text.charAt(j);
			}
			return abbreviatedText;
		}
	}
	
	public String fullCellText(){
		return text;
	}

}
