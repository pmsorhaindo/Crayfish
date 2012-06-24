package Prime;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;

public class XMLReader {

	public XMLReader() {
			
		}
		
	
	public boolean read(String filename) {
		try {
			InputSource source = utf8Source(filename);
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			XMLHandler handler = new XMLHandler();
			saxParser.parse(source, handler.getHandler());
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	private InputSource utf8Source(String filename) throws FileNotFoundException, UnsupportedEncodingException {
		File file = new File(filename);
		InputStream inputStream= new FileInputStream(file);
		Reader reader = new InputStreamReader(inputStream,"UTF-8");
		 
		InputSource is = new InputSource(reader);
		is.setEncoding("UTF-8");
		return is;
	}
}
