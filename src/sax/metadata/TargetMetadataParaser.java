package sax.metadata;

import java.io.FileInputStream;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class TargetMetadataParaser {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		TargetMetadataXMLHandler _handler = new TargetMetadataXMLHandler();
		XMLReader reader = XMLReaderFactory.createXMLReader();
		reader.setContentHandler(_handler);
		reader.parse(new InputSource(new FileInputStream("D:\\Nagendra\\Work\\EM-OPC\\RUEI Plugin\\Temp\\oracle_ruei_collector.xml")));
		System.out.println(_handler.getMetadata().toString());
		reader.parse(new InputSource(new FileInputStream("D:\\Nagendra\\Work\\EM-OPC\\RUEI Plugin\\Temp\\oracle_ruei_processor.xml")));
		System.out.println(_handler.getMetadata().toString());
		reader.parse(new InputSource(new FileInputStream("D:\\Nagendra\\Work\\EM-OPC\\RUEI Plugin\\Temp\\oracle_ruei_reporter.xml")));
		System.out.println(_handler.getMetadata().toString());
		reader.parse(new InputSource(new FileInputStream("D:\\Nagendra\\Work\\EM-OPC\\RUEI Plugin\\Temp\\oracle_ruei_sys.xml")));
		System.out.println(_handler.getMetadata().toString());

	}

}
