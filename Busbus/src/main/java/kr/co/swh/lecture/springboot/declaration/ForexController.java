package kr.co.swh.lecture.springboot.declaration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;

import kr.co.swh.lecture.springboot.commonness.ParsingHtml;
import kr.co.swh.lecture.springboot.commonness.TransXMLStringToDoc;
import kr.co.swh.lecture.springboot.detail.DetailUnmarshalFromDOMSource;
import kr.co.swh.lecture.springboot.detail.DetailXMLBuilder;
import kr.co.swh.lecture.springboot.detail.DetailXMLReader;
import kr.co.swh.lecture.springboot.next.NextUnmarshalFromDOMSource;
import kr.co.swh.lecture.springboot.next.NextXMLBuilder;
import kr.co.swh.lecture.springboot.next.NextXMLReader;

import javax.sql.rowset.spi.XmlReader;
import javax.xml.bind.*;
import javax.xml.transform.dom.DOMSource;

import java.io.FileInputStream;
import java.io.StringReader;
import java.io.File;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class ForexController {
	@GetMapping("/client/{busLine_num}")
	public ArrayList<HashMap<String, String>> retrieveExchangeValue(@PathVariable String busLine_num,
			@RequestParam String page,
			@RequestParam String perPage)  throws Exception {
		String ApiURL = "http://api.gbis.go.kr/ws/rest/busrouteservice/page?serviceKey=1234567890&pageSize=" + perPage + "&pageNo=" + page + "&keyword=" + busLine_num;
		

		String a = ParsingHtml.a(ApiURL);

		Document b = TransXMLStringToDoc.convertStringToDocument(a);

		String c = NextXMLReader.translate(b);
		

		DOMSource domSource = NextXMLBuilder.getXMLFile(c);
		
		ArrayList<HashMap<String, String>> result = NextUnmarshalFromDOMSource.unmar(domSource);
		
		System.out.println("client/buslinenum");
		return result;
		
	}

	//	@GetMapping("/next/{busLine_num}")
	//	public ArrayList<HashMap<String, String>> detailPage(@PathVariable String busLine_num,
	//			@RequestParam String page,
	//			@RequestParam String perPage) throws Exception {
	//		System.out.println(busLine_num);
	//
	//		String ApiURL = "http://api.gbis.go.kr/ws/rest/busrouteservice/page?serviceKey=1234567890&pageSize=" + perPage + "&pageNo=" + page + "&keyword=" + busLine_num;
	//
	//		String a = ParsingHtml.a(ApiURL);
	//		System.out.println(a);
	//		Document b = TransXMLStringToDoc.convertStringToDocument(a);
	//
	//		String c = XMLReader.translate(b);
	//
	//		DOMSource domSource = XMLBuilder.getXMLFile(c);
	//
	//
	//		ArrayList<HashMap<String, String>> result = UnmarshalFromDOMSource.unmar(domSource);
	//		return result;
	//
	//
	//	}
	@GetMapping("/next/{busLine_num}")
	public ArrayList<HashMap<String, String>> nextPage(@PathVariable String busLine_num,
			@RequestParam String page,
			@RequestParam String perPage) {
		ArrayList<HashMap<String, String>> result = new ArrayList<>();
		try {
			String ApiURL = "http://api.gbis.go.kr/ws/rest/busrouteservice/page?serviceKey=1234567890&pageSize=" + perPage + "&pageNo=" + page + "&keyword=" + busLine_num;

			String a = ParsingHtml.a(ApiURL);
			System.out.println(a);

			Document b = TransXMLStringToDoc.convertStringToDocument(a);

			String c = NextXMLReader.translate(b);

			if (c == "Done") {
				System.out.println("=======================================================");
				return null;
			} else {
			DOMSource domSource = NextXMLBuilder.getXMLFile(c);

			result = NextUnmarshalFromDOMSource.unmar(domSource);
			System.out.println("next/buslinenum");
			return result;
			}

		} catch (Exception e) {
			System.err.println("An error occurred in detailPage method: " + e.getMessage());
			e.printStackTrace();

			HashMap<String, String> errorResponse = new HashMap<>();
			errorResponse.put("error", "Failed to process request: " + e.getMessage());
			result.add(errorResponse);
			return result;
		}
		

	}
	
	@GetMapping("/detail/{routID}")
	public ArrayList<HashMap<String, String>> detailPage(@PathVariable String routID) {
		ArrayList<HashMap<String, String>> result = new ArrayList<>();
		try {
			String ApiURL = "http://api.gbis.go.kr/ws/rest/busrouteservice/station?serviceKey=1234567890&routeId=" + routID;

			String a = ParsingHtml.a(ApiURL);
			System.out.println(a);

			Document b = TransXMLStringToDoc.convertStringToDocument(a);

			String c = DetailXMLReader.translate(b);

			DOMSource domSource = DetailXMLBuilder.getXMLFile(c);
 
			result = DetailUnmarshalFromDOMSource.unmar(domSource);
			return result;


		} catch (Exception e) {
			System.err.println("An error occurred in detailPage method: " + e.getMessage());
			e.printStackTrace();

			HashMap<String, String> errorResponse = new HashMap<>();
			errorResponse.put("error", "Failed to process request: " + e.getMessage());
			result.add(errorResponse);
			return result;
		}
		

	}


}