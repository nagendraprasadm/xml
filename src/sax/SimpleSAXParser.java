package sax;

import java.io.StringReader;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class SimpleSAXParser {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		String inputStr = "<?xml version=\"1.0\"?>" + " <company>"
				+ "     <staff>" + "         <firstname>yong</firstname>"
				+ "         <lastname>mook kim</lastname>"
				+ "         <nickname>mkyong</nickname>"
				+ "         <salary>100000</salary>" + "     </staff>"
				+ "     <staff>" + "         <firstname>low</firstname>"
				+ "         <lastname>yin fong</lastname>"
				+ "         <nickname>fong fong</nickname>"
				+ "         <salary>200000</salary>" + "     </staff>"
				+ " </company> ";
		XMLReader reader = XMLReaderFactory.createXMLReader();
		reader.setContentHandler(new EmployeeXMLHandler());
		reader.parse(new InputSource(new StringReader(inputStr)));

	}

}
