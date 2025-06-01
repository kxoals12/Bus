package kr.co.swh.lecture.springboot.declaration;

import java.util.ArrayList;
import java.util.Arrays;
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

import com.jayway.jsonpath.internal.function.text.Length;

import kr.co.swh.lecture.springboot.commonness.XMLReader;
import kr.co.swh.lecture.springboot.commonness.XMLBuilder;
import kr.co.swh.lecture.springboot.commonness.ParsingHtml;
import kr.co.swh.lecture.springboot.commonness.TransXMLStringToDoc;
import kr.co.swh.lecture.springboot.detail.DetailUnmarshalFromDOMSource;
import kr.co.swh.lecture.springboot.next.NextUnmarshalFromDOMSource;
import kr.co.swh.lecture.springboot.nova.NovaArrivalUnmarshalFromDOMSource;
import kr.co.swh.lecture.springboot.nova.NovaStationUnmarshalFromDOMSource;

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
		
		System.out.println(ApiURL);

		String a = ParsingHtml.a(ApiURL);

		Document b = TransXMLStringToDoc.convertStringToDocument(a);

		String c = XMLReader.translate(b);
		

		DOMSource domSource = XMLBuilder.getXMLFile(c);
		
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

			System.out.println(ApiURL);
			
			String a = ParsingHtml.a(ApiURL);

			Document b = TransXMLStringToDoc.convertStringToDocument(a);

			String c = XMLReader.translate(b);
			
			ArrayList<HashMap<String, String>> done = new ArrayList<HashMap<String, String>>();

			if (c == "Done") {
				System.out.println("=======================================================");
				System.out.println(done);
				return done;
			} else {
			DOMSource domSource = XMLBuilder.getXMLFile(c);

			result = NextUnmarshalFromDOMSource.unmar(domSource);
			System.out.println("next/buslinenum");
			System.out.println(",mvjiolkgmrnedi172834950659483"+result);
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
	
	@GetMapping("/detail/{routID}/{wyw}")
	public ArrayList<HashMap<String, String>> detailPage(@PathVariable String routID, @PathVariable String wyw) {
		ArrayList<HashMap<String, String>> result = new ArrayList<>();
		try {

			if (wyw.equals("1")) {
				String ApiURL = "http://api.gbis.go.kr/ws/rest/busrouteservice/station?serviceKey=1234567890&routeId=" + routID;

				System.out.println(wyw + "wyw");
				
				System.out.println(ApiURL);
			
				String a = ParsingHtml.a(ApiURL);

				Document b = TransXMLStringToDoc.convertStringToDocument(a);

				String c = XMLReader.translate(b);

				DOMSource domSource = XMLBuilder.getXMLFile(c);
				
				result = DetailUnmarshalFromDOMSource.unmar(domSource, wyw);
				return result;
			} else {
				System.out.println(wyw + "wydw");
				String ApiURL = "http://api.gbis.go.kr/ws/rest/buslocationservice?serviceKey=1234567890&routeId=" + routID;

				System.out.println(ApiURL);
				
				String a = ParsingHtml.a(ApiURL);

				Document b = TransXMLStringToDoc.convertStringToDocument(a);

				String c = XMLReader.translate(b);

				DOMSource domSource = XMLBuilder.getXMLFile(c);
				
				result = DetailUnmarshalFromDOMSource.unmar(domSource,  wyw);
				
				System.out.println(result);
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
	
	
	@GetMapping("/nova/{stationId}/a/{routeId}")
	public ArrayList<HashMap<String, String>> nova(@PathVariable String stationId, @PathVariable String routeId, @RequestParam String countOrd ) {
		ArrayList<HashMap<String, String>> result = new ArrayList<>();
		System.out.println(stationId);
		System.out.println(routeId);
		if (routeId.length() == 1) { 
			try { 
				String ApiURL = "http://api.gbis.go.kr/ws/rest/busstationservice/info?serviceKey=1234567890&stationId=" + stationId;
				
				System.out.println(ApiURL);
				
				String a = ParsingHtml.a(ApiURL);

				Document b = TransXMLStringToDoc.convertStringToDocument(a);

				String c = XMLReader.translate(b);

				DOMSource domSource = XMLBuilder.getXMLFile(c);
				
				result = NovaStationUnmarshalFromDOMSource.unmar(domSource);
				
				return result;

			} catch (Exception e) {
				System.err.println("An error occurred in detailPage method: " + e.getMessage());
				e.printStackTrace();

				HashMap<String, String> errorResponse = new HashMap<>();
				errorResponse.put("error", "Failed to process request: " + e.getMessage());
				result.add(errorResponse);
				return result;
			}
		} else{
			try { 
				String ApiURL = "http://api.gbis.go.kr/ws/rest/busarrivalservice/tv?serviceKey=1234567890&stationId="+ stationId + "&routeId=" + routeId + "&staOrder=1" ;
//				String ApiURL = "http://api.gbis.go.kr/ws/rest/busarrivalservice/tv?serviceKey=1234567890&stationId="+ stationId + "&routeId=" + routeId + "&staOrder=" + countOrd ;
				System.out.println(ApiURL + "--------------ApiURL");
				String a = ParsingHtml.a(ApiURL);

				Document b = TransXMLStringToDoc.convertStringToDocument(a);

				String c = XMLReader.translate(b);

				DOMSource domSource = XMLBuilder.getXMLFile(c);
	 
				result = NovaArrivalUnmarshalFromDOMSource.unmar(domSource);
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

}