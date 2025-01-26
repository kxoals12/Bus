package kr.co.swh.lecture.springboot.commonness;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;

public class ParsingHtml {
	//first
	public static String a (String url) {
		
		String result = "";
		try {

			HttpClient client = HttpClientBuilder.create().build(); // HttpClient 생성
			HttpGet getRequest = new HttpGet(url); //GET 메소드 URL 생성
			HttpResponse response = client.execute(getRequest);



			ResponseHandler<String> handler = new BasicResponseHandler();
			result = handler.handleResponse(response);

		} catch (Exception e){
			System.err.println(e.toString());
		}
	    return result;
	}
}
