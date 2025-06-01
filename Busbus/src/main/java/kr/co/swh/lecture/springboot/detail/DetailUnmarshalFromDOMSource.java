package kr.co.swh.lecture.springboot.detail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.dom.DOMSource;


public class DetailUnmarshalFromDOMSource {
    public static ArrayList<HashMap<String, String>> unmar(DOMSource domSource, String wyw) throws JAXBException {
        // JAXBContext 생성: 변환할 클래스(RouteList.class)를 지정

    	JAXBContext context = JAXBContext.newInstance(DetailmsgBody.class);

        // Unmarshaller 생성
        Unmarshaller unmarshaller = context.createUnmarshaller();
        
        ArrayList<HashMap<String, String>> tagList = new ArrayList<>();	
        
        
        if(wyw.equals("1")){
        // DOMSource를 이용하여 RouteList 객체로 변환
        DetailmsgBody msgBodyTag = (DetailmsgBody) unmarshaller.unmarshal(domSource);

        // 변환된 객체에서 BusRouteListTag 정보 추출
        List<DetailBusRouteStationListTag> busRouteList = msgBodyTag.getBusRouteStationListTag();


        for (DetailBusRouteStationListTag bus : busRouteList) {
            HashMap<String, String> tagMap = new HashMap<>();
            tagMap.put("centerYn", bus.getcenterYn());
            tagMap.put("districtCd", bus.getdistrictCd());
            tagMap.put("mobileNoSi", bus.getmobileNoSi());
            tagMap.put("regionName", bus.getregionName());
            tagMap.put("stationId", bus.getstationId());
            tagMap.put("stationName", bus.getstationName());
            tagMap.put("toiletStYn", bus.gettoiletStYn());
            tagMap.put("x", bus.getx());
            tagMap.put("y", bus.gety());
            tagMap.put("mapX", bus.getmapX());
            tagMap.put("mapY", bus.getmapY());
            tagMap.put("toiletStNm", bus.gettoiletStNm());
            tagMap.put("adminName", bus.getadminName());
            tagMap.put("lastSepFlag", bus.getlastSepFlag());
            tagMap.put("sepFlag", bus.getsepFlag());
            tagMap.put("stationSeq", bus.getstationSeq());
            tagMap.put("turnSeq", bus.getturnSeq());
            tagMap.put("turnYn", bus.getturnYn());
            tagMap.put("routeName", bus.getrouteName());

            tagList.add(tagMap);
        }}else {
        	// DOMSource를 이용하여 RouteList 객체로 변환
            DetailmsgBody msgBodyTag = (DetailmsgBody) unmarshaller.unmarshal(domSource);

            // 변환된 객체에서 BusRouteListTag 정보 추출
            List<DetailBusLocationListTag> busLocationList = msgBodyTag.getBusLocationListTag();



            for (DetailBusLocationListTag bus : busLocationList) {
                HashMap<String, String> tagMap = new HashMap<>();
                tagMap.put("vehId", bus.getvehId());
                tagMap.put("stationSeq", bus.getstationSeq());
                tagMap.put("suddenEntry", bus.getsuddenEntry());
                tagList.add(tagMap);
        }
      }
		return tagList;
  }
}