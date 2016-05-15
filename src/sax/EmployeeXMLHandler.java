package sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class EmployeeXMLHandler extends DefaultHandler {

	private List<Employee> _employees = new ArrayList<Employee>();
	private Locator _locator;

	@Override
	public void setDocumentLocator(Locator arg0) {
		System.out.println("\tSET LOCATOR");
		this._locator = arg0;
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("\tSTART DOCUMENT");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("\tEND DOCUMENT");
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		System.out.println("\t\t\t Data -> " + new String(ch, start, length));
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		System.out.println("\n\n START ELEMENT :" + localName);
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		System.out.println("\n\n END ELEMENT :" + localName);
	}

}
