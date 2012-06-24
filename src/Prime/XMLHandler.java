package Prime;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class XMLHandler {
	
	TextBank tb;
	
	DefaultHandler handler = new DefaultHandler() {
		//boolean bfname = false;
		//boolean blname = false;
		
		public void startElement(String uri, String localName,String qName, Attributes attributes) throws SAXException {
			System.out.println("Start Element :" + qName);
			/*if (qName.equalsIgnoreCase("FIRSTNAME")) {
				bfname = true;
			}
			if (qName.equalsIgnoreCase("LASTNAME")) {
				blname = true;
			}*/
			
			if(qName.equalsIgnoreCase("VAR")) {
				verifyAttributes(attributes);
				//System.out.println("Attributes held are " + attributes.getLength());
				for(int i=0; i<attributes.getLength();i++)
				{
					System.out.print(attributes.getQName(i)+ ": ");
					System.out.println(" "+attributes.getValue(i));
				}
			}
			
		}
		

		public void endElement(String uri, String localName, String qName) throws SAXException {
			//System.out.println("End Element :" + qName);
		}
		
		public void characters(char ch[], int start, int length) throws SAXException {
			/*if (bfname) {
				System.out.println("First Name : " + new String(ch, start, length));
				bfname = false;
			}
			if (blname) {
				System.out.println("Last Name : " + new String(ch, start, length));
				blname = false;
			}*/
		}
	};
	
	public DefaultHandler getHandler() {
		return handler;
	}

	protected void verifyAttributes(Attributes atts) {
		if(atts.getLength()==2 && atts.getIndex("name")!=-1 && atts.getIndex("value")!=-1) {
			System.out.println("WH!");
			String temp = atts.getQName(1);
			String temp1 = atts.getQName(0);
			tb.addWH(temp, temp1);
		}		
	}
}
