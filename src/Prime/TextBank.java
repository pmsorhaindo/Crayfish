package Prime;

import java.util.ArrayList;

public class TextBank {

	ArrayList<String> originalText = new ArrayList<String>();
	ArrayList<String> transToolName = new ArrayList<String>(); // Unicode Strings
	ArrayList<Integer> gtsPhraseID = new ArrayList<Integer>();
	ArrayList<String> finsoftName = new ArrayList<String>();
	ArrayList<String> textType = new ArrayList<String>();
	
	public TextBank() {
		
	}
	
	public void addWH(String textValue, String transToolValue) {
		originalText.add(textValue);
		transToolName.add(transToolValue);
		gtsPhraseID.add(null);
		finsoftName.add(null);
		
		if(transToolValue.substring(0, 1).equalsIgnoreCase("tt"))
			textType.add("component");
		if(transToolValue.substring(0, 1).equalsIgnoreCase("gt"))
			textType.add("graphic");
		else
			textType.add(null);
				
	}
	
	public void addGTS(String textValue, Integer phraseID) {
		originalText.add(textValue);
		transToolName.add(null);
		gtsPhraseID.add(phraseID);
		finsoftName.add(null);
		textType.add(null); //TODO text type sort
	}
	
	public void addFin(String textValue, String finName) {
		originalText.add(textValue);
		transToolName.add(null);
		gtsPhraseID.add(null);
		finsoftName.add(finName);
		textType.add(null); //TODO text type sort
	}
	
	
}
