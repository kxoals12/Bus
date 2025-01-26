package kr.co.swh.lecture.springboot.detail;

import java.io.IOException;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class DetailXMLBuilder {
	//third
    public static DOMSource getXMLFile (String source) throws SAXException, IOException, ParserConfigurationException{
    	
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new StringReader(source)));

       
        DOMSource DOMsource = new DOMSource(doc);

        return DOMsource;
    }
}