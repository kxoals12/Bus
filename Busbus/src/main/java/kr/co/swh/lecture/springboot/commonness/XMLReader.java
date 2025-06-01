package kr.co.swh.lecture.springboot.commonness;
import org.w3c.dom.*;
import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;

public class XMLReader {
    public static String translate(Document xmlData) throws Exception {
        //second
    	
    	// XML 파일 로딩
//        File xmlFile = new File("C:\\Users\\user\\workspace\\bus2\\src\\main\\java\\kr\\co\\swh\\lecture\\springboot\\data1.xml");
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder builder = factory.newDocumentBuilder();
//        Document xmlData = builder.parse(xmlFile);
        
        // XML을 정규화 (옵션)
        xmlData.getDocumentElement().normalize();
        
        
        // 특정 태그인 <person>을 모두 추출
        NodeList nodeList = xmlData.getElementsByTagName("msgBody");
        String wreturn = "";
        
        // 각 <person> 태그를 출력
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                // XML 형식으로 출력하기 위해 Transformer 사용
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");

                // XML 노드를 스트림으로 변환하여 출력
                StringWriter writer = new StringWriter();
                StreamResult result = new StreamResult(writer);
                DOMSource source = new DOMSource(node);
                transformer.transform(source, result);


                
                // 결과 출력
//                System.out.println(writer.toString());
                wreturn += writer.toString();
                
            }
        }
       
        String done = "Done";
        if (wreturn == "") {
			System.out.println("=======================================================///////////");
        	return done;
        } else {
        	return wreturn;
        }
    }
}